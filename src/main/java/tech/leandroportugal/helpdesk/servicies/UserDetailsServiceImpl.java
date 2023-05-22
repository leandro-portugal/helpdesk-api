package tech.leandroportugal.helpdesk.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.leandroportugal.helpdesk.domain.Person;
import tech.leandroportugal.helpdesk.repositories.PersonRepository;
import tech.leandroportugal.helpdesk.security.UserSpringSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    PersonRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Optional<Person> user = repository.findByEmail(email);
        if(user.isPresent()){
            return new UserSpringSecurity(user.get().getId(), user.get().getEmail(), user.get().getPassword(), user.get().getProfiles());
        }

        throw  new UsernameNotFoundException(email);
    }
    
}
