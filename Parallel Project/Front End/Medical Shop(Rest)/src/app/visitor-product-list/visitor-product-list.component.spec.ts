import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitorProductListComponent } from './visitor-product-list.component';

describe('VisitorProductListComponent', () => {
  let component: VisitorProductListComponent;
  let fixture: ComponentFixture<VisitorProductListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisitorProductListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitorProductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
