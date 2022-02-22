package com.validationform.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrationservlet
 */
@WebServlet("/register")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    		String uname= request.getParameter("name");
    		String email= request.getParameter("email");
    		String password= request.getParameter("pass");
    		String mobile= request.getParameter("contact");
    		RequestDispatcher dispatcher = null;
    		Connection con = null;
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommarce?useSSL=false","root","Ynhd@0077");
    			PreparedStatement pst =con.prepareStatement("insert into users(uname,password,email,mobile) values(?,?,?,?)");
    			pst.setString(1, uname);
    			pst.setString(2, password);
    			pst.setString(3, email);
    			pst.setString(4, mobile);
    			
    			int rowCownt = pst.executeUpdate();
    			dispatcher = request.getRequestDispatcher("registration.jsp");
    			
    			if(rowCownt > 0) {
    				request.setAttribute("status","success");
    			}else {
    				request.setAttribute("status","failed");

    			}
    			dispatcher.forward(request, response);
    			
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

    		
	}

}
