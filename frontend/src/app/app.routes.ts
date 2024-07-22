import { Routes } from '@angular/router';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { AnnouncementsComponent } from './announcements/announcements.component';

export const routes: Routes = [
    { path: 'announcements', component: AnnouncementsComponent },
    { path: 'select-company', component: SelectCompanyComponent }
];
