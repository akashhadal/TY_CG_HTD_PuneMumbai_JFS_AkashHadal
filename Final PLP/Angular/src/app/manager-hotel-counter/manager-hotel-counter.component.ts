import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import { Hotel } from '../hotel';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-manager-hotel-counter',
  templateUrl: './manager-hotel-counter.component.html',
  styleUrls: ['./manager-hotel-counter.component.css']
})
export class ManagerHotelCounterComponent implements OnInit {

  message = null;
  statusCode = null;
  constructor(private hotelService: HotelService, private router: Router) {
    this.hotelListForManager();
  }

  selectedHotel: Hotel = {
    hotelId: null,
    hotelName: null,
    location: null,
    availableAcRoom: null,
    availableNonAcRoom: null
  };

  updateHotelDetails: Hotel = {
    hotelId: null,
    hotelName: null,
    location: null,
    availableAcRoom: null,
    availableNonAcRoom: null
  };

  hotelListForManager() {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.adminUserBean.hotelId);
    this.hotelService.getHotelListForManager(userDetails.adminUserBean.hotelId);
  }

  hotel(addHotel: NgForm) {
    this.hotelService.addHotel(addHotel.value).subscribe(response => {
      console.log(response);
      this.statusCode = response.statusCode;
      addHotel.reset();
      if (response.statusCode === '201') {
        this.message = response.description;
        console.log(this.message);
      } else if (response.statusCode === '401') {
        this.message = response.description;
      } else {
        this.message = response.description;
      }
    }, err => {
      console.log(err);
    });
  }

  selectHotel(hotel) {
    this.selectedHotel = hotel;
  }

  updateHotelForm(updateHotel: NgForm) {
    this.updateHotelDetails.hotelId = this.selectedHotel.hotelId;
    this.updateHotelDetails.hotelName = updateHotel.value.hotelName;
    this.updateHotelDetails.location = updateHotel.value.location;
    this.updateHotelDetails.availableAcRoom = updateHotel.value.availableAcRoom;
    this.updateHotelDetails.availableNonAcRoom = updateHotel.value.availableNonAcRoom;
    this.hotelService.updateHotel(this.updateHotelDetails).subscribe(response => {
      console.log(response);
      updateHotel.reset();
    }, err => {
      console.log(err);
    });
  }

  addHotel() {
    this.router.navigateByUrl('/addHotel');
  }

  deleteHotel(hotelId) {
    console.log(hotelId);
    this.hotelService.deleteHotel(hotelId).subscribe(response => {
      console.log(response.description);
      this.statusCode = response.statusCode;
      this.hotelService.getHotelList();
      if (response.statusCode === 201) {
        this.message = response.description;
        alert(response.description);
      } else {
        this.message = response.description;
        alert(response.description);
      }
    });
  }

  addRoom(hotelId) {
    this.hotelService.addRoomById(hotelId);
  }

  ngOnInit() {
  }

}
