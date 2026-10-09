package com.example.SpringSecurityV2.services;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PreAuthorizeService {

    @PreAuthorize("hasRole('ADMIN') and hasRole('SOME_OTHER_ROLE')")
    public void doAdminStuff()
    {
        System.out.println("OnlyAdmins here.");
    }



}
