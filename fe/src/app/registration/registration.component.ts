import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import Employee from '../models/Employee';
import Booking from '../models/Booking';
import Client from '../models/Client';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  @Input() selectedService: string;
  @Input() selectedEmployee: Employee;
  @Input() selectedDate: string;
  @Input() selectedHour: string;
  @Input() client: Client;
  booking: Booking;
  telephone: number;
  @Output() telephoneEvent = new EventEmitter<number>();
  @Output() saveBookingEvent = new EventEmitter<Booking>();

  constructor() {
  }

  ngOnInit() {
    this.selectedEmployee = new Employee();
    this.client = new Client();
    this.booking = new Booking();
  }

  findClient() {
    this.telephoneEvent.emit(this.telephone);
  }

  saveBooking() {
    this.booking.serviceTitle = this.selectedService;
    this.booking.EmployeeNameSurname = this.selectedEmployee.name + ' ' + this.selectedEmployee.surname;
    const dateString = this.selectedDate + 'T' + this.selectedHour + ':00';
    const newDate = new Date(dateString);
    this.booking.bookedTime = newDate;
    this.booking.ClientTelephone = this.telephone;
    this.saveBookingEvent.emit(this.booking);
  }
}
