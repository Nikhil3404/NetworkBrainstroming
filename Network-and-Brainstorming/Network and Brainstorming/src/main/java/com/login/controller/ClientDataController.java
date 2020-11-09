package com.login.controller;

import java.awt.Frame;
import java.awt.TextArea;
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
public class ClientDataController {

	private static final String PATH = "/ClientWillFetch";

	@RequestMapping(value = PATH, method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "ClientWillFetch";
	}

	@RequestMapping(value = PATH, method = RequestMethod.POST)
	public String show(ModelMap model) {

		try {
			Socket socket = new Socket("192.168.46.50", 8000);
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String clientMessage = "", serverMessage = "";
			while (!clientMessage.equals("bye")) {
				clientMessage = br.readLine();
				outStream.writeUTF(clientMessage);
				outStream.flush();
				serverMessage = inStream.readUTF();
				System.out.println(serverMessage);
				return "redirect:/Final";

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/Final";

	}

}
