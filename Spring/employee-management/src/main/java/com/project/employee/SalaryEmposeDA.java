package com.project.employee;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
public class SalaryEmposeDA extends MySqlConnection{

	String salarybyid="select * from salary_empose where employeeId=?";
	String salarybymonth="select * from salary_empose where month=?";
	String salaryinput="insert into salary_empose(employeeId,basic,house,communication,transport,medical,leave,leaveNotPay,bonous,total,month,emposeDate) values(?,?,?,?,?,?);";
	
	
	public void insertSalary(SalaryEmpose s) {
		try {
//			
			con=DriverManager.getConnection(url,user,pass);
			ps=con.prepareStatement(salaryinput);
			ps.setInt(1,s.getEmployeeId());
			ps.setDouble(2, s.getBasic());
			ps.setDouble(3, s.getHouse());
			ps.setDouble(4, s.getCommunication());
			ps.setDouble(5, s.getTransport());
			ps.setDouble(6, s.getMedical());
			ps.setInt(7, s.getLeave());
			ps.setDouble(8, s.getLeaveNotPay());
			ps.setDouble(9, s.getBonous());
			ps.setDouble(10, s.getTotal());
			ps.setString(11, s.getMonth());
			ps.setInt(12,s.getYear());
			ps.setDate(13, s.getEmposeDate());
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println(e);
//			
		}
	}
	
	//-----------------------Salary by Month------------------------------
	
List<SalaryEmpose> salary=new ArrayList<>();
	
	public List<SalaryEmpose> employeeSalary(String month){
		try {
			con=DriverManager.getConnection(url,user,pass);
			ps=con.prepareStatement(salarybymonth);
			ps.setString(1, month);
			rs=ps.executeQuery();
			while (rs.next()) {
				salary.add(new SalaryEmpose(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8),rs.getDouble(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getInt(13), rs.getDate(14)));
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return salary;
	}
}
