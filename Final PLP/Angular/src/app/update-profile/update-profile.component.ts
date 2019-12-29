import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { UserProfile } from '../user-profile';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  userProfile: UserProfile = {
    userId: null,
    userName: null,
    userType: null,
    emailId: null,
    address: null,
    nationality: null,
    phoneNumber: null,
    password: null
  };

  constructor(private auth: AuthService, private router: Router) {

  }

  UpdateProfile(UpdateProfileForm: NgForm) {
    console.log(UpdateProfileForm.value);
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.adminUserBean.userId);
    this.userProfile.userId = userDetails.adminUserBean.userId;
    this.userProfile.userName = UpdateProfileForm.value.userName;
    this.userProfile.userType = 'user';
    this.userProfile.password = UpdateProfileForm.value.password;
    this.userProfile.emailId = UpdateProfileForm.value.userEmail;
    this.userProfile.address = UpdateProfileForm.value.address;
    this.userProfile.nationality = UpdateProfileForm.value.nationality;
    this.userProfile.phoneNumber = UpdateProfileForm.value.phoneNumber;
    console.log(this.userProfile);
    this.auth.updatedProfile(this.userProfile).subscribe(response => {
      if (response.statusCode === 201) {
        alert(response.description);
        this.router.navigateByUrl('userProfile');
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
