import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  api = 'http://localhost:8080/';

  constructor(public http: HttpClient, private router: Router) { }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  registerData(data) {
    return this.http.put(`${this.api}registerUser1`, data);
  }


  loginData(data) {
    return this.http.post(`${this.api}login`, data);
  }

}
