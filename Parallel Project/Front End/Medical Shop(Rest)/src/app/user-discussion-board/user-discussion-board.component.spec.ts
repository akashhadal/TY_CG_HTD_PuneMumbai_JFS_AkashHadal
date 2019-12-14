import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDiscussionBoardComponent } from './user-discussion-board.component';

describe('UserDiscussionBoardComponent', () => {
  let component: UserDiscussionBoardComponent;
  let fixture: ComponentFixture<UserDiscussionBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserDiscussionBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDiscussionBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
