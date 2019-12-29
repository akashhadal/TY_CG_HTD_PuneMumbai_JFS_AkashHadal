import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerCounterComponent } from './manager-counter.component';

describe('ManagerCounterComponent', () => {
  let component: ManagerCounterComponent;
  let fixture: ComponentFixture<ManagerCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
