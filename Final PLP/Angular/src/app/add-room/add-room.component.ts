import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent implements OnInit {

  message = null;

  constructor(private hotelService: HotelService) { }

  room(addRoom: NgForm) {
    console.log(addRoom.value);
    this.hotelService.addRoom(addRoom.value).subscribe(response => {
      addRoom.reset();
      this.message = response.description;
      if (response.statusCode === 201) {
        alert(response.description);
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
