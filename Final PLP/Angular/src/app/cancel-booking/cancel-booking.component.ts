import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {

  dateObject = new Date();
  date = this.dateObject.getDate();
  month = this.dateObject.getMonth();
  year = this.dateObject.getFullYear();

  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;

  bookedRoomListDisplay = [];

  constructor(private hotelService: HotelService, private router: Router) {
    this.getBookingList();
  }

  getBookingList() {
    this.hotelService.userBookedRoom().subscribe(response => {
      console.log(response);
      this.bookedRoomListDisplay = response.bookedRoomList;
    }, err => {
      console.log(err);
    });
  }

  cancelBooking(user) {
    console.log(user.bookingId);
    if (user.checkInDate > this.todaysDate) {
      this.hotelService.cancelBooking(user.bookingId).subscribe(response => {
        console.log(response);
        if (response.statusCode === 201) {
          alert(response.description);
        } else {
          alert(response.description);
        }
        this.getBookingList();
      }, err => {
        console.log(err);
      });
    } else {
      alert('Booking Cannot Be Canceled on Same Date');
    }

  }

  ngOnInit() {

  }
}
