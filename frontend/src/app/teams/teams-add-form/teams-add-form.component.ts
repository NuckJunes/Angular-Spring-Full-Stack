import { Component, Inject, Injectable } from '@angular/core';
import { NgFor } from '@angular/common';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import TeamDTO from '../../models/TeamDTO';
import { get, post } from '../../../services/api';
import FullUserDTO from '../../models/FullUserDTO';
import { userInfo } from '../../../services/userInfo';

@Component({
  selector: 'app-teams-add-form',
  standalone: true,
  imports: [NgFor, MatInputModule, FormsModule, MatButtonModule, MatFormField, MatDialogTitle, MatDialogClose, MatDialogContent, MatDialogActions],
  templateUrl: './teams-add-form.component.html',
  styleUrl: './teams-add-form.component.css'
})
export class TeamsAddFormComponent {

  teamToAdd: TeamDTO = {
    id: 0,
    name: "",
    description: "",
    users: []
  }

  users: FullUserDTO[] = [];

  constructor(private userInfo: userInfo, public dialogRef: MatDialogRef<TeamsAddFormComponent>, @Inject(MAT_DIALOG_DATA) public data: TeamDTO) {}

  ngOnInit() {
    //Fill the users array with all users in a company
    this.generateUsers();
  }

  async generateUsers() {
    let id = this.userInfo.getCompanyID();
    let response = await get("company", [id.toString(), "users"])
    if(response) {
      this.users = response;
    }
  }

  onCancelClick() {
    this.dialogRef.close();
  }

  onSubmitClick() {
    this.data = this.teamToAdd;
    this.dialogRef.close(this.data);
  }

}
