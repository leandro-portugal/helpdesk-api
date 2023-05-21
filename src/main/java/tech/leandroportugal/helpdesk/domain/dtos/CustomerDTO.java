package tech.leandroportugal.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import tech.leandroportugal.helpdesk.domain.Customer;
import tech.leandroportugal.helpdesk.domain.enums.Profile;

import java.util.stream.Collectors;

public class CustomerDTO implements Serializable{

    private static final long serialVersionUID = 1L;


    protected Long id;
    @NotNull(message = "Name field is required")
    protected String name;
    @NotNull(message = "Email field is required")
    protected String email;
    @NotNull(message = "Password field is required")
    protected String password;
    @NotNull(message = "Document field is required")
    protected String document;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate creationDate = LocalDate.now();

   
    protected Set<String> profiles = new HashSet<>();


    public CustomerDTO() {
        super();
        addProfile(Profile.CUSTOMER);
    
    }


    public CustomerDTO(Customer obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.document = obj.getDocument();
        this.creationDate = obj.getCreationDate();
        this.profiles = obj.getProfiles().stream().map(x -> x.getName()).collect(Collectors.toSet());
        addProfile(Profile.CUSTOMER);
        
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getName());
    }


    public void setProfiles(Set<String> profiles) {
        this.profiles = profiles;
    }

    
    
}
