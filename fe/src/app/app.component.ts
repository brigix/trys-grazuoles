import { Component, OnInit } from '@angular/core';
import { BookingService } from './services/booking.service';
import Service from './models/Service';
import Employee from './models/Employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent extends Component implements OnInit {
  title = 'beauty booking';

  ngOnInit() {

  }


}
