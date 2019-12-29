import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersCounterComponent } from './customers-counter.component';

describe('CustomersCounterComponent', () => {
  let component: CustomersCounterComponent;
  let fixture: ComponentFixture<CustomersCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomersCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomersCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
