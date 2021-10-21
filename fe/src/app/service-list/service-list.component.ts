import { Component, EventEmitter, Injectable, Input, OnInit, Output } from '@angular/core';
import { ApiService } from '../core/api.service';
import Service from '../models/Service';
import Employee from '../models/Employee';


/*interface Service {
  serviceTitle: string;
  price: number;
}*/

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})

@Injectable()
export class ServiceListComponent implements OnInit {

  @Input() serviceList: Service[];
  @Output() selectedServiceEvent = new EventEmitter<string>();
  employees: Employee[];
  selectedService: string;
  selectedEmployee: Employee;

  constructor(
    private api: ApiService
  ) {
  }

  ngOnInit() {
    // this.api.get('/api/services').subscribe((data: Service[]) => this.services = data);
  }

  selectService() {
    this.selectedServiceEvent.emit(this.selectedService);
  }

}
