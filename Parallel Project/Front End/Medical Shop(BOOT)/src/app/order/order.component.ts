import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private product: ProductService) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.loginBean.userId);
    const user = userDetails.loginBean.userId;
    this.product.getOrderData(user);
    console.log(product.orders);
   }

  ngOnInit() {
  }

}
