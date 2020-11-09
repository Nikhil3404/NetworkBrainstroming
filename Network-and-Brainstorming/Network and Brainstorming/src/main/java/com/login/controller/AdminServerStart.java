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

import com.login.model.Data1;
import com.login.model.Data2;
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
public class AdminServerStart {

	private static final String PATH = "/connect_admin";

	@RequestMapping(value = PATH, method = RequestMethod.GET)
	public String showLoginPage1(ModelMap model) {
		return "connect_admin";
	}

	@RequestMapping(value = PATH, method = RequestMethod.POST)
	public String show(ModelMap model) {

		class ServerClientThread extends Thread {
			Socket serverClient;
			int clientNo;
			String squre;

			ServerClientThread(Socket inSocket, int counter) {
				serverClient = inSocket;
				clientNo = counter;

			}

			public void run() {
				try {
					DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
					DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
					String clientMessage = "", serverMessage = "";
					while (!clientMessage.equals("bye")) {
						clientMessage = inStream.readUTF();
						System.out.println("From Client-" + clientNo + ": Number is :" + clientMessage);
						String a = clientMessage;
						squre = a;
						serverMessage = "From Server to Client-" + clientNo + " Square of " + clientMessage + " is "
								+ squre;
						outStream.writeUTF(serverMessage);
						outStream.flush();
					}
					inStream.close();
					outStream.close();
					serverClient.close();

				} catch (Exception ex) {
					System.out.println(ex);
				} finally {
					System.out.println("Client -" + clientNo + " exit!! ");
				}

			}

		}

		try {
			ServerSocket server = new ServerSocket(8000);
			int counter = 0;
			System.out.println("Server Started ....");
			while (counter <= 3) {
				if (counter > 3) {
					System.out.println("Limit Exceed");
				} else {
					counter++;
					Socket serverClient = server.accept(); // server accept the client connection request
					System.out.println("*****" + "Client No:" + counter + " started!");
					ServerClientThread sct = new ServerClientThread(serverClient, counter); // send the request to a
																							// separate thread
					sct.start();
				}
			}
			return "redirect:/Final";

		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/Final";
	}

}