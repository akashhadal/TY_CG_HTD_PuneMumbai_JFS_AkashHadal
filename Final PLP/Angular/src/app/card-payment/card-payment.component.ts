import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card-payment',
  templateUrl: './card-payment.component.html',
  styleUrls: ['./card-payment.component.css']
})
export class CardPaymentComponent implements OnInit {

  totalAmount = null;

  selectedRoomDetails = null;

  constructor(private hotelService: HotelService, private router: Router) {
    this.totalAmount = this.hotelService.totalBill;
    this.selectedRoomDetails = this.hotelService.bookingHotelRoom;
  }

  payment(form: NgForm) {
    this.hotelService.paymentCardMode().subscribe(response => {
      console.log(response);
      form.reset();
      if (response.statusCode === 201) {
        //alert(response.description);
        this.router.navigateByUrl('/bookingDone');
      } else {
        alert(response.description);
      }
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
