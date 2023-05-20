package tech.leandroportugal.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{

    private List<Ticket> tickets = new ArrayList<>();

    public Customer() {
        super();
    }

    public Customer(Long id, String name, String email, String password, String document) {
        super(id, name, email, password, document);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    
    
}
