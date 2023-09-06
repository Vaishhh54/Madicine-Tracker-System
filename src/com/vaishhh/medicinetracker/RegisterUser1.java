package com.vaishhh.medicinetracker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaishhh.ConnectDB.ConnectDB;

/**
 * Servlet implementation class RegisterUser1
 */
public class RegisterUser1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String u1name = request.getParameter("u1name");
		String u1email= request.getParameter("u1email");
		String u1password= request.getParameter("u1password");
		String u1contact= request.getParameter("u1contact");
		int u1pincode = Integer.parseInt(request.getParameter("u1pincode"));
		String lat =request.getParameter("lat");
	    String  lng =request.getParameter("lng");
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement p1 = con.prepareStatement("select * from user1_tbl where u1email=?");
			p1.setString(1, u1email);
			ResultSet rs = p1.executeQuery();
			if(rs.next())
			{   
				response.sendRedirect("user1.jsp");
			}
			else
			{  
				Ulatlng.setLat(lat);
				Ulatlng.setLng(lng);
				
				PreparedStatement p2 = con.prepareStatement("insert into user1_tbl values(?,?,?,?,?,?,?,?)");
				p2.setInt(1, 0);
				p2.setString(2, u1name);
				p2.setString(3, u1email);
				p2.setString(4, u1password);
				p2.setString(5, u1contact);
				p2.setInt(6, u1pincode);
				p2.setString(7, lat);
				p2.setString(8, lng);
				int i = p2.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("user1.jsp");
					
				}
				else
				{
					response.sendRedirect("user1register.jsp");
				}
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
