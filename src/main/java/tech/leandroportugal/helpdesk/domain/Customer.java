package tech.leandroportugal.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import tech.leandroportugal.helpdesk.domain.dtos.CustomerDTO;
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

    public Customer(CustomerDTO obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.document = obj.getDocument();
        this.creationDate = obj.getCreationDate();
        this.profiles = obj.getProfiles().stream().map(x -> x.getName()).collect(Collectors.toSet());
        
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    
    
}
