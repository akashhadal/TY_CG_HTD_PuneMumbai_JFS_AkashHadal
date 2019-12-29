import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VisitorService {

  api = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  hotelArray = [];
  getHotelList() {
    this.http.get<any>(`${this.api}getHotelList`).subscribe(data => {
      console.log(data.hotelList);
      this.hotelArray = data.hotelList;
    }, err => {
      console.log(err);
    });
  }
}
