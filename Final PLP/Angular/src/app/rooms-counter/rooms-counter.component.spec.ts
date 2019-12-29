import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomsCounterComponent } from './rooms-counter.component';

describe('RoomsCounterComponent', () => {
  let component: RoomsCounterComponent;
  let fixture: ComponentFixture<RoomsCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomsCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomsCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
