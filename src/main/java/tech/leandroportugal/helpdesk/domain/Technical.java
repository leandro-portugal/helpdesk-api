package tech.leandroportugal.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Technical extends Person {

    private List<Ticket> tickets = new ArrayList<>();

    public Technical() {
        super();

    }

    public Technical(Long id, String name, String email, String password, String document) {
        super(id, name, email, password, document);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    

}
