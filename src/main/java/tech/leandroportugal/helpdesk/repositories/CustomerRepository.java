package tech.leandroportugal.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.leandroportugal.helpdesk.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
