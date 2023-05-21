package tech.leandroportugal.helpdesk.servicies;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import tech.leandroportugal.helpdesk.domain.Customer;
import tech.leandroportugal.helpdesk.domain.Technical;
import tech.leandroportugal.helpdesk.domain.Ticket;
import tech.leandroportugal.helpdesk.domain.dtos.TicketDTO;
import tech.leandroportugal.helpdesk.domain.enums.Priority;
import tech.leandroportugal.helpdesk.domain.enums.Status;
import tech.leandroportugal.helpdesk.repositories.TicketRepository;
import tech.leandroportugal.helpdesk.servicies.exceptions.ObjectNotFoundException;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TechnicalService technicalService;
    

    public Ticket findById(Long id) {
       Optional <Ticket> obj = repository.findById(id);
       return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found id: " + id));
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }

    public Ticket create(@Valid TicketDTO objDTO) {
        return repository.save(newTicket(objDTO));
    }

    public Ticket update(Long id, @Valid TicketDTO objDTO) {
        objDTO.setId(id);
        Ticket oldObj = findById(id);
        oldObj = newTicket(objDTO);
        return repository.save(oldObj);
    } 

    private Ticket newTicket(TicketDTO obj) {

        Technical technical = technicalService.findById(obj.getTechnical());
        Customer customer = customerService.findById(obj.getCustomer());

        Ticket ticket = new Ticket();
        if(obj.getId() != null) {
            ticket.setId(obj.getId());
        }

        if(obj.getStatus().equals("close")){
            ticket.setClosingDate(LocalDate.now());
        }

        ticket.setCustomer(customer);
        ticket.setTechnical(technical);
        ticket.setPriority(Priority.toEnum(obj.getPriority()));
        ticket.setStatus(Status.toEnum(obj.getStatus()));
        ticket.setTitle(obj.getTitle());
        ticket.setObservation(obj.getObservation());
        return ticket;
    }

   

}
