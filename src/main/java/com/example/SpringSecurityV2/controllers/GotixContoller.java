package com.example.SpringSecurityV2.controllers;

import com.example.SpringSecurityV2.models.Person;
import com.example.SpringSecurityV2.security.PersonDetails;
import com.example.SpringSecurityV2.services.PreAuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/daldanix")
public class GotixContoller {

    private final PreAuthorizeService preAuthorizeService;

    @Autowired
    public GotixContoller(PreAuthorizeService preAuthorizeService) {
        this.preAuthorizeService = preAuthorizeService;
    }

    @GetMapping()
    public String getIt()
    {
        return "za4ilsa";
    }

    @GetMapping("/popa")
    public String getUserInfo()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails details = (PersonDetails) auth.getPrincipal();
        Person p = details.getPerson();
        System.out.println("BRAVO:  " + p + "  THIS IS IT...");

        return "xuliTut";
    }


    @GetMapping("/preAuthorize")
    public String preAuthorize()
    {
        preAuthorizeService.doAdminStuff();

        return "preAuthorize";
    }
}
