import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-delete-update-employee',
  templateUrl: './delete-update-employee.component.html',
  styleUrls: ['./delete-update-employee.component.css']
})
export class DeleteUpdateEmployeeComponent implements OnInit {

  selectedUser: User = {
    userId: null,
    userName: null,
    emailId: null,
    userType: null,
    password: null
  };

  userArray: [];
  getEmployee() {
    this.authService.getEmployee().subscribe((data) => {
      console.log(data.userList);
      this.userArray = data.userList;
    });
  }
  constructor(private authService: AuthService, private router: Router) {
    this.getEmployee();
  }

  deleteEmployee(userId) {
    console.log(userId);
    this.authService.deleteEmployee(userId).subscribe(response => {
      console.log(response);
      // To update the table again after deletion
      this.getEmployee();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
