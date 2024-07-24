import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { userInfo } from '../../services/userInfo';
import { get } from '../../services/api';
import ProjectDTO from '../models/ProjectDTO';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [NgFor],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent {

  projects: ProjectDTO[] = [];

  constructor(private userInfo: userInfo) {}

  ngOnInit() {
    let teamId = 0;
    this.userInfo.getTeamID().subscribe((value) => teamId = value);
    let companyId = 0;
    this.userInfo.getCompanyID().subscribe((value) => companyId = value);
    //getTeamProjects(teamId, companyId);
  }

  async getTeamProjects(teamId: number, companyId: number) {
    let response = await get("company", [companyId.toString(), "teams", teamId.toString(), "projects"]);
    if(response) {
      this.projects = response;
    }
  }

  getTeamName() {

  }

}
