package tech.leandroportugal.helpdesk.servicies;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tech.leandroportugal.helpdesk.domain.Person;
import tech.leandroportugal.helpdesk.domain.Technical;
import tech.leandroportugal.helpdesk.domain.dtos.TechnicalDTO;
import tech.leandroportugal.helpdesk.repositories.PersonRepository;
import tech.leandroportugal.helpdesk.repositories.TechnicalRepository;
import tech.leandroportugal.helpdesk.servicies.exceptions.DataIntegrityViolationException;
import tech.leandroportugal.helpdesk.servicies.exceptions.ObjectNotFoundException;


@Service
public class TechnicalService {

@Autowired
private TechnicalRepository repository;

@Autowired
private PersonRepository personRepository;

@Autowired
BCryptPasswordEncoder encoder;

public Technical findById(Long id){
    Optional<Technical> obj = repository.findById(id);
    return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id));
}

public List<Technical> findAll() {
    return repository.findAll();
}

public Technical create(TechnicalDTO objDTO) {
    objDTO.setId(null);
    objDTO.setPassword(encoder.encode(objDTO.getPassword()));
    validateUniqueDocumentandMail(objDTO);
    Technical obj = new Technical(objDTO);
    return repository.save(obj);
}

public  Technical update(Long id, TechnicalDTO objDTO) {
    objDTO.setId(id);
    Technical oldObj = findById(id);
     if(!oldObj.getPassword().equals(objDTO.getPassword())){
        objDTO.setPassword(encoder.encode(objDTO.getPassword()));
    }
    validateUniqueDocumentandMail(objDTO);
    oldObj = new Technical(objDTO);
    return repository.save(oldObj);

}

public void delete(Long id) {
    
    Technical obj = findById(id);
    if(obj.getTickets().size() > 0) {
        throw new DataIntegrityViolationException("Este técnico possui chamados e não pode ser deletado!");
    
}
    repository.deleteById(id);
    
}
private void validateUniqueDocumentandMail(TechnicalDTO objDTO) {

    Optional<Person> obj = personRepository.findByDocument(objDTO.getDocument());  
    if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {  
        throw new DataIntegrityViolationException("Este CPF já existe!");  
    }
    
    obj = personRepository.findByEmail(objDTO.getEmail());
    if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
        throw new DataIntegrityViolationException("Este e-mail já existe!");
    }
}
}



