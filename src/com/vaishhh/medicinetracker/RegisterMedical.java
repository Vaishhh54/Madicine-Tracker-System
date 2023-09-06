package com.vaishhh.medicinetracker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import com.vaishhh.medicinetracker.Status;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaishhh.ConnectDB.*;


/**
 * Servlet implementation class RegisterMedical
 */
public class RegisterMedical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMedical() {
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
		String mname = request.getParameter("mname");
		String mcontact= request.getParameter("mcontact");
		String memail= request.getParameter("memail");
		String mpassword= request.getParameter("mpassword");
		String mlicence= request.getParameter("mlicence");
		String mlocation= request.getParameter("mlocation");
		String lat=request.getParameter("lat");
	    String  lng=request.getParameter("lng");
		try
		{	
			Mlatlng.setLat(lat);
			Mlatlng.setLng(lng);
		
			Connection con = ConnectDB.connect();
			PreparedStatement p1 = con.prepareStatement("select * from medical_tbl where memail=?");
			p1.setString(1, memail);
			ResultSet rs = p1.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("medicallogin.jsp");
			
			}
			else
			{  
				
				PreparedStatement p2 = con.prepareStatement("insert into medical_tbl values(?,?,?,?,?,?,?,?,?,?)");
				p2.setInt(1, 0);
				p2.setString(2, mname);
				p2.setString(3, memail);
				p2.setString(4, mpassword);
				p2.setString(5, mcontact);
				p2.setString(6, mlicence);
				p2.setString(7, lat);
				p2.setString(8, lng);
				p2.setString(9, mlocation);
				p2.setString(10, "pending");
				
				int i = p2.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("medicallogin.jsp");
				}
				else
				{
					response.sendRedirect("medicalregister.jsp");
				}
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
