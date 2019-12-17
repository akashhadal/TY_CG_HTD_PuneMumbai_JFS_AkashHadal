import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class MedicalshopService {

  api = 'http://localhost:8080/';

  userDetailsList: User[] = [];

  userProfiles1: User[] = [];

  constructor(private http: HttpClient) { }

  getUserList() {
    this.http.get(`${this.api}getAllUsers`).subscribe(data => {
      console.log(data);
      const userArray = [];
      for (const userId in data) {
        if (data.hasOwnProperty(userId)) {
          userArray.push(...data[userId]);
        }
      }
      this.userDetailsList = userArray;
      console.log(this.userDetailsList);
    }, err => {
      console.log(err);
    });
  }

  getUserProfile(userId) {
    this.http.get<any>(`${this.api}userProfile/${userId}`).subscribe(data => {
      console.log(data);
      this.userProfiles1 = data.loginBeans;
      console.log(this.userProfiles1);
    }, err => {
      console.log(err);
    });
  }

  deleteUser(userId) {
    return this.http.delete(`${this.api}deleteUser/${userId}`);
  }

  updateUser(data) {
    return this.http.post(`${this.api}updateUser`, data);
  }
}
