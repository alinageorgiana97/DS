import { Component, OnInit } from '@angular/core';
import {Patient} from '../model/Patient';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {PatientService} from '../services/patient.service';
import {Doctor} from '../model/Doctor';
import {DoctorService} from '../services/doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  doctor: Doctor[] = [];
  doctorInsert: Doctor;
  displayedColumns: string[] = ['name', 'address'];
  submitted: boolean;
  registerForm: FormGroup;

  constructor(private router: Router, private doctorService: DoctorService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {

    this.submitted = false;
    this.updateDoctorTable();
  }

  updateDoctorTable() {
    this.registerForm = this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      birthDate: ['', Validators.required],
      gender: ['', Validators.required],
      address: ['', Validators.required],
    });
    this.doctorInsert = new Doctor();
    this.doctorService.getDoctors()
      .subscribe(data => {
        this.doctor = data;
      });
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    this.doctorInsert.name = this.registerForm.get('name').value;
    this.doctorInsert.birthDate = this.registerForm.get('birthDate').value;
    this.doctorInsert.gender = this.registerForm.get('gender').value;
    this.doctorInsert.address = this.registerForm.get('address').value;
    this.doctorService.insertDoctor(this.doctorInsert).subscribe(data => {
      alert(this.doctorInsert.name + ' successfull inserted');
      this.updateDoctorTable();
    });
  }
}
