package com.project.employee;

import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDA extends MySqlConnection{

	String showAllAttendance="select * from attendance where date between ? and ?";
	String insertAttendance="insert into attendance(employeeId,date,status) values(?,?,?);";
	String updateAttendance="update attendance set status=? where employeeId=? and date=?;";

	
	
	//_____________________________Show all Department__________________________________
	
//	List<Department> alldepartments=new ArrayList<>();
//	public List<Department> alldepartment(){
//		try {
//			con=DriverManager.getConnection(url,user,pass);
//			ps=con.prepareStatement(showAllAttendance);
//			rs=ps.executeQuery();
//			while (rs.next()) {
//				alldepartments.add(new Department(rs.getInt(1),rs.getString(2)));
//			}
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//		
//		return alldepartments;
//	}
//	
	
	//______________________Create Department part_______________________________
	
	public void makeAttendance(Attendance a) {
		try {
//			con=DriverManager.getConnection(url,user,pass);
//			ps=con.prepareStatement(updateAttendance);
//			ps.setString(1, a.getStatus());
//			ps.setInt(2, a.getEmployeeId());
//			ps.setDate(3, a.getDate());
//			
//			ps.executeUpdate();
			con=DriverManager.getConnection(url,user,pass);
			ps=con.prepareStatement(insertAttendance);
			ps.setInt(1, a.getEmployeeId());
			ps.setDate(2, a.getDate());
			ps.setString(3, a.getStatus());
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println(e);
//			try {
//				
//				
//				
//			}catch(Exception f) {
//				System.out.println(f);
//				
//			}
		}
	}
	
	//_______________________Attendance Report_________________________
	
	List<Attendance> attendanceReport=new ArrayList<>();
	public List<Attendance> report(Date start, Date end){
		try {
			con=DriverManager.getConnection(url,user,pass);
			ps=con.prepareStatement(showAllAttendance);
			ps.setDate(1, start);
			ps.setDate(2, end);
			rs=ps.executeQuery();
			while(rs.next()) {
				attendanceReport.add(new Attendance(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4)));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return attendanceReport;
	}
}
