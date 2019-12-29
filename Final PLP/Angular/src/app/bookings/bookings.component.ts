import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

  dateObject = new Date();
  date = this.dateObject.getDate();
  month = this.dateObject.getMonth();
  year = this.dateObject.getFullYear();

  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;

  constructor(private hotelService: HotelService, private router: Router) { }

  search(bookingForm: NgForm) {
    console.log(bookingForm.value);
    if ((bookingForm.value.checkInDate >= this.todaysDate) && (bookingForm.value.checkOutDate >= bookingForm.value.checkInDate)) {
      this.hotelService.searchHotel(bookingForm.value);
    } else {
      alert('Enter Valid Check In & Check Out Dates');
    }

  }

  ngOnInit() {
  }

}
