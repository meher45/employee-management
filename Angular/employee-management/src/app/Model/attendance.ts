export class Attendance {
    attendanceId:any;
	employeeId:any;
	date:any;
	status:any;
    constructor(attendanceId:any,employeeId:any,date:any,status:any){
        this.attendanceId=attendanceId;
        this.employeeId=employeeId;
        this.date=date;
        this.status=status;
    }
}
