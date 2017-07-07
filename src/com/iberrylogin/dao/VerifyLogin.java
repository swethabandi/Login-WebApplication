package com.iberrylogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class VerifyLogin {
    public static boolean validate(String name, String pass) 
    {
    	boolean status = false;
    	try
    	{
        //This program validates the user id and password
    	Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akshitha","root","root");
		PreparedStatement pst=con.prepareStatement("select *from user"); 
		pst.executeQuery();
		
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
		if(	rs.getString(1).equals(name) && rs.getString(2).equals(pass))
		{
			status=true;//WELCOME
			
		}
    }
    	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
	
	}	
    	
       
    }
