package com.example.SpringSecurityV2.services;

import com.example.SpringSecurityV2.models.Person;
import com.example.SpringSecurityV2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PersonRepository personRepository;

    @Autowired
    public RegistrationService(PersonRepository personRepository)
    {
        this.personRepository=personRepository;
    }


    @Transactional
    public void register(Person person)
    {
        personRepository.save(person);
        System.out.println("Person with username \""+ person.getUsername()+"\" has been saved");
    }

}
