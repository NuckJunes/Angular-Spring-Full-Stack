import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { userInfo } from '../../services/userInfo';
import { get } from '../../services/api';
import TeamDTO from '../models/TeamDTO';
import { SingleTeamComponent } from "./single-team/single-team.component";

@Component({
  selector: 'app-teams',
  standalone: true,
  imports: [NgFor, SingleTeamComponent],
  templateUrl: './teams.component.html',
  styleUrl: './teams.component.css'
})
export class TeamsComponent {

  id: string = "";
  teams: TeamDTO[] = [];

  constructor(private userInfo: userInfo) {}

  ngOnInit() {
    this.userInfo.getCompanyID().subscribe((value) => (this.id = value.toString()));
    this.getTeams();
  }

  async getTeams() {
    let response = await get("company", [this.id, "teams"]);
    if(response) {
      this.teams = response;
    }
  }

  async loadProjects(teamId: number) {
    let response = await get("company", [this.id, "teams", teamId.toString(), "projects"]);
    if(response) {
      return response.length();
    }
  }

  
}
