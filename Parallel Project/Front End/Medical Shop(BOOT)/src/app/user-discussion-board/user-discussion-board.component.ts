import { Component, OnInit } from '@angular/core';
import { DiscussionBoardService } from '../discussion-board.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-discussion-board',
  templateUrl: './user-discussion-board.component.html',
  styleUrls: ['./user-discussion-board.component.css']
})
export class UserDiscussionBoardComponent implements OnInit {

  query1 = {
    userId: null,
    message: null,
    type: null
  };
  constructor(private discussion: DiscussionBoardService) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.loginBean.userId);
    const user = userDetails.loginBean.userId;
    this.query1.userId = user;
    this.discussion.getAdminResponse(user);
    console.log(discussion.userMessageList);
  }

  submitForm(query: NgForm) {
    console.log(query.value.message);
    this.query1.message = query.value.message;
    console.log(query.value.type);
    this.query1.type = query.value.type;
    this.discussion.query(this.query1).subscribe(response => {
      console.log(response);
      query.reset();
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
