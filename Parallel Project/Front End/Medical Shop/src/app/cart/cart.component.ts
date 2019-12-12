import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  constructor(private product: ProductService) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.loginBean.userId);
    const user = userDetails.loginBean.userId;
    this.product.getCartData(user);
    console.log(product.carts);
  }

  deleteProductCart(cart) {
    console.log(cart);
    this.product.deleteProductFromCart(cart).subscribe(response => {
      console.log(response);
      const userDetails = JSON.parse(localStorage.getItem('user'));
      console.log(userDetails.loginBean.userId);
      const user = userDetails.loginBean.userId;
      this.product.getCartData(user);
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
