import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ApiService } from '../core/api.service';
import Employee from '../models/Employee';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  @Input() employees: Employee[];
  @Input() selectedService: string;
  @Output() selectedEmployeeEvent = new EventEmitter<Employee>();
  selectedEmployee: Employee;

  constructor(
    private api: ApiService,
  ) {
  }

  ngOnInit() {
    this.selectedEmployee = new Employee();
  }

  selectEmployee() {
    this.selectedEmployeeEvent.emit(this.selectedEmployee);
  }
}
