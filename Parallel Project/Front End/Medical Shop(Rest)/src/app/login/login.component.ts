import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error = null;

  constructor(private auth: AuthService, private router: Router) { }

  loginUser(form: NgForm) {
    console.log(form.value);
    this.auth.loginData(form.value).subscribe(response => {
      console.log(response);
      form.reset();
      localStorage.setItem('user', JSON.stringify(response));
      this.router.navigateByUrl('/');
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
