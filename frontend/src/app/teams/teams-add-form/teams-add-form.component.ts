import { Component, Inject, Injectable } from '@angular/core';
import { NgFor } from '@angular/common';
import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import TeamDTO from '../../models/TeamDTO';
import { get, post } from '../../../services/api';
import FullUserDTO from '../../models/FullUserDTO';
import { userInfo } from '../../../services/userInfo';
import { unescape } from 'querystring';
import { empty } from 'rxjs';

@Component({
  selector: 'app-teams-add-form',
  standalone: true,
  imports: [
    NgFor,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatFormField,
    MatDialogTitle,
    MatDialogClose,
    MatDialogContent,
    MatDialogActions,
    MatSelectModule,
  ],
  templateUrl: './teams-add-form.component.html',
  styleUrl: './teams-add-form.component.css',
})
export class TeamsAddFormComponent {
  teamToAdd: TeamDTO = {
    id: 0,
    name: '',
    description: '',
    teammates: [],
  };

  users: FullUserDTO[] = [];

  allUsers: FullUserDTO[] = [];

  currentUser: FullUserDTO = {
    id: 0,
    profile: {
      firstName: '',
      lastName: '',
      email: '',
      phoneNumber: '',
    },
    admin: false,
    active: false,
    status: '',
    companies: [],
    teams: [],
  };

  emptyUser: FullUserDTO = {
    id: 0,
    profile: {
      firstName: '',
      lastName: '',
      email: '',
      phoneNumber: '',
    },
    admin: false,
    active: false,
    status: '',
    companies: [],
    teams: [],
  };

  id: number = 0;

  constructor(
    private userInfo: userInfo,
    public dialogRef: MatDialogRef<TeamsAddFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: TeamDTO
  ) {}

  ngOnInit() {
    //Fill the users array with all users in a company
    this.generateUsers();
  }

  async generateUsers() {
    let id = 0;
    this.userInfo.getCompanyID().subscribe((value) => id = value);
    let response = await get('company', [id.toString(), 'users']);
    if (response) {
      this.allUsers = response;
      this.users = this.allUsers.slice();
    }
  }

  addUser(value: any) {
    //We must convert from FullUserDTO to BasicUserDTO
    //Removes currentUser from users and adds to teamToAdd.users
    let pos = this.users.indexOf(this.currentUser);
    this.users.splice(pos, 1);
    this.teamToAdd.teammates.push({
      id: this.currentUser.id,
      profile: this.currentUser.profile,
      admin: this.currentUser.admin,
      active: this.currentUser.active,
      status: this.currentUser.status,
    });
    this.currentUser = JSON.parse(JSON.stringify(this.emptyUser));
  }

  removeUser(id: number) {
    //We must convert from BasicUserDTO to FullUserDTO
    //Removes user by id in the teamToAdd.users and add it to users
    this.teamToAdd.teammates = this.teamToAdd.teammates.filter(
      (user) => user.id !== id
    );
    let tmp = undefined;
    this.allUsers.forEach(element => {
      if(element.id === id) {
        tmp = element;
      }
    });
    if(tmp !== undefined) {
      this.users.push(tmp);
    }
    this.currentUser = JSON.parse(JSON.stringify(this.emptyUser));
  }

  onCancelClick() {
    this.dialogRef.close();
  }

  onSubmitClick() {
    this.data = this.teamToAdd;
    this.dialogRef.close(this.data);
  }
}
