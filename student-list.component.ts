import { Component, OnInit } from '@angular/core';
import { StudentDetailComponent } from '../student-detail/student-detail.component';
import { Observable } from "rxjs";
import { StudentService } from "../student.service";
import { Student } from "../student";
import { Router } from '@angular/router';


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  'student': Observable<Student[]>;

  constructor(private studentService: StudentService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.student = this.studentService.getStudentList();
  }

  deleteStudent(id: number) {
    this.studentService.deleteStudent(id)
      .subscribe(
        (        data: any) => {
          console.log(data);
          this.reloadData();
        },
        (        error: any) => console.log(error));
  }

  studentDetails(id: number){
    this.router.navigate(['details', id]);
  }
}

