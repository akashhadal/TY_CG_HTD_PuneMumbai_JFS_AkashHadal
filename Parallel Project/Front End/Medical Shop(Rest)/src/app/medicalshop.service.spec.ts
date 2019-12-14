import { TestBed } from '@angular/core/testing';

import { MedicalshopService } from './medicalshop.service';

describe('MedicalshopService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MedicalshopService = TestBed.get(MedicalshopService);
    expect(service).toBeTruthy();
  });
});
