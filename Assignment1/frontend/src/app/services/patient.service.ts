import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Patient} from '../model/Patient';
import {REST_API} from '../common/API';
import {Observable, throwError} from 'rxjs';
import 'rxjs-compat/add/operator/catch';
import {MatDialog} from '@angular/material';
import {ErrorService} from '../utils/error-service';
import {PatientView} from '../model/PatientView';


@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient, private dialog: MatDialog) {
  }

  getPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(REST_API + 'patient/list')
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

  insertPatient(patient: PatientView): Observable<Patient> {
    return this.http.post<any>(REST_API + 'patient/save', patient)
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

  getPatientById(id: number): Observable<Patient> {
    return this.http.get<Patient>(REST_API + 'patient' + id)
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }
  deletePatient(id: number) {
    return this.http.get<Patient>(REST_API + 'patient/delete/' + id)
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }
}



