package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.login.service.LoginService;

/*
 * Network Brainstorming System
 * 
 * Team 3
 * 
 * @author Umamaheswar Reddy, Akshay, Jawahar, Preetinder, Nikhil 
 * 
 * @version 1.0 21-Nov-2019 Brainstorming with multiply client system and with database connectivity
 *  
 * Roles-
 * UmaMaheswar reddy - Admin and connectivity
 * Akshay - Client UI and connectivity
 * Preetinder - CRUD 
 * Jawahar - Socket programming
 * Nikhil - Helping in  CRUD and socket programming
 * 
 */
@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        boolean isValidUser = service.validateUser(name, password);
        boolean isValidClient1 = service.validateClient1(name, password);
        boolean isValidClient2 = service.validateClient2(name, password);
        boolean isValidClient3 = service.validateClient3(name, password);
        boolean isValidClient4 = service.validateClient3(name, password);

        if (!isValidUser && !isValidClient1 && !isValidClient2 && !isValidClient3 && !isValidClient4) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
         else if(isValidClient1) {
    	 return "redirect:/client";
    	
    }
         else if(isValidClient2) {
         	 return "redirect:/client";
   	 
   }
         else if(isValidClient3) {
         	 return "redirect:/client";
   }
         else if(isValidClient4) {
         	 return "redirect:/client";
       	     }
         else if(isValidUser) {
        	 return "redirect:/admin";
         }
        model.put("name", name);
        model.put("password", password);

        return "redirect:/admin";
    }
    
 
}