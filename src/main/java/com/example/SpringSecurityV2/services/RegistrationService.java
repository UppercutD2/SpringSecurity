package com.example.SpringSecurityV2.services;

import com.example.SpringSecurityV2.models.Person;
import com.example.SpringSecurityV2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;

    @Autowired
    public RegistrationService(PasswordEncoder passwordEncoder, PersonRepository personRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.personRepository=personRepository;
    }


    @Transactional
    public void register(Person person)
    {


        person.setPassword(passwordEncoder.encode(person.getPassword()));

        personRepository.save(person);
        System.out.println("Person with username \""+ person.getUsername()+"\" has been saved");
    }

}
