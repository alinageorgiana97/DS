import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Caregiver} from '../model/Caregiver';
import {REST_API} from '../common/API';
import {Observable, throwError} from 'rxjs';
import 'rxjs-compat/add/operator/catch';
import {MatDialog} from '@angular/material';
import {ErrorService} from '../utils/error-service';


@Injectable({
  providedIn: 'root'
})
export class CaregiverService {

  constructor(private http: HttpClient, private dialog: MatDialog) {
  }

  getCaregivers(): Observable<Caregiver[]> {
    return this.http.get<Caregiver[]>(REST_API + 'person')
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

  insertCaregiver(caregiver: Caregiver): Observable<Caregiver> {
    return this.http.post<any>(REST_API + 'person', caregiver)
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

  getCaregiverById(id: number): Observable<Caregiver> {
    return this.http.get<Caregiver>(REST_API + 'person' + id)
      .catch((e: any) => throwError(ErrorService.handleError(e, this.dialog)));
  }

}

