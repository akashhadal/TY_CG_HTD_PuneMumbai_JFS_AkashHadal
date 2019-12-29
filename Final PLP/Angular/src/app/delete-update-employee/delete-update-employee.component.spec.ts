import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateEmployeeComponent } from './delete-update-employee.component';

describe('DeleteUpdateEmployeeComponent', () => {
  let component: DeleteUpdateEmployeeComponent;
  let fixture: ComponentFixture<DeleteUpdateEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
