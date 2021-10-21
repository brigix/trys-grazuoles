import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DateRangeType} from 'igniteui-angular';
import Employee from '../models/Employee';
import TimeTable from '../models/TimeTable';


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})


export class CalendarComponent implements OnInit {
  public formatOptions: any;
  public formatViews: any;
  public locale: string;

  public disabledDates = [
    {
      type: DateRangeType.Before,
      dateRange: [
        new Date(),
      ]
    },
    {type: DateRangeType.Weekends}
  ];

  @Input() selectedEmployee: Employee;
  @Input() timetable: TimeTable[];
  @Input() selectedService: string;
  @Output() selectedDateEvent = new EventEmitter<string>();
  selectedDate: Date;
  selectedDateStr: string;
  fullBookedDates: Date[];
  @Input() freeHours: string[];
  selectedHour: string;
  @Output() selectedHourEvent = new EventEmitter<string>();

  public ngOnInit() {
    this.selectedEmployee = new Employee();
    this.selectedDate = new Date();
    this.locale = 'lt';
    this.formatOptions = {day: '2-digit', month: 'long', weekday: 'short', year: 'numeric'};
    this.formatViews = {day: true, month: true, year: true};
  }

  selectDate() {
    const offset = this.selectedDate.getTimezoneOffset();
    let tempDate: Date;
    tempDate = new Date(this.selectedDate.getTime() - (offset * 60 * 1000));
    this.selectedDateStr = tempDate.toISOString().split('T')[0];
    this.selectedDateEvent.emit(this.selectedDateStr);
  }

  selectHour() {
    console.log('emit selected hour: ', this.selectedHour);
    this.selectedHourEvent.emit(this.selectedHour);
  }
}

