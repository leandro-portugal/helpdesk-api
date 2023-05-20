package tech.leandroportugal.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import tech.leandroportugal.helpdesk.domain.enums.Profile;

@Entity
public abstract class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    @Column(unique = true)
    protected String email;
    protected String password;
    @Column(unique = true)
    protected String document;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate creationDate = LocalDate.now();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PROFILEs")
    protected Set<String> profiles = new HashSet<>();

    public Person() {
        super();
        addProfile(Profile.CUSTOMER);
    }

    public Person(Long id, String name, String email, String password, String document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.document = document;
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
        return profiles.stream().map(Profile::toEnum).collect(java.util.stream.Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((document == null) ? 0 : document.hashCode());
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
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (document == null) {
            if (other.document != null)
                return false;
        } else if (!document.equals(other.document))
            return false;
        return true;
    }

}
