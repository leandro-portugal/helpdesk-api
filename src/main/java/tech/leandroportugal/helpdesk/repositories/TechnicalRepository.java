package tech.leandroportugal.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.leandroportugal.helpdesk.domain.Technical;

public interface TechnicalRepository  extends  JpaRepository<Technical, Long>{
    
}
