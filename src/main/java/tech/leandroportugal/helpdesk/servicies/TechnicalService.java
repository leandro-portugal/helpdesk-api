package tech.leandroportugal.helpdesk.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.leandroportugal.helpdesk.domain.Technical;
import tech.leandroportugal.helpdesk.repositories.TechnicalRepository;

@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository repository;

public Technical findById(Long id){
    Optional<Technical> obj = repository.findById(id);
    return obj.orElse(null);
}


}
