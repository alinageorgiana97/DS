import {Component, OnInit} from '@angular/core';
import {User} from '../model/User';
import {UserService} from '../services/user.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];
  userInsert: User;
  displayedColumns: string[] = ['name', 'email'];
  registerForm: FormGroup;
  submitted: boolean;

  constructor(private router: Router, private userService: UserService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.submitted = false;
    this.updateUserTable();
  }

  updateUserTable() {
    this.registerForm = this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      iban: ['', Validators.required],
      address: ['', Validators.required]
    });
    this.userInsert = new User();
    this.userService.getUsers()
      .subscribe(data => {
        this.users = data;
      });
  }

  get requestedForm() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    this.userInsert.username = this.registerForm.get('username').value;
    this.userInsert.password = this.registerForm.get('paswword').value;
    // this.userInsert.role = this.registerForm.get('role').value;
    this.userService.insertUser(this.userInsert).subscribe(data => {
      alert(this.userInsert.username + ' successfull inserted');
      this.updateUserTable();
    });
  }

}
