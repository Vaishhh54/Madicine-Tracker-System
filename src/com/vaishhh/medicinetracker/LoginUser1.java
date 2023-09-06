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
 * Servlet implementation class LoginUser1
 */
public class LoginUser1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser1() {
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
		String u1email = request.getParameter("u1email");
		String u1password = request.getParameter("u1password");
		try
		{
		Connection con = ConnectDB.connect();
		
		PreparedStatement ps2 = con.prepareStatement("select * from user1_tbl where u1email=? and u1password=? ");
		ps2.setString(1, u1email);
		ps2.setString(2, u1password);
		ResultSet rs = ps2.executeQuery();
		if(rs.next())
		{    
			String lat = rs.getString("lat");
			String lng = rs.getString("lng");
			Ulatlng.setLat(lat);
			Ulatlng.setLng(lng);
			response.sendRedirect("userinterface1.html");
			
		}
		else
		{
			response.sendRedirect("user1.jsp");
		}
		
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
