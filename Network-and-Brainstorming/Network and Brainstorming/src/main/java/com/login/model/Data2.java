package com.login.model;

public class Data2 {
	   
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
	public Data2() {

	}
	public static int id;
	  public static String client;
	     public static String activity;
	    public static String details;

	    public static int getid() {
	        return id;
	    }
	 
	    public void setid(int id) {
	        this.id = id;
	    }

	    public static String getclient() {
	        return client;
	    }
	 
	    public void setclient(String client) {
	        this.client = client;
	    }
	
	    public static String getactivity() {
	        return activity;
	    }
	 
	    public void setactivity(String activity) {
	        this.activity = activity;
	    }
	    
	    public static String getdetails() {
	        return details;
	    }
	 
	    public void setdetails(String details) {
	        this.details = details;
	    }
	
	

}
