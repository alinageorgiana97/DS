import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../services/user.service';
import {User} from '../model/User';
import {UserView} from '../model/UserView';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private http: HttpClient
  ) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

  }

  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    console.log(this.f);
    this.userService.login(this.f.username.value, this.f.password.value)
      .subscribe(
        data => {
          const userView = (<UserView>data);
          console.log(data);
          if (userView.role === 'DOCTOR') {
            this.router.navigate(['patient']);
          // } else if (userView.role === 'CAREGIVER') {
          //   this.router.navigate(['patient']);
          // } else if (userView.role === 'PATIENT') {
          //   this.router.navigate(['medication']);
          //
            }
            },
        error => {
          alert(error);
          this.loading = false;
        });
  }

}
