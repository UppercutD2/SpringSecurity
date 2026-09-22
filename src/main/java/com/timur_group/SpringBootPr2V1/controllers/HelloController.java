package com.timur_group.SpringBootPr2V1.controllers;

import com.timur_group.SpringBootPr2V1.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String getHello()
    {
        return "/hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

       PersonDetails details = (PersonDetails) auth.getPrincipal();
        System.out.println(details);
        return "/hello";
    }
}
