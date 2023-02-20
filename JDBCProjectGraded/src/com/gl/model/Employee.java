package com.gl.model;

public class Employee {

		int id;
		String name;
		String Email_Id;
		String Phone_Number;
		
		public Employee() {
		}
		public Employee(int id, String name, String email_Id, String phone_Number) {
			super();
			this.id = id;
			this.name = name;
			Email_Id = email_Id;
			Phone_Number = phone_Number;
		}
		
		public Employee(String name,String phone_Number,int id) {
			super();
			this.name = name;
			this.Phone_Number = phone_Number;
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail_Id() {
			return Email_Id;
		}
		public void setEmail_Id(String email_Id) {
			Email_Id = email_Id;
		}
		public String getPhone_Number() {
			return Phone_Number;
		}
		public void setPhone_Number(String phone_Number) {
			Phone_Number = phone_Number;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", Email_Id=" + Email_Id + ", Phone_Number=" + Phone_Number
					+ "]";
		}	
		
}
