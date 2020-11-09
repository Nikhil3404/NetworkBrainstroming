package com.login.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/*
 * Network Brainstorming System
 * 
 * Team 3
 * 
 * @author Umamaheswar Reddy, Akshay, Jawahar, Preetinder, Nikhil 
 * 
 * @version 1.0 21-Nov-2019 Brainstorming with multiply client system and with database connectivity
 *  
 */

@Service
public class LoginService {

    public boolean validateClient1(String userid, String password) {
  
    	 return userid.equalsIgnoreCase("client1")
                 && password.equalsIgnoreCase("12345");
     }
    public boolean validateClient2(String userid, String password) {
        
        return userid.equalsIgnoreCase("client2")
                && password.equalsIgnoreCase("12345");
    }
    
    public boolean validateClient3(String userid, String password) {

        return userid.equalsIgnoreCase("client3")
                && password.equalsIgnoreCase("12345");
    }
    public boolean validateClient4(String userid, String password) {

        return userid.equalsIgnoreCase("client4")
                && password.equalsIgnoreCase("12345");
    }
    public boolean validateUser(String userid, String password) {
     
        return userid.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("12345");
    }
}
