import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginResponse } from './login-response';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  api = 'http://localhost:8080/';

  profile = [];

  updateUserProfile = {};

  constructor(public http: HttpClient, private router: Router) { }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  registerData(data): Observable<any> {
    return this.http.post<any>(`${this.api}userRegister`, data);
  }

  loginData(data): Observable<any> {
    return this.http.post<any>(`${this.api}login?userEmail=${data.userEmail}&password=${data.password}`, data);
  }

  getManager(): Observable<any> {
    return this.http.get<any>(`${this.api}getAllManager`);
  }

  deleteManager(data): Observable<any> {
    return this.http.delete<any>(`${this.api}deleteManager?userId=${data}`);
  }

  getEmployee(): Observable<any> {
    return this.http.get<any>(`${this.api}getAllEmployees`);
  }

  deleteEmployee(data) {
    return this.http.delete(`${this.api}deleteEmployee?userId=${data}`);
  }

  updateProfile(data) {
    console.log(data);
    this.updateUserProfile = data;
    this.router.navigateByUrl('/userUpdateProfile');
  }

  getProfile(userId): Observable<any> {
    return this.http.get<any>(`${this.api}userProfile?userId=${userId}`);
  }

  updatedProfile(data): Observable<any> {
    return this.http.post<any>(`${this.api}updateProfile`, data);
  }
}
