package tech.leandroportugal.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.leandroportugal.helpdesk.domain.Person;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long>{
    
    Optional<Person> findByDocument(String document);
    Optional<Person> findByEmail(String email);
}
