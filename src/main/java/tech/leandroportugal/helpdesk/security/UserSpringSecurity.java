package tech.leandroportugal.helpdesk.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tech.leandroportugal.helpdesk.domain.enums.Profile;
import java.util.stream.Collectors;

public class UserSpringSecurity implements UserDetails{
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    

    public UserSpringSecurity(Long id, String email, String password, Set<Profile> profiles) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = profiles.stream().map(x-> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return authorities;
    }

    @Override
    public String getPassword() {
       
        return password;
    }

    @Override
    public String getUsername() {
       
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
       
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       
        return true;    }

    @Override
    public boolean isEnabled() {
       
        return true;
    }
    
}
