package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testdbservlet
 */
@WebServlet("/testdbservlet")
public class testdbservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "Student";
		String pass = "Suprith@2002";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database" + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Sucess");
			
			myconn.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
