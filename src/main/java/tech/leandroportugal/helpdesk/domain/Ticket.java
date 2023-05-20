package tech.leandroportugal.helpdesk.domain;

import java.time.LocalDate;

import tech.leandroportugal.helpdesk.domain.enums.Priority;
import tech.leandroportugal.helpdesk.domain.enums.Status;

public class Ticket {

    private Long id;
    private LocalDate openingDate = LocalDate.now();
    private LocalDate closingDate;
    private Priority priority;
    private Status status;
    private String title;
    private String observation;

    private Technical technical;
    private Customer customer;

    public Ticket() {
        super();
    }

    public Ticket(Long id, Priority priority, Status status, String title, String observation, Technical technical,
            Customer customer) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.observation = observation;
        this.technical = technical;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Technical getTechnical() {
        return technical;
    }

    public void setTechnical(Technical technical) {
        this.technical = technical;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}