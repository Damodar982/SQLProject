package com.gl.service;

import java.util.ArrayList;

import com.gl.dao.EmployeeDao;
import com.gl.model.Employee;


public class EmployeeService {
	EmployeeDao employeeDao;
	
	public EmployeeService() {
		employeeDao = new EmployeeDao();
	}
	public ArrayList<Employee> getAllEmployeeSvc(){
		ArrayList<Employee> employees;
		employees=employeeDao.getAllEmployeeDAO();
		return employees;
	}

	public boolean insertEmployeeSVC(Employee employees) {
		boolean flag=false;
		flag=employeeDao.insertEmployeeRecordDAO(employees);//Calling DAO 
		return flag;
	}
	
	public boolean modifyEmailIdColumn() {
		boolean flag=false;
		flag=employeeDao.modifyEmailIdColumn();
		return flag;
	}
	public boolean updateEmployeeSVC(Employee employeeUpdate) {
		boolean flag=false;
		flag=employeeDao.updateEmployeeRecordDAO(employeeUpdate);//Calling DAO 
		return flag;
	}
	public boolean deleteEmployeeByIdSVC(int dEId) {
		boolean flag=false;
		flag=employeeDao.deleteEmployeeByIdDAO(dEId);//Calling DAO 
		return flag;
	}
	public boolean removeAllRecordsSVC() {
		boolean flag=false;
		flag=employeeDao.removeAllRecordsDao();//Calling DAO 
		return flag;
	}

}
