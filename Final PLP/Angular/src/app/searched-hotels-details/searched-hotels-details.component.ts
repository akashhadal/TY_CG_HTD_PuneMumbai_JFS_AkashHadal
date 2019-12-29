import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from '../hotel';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-searched-hotels-details',
  templateUrl: './searched-hotels-details.component.html',
  styleUrls: ['./searched-hotels-details.component.css']
})
export class SearchedHotelsDetailsComponent implements OnInit {

  constructor(private hotelService: HotelService) { }

  @Input() hotelDetails: Hotel;

  book(hotel) {
    console.log(hotel);
    this.hotelService.bookRoom(hotel);
  }

  ngOnInit() {
  }

}
