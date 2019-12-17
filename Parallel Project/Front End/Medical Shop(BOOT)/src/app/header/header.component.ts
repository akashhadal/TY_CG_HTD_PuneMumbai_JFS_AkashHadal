import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) { }

  logout() {
    localStorage.removeItem('user');
    this.router.navigateByUrl('/');
  }

  isAdmin(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if ( userDetails.loginBean.role === 'Admin') {
      return true;
    } else {
      return false;
    }
  }

  isUser(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if ( userDetails.loginBean.role === 'User') {
      return true;
    } else {
      return false;
    }
  }

  ngOnInit() {
  }

}
