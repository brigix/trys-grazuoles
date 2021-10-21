import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatDatepickerModule, MatDialogModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatRadioModule,
  MatStepperModule,
  MatToolbarModule
} from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BookingStepperComponent } from './booking-stepper/booking-stepper.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { EmployeeComponent } from './employee/employee.component';
import { ServiceListComponent } from './service-list/service-list.component';
import { CalendarComponent } from './calendar/calendar.component';
import { IgxCalendarModule } from 'igniteui-angular';
import { BookingService } from './services/booking.service';
import { BookingLoginComponent } from './booking-login/booking-login.component';
import { RegistrationComponent } from './registration/registration.component';
import { TelephoneComponent } from './telephone/telephone.component';
import { ConfirmComponent } from './confirm/confirm.component';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';

@NgModule({
  declarations: [
    AppComponent,
    BookingStepperComponent,
    EmployeeComponent,
    ServiceListComponent,
    CalendarComponent,
    BookingLoginComponent,
    RegistrationComponent,
    TelephoneComponent,
    ConfirmComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatStepperModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatInputModule,
    MatDatepickerModule,
    FormsModule,
    MatRadioModule,
    IgxCalendarModule,
    MatDialogModule,
    MatCardModule,
    MatGridListModule
  ],
  providers: [
    { provide: 'selectedService', useValue: 'selectedService' },
   BookingService
  ],
  exports: [
    BookingStepperComponent,
    EmployeeComponent,
    ServiceListComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
