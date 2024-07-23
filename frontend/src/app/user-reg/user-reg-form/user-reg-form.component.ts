import { Component, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-reg-form',
  standalone: true,
  imports: [MatInputModule, FormsModule, MatButtonModule, MatFormField, MatDialogTitle, MatDialogClose, MatDialogContent, MatDialogActions],
  templateUrl: './user-reg-form.component.html',
  styleUrl: './user-reg-form.component.css'
})
export class UserRegFormComponent {
  constructor(public dialogRef: MatDialogRef<UserRegFormComponent>) {}

  onCancelClick() {
    this.dialogRef.close();
  }
}
