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
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String date_of_birth=request.getParameter("date_of_birth");
		String password=request.getParameter("password");
		String number=request.getParameter("number");
		String employee_id=request.getParameter("employee_id");
		Employee newemployee=new Employee();
		try {
			if(newemployee.CreateEmployee(employee_id,first_name,last_name,date_of_birth,number,password)) {
				HttpSession Session=request.getSession();
				Session.setAttribute("first_name", first_name);
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
