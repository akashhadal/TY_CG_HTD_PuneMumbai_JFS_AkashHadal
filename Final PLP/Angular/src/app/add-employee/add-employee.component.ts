import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user = {
    userName: null,
    password: null,
    userType: null,
    userEmail: null,
    nationality: null,
    address: null,
    phoneNumber: null,
    hotelId: null
  };

  managerHotelId = null;

  message = null;

  constructor(private auth: AuthService) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    this.managerHotelId = userDetails.adminUserBean.hotelId;
   }

  RegisterUser(registrationForm: NgForm) {
    this.user.userName = registrationForm.value.userName;
    this.user.password = registrationForm.value.password;
    this.user.userType = 'employee';
    this.user.userEmail = registrationForm.value.userEmail;
    this.user.address = registrationForm.value.address;
    this.user.nationality = registrationForm.value.nationality;
    this.user.phoneNumber = registrationForm.value.phoneNumber;
    this.user.hotelId = registrationForm.value.hotelId;
    this.auth.registerData(this.user).subscribe(response => {
      console.log(response);
      registrationForm.reset();
      console.log(response.statusCode);
      if (response.statusCode === 201) {
        alert('Employee Registered Successfully');
        console.log(this.message);
      } else if (response.statusCode === 401) {
        alert('Employee Registeration Failed');
      }
    }, err => {
      console.log(err);
    });

  }

  ngOnInit() {
  }

}
