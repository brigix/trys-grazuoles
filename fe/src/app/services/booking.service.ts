import { Injectable } from '@angular/core';
import { ApiService } from '../core/api.service';
import { Observable } from 'rxjs';
import Employee from '../models/Employee';
import Service from '../models/Service';
import TimeTable from '../models/TimeTable';
import Booking from '../models/Booking';


@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(
    private api: ApiService
  ) {
  }

  getServiceList(): Observable<Service[]> {
    return this.api.get('/api/services') as Observable<Service[]>;
  }

  getEmployeesByService(selectedService: string): Observable<Employee[]> {
    return this.api.get(`/api/employees?title=${selectedService}`) as Observable<Employee[]>;
  }

  getTimetableByEmployee(name: string, surname: string): Observable<TimeTable[]> {
    return this.api.get(`/api/timetable?name=${name}&surname=${surname}`) as Observable<TimeTable[]>;
  }

  getFreeHours(name: string, surname: string, day: string): Observable<string[]> {
    return this.api.get(`/api/timetable/day?name=${name}&surname=${surname}&date=${day}`) as Observable<string[]>;
  }

  getClient(telephone: number): Observable<any> {
    return this.api.get(`/api/clients/telephone?telephone=${telephone}`) as Observable<any>;
  }

  saveBooking(booking: Booking): Observable<any> {
    return this.api.post(`/api/timetable/save_booking`, booking);
  }
}
