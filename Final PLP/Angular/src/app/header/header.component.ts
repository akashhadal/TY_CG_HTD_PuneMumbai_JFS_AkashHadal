import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public auth: AuthService, public router: Router) { }

  logout() {
    localStorage.removeItem('user');
    alert('Logout Successfull.....');
    this.router.navigateByUrl('/');
  }

  isAdmin(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if ( userDetails.adminUserBean.userType === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  isUser(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if ( userDetails.adminUserBean.userType === 'user') {
      return true;
    } else {
      return false;
    }
  }

  isManager(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if ( userDetails.adminUserBean.userType === 'manager') {
      return true;
    } else {
      return false;
    }
  }

  isEmployee(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if ( userDetails.adminUserBean.userType === 'employee') {
      return true;
    } else {
      return false;
    }
  }

  ngOnInit() {
  }

}
