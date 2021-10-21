import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingLoginComponent } from './booking-login.component';

describe('BookingLoginComponent', () => {
  let component: BookingLoginComponent;
  let fixture: ComponentFixture<BookingLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookingLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
