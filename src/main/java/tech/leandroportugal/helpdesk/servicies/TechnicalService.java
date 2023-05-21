package tech.leandroportugal.helpdesk.servicies;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
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

public Technical findById(Long id){
    Optional<Technical> obj = repository.findById(id);
    return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id));
}

public List<Technical> findAll() {
    return repository.findAll();
}

public Technical create(TechnicalDTO objDTO) {
    objDTO.setId(null);
    validateUniqueDocumentandMail(objDTO);
    Technical obj = new Technical(objDTO);
    return repository.save(obj);
}

public  Technical update(Long id, TechnicalDTO objDTO) {
    objDTO.setId(id);
    Technical oldObj = findById(id);
    validateUniqueDocumentandMail(objDTO);
    oldObj = new Technical(objDTO);
    return repository.save(oldObj);

}

public void delete(Long id) {
    
    Technical obj = findById(id);
    if(obj.getTickets().size() > 0) {
        throw new DataIntegrityViolationException("Technical has tickets and can't be deleted!");
    
}
    repository.deleteById(id);
    
}
private void validateUniqueDocumentandMail(TechnicalDTO objDTO) {

    Optional<Person> obj = personRepository.findByDocument(objDTO.getDocument());  
    if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {  
        throw new DataIntegrityViolationException("Document already exists!");  
    }
    
    obj = personRepository.findByEmail(objDTO.getEmail());
    if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
        throw new DataIntegrityViolationException("Email already exists!");
    }
}
}



