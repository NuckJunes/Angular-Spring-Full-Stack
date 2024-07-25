import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { SelectCompanyComponent } from './select-company/select-company.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AnnouncementsComponent, SelectCompanyComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'frontend';
}
