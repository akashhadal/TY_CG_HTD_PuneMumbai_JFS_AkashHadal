import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  payment1 = {
    userId: null,
    address: null
  };

  user;

  constructor(private productService: ProductService, private router: Router) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.loginBean.userId);
    const user = userDetails.loginBean.userId;
    this.user = userDetails;
  }


  payment(paymentForm: NgForm) {
    console.log(this.user.loginBean.userId);
    this.payment1.userId = this.user.loginBean.userId;
    console.log(paymentForm.value.address);
    this.payment1.address = paymentForm.value.address;
    this.productService.payment(this.payment1).subscribe(response => {
      paymentForm.reset();
      this.router.navigateByUrl('/order');
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
