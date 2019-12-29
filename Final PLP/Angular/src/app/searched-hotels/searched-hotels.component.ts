import { Component, OnInit } from '@angular/core';
import { Hotel } from '../hotel';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-searched-hotels',
  templateUrl: './searched-hotels.component.html',
  styleUrls: ['./searched-hotels.component.css']
})
export class SearchedHotelsComponent implements OnInit {

  constructor(private hotelService: HotelService) {
  }

  hotels = this.hotelService.searchedHotel;

  selectedHotel = this.hotels[0];

  selectHotel(hotel: Hotel) {
      console.log(hotel);
      this.selectedHotel = hotel;
      console.log(hotel);
  }

  ngOnInit() {
  }

}
