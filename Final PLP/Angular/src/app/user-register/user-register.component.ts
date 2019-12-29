import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

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

  message = null;

  constructor(private auth: AuthService, private router: Router) { }

  RegisterUser(registrationForm: NgForm) {
    this.user.userName = registrationForm.value.userName;
    this.user.password = registrationForm.value.password;
    this.user.userType = 'user';
    this.user.userEmail = registrationForm.value.userEmail;
    this.user.address = registrationForm.value.address;
    this.user.nationality = registrationForm.value.nationality;
    this.user.phoneNumber = registrationForm.value.phoneNumber;
    this.user.hotelId = 88888;
    this.auth.registerData(this.user).subscribe(response => {
      console.log(response);
      registrationForm.reset();
      console.log(response.statusCode);
      if (response.statusCode === 201) {
        this.message = response.description;
        alert(this.message);
        this.router.navigateByUrl('/sign-in');
      } else if (response.statusCode === 401) {
        this.message = response.description;
        alert(this.message);
      } else {
        this.message = response.description;
        alert(this.message);
      }
    }, err => {
      console.log(err);
    });

  }

  ngOnInit() {
  }

}
