import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DiscussionBoardService {

  api = 'http://localhost:8080/medicalshop/';

  userMessageList = [];

  constructor(private http: HttpClient) { }

  getUserMessage() {
    this.http.get(`${this.api}getAdminMessage`).subscribe(data => {
      console.log(data);
      const messageArray = [];
      for (const userId in data) {
        if (data.hasOwnProperty(userId)) {
          messageArray.push(...data[userId]);
        }
      }
      this.userMessageList = messageArray;
      console.log(this.userMessageList);
    }, err => {
      console.log(err);
    });
  }

  getAdminResponse(userId) {
    this.http.get<any>(`${this.api}getUserMessage/${userId}`).subscribe(data => {
      console.log(data);
      this.userMessageList = data.messageBeans;
      console.log(this.userMessageList);
    }, err => {
      console.log(err);
    });
  }

  replyUser(data) {
    return this.http.put(`${this.api}adminResponse`, data);
  }

  query(data) {
    return this.http.put<any>(`${this.api}userQuery`, data);
  }
}
