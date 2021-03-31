import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Doctor} from '../model/Doctor';
import {REST_API} from '../common/API';
import {Observable, throwError} from 'rxjs';
import 'rxjs-compat/add/operator/catch';
import {MatDialog} from '@angular/material';
import {ErrorService} from '../utils/error-service';


@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient, private dialog: MatDialog) {
  }

  getDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(REST_API + 'person')
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

  insertDoctor(doctor: Doctor): Observable<Doctor> {
    return this.http.post<any>(REST_API + 'person', doctor)
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

  getDoctorById(id: number): Observable<Doctor> {
    return this.http.get<Doctor>(REST_API + 'person' + id)
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

}

