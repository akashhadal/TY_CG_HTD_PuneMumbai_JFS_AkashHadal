import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerHotelCounterComponent } from './manager-hotel-counter.component';

describe('ManagerHotelCounterComponent', () => {
  let component: ManagerHotelCounterComponent;
  let fixture: ComponentFixture<ManagerHotelCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerHotelCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerHotelCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
