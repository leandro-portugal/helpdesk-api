package tech.leandroportugal.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.leandroportugal.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
