package tech.leandroportugal.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import tech.leandroportugal.helpdesk.domain.Ticket;


public class TicketDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdDate = LocalDate.now();
    private String priority;
    private String status;
    private String title;
    private String observation;
    private Long technical;
    private Long customer;
    private String customerName;
    private String technicalName;

    public TicketDTO() {
        super();
    }

    public TicketDTO(Ticket obj) {
        this.id = obj.getId();
        this.lastUpdDate = obj.getLastUpdate();
        this.priority = obj.getPriority().getName();
        this.status = obj.getStatus().getName();
        this.title = obj.getTitle();
        this.observation = obj.getObservation();
        this.technical = obj.getTechnical().getId();
        this.customer = obj.getCustomer().getId();
        this.customerName = obj.getCustomer().getName();
        this.technicalName = obj.getTechnical().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLastUpdate() {
        return lastUpdDate;
    }

    public void setLastUpdate(LocalDate lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }



    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Long getTechnical() {
        return technical;
    }

    public void setTechnical(Long technical) {
        this.technical = technical;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

  
}
