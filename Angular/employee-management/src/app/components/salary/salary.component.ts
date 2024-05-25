import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})
export class SalaryComponent implements OnInit {

  salary:any;
  emposeSalary:any;
  templete:any;
  attendanceDate:any;
  allemployee:any;

  month:any;
  constructor() { }

  ngOnInit(): void {
  }
  salaryEmpose(){

  }
  show(){

  }

  makeAttendance(id:any,status:any){

  }

}
