import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-mode',
  templateUrl: './payment-mode.component.html',
  styleUrls: ['./payment-mode.component.css']
})
export class PaymentModeComponent implements OnInit {

  totalAmount = null;

  selectedRoomDetails = null;

  constructor(private hotelService: HotelService, private router: Router) {
    console.log(this.hotelService.totalBill);
    this.totalAmount = this.hotelService.totalBill;
    this.selectedRoomDetails = this.hotelService.bookingHotelRoom;
    console.log(this.selectedRoomDetails);
  }

  paymentDone() {
    this.hotelService.paymentCashMode().subscribe(response => {
      console.log(response);
      this.router.navigateByUrl('/bookingDone');
    }, err => {
      console.log(err);
    });
  }

  cardPayment() {
    this.router.navigateByUrl('/cardPayment');
  }


  ngOnInit() {
  }

}
