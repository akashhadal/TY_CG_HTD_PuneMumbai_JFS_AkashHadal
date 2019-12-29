import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TariffPlanFacilitiesComponent } from './tariff-plan-facilities.component';

describe('TariffPlanFacilitiesComponent', () => {
  let component: TariffPlanFacilitiesComponent;
  let fixture: ComponentFixture<TariffPlanFacilitiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TariffPlanFacilitiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TariffPlanFacilitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
