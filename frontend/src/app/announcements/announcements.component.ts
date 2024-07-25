import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import FullUserDTO from '../models/FullUserDTO';
import AnnouncementDTO from '../models/AnnouncementDTO';
import { userInfo } from '../../services/userInfo';
import { NavmenuComponent } from '../navmenu/navmenu.component';

@Component({
  selector: 'app-announcements',
  standalone: true,
  imports: [CommonModule, NavmenuComponent],
  templateUrl: './announcements.component.html',
  styleUrls: ['./announcements.component.css']
})
export class AnnouncementsComponent implements OnInit {

  user: FullUserDTO | undefined = undefined;
  announcements: AnnouncementDTO[] = [];
  announcementPopup: boolean = false;

  constructor(private userService: userInfo) {}

  ngOnInit() {
    this.userService.getFullUser().subscribe(user => {
      this.user = user;
    })
    this.fetchAnnouncements();
    console.log(this.user);
  }

  async fetchAnnouncements() {
    try {
      const response = await fetch('http://localhost:8080/company/1/announcements');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data: AnnouncementDTO[] = await response.json();
      this.announcements = data.map(announcement => ({
        ...announcement,
        date: new Date(announcement.date).toLocaleDateString()
      }));
    } catch (error) {
      console.error('Error fetching announcements:', error);
    }
  }

  newAnnouncementPopup() {
    this.announcementPopup = !this.announcementPopup;
  }

  submitAnnouncement(title: string, message: string) {
    // Implementation for submitting an announcement
  }
}
