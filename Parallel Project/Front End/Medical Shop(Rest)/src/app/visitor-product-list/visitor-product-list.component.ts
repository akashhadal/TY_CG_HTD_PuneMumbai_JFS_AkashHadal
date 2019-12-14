import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visitor-product-list',
  templateUrl: './visitor-product-list.component.html',
  styleUrls: ['./visitor-product-list.component.css']
})
export class VisitorProductListComponent implements OnInit {

  constructor(private productService: ProductService, private auth: AuthService, private router: Router) {
    this.productService.getData();
    console.log(productService.products);
   }

  ngOnInit() {
  }

}
