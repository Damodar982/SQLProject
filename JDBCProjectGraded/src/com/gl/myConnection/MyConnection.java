package com.gl.myConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	Connection con;
	String url= "jdbc:mysql://localhost:3306/GLCA1";
	String user ="root";
	String password ="admin";
	
	public Connection getMyConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//loading driver
			con=DriverManager.getConnection(url,user,password);//making connection
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		return con;
	}

}
