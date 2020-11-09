package com.login.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.login.model.ToDo;
import com.login.model.Data1;
import com.login.service.LoginService;
import com.sun.media.jfxmedia.logging.Logger;
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
public class AdminController {

	private static final String PATH = "/admin";

	@RequestMapping(value = PATH, method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {

		return "AdminWillFetch";

	}

	@RequestMapping(value = PATH, method = RequestMethod.POST)

	public String loginadmin(Data1 credentials) {

		String a = credentials.getclient();
		String b = credentials.getactivity();
		String c = credentials.getdetails();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/pp7", "root", "12345678");
			Statement st = conn.createStatement();

			st.executeUpdate("insert into admin(clientname, Activity, ActivityDescription) values(" + "'" + a + "',"
					+ " " + "'" + b + "'," + " " + "'" + c + "')");
			System.out.println("Activity:  " + " " + b + "has been started.");
		} catch (Exception e) {

			System.out.print(e);
			e.printStackTrace();
		}

		return "redirect:/connect_admin";

	}

}
