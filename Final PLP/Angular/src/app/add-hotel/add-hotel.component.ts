import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-hotel',
  templateUrl: './add-hotel.component.html',
  styleUrls: ['./add-hotel.component.css']
})
export class AddHotelComponent implements OnInit {

  message = null;

  constructor(private hotelService: HotelService) { }

  hotel(addHotel: NgForm) {
    this.hotelService.addHotel(addHotel.value).subscribe(response => {
      addHotel.reset();
      console.log(response);
      this.message = response.description;
      if (response.statusCode === 201) {
        alert(response.description);
      } else {
        alert(response.description);
      }
    });
  }

  ngOnInit() {
  }

}
