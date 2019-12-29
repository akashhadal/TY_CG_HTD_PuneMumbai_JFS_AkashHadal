import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateManagerComponent } from './delete-update-manager.component';

describe('DeleteUpdateManagerComponent', () => {
  let component: DeleteUpdateManagerComponent;
  let fixture: ComponentFixture<DeleteUpdateManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
