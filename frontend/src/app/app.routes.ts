import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { ProjectsComponent } from './projects/projects.component';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { TeamsComponent } from './teams/teams.component';
import { UserRegComponent } from './user-reg/user-reg.component';
import { GeneralGuard } from '../services/general.guard';
import { AdminGuard } from '../services/admin.guard';

export const routes: Routes = [
    {path: '', component: LoginComponent},
    {path: 'announcements', component: AnnouncementsComponent,canActivate:[GeneralGuard]},
    {path: 'projects', component: ProjectsComponent,canActivate:[GeneralGuard]},
    {path: 'select-company', component: SelectCompanyComponent,canActivate:[GeneralGuard,AdminGuard]},
    {path: 'teams', component: TeamsComponent,canActivate:[GeneralGuard]},
    {path: 'users', component: UserRegComponent,canActivate:[GeneralGuard,AdminGuard]}
];
