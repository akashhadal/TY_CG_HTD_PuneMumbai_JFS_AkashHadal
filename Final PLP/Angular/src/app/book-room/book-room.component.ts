import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import { Room } from '../room';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-book-room',
  templateUrl: './book-room.component.html',
  styleUrls: ['./book-room.component.css']
})
export class BookRoomComponent implements OnInit {

  message = null;
  statusCode = null;

  constructor(private hotelService: HotelService, private router: Router) {
    this.hotelService.getRoomList();
  }

  selectedRoom: Room = {
    roomId: null,
    roomRent: null,
    roomType: null,
    roomCapacity: null,
    roomStatus: null,
    hotelId: null,
    roomFacility: null
  };

  bookRoomDetails: Room = {
    roomId: null,
    roomRent: null,
    roomType: null,
    roomCapacity: null,
    roomStatus: null,
    hotelId: null,
    roomFacility: null
  };

  statusRoom = null;

  selectRoom(room) {
    this.selectedRoom = room;
    console.log(this.selectedRoom);
  }

  bookRoomForm(bookHotelRoom: NgForm) {
    this.bookRoomDetails.roomId = this.selectedRoom.roomId;
    this.bookRoomDetails.hotelId = this.selectedRoom.hotelId;
    this.bookRoomDetails.roomRent = bookHotelRoom.value.roomRent;
    this.bookRoomDetails.roomType = bookHotelRoom.value.roomType;
    this.bookRoomDetails.roomCapacity = bookHotelRoom.value.roomCapacity;
    this.bookRoomDetails.roomStatus = bookHotelRoom.value.roomStatus;
    this.bookRoomDetails.roomFacility = bookHotelRoom.value.roomFacility;
    this.hotelService.bookHotelRoom(this.bookRoomDetails).subscribe(response => {
      console.log(response);
      bookHotelRoom.reset();
    }, err => {
      console.log(err);
    });
  }

  paymentTransfer(roomId) {
    this.hotelService.getBill(roomId);
  }

  ngOnInit() {
  }

}
