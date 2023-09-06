package com.vaishhh.ConnectDB;
import java.sql.*;
public class ConnectDB
{	
	static Connection con = null;
	public static Connection connect()
	{
		
		if(con == null)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicaltracker_db","root","");
				System.out.println("Connection Established...!!!");
			} 
			catch (Exception e) 
			{
				System.err.println("Failed...!!");
				e.printStackTrace();
			}
		}
		return con;
	}
}
