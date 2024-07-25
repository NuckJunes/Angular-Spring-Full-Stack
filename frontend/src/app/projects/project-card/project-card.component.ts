import { NgIf } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import ProjectDTO from '../../models/ProjectDTO';
import { CreateProjectComponent } from "../create-project/create-project.component";

@Component({
  selector: 'app-project-card',
  standalone: true,
  imports: [NgIf, CreateProjectComponent],
  templateUrl: './project-card.component.html',
  styleUrl: './project-card.component.css'
})
export class ProjectCardComponent {
  showOverlay = false;
  daysAgo = 0;
  hoursAgo = 0;
  minutesAgo = 0;
  @Input('project') project: ProjectDTO = {
    id: 0,
    name: '',
    description: '',
    active: false,
    team: {
      id: 0,
      name: '',
      description: '',
      users: [], // initialize users array with no elements
    },
    date: '',
  };
  @Output() toggleModal = new EventEmitter<any>();

  ngOnInit() {
    const date1 = new Date(this.project.date);
    const date2 = new Date();
    const millDifference = date2.getTime() - date1.getTime();
    this.daysAgo = Math.floor(millDifference / (1000 * 3600 * 24));
    this.hoursAgo = Math.floor(millDifference / (1000 * 3600));
    this.minutesAgo = Math.floor(millDifference / (1000 * 60));
  }

  toggleOverlay() {
    this.showOverlay = !this.showOverlay;
  }
}
