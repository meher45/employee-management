package com.project.employee;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int attendanceId;
//	@ManyToOne
//    @JoinColumn(name = "employee_id")
	int employeeId;
	Date date;
	String status;
	public Attendance() {
		super();
	}
	public Attendance(int attendanceId, int employeeId, Date date, String status) {
		super();
		this.attendanceId = attendanceId;
		this.employeeId = employeeId;
		this.date = date;
		this.status = status;
	}
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", employeeId=" + employeeId + ", date=" + date
				+ ", status=" + status + ", getAttendanceId()=" + getAttendanceId() + ", getEmployeeId()="
				+ getEmployeeId() + ", getDate()=" + getDate() + ", getStatus()=" + getStatus() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
