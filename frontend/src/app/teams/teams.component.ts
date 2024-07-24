import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { userInfo } from '../../services/userInfo';
import { get } from '../../services/api';
import TeamDTO from '../models/TeamDTO';
import { Router } from '@angular/router';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { TeamsAddFormComponent } from './teams-add-form/teams-add-form.component';

@Component({
  selector: 'app-teams',
  standalone: true,
  imports: [NgFor],
  templateUrl: './teams.component.html',
  styleUrl: './teams.component.css'
})
export class TeamsComponent {

  id: string = "";
  teams: TeamDTO[] = [ 
    {
      id: 0,
      name: "Team 1",
      description: "A new team 1.",
      users: [ 
      {
        id: 0,
        profile: {
          firstName: "Dwayne",
          lastName: "Johnson",
          phone: "000-000-0000",
          email: "mail@mail.com"
        },
        isAdmin: true,
        active: true,
        status: "The Rock",
      }
      ]
    },
    {
      id: 1,
      name: "Team 2",
      description: "A new team 2.",
      users: []
    },
    {
      id: 2,
      name: "Team 3",
      description: "A new team 3.",
      users: []
    }
  ];

  teamToAdd: TeamDTO = {
    id: 0,
    name: "",
    description: "",
    users: []
  }

  constructor(private userInfo: userInfo, private router: Router, public dialog: MatDialog) {}

  ngOnInit() {
    this.userInfo.getCompanyID().subscribe((value) => (this.id = value.toString()));
    //this.getTeams();
  }

  async getTeams() {
    let response = await get("company", [this.id, "teams"]);
    if(response) {
      this.teams = response;
      // this.teams.forEach(element => {
      //   this.loadProjects(element.id);
      // });
    }
  }

  loadProjects(teamId: number) {
    // let response = await get("company", [this.id, "teams", teamId.toString(), "projects"]);
    // if(response) {
    //   return response.length();
    // }
    return 0;
  }

  projects(teamId: number) {
    //navigate to projects page and update current teamid to be this input
    this.userInfo.updateTeamIDSource(teamId);
    this.router.navigate(['/projects']);
  }

  addTeam() {
    const dialogRef = this.dialog.open(TeamsAddFormComponent, {
      data: this.teamToAdd
    });
    dialogRef.afterClosed().subscribe(result => {
      //here is were we post the new user team
      //let response =  post("company", [id, "teams"], this.teamToAdd)
      //if(response) {
      //  teams = response;
      //}
    });
  }
  
}
