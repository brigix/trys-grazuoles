import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import Booking from '../models/Booking';
import Client from '../models/Client';

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

  @Input() booking: Booking;
  @Input() client: Client;
  @Output() confirmEvent = new EventEmitter<Booking>();

  constructor() {
  }

  ngOnInit() {
    this.booking = new Booking();
    this.client = new Client();
  }

  confirm() {
    this.confirmEvent.emit(this.booking);
  }
}
