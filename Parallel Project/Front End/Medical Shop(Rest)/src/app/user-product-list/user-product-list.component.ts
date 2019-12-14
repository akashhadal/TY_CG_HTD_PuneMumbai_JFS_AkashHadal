import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { MedicalshopService } from '../medicalshop.service';

@Component({
  selector: 'app-user-product-list',
  templateUrl: './user-product-list.component.html',
  styleUrls: ['./user-product-list.component.css']
})
export class UserProductListComponent implements OnInit {

  user;
  // tslint:disable-next-line: max-line-length
  constructor(private productService: ProductService, private auth: AuthService, private router: Router, private medicalService: MedicalshopService) {
    this.productService.getData();
  }

  add(product) {
    this.productService.add(product).subscribe(response => {
      console.log(response);
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
