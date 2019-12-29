import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  api = 'http://localhost:8080/';

  hotelId = null;

  totalBill = null;

  hotelArray: [];

  roomArray: [];

  searchedHotel = [];

  bookingHotelRoom = {
    roomId: null,
    userId: null,
    hotelId: null,
    roomAmount: null,
    paymentStatus: null,
    modeOfPayment: null,
    checkInDate: null,
    checkOutDate: null
  };

  constructor(private http: HttpClient, private router: Router) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    this.bookingHotelRoom.userId = userDetails.adminUserBean.userId;
  }

  addHotel(data): Observable<any> {
    console.log(data);
    return this.http.post<any>(`${this.api}addHotel`, data);
  }

  getHotelList() {
    this.http.get<any>(`${this.api}getHotelList`).subscribe(data => {
      console.log(data.hotelList);
      this.hotelArray = data.hotelList;
    }, err => {
      console.log(err);
    });
  }

  getHotelListForManager(hotelId) {
    this.http.get<any>(`${this.api}getHotelListForManager?hotelId=${hotelId}`).subscribe(data => {
      console.log(data);
      this.hotelArray = data.hotelList;
    }, err => {
      console.log(err);
    });
  }

  updateHotel(data) {
    return this.http.post<any>(`${this.api}updateHotel`, data);
  }

  deleteHotel(hotelId) {
    return this.http.delete<any>(`${this.api}removeHotel?hotelId=${hotelId}`);
  }

  searchHotel(bookingForm) {
    this.bookingHotelRoom.checkInDate = bookingForm.checkInDate;
    this.bookingHotelRoom.checkOutDate = bookingForm.checkOutDate;
    this.http.get<any>(`${this.api}getHotelLocationList?location=${bookingForm.location}`).subscribe(data => {
      console.log(data.hotelList);
      this.searchedHotel = data.hotelList;
      this.router.navigateByUrl('/searchedHotel');
    }, err => {
      console.log(err);
    });
  }

  addRoom(data): Observable<any> {
    console.log(data);
    return this.http.post<any>(`${this.api}addRoom`, data);
  }

  getRoomList() {
    console.log(this.bookingHotelRoom.hotelId);
    this.http.get<any>(`${this.api}getRoomList?hotelId=${this.bookingHotelRoom.hotelId}`).subscribe(data => {
      console.log(data.roomList);
      this.roomArray = data.roomList;
    }, err => {
      console.log(err);
    });
  }

  getRoomListForManager(hotelId) {
    this.http.get<any>(`${this.api}getRoomList?hotelId=${hotelId}`).subscribe(data => {
      console.log(data.roomList);
      this.roomArray = data.roomList;
    }, err => {
      console.log(err);
    });
  }

  updateRoom(data) {
    return this.http.post<any>(`${this.api}updateRoom`, data);
  }

  deleteRoom(roomId) {
    return this.http.delete<any>(`${this.api}removeRoom?roomId=${roomId}`);
  }

  getCustomer(): Observable<any> {
    return this.http.get<any>(`${this.api}bookingList`);
  }

  bookRoom(hotelDetails) {
    this.bookingHotelRoom.hotelId = hotelDetails.hotelId;
    this.router.navigateByUrl('/bookRoom');
  }

  bookHotelRoom(data) {
    return this.http.post<any>(`${this.api}bookRoom`, data);
  }

  getBill(roomId) {
    this.bookingHotelRoom.roomId = roomId;
    console.log(this.bookingHotelRoom);
    this.http.post<any>(`${this.api}bill`, this.bookingHotelRoom).subscribe(response => {
      console.log(response);
      console.log(this.bookingHotelRoom);
      this.totalBill = response.bill;
      this.router.navigateByUrl('/paymentMode');
    }, err => {
      console.log(err);
    });
  }

  paymentCashMode(): Observable<any> {
    this.bookingHotelRoom.modeOfPayment = 'cash';
    this.bookingHotelRoom.paymentStatus = 'UnPaid';
    console.log(this.bookingHotelRoom);
    return this.http.post<any>(`${this.api}booking`, this.bookingHotelRoom);
  }

  paymentCardMode(): Observable<any> {
    this.bookingHotelRoom.modeOfPayment = 'card';
    this.bookingHotelRoom.paymentStatus = 'Done';
    console.log(this.bookingHotelRoom);
    return this.http.post<any>(`${this.api}booking`, this.bookingHotelRoom);
  }

  userBookedRoom(): Observable<any> {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    const userId = userDetails.adminUserBean.userId;
    console.log(userId);
    return this.http.get<any>(`${this.api}userBookedList?userId=${userId}`, userId);
  }

  cancelBooking(bookingId): Observable<any> {
    return this.http.delete<any>(`${this.api}cancelBooking?bookingId=${bookingId}`);
  }

  addRoomById(hotelId) {
    this.hotelId = hotelId;
    this.router.navigateByUrl('/addRoom');
  }

  addManager(hotelId) {
    this.hotelId = hotelId;
    console.log(this.hotelId);
    this.router.navigateByUrl('/addManager');
  }

}
