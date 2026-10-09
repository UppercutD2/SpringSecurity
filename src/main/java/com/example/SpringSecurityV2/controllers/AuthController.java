package com.example.SpringSecurityV2.controllers;

import com.example.SpringSecurityV2.models.Person;
import com.example.SpringSecurityV2.services.RegistrationService;
import com.example.SpringSecurityV2.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/authenticate")
public class AuthController {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

    @Autowired
    public AuthController(PersonValidator personValidator,
                          RegistrationService registrationService)
    {
        this.registrationService=registrationService;
        this.personValidator=personValidator;
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "authenticate/login";
    }


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person)
    {

        return "authenticate/registration";
    }


    @PostMapping("/registration")
    public String completeRegistration(@ModelAttribute("person") @Valid Person person,
                                       BindingResult bindingResult)
    {

                personValidator.validate(person,bindingResult);///check for occupied username.

                if(bindingResult.hasErrors()) {
                    System.out.println("Some Errors");
                    return "/authenticate/registration";
                }

            registrationService.register(person);
            return "redirect:/authenticate/login";
    }
}
