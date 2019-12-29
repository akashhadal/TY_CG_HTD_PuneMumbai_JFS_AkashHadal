import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-delete-update-manager',
  templateUrl: './delete-update-manager.component.html',
  styleUrls: ['./delete-update-manager.component.css']
})
export class DeleteUpdateManagerComponent implements OnInit {

  selectedUser: User = {
    userId: null,
    userName: null,
    emailId: null,
    userType: null,
    password: null
  };

  userArray: [];
  getManager() {
    this.authService.getManager().subscribe((data) => {
      console.log(data.getAllManager);
      this.userArray = data.getAllManager;
    });
  }
  constructor(private authService: AuthService, private router: Router) {
    this.getManager();
  }

  deleteManager(userId) {
    console.log(userId);
    this.authService.deleteManager(userId).subscribe(response => {
      console.log(response);
      // To update the table again after deletion
      this.getManager();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
