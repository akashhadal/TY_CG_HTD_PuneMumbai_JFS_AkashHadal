import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesCounterComponent } from './employees-counter.component';

describe('EmployeesCounterComponent', () => {
  let component: EmployeesCounterComponent;
  let fixture: ComponentFixture<EmployeesCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeesCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeesCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
