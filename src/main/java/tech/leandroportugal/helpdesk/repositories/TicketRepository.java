package tech.leandroportugal.helpdesk.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import tech.leandroportugal.helpdesk.domain.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket, Long>{
    
}
