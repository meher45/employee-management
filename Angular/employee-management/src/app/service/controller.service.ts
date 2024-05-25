import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employees } from '../Model/employees';
import { User } from '../Model/user';
import { Department } from '../Model/department';
import { Role } from '../Model/role';
import { Attendance } from '../Model/attendance';

@Injectable({
  providedIn: 'root'
})
export class ControllerService {

  url:any="http://localhost:8080/";

  constructor(private http:HttpClient) { }

  //All Employee
  public allemployee():Observable<Employees>{
    this.url="http://localhost:8080/all-employee";
    return this.http.get<Employees>(this.url);
  }

  //__________________Create Employee________________________________-

  public addEmploye(employee:any):Observable<Employees>{
    alert("Angular Service")
    this.url="http://localhost:8080/create-employee";
    return this.http.post<Employees>(this.url,employee);
  }

//---------------------Login-----------------------

public login(userName:any,password:any):Observable<User>{
  this.url="http://localhost:8080/"+userName+"/"+password;
  return this.http.get<User>(this.url);
}

//------------------------all department-----------------------
public alldepartment():Observable<Department>{
  this.url="http://localhost:8080/departments";
  return this.http.get<Department>(this.url);
}

//______________________________create Department___________________________________

public createDepartment(departmentName:any):Observable<Department>{
  this.url="http://localhost:8080/departments/"+departmentName;
  return this.http.post<Department>(this.url,departmentName);
}

//-----------------------------All Role-------------------------------------

public allRole():Observable<Role>{
  this.url="http://localhost:8080/roles";
  return this.http.get<Role>(this.url);
}


//------------------Make Attendance________________________________________

public makeAttendance(a:Attendance):Observable<Attendance>{
  this.url="http://localhost:8080/attendance";
  return this.http.post<Attendance>(this.url,a);
}

//________________________Attendance Report_________________________________

public attendanceReport(startDate:any,endDate:any):Observable<Attendance>{
  this.url="http://localhost:8080/attendancereport/"+startDate+"/"+endDate;
  return this.http.get<Attendance>(this.url);
}


}
