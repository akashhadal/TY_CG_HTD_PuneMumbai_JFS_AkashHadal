import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelsCounterComponent } from './hotels-counter.component';

describe('HotelsCounterComponent', () => {
  let component: HotelsCounterComponent;
  let fixture: ComponentFixture<HotelsCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelsCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelsCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
