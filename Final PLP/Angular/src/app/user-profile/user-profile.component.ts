import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userProfile = {};
  constructor(private auth: AuthService) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    this.getProfile(userDetails.adminUserBean.userId);
  }

  getProfile(userId) {
    console.log(userId);
    this.auth.getProfile(userId).subscribe(response => {
      console.log(response);
      this.userProfile = response.adminUserBean;
    }, err => {
      console.log(err);
    });
  }

  updateProfile(userProfile) {
    console.log(userProfile);
    this.auth.updateProfile(userProfile);
  }

  ngOnInit() {

  }

}


