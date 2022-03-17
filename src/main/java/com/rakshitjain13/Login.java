package com.rakshitjain13;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employee_id=request.getParameter("employee_id");
		String pass=request.getParameter("password");
		Employee newemployee=new Employee();
		
		try {
			String result=newemployee.CheckEmployee(employee_id, pass);
			System.out.println(result);
			if(result!="") {
				HttpSession Session=request.getSession();
				Session.setAttribute("first_name", result);
				response.sendRedirect("home.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
