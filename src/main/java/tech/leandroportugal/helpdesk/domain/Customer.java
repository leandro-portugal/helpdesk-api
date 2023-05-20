package tech.leandroportugal.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import tech.leandroportugal.helpdesk.domain.enums.Profile;

@Entity
public class Customer extends Person{

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "customer")
    private List<Ticket> tickets = new ArrayList<>();

    public Customer() {
        super();
        addProfile(Profile.CUSTOMER);
    }

    public Customer(Long id, String name, String email, String password, String document) {
        super(id, name, email, password, document);
        addProfile(Profile.CUSTOMER);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    
    
}
