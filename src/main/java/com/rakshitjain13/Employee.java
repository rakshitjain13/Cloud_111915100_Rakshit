package com.rakshitjain13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	String url="jdbc:mysql://localhost:3306/cloud";
	String username="root";
	String password_sql="Rd@878889";
	String sql="insert into rakshit_111915100(Employee_ID_Number,First_Name,Last_Name,Date_of_Birth,Contact_Number,password) values(?,?,?,?,?,?)";
	String[] JobRoles={"Developer","Tester","Devops"};
	public int RandomNumber(int max,int min) {
		int ans = (int)(Math.random()*(max-min+1)+min);  
		return ans;
	}
	public boolean CreateEmployee(String Employee_ID_Number,String First_Name,String Last_Name,String Date_of_Birth,String Contact_Number,String password) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection(url,username,password_sql);
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, Employee_ID_Number);
		st.setString(2, First_Name);
		st.setString(3, Last_Name);
		st.setString(4, Date_of_Birth);
		st.setString(5, Contact_Number);
		st.setString(6, password);
		int rs1=st.executeUpdate();
		sql="insert into rakshit_111915100_slary(Employee_ID_Number,Job_Role,Monthly_Salary,Yearly_Bonus) values(?,?,?,?)";
		st=con.prepareStatement(sql);
		st.setString(1, Employee_ID_Number);
		int pos=RandomNumber(2,0);
		st.setString(2, JobRoles[pos]);
		st.setString(3,String.valueOf(RandomNumber(20000, 30000)));
		st.setString(4,String.valueOf(RandomNumber(10000, 15000)));
		st.executeUpdate();
		if(rs1==1) {
			return true;
		}
		return false;
	} 
	public String CheckEmployee(String employee_id,String password) throws ClassNotFoundException, SQLException {
		String SqlCheck="select * from rakshit_111915100 where Employee_ID_Number=? and password=?";
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection(url,username,password_sql);
		PreparedStatement st=con.prepareStatement(SqlCheck);
		st.setString(1, employee_id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			return rs.getString("first_name");
		}
		String empty="";
		return empty;
	}
	public String GetDetails() throws ClassNotFoundException, SQLException {
		String values="";
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection(url,username,password_sql);
		String sql1="select * from rakshit_111915100 ";
		PreparedStatement st=con.prepareStatement(sql1);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			values=values+"\n"+rs.getString("Employee_ID_Number")+" : "+rs.getString("First_Name");
		}
		return values;
	} 
	public String GetEmployeeDetails(String employee_id) throws ClassNotFoundException, SQLException {
		String values="";
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection(url,username,password_sql);
		String sql1="select * from rakshit_111915100 where employee_id_number=?";
		PreparedStatement st=con.prepareStatement(sql1);
		st.setString(1, employee_id);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			values="First_Name :"+rs.getString("First_Name")+ ", Last_Name: "+rs.getString("Last_Name")+", Date_of_Birth: "+rs.getString("Date_of_Birth")+", Contact_Number: "+rs.getString("Contact_Number");
		}
		return values;
	} 
	public String GetSalary(String employee_id) throws ClassNotFoundException, SQLException {
		String values="";
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection(url,username,password_sql);
		String sql1="select * from rakshit_111915100_slary where employee_id_number=?";
		PreparedStatement st=con.prepareStatement(sql1);
		st.setString(1, employee_id);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
		values=rs.getString("Employee_ID_Number")+" , Job Role :"+rs.getString("Job_Role")+ ", Monthly_Salary: "+rs.getString("Monthly_Salary")+", Yearly_Bonus: "+rs.getString("Yearly_Bonus");
		int YearlySalarayWithBonus=Integer.valueOf(rs.getString("Monthly_Salary"))*12+Integer.valueOf(rs.getString("Yearly_Bonus"));
		values+=", YearlySalarayWithBonus: "+YearlySalarayWithBonus;
		}
		return values;
	} 
}
