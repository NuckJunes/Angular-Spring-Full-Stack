import { NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, NgModule, Output } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { userInfo } from '../../../services/userInfo';

@Component({
  selector: 'app-create-project',
  standalone: true,
  imports: [FormsModule,NgIf],
  templateUrl: './create-project.component.html',
  styleUrl: './create-project.component.css'
})
export class CreateProjectComponent {
 // just for testing
 admin = true;
 //
 modalVisible = true;
 projectName = '';
 description = '';
 result = '';
 companyId = 0;
 active = true;
 //@Input() teamId = 0;
 teamId: number = 0;
 @Input() project: any;
 @Input() team: any;
 @Output() updateOverlay = new EventEmitter<any>();

 constructor(private http: HttpClient, private userInfo: userInfo) {
  userInfo.getTeamID().subscribe(teamId => this.teamId = teamId);
 }

 ngOnInit(): void {
   const companyId = JSON.parse(localStorage.getItem('companyId')!);
   if (companyId) this.companyId = companyId;
   if (this.project) {
     this.projectName = this.project.name;
     this.description = this.project.description;
   }
 }

 postOrPut() {
   if (this.project) this.updateProject();
   else this.createProject();
 }

 updateProject() {
   this.http
     .put(
       `http://localhost:8080/company/${this.companyId}/teams/${this.project.team.id}/project/${this.project.id}`,
       {
         name: this.projectName,
         description: this.description,
         active: this.active,
         team: {id: this.teamId},
       }
     )
     .subscribe({
       error: (e) => {
         console.log(e);
         this.result = 'something went wrong';
       },
       complete: () => {
         window.location.reload();
         this.exit();
       },
     });
 }

 createProject() {
   this.http
     .post(
       `http://localhost:8080/company/${this.companyId}/teams/${this.teamId}/project`,
       {
         name: this.projectName,
         description: this.description,
         active: this.active,
         team: {id: this.teamId},
       }
     )
     .subscribe({
       error: (e) => {
         console.log(e);
         this.result = 'something went wrong';
       },
       complete: () => {
         window.location.reload();
         this.exit();
       },
     });
 }

 exit() {
   this.updateOverlay.emit();
 }
}
