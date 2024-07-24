import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { userInfo } from '../../services/userInfo';
import { get } from '../../services/api';
import TeamDTO from '../models/TeamDTO';

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
          firstname: "Dwayne",
          lastname: "Johnson",
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

  constructor(private userInfo: userInfo) {}

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

  async loadProjects(teamId: number) {
    // let response = await get("company", [this.id, "teams", teamId.toString(), "projects"]);
    // if(response) {
    //   return response.length();
    // }
    return 0;
  }

  projects(teamId: number) {
    //navigate to projects page and update current teamid to be this input
    this.userInfo.updateTeamIDSource(teamId);
    
  }

  
}
