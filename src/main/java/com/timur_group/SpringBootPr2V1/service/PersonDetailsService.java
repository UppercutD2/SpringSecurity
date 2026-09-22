package com.timur_group.SpringBootPr2V1.service;

import com.timur_group.SpringBootPr2V1.models.Person;
import com.timur_group.SpringBootPr2V1.repository.PersonRepository;
import com.timur_group.SpringBootPr2V1.security.PersonDetails;
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
        Optional<Person> person =repository.findByUsername(s);

        if(person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new PersonDetails(person.get());
    }
}
