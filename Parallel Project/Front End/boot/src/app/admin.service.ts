import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  api = 'http://localhost:8080/medicalshop/';

  constructor(private http: HttpClient) { }



}
