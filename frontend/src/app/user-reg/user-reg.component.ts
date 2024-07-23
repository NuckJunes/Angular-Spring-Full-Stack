import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';

import FullUserDTO from '../models/FullUserDTO';
import ProfileDTO from '../models/ProfileDTO';
import { UserRegFormComponent } from './user-reg-form/user-reg-form.component';

@Component({
  selector: 'app-user-reg',
  standalone: true,
  imports: [NgFor, MatInputModule, MatButtonModule],
  templateUrl: './user-reg.component.html',
  styleUrl: './user-reg.component.css'
})
export class UserRegComponent {

  users: FullUserDTO[] = [{
    id: 2,
    profile: {
      firstname: "FirstName",
      lastname: "LastName",
      email: "email@email.com",
      phone: "000-000-000"
    },
    isAdmin: true,
    active: true,
    status: "Working?",
    companies: [],
    teams: []
  }];

  constructor(public dialog: MatDialog) {}

  addUser() {
    const dialogRef = this.dialog.open(UserRegFormComponent);
    dialogRef.afterClosed().subscribe(result => {
      console.log('Closed User Add');
    })
  }
}
