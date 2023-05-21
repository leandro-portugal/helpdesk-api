package tech.leandroportugal.helpdesk.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.leandroportugal.helpdesk.domain.Ticket;
import tech.leandroportugal.helpdesk.repositories.TicketRepository;
import tech.leandroportugal.helpdesk.servicies.exceptions.ObjectNotFoundException;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public Ticket findById(Long id) {
       Optional <Ticket> obj = repository.findById(id);
       return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found id: " + id));
    }
}
