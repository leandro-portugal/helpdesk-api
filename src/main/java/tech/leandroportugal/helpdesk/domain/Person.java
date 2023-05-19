package tech.leandroportugal.helpdesk.domain;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import tech.leandroportugal.helpdesk.domain.enums.Profile;

public abstract class Person {

    protected Long id;
    protected String name;
    protected String email;
    protected String password;
    protected String document;
    protected LocalDate creationDate = LocalDate.now();

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
