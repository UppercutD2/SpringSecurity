package com.example.SpringSecurityV2.config;

import com.example.SpringSecurityV2.security.AuthenticationProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationProviderImpl impl;

    @Autowired
    public SecurityConfig(AuthenticationProviderImpl impl)
    {
        this.impl=impl;
    }

    protected void configure(AuthenticationManagerBuilder authMan)
    {
        authMan.authenticationProvider(impl); ///TO DO

    }
}
