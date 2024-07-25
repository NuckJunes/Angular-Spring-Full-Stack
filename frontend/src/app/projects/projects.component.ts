import { Component } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { userInfo } from '../../services/userInfo';
import { get } from '../../services/api';
import ProjectDTO from '../models/ProjectDTO';
import { HttpClient } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';
import { ProjectCardComponent } from "./project-card/project-card.component";
import { CreateProjectComponent } from "./create-project/create-project.component";
import { NavmenuComponent } from "../navmenu/navmenu.component";

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [NgFor, ProjectCardComponent, NgIf, CreateProjectComponent, RouterModule, NavmenuComponent],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent {

  showOverlay = false;
  projects: ProjectDTO[] = [];
  teamName = '';
  teamId = 0;
  team: any = undefined;
  isAdmin = false;

  constructor(private http: HttpClient, private router: Router) {
    const input = this.router.getCurrentNavigation();
    const receivedTeamId = input?.extras?.state?.['teamId'];
    if (receivedTeamId) this.teamId = receivedTeamId;
    const receivedTeamName = input?.extras?.state?.['teamName'];
    if (receivedTeamName) this.teamName = receivedTeamName;
    const receivedTeam = input?.extras?.state?.['team'];
    if (receivedTeam) this.team = receivedTeam;
  }

  ngOnInit() {
    const user = JSON.parse(localStorage.getItem('user') as string);
    if (this.teamId === 0) this.teamId = user.teams[0].id;
    if (this.teamName === '') this.teamName = user.teams[0].name;
    if (!this.team) this.team = user.teams[0];
    this.isAdmin = user.admin;

    const url =
      'http://localhost:8080/company/' +
      localStorage.getItem('companyId') +
      '/teams/' +
      this.teamId +
      '/projects';
    this.http.get<any>(url).subscribe({
      next: (data) => {
        this.projects = (data as ProjectDTO[]).sort((a: ProjectDTO, b: ProjectDTO) => a.date < b.date ? 1 : -1);
      },
      error: (e) => console.error(e),
    });
  }

  updateProjectList() {
    const url =
      'http://localhost:8080/company/' +
      localStorage.getItem('companyId') +
      '/teams/' +
      this.teamId +
      '/projects';
    this.http.get<any>(url).subscribe({
      next: (data) => {
        this.projects = data as ProjectDTO[];
      },
      error: (e) => console.error(e),
    });
  }

  toggleOverlay() {
    this.showOverlay = !this.showOverlay;
  }
}
