package com.gl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.gl.model.Employee;
import com.gl.myConnection.MyConnection;

public class EmployeeDao {
	Connection cons;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet result;
	MyConnection mCon;
	ArrayList <Employee> emloyees;
	
	public EmployeeDao() {
		emloyees=new ArrayList<>();
		mCon=new MyConnection();
	}
	
	public boolean insertEmployeeRecordDAO(Employee employee) {
		boolean flag=false;
		cons=mCon.getMyConnection();
		try {
			pstmt=cons.prepareStatement("insert into employee values(?,?,?,?)");
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getEmail_Id());
			pstmt.setString(4, employee.getPhone_Number());
			pstmt.execute();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		flag=true;
		return flag;
	}
	
	public boolean modifyEmailIdColumn() {
		boolean flag=false;
		cons=mCon.getMyConnection();
		try {
			pstmt=cons.prepareStatement("alter table employee modify Email_Id VARCHAR(30)");
			pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		flag=true;
		return flag;
	}
	public boolean updateEmployeeRecordDAO(Employee employeeUpdate) {
		boolean flag=false;
		cons=mCon.getMyConnection();
		try {
			pstmt=cons.prepareStatement("update employee set name=?, Phone_Number=? where id=?");
			pstmt.setString(1, employeeUpdate.getName());
			pstmt.setString(2, employeeUpdate.getPhone_Number());
			pstmt.setInt(3, employeeUpdate.getId());
			pstmt.execute();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return flag=true;
	}
	public boolean deleteEmployeeByIdDAO(int dEId) {
		boolean flag=false;
		cons=mCon.getMyConnection();
		try {
			pstmt=cons.prepareStatement("delete from employee where id = ? ");
			pstmt.setInt(1, dEId);
			pstmt.execute();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return flag=true;
	}

	public boolean removeAllRecordsDao() {
		boolean flag=false;
		cons=mCon.getMyConnection();
		try {
			pstmt=cons.prepareStatement("delete from employee");
			pstmt.execute();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return flag=true;
	}
	public ArrayList<Employee> getAllEmployeeDAO(){
		cons=mCon.getMyConnection();
		int id;
		String name, email_Id, phone_Number;
		try {
			stmt=cons.createStatement();//Creating statement
			result=stmt.executeQuery("select*from employee");
			if(result==null) System.out.println("No Records");
			while(result.next()) {
				id=result.getInt(1);
				name=result.getString(2);
				email_Id=result.getString(3);
				phone_Number=result.getString(4);
				Employee emp=new Employee(id,name, email_Id, phone_Number);
				emloyees.add(emp);	
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return emloyees;
	}

}
