package com.example.SpringSecurityV2.config;


import com.example.SpringSecurityV2.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService)
    {
        this.personDetailsService=personDetailsService;
    }

    /// Spring Security Configuration and Authorizations
    @Override
    protected void configure(HttpSecurity http ) throws Exception{

        http  .authorizeRequests()
              //  .antMatchers("/daldanix/popa").hasRole("ADMIN")
                .antMatchers("/authenticate/login","/authenticate/registration","/error").permitAll()
                .anyRequest().hasAnyRole("USER","ADMIN")
                .and()/// connecting method
                .formLogin().loginPage("/authenticate/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/daldanix",true)
                .failureForwardUrl("/authenticate/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/authenticate/login");




    }


    /// when using userDetailsService must have Encryption for password method!!!
    /// configuring AUTHENTICATION
    @Override
    protected void configure(AuthenticationManagerBuilder authMan) throws Exception {
        authMan.userDetailsService(personDetailsService).passwordEncoder(getPasswordEncoder());
    }
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
