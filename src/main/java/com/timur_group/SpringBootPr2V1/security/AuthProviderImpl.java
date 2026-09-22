package com.timur_group.SpringBootPr2V1.security;

import com.timur_group.SpringBootPr2V1.models.Person;
import com.timur_group.SpringBootPr2V1.repository.PersonRepository;
import com.timur_group.SpringBootPr2V1.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService)
    {
        this.personDetailsService=personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails personDetails = personDetailsService.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if(!password.equals(personDetails.getPassword()))
            throw new BadCredentialsException("Incorrect password");

        return  new UsernamePasswordAuthenticationToken(personDetails,password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
