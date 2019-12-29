import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchedHotelsDetailsComponent } from './searched-hotels-details.component';

describe('SearchedHotelsDetailsComponent', () => {
  let component: SearchedHotelsDetailsComponent;
  let fixture: ComponentFixture<SearchedHotelsDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchedHotelsDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchedHotelsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
