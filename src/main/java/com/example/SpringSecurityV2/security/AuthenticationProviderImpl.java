/*package com.example.SpringSecurityV2.security;

import com.example.SpringSecurityV2.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {


    private final PersonDetailsService perDetSer;

    @Autowired
    public AuthenticationProviderImpl(PersonDetailsService perDetSer)
    {
        this.perDetSer=perDetSer;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();

        UserDetails details = perDetSer.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if(!password.equals(details.getPassword()))
            throw new BadCredentialsException("Wrong password.");


        return new UsernamePasswordAuthenticationToken(details,password, Collections.emptyList());///THIS IS SU4ARA - PRINCIPAL
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
*/