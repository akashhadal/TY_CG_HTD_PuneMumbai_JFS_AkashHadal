import { Component, OnInit } from '@angular/core';
import { MedicalshopService } from '../medicalshop.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  selectedUser: User = {
    userId: null,
    userName: null,
    userEmail: null,
    userPassword: null,
    role: null
  };

  constructor(private medicalService: MedicalshopService) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.loginBean.userId);
    const user = userDetails.loginBean.userId;
    this.medicalService.getUserProfile(user);
    console.log(medicalService.userProfiles1);
  }

  selectUser(user: User) {
    console.log(user);
    this.selectedUser = user;
  }

  submitForm(form: NgForm) {
    this.medicalService.updateUser(form.value).subscribe(response => {
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    });
  }

  getUser() {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.loginBean.userId);
    const user = userDetails.loginBean.userId;
    this.medicalService.getUserProfile(user);
  }
  ngOnInit() {
  }

}
