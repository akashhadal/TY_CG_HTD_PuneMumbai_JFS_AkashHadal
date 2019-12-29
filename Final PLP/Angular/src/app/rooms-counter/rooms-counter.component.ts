import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import { Room } from '../room';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-rooms-counter',
  templateUrl: './rooms-counter.component.html',
  styleUrls: ['./rooms-counter.component.css']
})
export class RoomsCounterComponent implements OnInit {

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

  updateRoomDetails: Room = {
    roomId: null,
    roomRent: null,
    roomType: null,
    roomCapacity: null,
    roomStatus: null,
    hotelId: null,
    roomFacility: null
  };

  room(addRoom: NgForm) {
    this.hotelService.addRoom(addRoom.value).subscribe(response => {
      console.log(response);
      addRoom.reset();
      if (response.statusCode === 201) {
        this.message = response.description;
        console.log(this.message);
        alert(this.message);
      } else if (response.statusCode === 401) {
        this.message = response.description;
        alert(this.message);
      } else {
        this.message = response.description;
        alert(this.message);
      }
    }, err => {
      console.log(err);
    });
  }

  selectRoom(room) {
    this.selectedRoom = room;
  }

  updateRoomForm(updateRoom: NgForm) {
    this.updateRoomDetails.roomId = this.selectedRoom.roomId;
    this.updateRoomDetails.roomRent = updateRoom.value.roomRent;
    this.updateRoomDetails.roomType = updateRoom.value.roomType;
    this.updateRoomDetails.hotelId = this.selectedRoom.hotelId;
    this.updateRoomDetails.roomCapacity = updateRoom.value.roomCapacity;
    this.updateRoomDetails.roomStatus = updateRoom.value.roomStatus;
    this.updateRoomDetails.roomFacility = updateRoom.value.roomFacility;
    this.hotelService.updateRoom(this.updateRoomDetails).subscribe(response => {
      console.log(response);
      updateRoom.reset();
    }, err => {
      console.log(err);
    });
  }

  addRoom() {
    this.router.navigateByUrl('/addRoom');
  }

  deleteRoom(roomId) {
    console.log(roomId);
    this.hotelService.deleteRoom(roomId).subscribe(response => {
      console.log(response.description);
      this.statusCode = response.statusCode;
      this.hotelService.getRoomList();
      if (response.statusCode === '201') {
        this.message = response.description;
        console.log(this.message);
      } else if (response.statusCode === '401') {
        this.message = response.description;
        console.log(this.message);
      } else {
        this.message = response.description;
      }
    });
  }

  ngOnInit() {
  }

}
