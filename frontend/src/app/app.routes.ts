import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { ProjectsComponent } from './projects/projects.component';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { TeamsComponent } from './teams/teams.component';
import { UserRegComponent } from './user-reg/user-reg.component';

export const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: '', component: AnnouncementsComponent},
    {path: 'projects', component: ProjectsComponent},
    {path: 'select-company', component: SelectCompanyComponent},
    {path: 'teams', component: TeamsComponent},
    {path: 'users', component: UserRegComponent}
];
