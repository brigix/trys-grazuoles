import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingStepperComponent } from './booking-stepper/booking-stepper.component';
import { BookingLoginComponent } from './booking-login/booking-login.component';

const routes: Routes = [
 { path: 'booking-stepper', component: BookingStepperComponent},
 { path: 'booking-login', component: BookingLoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    onSameUrlNavigation: 'reload'
  })],
  exports: [RouterModule],
})
export class AppRoutingModule { }


/*
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingStepperComponent } from './booking-stepper/booking-stepper.component';
import { AppComponent } from './app.component';
import { MatInputModule, MatStepperModule, MatToolbarModule } from '@angular/material';


const routes: Routes = [
  {
    path: 'booking-stepper', component: BookingStepperComponent
    /!* loadChildren: () =>
       import('./booking-stepper/booking-stepper.module').then(m => m.BookingStepperModule)*!/
  },
  {
    path: '', component: AppComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), MatToolbarModule, MatInputModule, MatStepperModule],
  declarations: [
    AppComponent,
    BookingStepperComponent
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
*/
