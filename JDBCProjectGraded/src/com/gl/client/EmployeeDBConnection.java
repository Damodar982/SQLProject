package com.gl.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.gl.model.Employee;
import com.gl.service.EmployeeService;

public class EmployeeDBConnection {
	Scanner scan = new Scanner(System.in);//Scanner For taking input from console
	String ans = "yes";
	String custId;
	EmployeeService employeeService = new EmployeeService();

	public EmployeeDBConnection() {	
	}

	public void showMenu() {
		int choice;
		while (ans.equals("yes") || ans.equals("YES")) {
			System.out.println("---------------MAIN MENU------------");

			System.out.println("1.Insert Employee Record");
			System.out.println("2.Modify Email_Id column");
			System.out.println("3.Update Employee Record");
			System.out.println("4.Delete Employee Record By Id");
			System.out.println("5.Remove All Employee Records");
			System.out.println("6.View all Employees");
			System.out.println("7.Exit");
			System.out.println("Enter your Choice....");
			choice = scan.nextInt();

			switch (choice) {

			case (1): {
				System.out.println("Inserting Record");
				int id;
				String name, email, phone;

				System.out.println("Enter the Employee Id");
				id = scan.nextInt();
				System.out.println("Enter the Employee Name");
				name = scan.next();
				System.out.println("Enter the Employee Email");
				email = scan.next();
				System.out.println("Enter the Employee Phone");
				phone = scan.next();

				System.out.println("Inserting New Record");
				Employee emp = new Employee(id, name, email, phone);
				if (employeeService.insertEmployeeSVC(emp)) {
					System.out.println("Inserted Employee Record Successfully");
				} else {
					System.out.println("Sorry Insertion Failed....");
				}
				break;
			}
			case (2): {
				System.out.println("Modifying Email_Id Column from varchar(50) to varchar(30)");
				if (employeeService.modifyEmailIdColumn())
					System.out.println("Successfully Modifyied Email_Id column");
				else
					System.out.println("Modification Failed");
				break;
			}
			case (3): {
				int empId;
				String upEmpName, upEmpPhone;
				System.out.println("Enter Employee Id to update");
				empId = scan.nextInt();
				System.out.println("Enter the New Name");
				upEmpName = scan.next();
				System.out.println("Enter the New Phone");
				upEmpPhone = scan.next();
				Employee employeeUpdate = new Employee(upEmpName, upEmpPhone, empId);
				if (employeeService.updateEmployeeSVC(employeeUpdate)) {
					System.out.println("Successfully updated the Name and Phone for EmployeeId=" + empId);
				} else {
					System.out.println("Sorry Updation Failed...");
				}

				break;
			}
			case (4): {
				System.out.println("Enter Employee ID to Delete Record");
				int empDelId = scan.nextInt();
				if (employeeService.deleteEmployeeByIdSVC(empDelId)) {
					System.out.println("Successfuly deleted record for EmployeeId=" + empDelId);
				} else {
					System.out.println("Sorry deletion Failed....");
				}
				break;
			}
			case (5): {
				System.out.println("Removing all records from Employee Table");
				if (employeeService.removeAllRecordsSVC()) {
					System.out.println("Successfuly Removed all records from Employee Table");
				} else {
					System.out.println("Sorry Remove failed");
				}
				break;
			}
			case (6): {
				System.out.println("Viewing All Employee");
				ArrayList<Employee> empArr = employeeService.getAllEmployeeSvc();
				System.out.println("Employee Records are");
				Iterator<Employee> iterator = empArr.iterator();
				while (iterator.hasNext()) {
					Employee e = iterator.next();
					System.out.println(e);
				}
				break;
			}
			case (7): {
				System.out.println("Exiting Application");
				return;
			}
			default: {
				System.out.println("Invalid Choice valid 1 to 5");
			}
			}
			System.out.println("Do You wish to Continue yes/no");
			ans = scan.next();

		}
		System.out.println("We are Out of Loop");
	}

}
