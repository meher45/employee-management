import { Component, OnInit } from '@angular/core';
import { Attendance } from 'src/app/Model/attendance';
import { ControllerService } from 'src/app/service/controller.service';

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrls: ['./attendance.component.css']
})
export class AttendanceComponent implements OnInit {

  templete:any;
  allemployee:any;
  startDate:any;
  endDate:any;
  attendanceReport:any=[];

  attendanceDate:any;

  attendanceId:any;
	employeeId:any;
	// date:any;
	status:any;

  attendance:any;
  show(){
    
  }
  constructor(private myservice:ControllerService) {
    this.myservice.allemployee().subscribe((x)=>{
      this.allemployee=x;
    })
   }

  ngOnInit(): void {
  }


  makeAttendance(id:any,status:any){
    this.attendance=new Attendance(this.attendanceId,id,this.attendanceDate,status);
    this.myservice.makeAttendance(this.attendance).subscribe(()=>{
      // alert("Update Attendance")
    })

  }
  report(){
    this.myservice.attendanceReport(this.startDate,this.endDate).subscribe((x)=>{
      this.attendanceReport=x;
    })
  }

}
