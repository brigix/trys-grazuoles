import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-telephone',
  templateUrl: './telephone.component.html',
  styleUrls: ['./telephone.component.css']
})
export class TelephoneComponent implements OnInit {

  telephone: number;
  @Output() telephoneEventEmitter = new EventEmitter<number>();

  constructor() {
  }

  ngOnInit() {
  }

  findClient() {
    this.telephoneEventEmitter.emit(this.telephone);
  }
}

