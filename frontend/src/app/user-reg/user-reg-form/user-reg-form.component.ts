import { Component, EventEmitter, Inject, Input, Output } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatPseudoCheckbox } from '@angular/material/core';
import FullUserDTO from '../../models/FullUserDTO';
import UserRequestDto from '../../models/UserRequestDto';
import { HttpClient } from '@angular/common/http';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-user-reg-form',
  standalone: true,
  imports: [MatInputModule, FormsModule, NgIf],
  templateUrl: './user-reg-form.component.html',
  styleUrl: './user-reg-form.component.css'
})
export class UserRegFormComponent {
  modalVisible = true;
  user: UserRequestDto = {
    credentials: {
      username: '',
      password: '',
    },
    profile: {
      firstName: '',
      lastName: '',
      email: '',
      phone: '',
    },
    admin: false,
  };
  result = '';
  firstName = '';
  lastName = '';
  password = '';
  confirmPassword = '';
  email = '';

  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  constructor(private http: HttpClient) {}

  addUser(form: any) {
    this.user.credentials.username =
      form.firstName.toLowerCase() + '.' + form.lastName.toLowerCase();
    this.user.credentials.password = form.password;
    this.user.profile.firstName = form.firstName;
    this.user.profile.lastName = form.lastName;
    this.user.profile.email = form.email;
    this.user.profile.phone = form.phoneNumber;
    this.user.admin = form.userIsAdmin;

    const url =
      'http://localhost:8080' +
      '/company/' +
      localStorage.getItem('companyId') +
      '/user';
    this.http.post<any>(url, this.user).subscribe({
      error: (e) => {
        console.log(e);
        this.result = 'something went wrong';
      },
      complete: () => {
        window.location.reload();
        this.handleOverlayExit();
      },
    });
  }

  handleOverlayExit() {
    this.updateUserOverlayVisibility.emit();
  }
}
