package tech.leandroportugal.helpdesk.servicies;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tech.leandroportugal.helpdesk.domain.Person;
import tech.leandroportugal.helpdesk.domain.Customer;
import tech.leandroportugal.helpdesk.domain.dtos.CustomerDTO;
import tech.leandroportugal.helpdesk.repositories.CustomerRepository;
import tech.leandroportugal.helpdesk.repositories.PersonRepository;
import tech.leandroportugal.helpdesk.servicies.exceptions.DataIntegrityViolationException;
import tech.leandroportugal.helpdesk.servicies.exceptions.ObjectNotFoundException;


@Service
public class CustomerService {

@Autowired
private CustomerRepository repository;

@Autowired
private PersonRepository personRepository;

@Autowired
BCryptPasswordEncoder encoder;

public Customer findById(Long id){
    Optional<Customer> obj = repository.findById(id);
    return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id));
}

public List<Customer> findAll() {
    return repository.findAll();
}

public Customer create(CustomerDTO objDTO) {
    objDTO.setId(null);
    objDTO.setPassword(encoder.encode(objDTO.getPassword()));
    validateUniqueDocumentandMail(objDTO);
    Customer obj = new Customer(objDTO);
    return repository.save(obj);
}

public  Customer update(Long id, CustomerDTO objDTO) {
    objDTO.setId(id);
    Customer oldObj = findById(id);
    if(!oldObj.getPassword().equals(objDTO.getPassword())){
        objDTO.setPassword(encoder.encode(objDTO.getPassword()));
    }
    validateUniqueDocumentandMail(objDTO);
    oldObj = new Customer(objDTO);
    return repository.save(oldObj);

}

public void delete(Long id) {
    
    Customer obj = findById(id);
    if(obj.getTickets().size() > 0) {
        throw new DataIntegrityViolationException("Customer has tickets and can't be deleted!");
    
}
    repository.deleteById(id);
    
}
private void validateUniqueDocumentandMail(CustomerDTO objDTO) {

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



