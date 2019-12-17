import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDiscussionBoardComponent } from './admin-discussion-board.component';

describe('AdminDiscussionBoardComponent', () => {
  let component: AdminDiscussionBoardComponent;
  let fixture: ComponentFixture<AdminDiscussionBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminDiscussionBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDiscussionBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
