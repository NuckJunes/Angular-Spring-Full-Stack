import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';


interface Announcement {
  date: string,
  title: string,
  message: string,
  author: string
}

interface Profile {
  firstName: string
}

interface User {
  admin: boolean,
  profile: Profile
}

@Component({
  selector: 'app-announcements',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './announcements.component.html',
  styleUrl: './announcements.component.css'
})
export class AnnouncementsComponent {

  constructor() {}

  announcementPopup: boolean = false;

  userDummyDTO: User = {
    admin: true,
    profile: {
      firstName: 'Dakotah'
    }
  }

  dummyDTO: Announcement[] = [
    {
      date: 'November 17, 2022',
      title: 'CEO',
      message: 'What should we do about lorem? Lorem is running rampit throughout the company as a filler for posts and data and we would prefer you not utlize this method of posting anymore. We have testing software and items in place, please make use of those for the future if you need to test functionality of a post. Lorem just takes up time and space and we have decided we no longer want to use it going forward.',
      author: 'Chris'
    },
    {
      date: 'November 19, 2022',
      title: 'SDE',
      message: 'L take, Chris. 👎',
      author: 'Dakotah'
    }
  ]

  ngOnInit() {
    this.sortAnnouncements();
  }

  sortAnnouncements() {
    this.dummyDTO.sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime());
  }

  newAnnouncementPopup() {
    this.announcementPopup = !this.announcementPopup;
  }

  submitAnnouncement(title: string, message: string) {
    this.dummyDTO.push({
      date: 'June 23, 2024',
      title,
      message,
      author: this.userDummyDTO.profile.firstName
    });
    this.announcementPopup = false;
    this.sortAnnouncements();
  }
}
