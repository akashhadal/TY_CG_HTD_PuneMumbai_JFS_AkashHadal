import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';
import { Cart } from './cart';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  api = 'http://localhost:8080/';

  selectedCart: Cart = {
    userId: null,
    userName: null,
    productId: null,
    productName: null,
    price: null
  };

  // orderBeans = {
  //   orderId: null,
  //   userId: null,
  //   userName: null,
  //   productId: null,
  //   productName: null,
  //   price: null,
  //   address: null
  // };
  products: Product[] = [];

  carts: Cart[] = [];

  orders: Order[] = [];


  user;

  constructor(private http: HttpClient) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails);
    this.user = userDetails;
  }

  postData(data) {
    return this.http.post(`${this.api}addProduct`, data);
  }

  getData() {
    this.http.get(`${this.api}getAllProducts`).subscribe(data => {
      console.log(data);
      const productArray = [];
      for (const productId in data) {
        if (data.hasOwnProperty(productId)) {
          productArray.push(...data[productId]);
        }
      }
      this.products = productArray;
      console.log(this.products);
    }, err => {
      console.log(err);
    });
  }

  add(product: Product) {
    this.selectedCart.userId = this.user.loginBean.userId;
    this.selectedCart.userName = this.user.loginBean.userName;
    this.selectedCart.productId = product.productId;
    this.selectedCart.productName = product.productName;
    this.selectedCart.price = product.price;

    return this.http.post(`${this.api}cartProduct`, this.selectedCart);
  }

  deleteData(productId) {
    console.log(productId);
    return this.http.delete(`${this.api}deleteProduct/${productId}`);
  }

  updateProduct(data) {
    return this.http.put(`${this.api}updateProduct`, data);
  }

  getCartData(user) {
    console.log(user);
    this.http.get<any>(`${this.api}viewCart/${user}`).subscribe(data => {
      console.log(data);
      this.carts = data.cartBeans;
      console.log(this.carts);
    }, err => {
      console.log(err);
    });
  }

  getOrderData(user) {
    console.log(this.user.loginBean.userId);
    this.http.get<any>(`${this.api}viewOrder/${user}`).subscribe(data => {
      this.orders = data.orderBeans;
    }, err => {
      console.log(err);
    });
  }

  deleteProductFromCart(cart) {
    return this.http.post(`${this.api}cartDelete`, cart);
  }

  payment(payment) {
    return this.http.post(`${this.api}payment`, payment);
  }

}
