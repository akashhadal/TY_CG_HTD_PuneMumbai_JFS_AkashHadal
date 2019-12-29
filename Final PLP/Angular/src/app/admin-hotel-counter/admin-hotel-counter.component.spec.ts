import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHotelCounterComponent } from './admin-hotel-counter.component';

describe('AdminHotelCounterComponent', () => {
  let component: AdminHotelCounterComponent;
  let fixture: ComponentFixture<AdminHotelCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminHotelCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminHotelCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
