import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private auth: AuthService) { }

  RegisterUser(form: NgForm) {
    console.log(form.value);
    this.auth.registerData(form.value).subscribe(response => {
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
