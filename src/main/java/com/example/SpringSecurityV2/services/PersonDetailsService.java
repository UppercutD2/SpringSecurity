package com.example.SpringSecurityV2.services;

import com.example.SpringSecurityV2.models.Person;
import com.example.SpringSecurityV2.repositories.PersonRepository;
import com.example.SpringSecurityV2.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository repository;


    @Autowired
    public PersonDetailsService(PersonRepository repository)
    {
        this.repository=repository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            Optional<Person> a = repository.findByUsername(s);

            if(a.isEmpty())
                throw new UsernameNotFoundException("Username not found");


        return new PersonDetails(a.get());
    }
}
