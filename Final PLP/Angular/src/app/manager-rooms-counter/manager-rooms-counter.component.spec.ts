import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerRoomsCounterComponent } from './manager-rooms-counter.component';

describe('ManagerRoomsCounterComponent', () => {
  let component: ManagerRoomsCounterComponent;
  let fixture: ComponentFixture<ManagerRoomsCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerRoomsCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerRoomsCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
