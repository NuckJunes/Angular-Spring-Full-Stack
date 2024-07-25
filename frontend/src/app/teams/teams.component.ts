import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { userInfo } from '../../services/userInfo';
import { get } from '../../services/api';
import TeamDTO from '../models/TeamDTO';
import { Router } from '@angular/router';
import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { TeamsAddFormComponent } from './teams-add-form/teams-add-form.component';
import { NavmenuComponent } from '../navmenu/navmenu.component';

@Component({
  selector: 'app-teams',
  standalone: true,
  imports: [NgFor, NgIf, NavmenuComponent],
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css'],
})
export class TeamsComponent {
  id: string = '';
  teams: TeamDTO[] = [];
  dataLoaded = false;
  // teams: TeamDTO[] = [
  //   {
  //     id: 0,
  //     name: 'Team xyz',
  //     description: 'New team',
  //     users: [],
  //   },
  // ];
  // teams: TeamDTO[] = [
  //   {
  //     id: 0,
  //     name: "Team 1",
  //     description: "A new team 1.",
  //     users: [
  //     {
  //       id: 0,
  //       profile: {
  //         firstName: "Dwayne",
  //         lastName: "Johnson",
  //         phoneNumber: "000-000-0000",
  //         email: "mail@mail.com"
  //       },
  //       admin: true,
  //       active: true,
  //       status: "The Rock",
  //     }
  //     ]
  //   },
  //   {
  //     id: 1,
  //     name: "Team 2",
  //     description: "A new team 2.",
  //     users: []
  //   },
  //   {
  //     id: 2,
  //     name: "Team 3",
  //     description: "A new team 3.",
  //     users: []
  //   }
  // ];

  teamToAdd: TeamDTO = {
    id: 0,
    name: '',
    description: '',
    teammates: [],
  };

  constructor(
    private userInfo: userInfo,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit() {
    this.userInfo
      .getCompanyID()
      .subscribe((value) => (this.id = value.toString()));
    this.getTeams();
  }

  async getTeams() {
    try {
      let response = await get('company', ['1', 'teams']);
      if (response) {
        this.teams = response;
        console.log('Response: ');
        console.log(response);
        // for (let i = 0; i < response.length; i++) {
        //   this.teams[i].users = response[i].teammates;
        // }
        this.dataLoaded = true;
        console.log(this.teams);
      }
    } catch (error) {
      console.error('Error fetching teams:', error);
    }
  }

  // async getTeams() {
  //   //let response = await get('company', [this.id, 'teams']);
  //   let response = await get('company', ['1', 'teams']);
  //   if (response) {
  //     //this.teams.push(response[0]);
  //     //console.log(this.teams);
  //     let team1 = response[0];
  //     console.log('Team 1: ');
  //     console.log(team1);
  //     let team1DTO = {
  //       id: 69,
  //       name: 'team1.name',
  //       description: 'team1.description',
  //       users: [],
  //     };
  //     console.log('Team 1 DTO: ');
  //     console.log(team1DTO);
  //     this.teams.push(team1DTO);
  //     let team2 = {
  //       id: 0,
  //       name: 'Team 3',
  //       description: 'New team',
  //       users: [],
  //     };
  //     this.teams.push(team2);

  //     //this.teams = response;
  //     // this.teams.forEach((element) => {
  //     //   this.loadProjects(element.id);
  //     // });
  //   }
  //   // console.log('Teams: ' + this.teams);
  //   // console.log(this.teams[0]);
  // }

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
      data: this.teamToAdd,
    });
    dialogRef.afterClosed().subscribe((result) => {
      //here is were we post the new user team
      //let response =  post("company", [id, "teams"], this.teamToAdd)
      //if(response) {
      //  teams = response;
      //}
    });
  }
}
