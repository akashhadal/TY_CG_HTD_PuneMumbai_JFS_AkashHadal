import { Component, OnInit } from '@angular/core';
import { MedicalshopService } from '../medicalshop.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private medicalService: MedicalshopService) {
    this.medicalService.getUserList();
    console.log(medicalService.getUserList);
  }


  deleteUser(userId) {
    console.log(userId);
    this.medicalService.deleteUser(userId).subscribe(response => {
      console.log(response);
      this.medicalService.getUserList();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
