import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {
  MatIconModule,
  MatMenuModule,
  MatToolbarModule,
  MatButtonModule,
  MatTableModule,
  MatPaginatorModule,
  MatDialogModule
} from '@angular/material';
import {RouterModule} from '@angular/router';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {UsersComponent} from './users/users.component';
import {HomeComponent} from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {HeaderComponent} from './header/header.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ErrorHandlingComponent } from './error-handling/error-handling.component';
import { LoginComponent } from './login/login.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';
import { CaregiverComponent } from './caregiver/caregiver.component';
import { MedicationComponent } from './medication/medication.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    HomeComponent,
    HeaderComponent,
    ErrorHandlingComponent,
    LoginComponent,
    DoctorComponent,
    PatientComponent,
    CaregiverComponent,
    MedicationComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    HttpClientModule,
    MatPaginatorModule,
    RouterModule.forRoot([
      {
        path: 'user',
        component: UsersComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'patient',
        component: PatientComponent
      },
      {
        path: '',
        component: HomeComponent
      }
    ]),
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule
  ],
  entryComponents: [
    ErrorHandlingComponent
  ],
  exports: [
    MatPaginatorModule,
    MatTableModule,
    ErrorHandlingComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
