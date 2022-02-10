import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { StudentListComponent } from '../student-list/student-list.component';
import { Router, ActivatedRoute } from '@angular/router';
import { Student } from '../student';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  'id': number;
  'student': Student;
  

  constructor(private route: ActivatedRoute,private router: Router,
    private studentService: StudentService) { }

  ngOnInit() {
    this.student = new Student();

    this.id = this.route.snapshot.params['id'];
    
    this.studentService.getStudent(this.id)
      .subscribe((data: any) => {
        console.log(data)
        this.student = data;
      }, (error: any) => console.log(error));
  }

  list(){
    this.router.navigate(['students']);
  }
}