import {Component, OnInit} from '@angular/core';
import {Patient} from '../model/Patient';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {PatientService} from '../services/patient.service';
import {PatientView} from '../model/PatientView';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
  patients: Patient[] = [];
  patientInsert: PatientView;
  displayedColumns: string[] = ['name', 'address', 'gender', 'birthDate'];
  submitted: boolean;
  registerForm: FormGroup;

  constructor(private router: Router, private patientService: PatientService, private formBuilder: FormBuilder) {
    this.patientInsert = {
      name: '',
      address: '',
      gender: '',
      birthDate: '',
      medicalRecord: '',
      userDTO: {
        username: '',
        password: '',
        role: 'PATIENT'
      }
    };
  }

  ngOnInit() {
    this.submitted = false;
    this.updatePatientTable();
  }

  updatePatientTable() {
    this.registerForm = this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      gender: ['', Validators.required],
      birthDate: ['', Validators.required],
      medicalRecord: ['', Validators.required],
      userDTO: {
        username: ['', Validators.required],
        password: ['', Validators.required],
        role: ['', Validators.required],
      }
    });
    this.patientInsert = new PatientView();
    this.patientService.getPatients()
      .subscribe(data => {
        console.log(data);
        this.patients = data;
      });
  }

  deletePatient(patient: Patient) {
    console.log(patient);
    this.patientService.deletePatient(patient.id).pipe().subscribe()
    ;
    this.patients.splice(this.patients.indexOf(patient), 1);
    this.patientService.getPatients();
    this.updatePatientTable();
  }

  get requestedForm() {
    return this.registerForm.controls;
  }

  onSubmit() {

    this.patientInsert.name = this.registerForm.get('name').value;
    this.patientInsert.address = this.registerForm.get('address').value;
    this.patientInsert.gender = this.registerForm.get('gender').value;
    this.patientInsert.birthDate = this.registerForm.get('birthDate').value;
    this.patientInsert.medicalRecord = this.registerForm.get('medicalRecord').value;
    this.patientInsert.userDTO.username = this.registerForm.get('username').value;
    this.patientInsert.userDTO.password = this.registerForm.get('password').value;
    this.patientInsert.userDTO.role = 'PATIENT';
    console.log(this.patientInsert);
    this.patientService.insertPatient(this.patientInsert).subscribe(data => {
      alert(this.patientInsert.name + ' successfull inserted');
      this.updatePatientTable();
    });
  }
}
