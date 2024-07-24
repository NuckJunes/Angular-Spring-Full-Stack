import { Component, Inject, Injectable } from '@angular/core';
import { NgFor } from '@angular/common';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import {MatSelectModule} from '@angular/material/select';
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
  imports: [NgFor, MatInputModule, FormsModule, MatButtonModule, MatFormField, MatDialogTitle, MatDialogClose, MatDialogContent, MatDialogActions, MatSelectModule],
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

  allUsers: FullUserDTO[] = [];

  currentUser: FullUserDTO = {
    id: 0,
    profile: {
      firstname: "",
      lastname: "",
      email: "",
      phone: ""
    },
    isAdmin: false,
    active: false,
    status: "",
    companies: [],
    teams: []
  };

  constructor(private userInfo: userInfo, public dialogRef: MatDialogRef<TeamsAddFormComponent>, @Inject(MAT_DIALOG_DATA) public data: TeamDTO) {}

  ngOnInit() {
    //Fill the users array with all users in a company
    this.generateUsers();
  }

  async generateUsers() {
    let id = this.userInfo.getCompanyID();
    let response = await get("company", [id.toString(), "users"])
    if(response) {
      this.allUsers = response;
      this.users = response;
    }
  }

  addUser() {
    //We must convert from FullUserDTO to BasicUserDTO
    //Removes currentUser from users and adds to teamToAdd.users
    let pos = this.users.indexOf(this.currentUser);
    this.users.splice(pos, 1)
    this.teamToAdd.users.push({
      id: this.currentUser.id,
      profile: this.currentUser.profile,
      isAdmin: this.currentUser.isAdmin,
      active: this.currentUser.active,
      status: this.currentUser.status
    });
  }

  removeUser(id: number) {
    //We must convert from BasicUserDTO to FullUserDTO
    //Removes user by id in the teamToAdd.users and add it to users
    this.teamToAdd.users = this.teamToAdd.users.filter((user) => user.id !== id)
    let tmp = this.allUsers.filter((user) => user.id === id)
    this.users.push(tmp[0]);
  }

  onCancelClick() {
    this.dialogRef.close();
  }

  onSubmitClick() {
    this.data = this.teamToAdd;
    this.dialogRef.close(this.data);
  }

}
