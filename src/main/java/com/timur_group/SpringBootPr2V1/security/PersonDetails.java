package com.timur_group.SpringBootPr2V1.security;

import com.timur_group.SpringBootPr2V1.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class PersonDetails implements UserDetails {

    private Person person;

    @Autowired
    public PersonDetails(Person person)
    {
        this.person=person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
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
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Person getPerson()
    {
        return this.person;
    }

    @Override
    public String toString() {
        return  person.toString();

    }
}
