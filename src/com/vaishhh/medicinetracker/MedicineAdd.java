package com.vaishhh.medicinetracker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaishhh.ConnectDB.ConnectDB;

/**
 * Servlet implementation class MedicineAdd
 */
public class MedicineAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineAdd() {
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
		
		
		String mdname = request.getParameter("mdname");
		String mdbrand= request.getParameter("mdbrand");
		String mdquantity= request.getParameter("mdquantity");
		String mdexpiredate= request.getParameter("mdexpiredate");
		int mddiscount= Integer.parseInt(request.getParameter("mddiscount"));
		int mdprice= Integer.parseInt(request.getParameter("mdprice"));
		String mgfdate= request.getParameter("mgfdate");
		
		Ulatlng.setMdprice(mdprice);
		Ulatlng.setMddiscount(mddiscount);
		
		String inputDateStr = mdexpiredate; // Replace this with your input date from the form
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inputDate = LocalDate.parse(inputDateStr, formatter);
        
        // Subtract one month from the input date
        LocalDate oneMonthBeforeDate = inputDate.minusMonths(1);

        // Output the result in the same format as the input
        String oneMonthBeforeDateStr = oneMonthBeforeDate.format(formatter);
        System.out.println("One month before the input date: " + oneMonthBeforeDateStr);
        String memail = MedUser.getMemail();
		try
		{
			Connection con = ConnectDB.connect(); 
				
				PreparedStatement p2 = con.prepareStatement("insert into medicine_tbl values(?,?,?,?,?,?,?,?,?,?)");
				p2.setInt(1, 0);
				p2.setString(2, mdname);
				p2.setString(3, mdbrand);
				p2.setString(4, mdquantity);
				p2.setString(5, mgfdate);
				p2.setString(6, mdexpiredate);
				p2.setString(7, oneMonthBeforeDateStr );
				p2.setInt(8, mddiscount);
				p2.setInt(9, mdprice);
				p2.setString(10, memail);
				int i = p2.executeUpdate();
				Ulatlng.setMdprice( mdprice);
				Ulatlng.setMddiscount( mddiscount);
				
				if(i>0)
				{
					response.sendRedirect("medicalinterface.html");
				}
				else
				{
					response.sendRedirect("addmedicine.html");
				}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}

}
