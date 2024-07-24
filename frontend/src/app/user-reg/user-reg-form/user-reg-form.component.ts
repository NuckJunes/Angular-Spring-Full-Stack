import { Component, Inject, Input } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import FullUserDTO from '../../models/FullUserDTO';

@Component({
  selector: 'app-user-reg-form',
  standalone: true,
  imports: [MatInputModule, FormsModule, MatButtonModule, MatFormField, MatDialogTitle, MatDialogClose, MatDialogContent, MatDialogActions],
  templateUrl: './user-reg-form.component.html',
  styleUrl: './user-reg-form.component.css'
})
export class UserRegFormComponent {
  constructor(public dialogRef: MatDialogRef<UserRegFormComponent>, @Inject(MAT_DIALOG_DATA) public data: FullUserDTO) {}

  userToAdd: FullUserDTO = {
    id: 0,
    profile: {
      firstname: "",
      lastname: "",
      email: "",
      phone: ""
    },
    isAdmin: false,
    active: false,
    status: "Pending",
    companies: [],
    teams: []
  }

  onCancelClick() {
    this.dialogRef.close();
  }

  onSubmitClick() {
    this.data = this.userToAdd;
    this.dialogRef.close(this.data);
  }
}
