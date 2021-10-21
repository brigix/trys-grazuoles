import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { ApiService } from '../core/api.service';
import Employee from '../models/Employee';
import Service from '../models/Service';
import { BookingService } from '../services/booking.service';
import TimeTable from '../models/TimeTable';
import { Time } from '@angular/common';
import Booking from '../models/Booking';
import Client from '../models/Client';

/**
 * @title Stepper with customized states
 */

@Component({
  selector: 'app-booking-stepper',
  templateUrl: './booking-stepper.component.html',
  styleUrls: ['./booking-stepper.component.css'],
  providers: [{
    provide: STEPPER_GLOBAL_OPTIONS, useValue: {displayDefaultIndicatorType: false}
  }]
})
export class BookingStepperComponent implements OnInit {
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  serviceList: Service[];
  @Input() selectedService: string;
  employeesListByService: Employee[];
  @Input() selectedEmployee: Employee;
  timetable: TimeTable[];
  @Input() selectedDateStr: string;
  freeHours: string[];
  @Input() selectedHour: string;
  @Input() telephone: number;
  @Input() booking: Booking;
  client: Client;
  toastMessage = '';


  constructor(private formBuilder: FormBuilder, private api: ApiService, private bookingService: BookingService) {

  }

  ngOnInit() {
    this.firstFormGroup = this.formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this.formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.bookingService.getServiceList()
      .subscribe((serviceListFromBack: Service[]) => {
        this.serviceList = serviceListFromBack;
      });
  }

  refetchEmployeeList() {
    this.bookingService.getEmployeesByService(this.selectedService)
      .subscribe((employeesFromBack: Employee[]) => {
        this.employeesListByService = employeesFromBack;
      });
  }

  refetchTimetable() {
    this.bookingService.getTimetableByEmployee(this.selectedEmployee.name, this.selectedEmployee.surname)
      .subscribe((timetableFromBack: TimeTable[]) => {
        this.timetable = timetableFromBack;
      });
  }

  refetchFreeHours() {
    this.bookingService.getFreeHours(this.selectedEmployee.name, this.selectedEmployee.surname, this.selectedDateStr)
      .subscribe((hoursFromBack: string[]) => {
        this.freeHours = hoursFromBack;
      });
  }

  refetchClient() {
    this.bookingService.getClient(this.telephone)
      .subscribe((clientFromBack: Client) => {
        this.client = clientFromBack;
      });
  }

  onSelectedServiceEvent(selectedService1: string) {
    this.selectedService = selectedService1;
    this.bookingService.getEmployeesByService(selectedService1);
    this.refetchEmployeeList();
  }

  onSelectedEmployeeEvent(selectedEmployee1: Employee) {
    this.selectedEmployee = selectedEmployee1;
    this.bookingService.getTimetableByEmployee(selectedEmployee1.name, selectedEmployee1.surname);
    this.refetchTimetable();
  }

  onSelectedDateEvent(selectedDateStr1: string) {
    this.selectedDateStr = selectedDateStr1;
    this.refetchFreeHours();
  }

  onSelectedTimeEvent(selectedTime1: string) {
    this.selectedHour = selectedTime1;
    console.log('SELECTED: ', this.selectedService,
      this.selectedEmployee.surname, this.selectedEmployee.name,
      this.selectedDateStr, this.selectedHour);
  }

  onFindClientEvent(telephone1: number) {
    this.telephone = telephone1;
    this.refetchClient();
  }

  onSaveBookingEvent(booking1: Booking) {
    this.booking = booking1;
  }

  onConfirmBookingEvent(booking1: Booking) {
    this.booking = booking1;
    console.log('CONFIRM BOOKING', booking1);
    this.bookingService.saveBooking(booking1).subscribe(saveBooking => {
      this.toastMessage = 'Rezervacija sėkminga !';
      document.getElementById('savedToast').hidden = false;
    });
  }

  closeToast() {
    document.getElementById('savedToast').hidden = true;
  }
}








