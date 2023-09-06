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
 * Servlet implementation class LoginMedical
 */
public class LoginMedical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMedical() {
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
		String memail = request.getParameter("memail");
		String mpassword = request.getParameter("mpassword");
		
		try
		{
		Connection con = ConnectDB.connect();
		
		PreparedStatement ps2 = con.prepareStatement("select * from medical_tbl where memail=? and mpassword=?");
		ps2.setString(1, memail);
		ps2.setString(2, mpassword);
		ResultSet rs = ps2.executeQuery();
		if(rs.next())
		{ 
			response.sendRedirect("medicalinterface.html");
			MedUser.setMemail(memail);
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


