import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-add-manager',
  templateUrl: './add-manager.component.html',
  styleUrls: ['./add-manager.component.css']
})
export class AddManagerComponent implements OnInit {

  user = {
    userName: null,
    password: null,
    userType: null,
    userEmail: null,
    nationality: null,
    phoneNumber: null,
    address: null,
    hotelId: null
  };

  message = null;

  constructor(private auth: AuthService, private hotelService: HotelService) { }

  RegisterUser(registrationForm: NgForm) {
    this.user.userName = registrationForm.value.userName;
    this.user.password = registrationForm.value.password;
    this.user.userType = 'manager';
    this.user.userEmail = registrationForm.value.userEmail;
    this.user.address = registrationForm.value.address;
    this.user.nationality = registrationForm.value.nationality;
    this.user.phoneNumber = registrationForm.value.phoneNumber;
    this.user.hotelId = registrationForm.value.hotelId;
    this.auth.registerData(this.user).subscribe(response => {
      console.log(response);
      registrationForm.reset();
      console.log(response.statusCode);
      if (response.statusCode === '201') {
        console.log(this.message);
        alert(response.description);
      } else if (response.statusCode === '401') {
        alert(response.description);
      } else {
        alert(response.description);
      }
    }, err => {
      console.log(err);
    });

  }

  ngOnInit() {
  }

}
