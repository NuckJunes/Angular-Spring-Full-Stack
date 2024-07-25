import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { userInfo } from '../../services/userInfo';
import { get } from '../../services/api';
import TeamDTO from '../models/TeamDTO';
import ProjectDTO from '../models/ProjectDTO';
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
import { response } from 'express';

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
  allProjects: ProjectDTO[] = [];
  teamId: string = '';

  teamToAdd: TeamDTO = {
    id: 0,
    name: 'Test',
    description: 'asdfadsf',
    teammates: [],
  };

  constructor(
    private userInfo: userInfo,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit() {
    this.userInfo.getCompanyID().subscribe((value) => (this.id = value.toString()));
    this.userInfo.getTeamID().subscribe((value) => (this.teamId = value.toString()));
    this.getTeams();
    this.getCompanyProjects();
  }

  async getTeams() {
    try {
      let response = await get('company', [this.id, 'teams']);
      if (response) {
        this.teams = response;
        this.dataLoaded = true;
      }
    } catch (error) {
      console.error('Error fetching teams:', error);
    }
  }

  async getCompanyProjects() {
    try {
      let response = await get('company', [this.id, 'projects']);
      if (response) {
        this.allProjects = response;
      }
    } catch (error) {
      console.error('Error fetching team projects:', error);
    }
  }

  loadProjects(teamId: number) {
    let numProjects = 0;
    for (let i = 0; i < this.allProjects.length; i++) {
      if (this.allProjects[i].team.id === teamId) {
        numProjects++;
      }
    }
    return numProjects;
  }

  projects(teamId: number, teamName: string) {
    //navigate to projects page and update current teamid to be this input
    this.userInfo.updateTeamNameSource(teamName);
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
      this.postTeam(result);
    });
  }

  async postTeam(result: TeamDTO) {
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(result)
    }

    const response = await fetch(`http://localhost:8080/company/${this.id}/teams`, options)
    console.log(response.json());
    this.getTeams();
  }
}
