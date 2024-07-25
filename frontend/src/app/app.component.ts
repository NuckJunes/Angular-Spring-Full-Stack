import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AnnouncementsComponent } from "./announcements/announcements.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AnnouncementsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
