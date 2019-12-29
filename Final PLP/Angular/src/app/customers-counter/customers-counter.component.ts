import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customers-counter',
  templateUrl: './customers-counter.component.html',
  styleUrls: ['./customers-counter.component.css']
})
export class CustomersCounterComponent implements OnInit {

  selectedUser: Customer = {
    bookingId: null,
    hotelId: null,
    roomId: null,
    userId: null,
    amount: null,
    paymentStatus: null,
    modeOfPayment: null,
    checkinDate: null,
    checkoutDate: null,
  };

  userArray: [];

  getCustomer() {
    this.authService.getCustomer().subscribe((data) => {
      console.log(data.bookedRoomList);
      this.userArray = data.bookedRoomList;
    });
  }

  constructor(private authService: HotelService, private router: Router) {
    this.getCustomer();
  }

  ngOnInit() {
  }

}
