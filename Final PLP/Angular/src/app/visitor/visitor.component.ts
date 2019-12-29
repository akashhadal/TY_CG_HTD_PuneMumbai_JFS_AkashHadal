import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VisitorService } from '../visitor.service';

@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.css']
})
export class VisitorComponent implements OnInit {

  hotel = {};

  constructor(private hotelService: VisitorService, private router: Router) {
    console.log('visitor ts');
    this.hotelService.getHotelList();
    this.hotel = this.hotelService.hotelArray;
  }

  bookNow() {
    this.router.navigateByUrl('/sign-in');
  }
  ngOnInit() {
  }

}
