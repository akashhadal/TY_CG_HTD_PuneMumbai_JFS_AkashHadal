import { Component, OnInit } from '@angular/core';
import { DiscussionBoardService } from '../discussion-board.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-admin-discussion-board',
  templateUrl: './admin-discussion-board.component.html',
  styleUrls: ['./admin-discussion-board.component.css']
})
export class AdminDiscussionBoardComponent implements OnInit {

  selectedMessage = {
    userId: null,
    message: null,
    type: null
  };

  constructor(private discussion: DiscussionBoardService) {
    this.discussion.getUserMessage();
    console.log(discussion.userMessageList);
  }
  selectMessage(messages) {
    console.log(messages);
    this.selectedMessage = messages;
  }

  // selectMessage(message) {
  //   console.log(message);
  //   this.selectMessage = message;
  // }

  submitForm(reply: NgForm) {
    this.discussion.replyUser(reply.value).subscribe(response => {
      console.log(response);
      reply.reset();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
