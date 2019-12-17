import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  selectedProduct: Product = {
    productId: null,
    productName: null,
    category: null,
    price: null
  };

  constructor(private productService: ProductService, private auth: AuthService, private router: Router) {
    this.productService.getData();
    console.log(productService.products);
  }

  deleteProduct(productId) {
    this.productService.deleteData(productId).subscribe(response => {
      console.log(response);
      console.log('deleted one product');
      this.productService.getData();
    }, err => {
      console.log(err);
    });
  }

  selectProduct(product: Product) {
    this.selectedProduct = product;
  }


  submitForm(form: NgForm) {
    this.productService.updateProduct(form.value).subscribe(response => {
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
