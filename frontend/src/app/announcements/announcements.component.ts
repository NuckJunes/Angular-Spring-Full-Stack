import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import FullUserDTO from '../models/FullUserDTO';
import AnnouncementDTO from '../models/AnnouncementDTO';
import { userInfo } from '../../services/userInfo';
import { NavmenuComponent } from '../navmenu/navmenu.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-announcements',
  standalone: true,
  imports: [CommonModule, NavmenuComponent, ReactiveFormsModule],
  templateUrl: './announcements.component.html',
  styleUrls: ['./announcements.component.css']
})
export class AnnouncementsComponent implements OnInit {

  user: FullUserDTO | undefined = undefined;
  companyId: number = -1;
  announcementForm: FormGroup | undefined;
  announcements: AnnouncementDTO[] = [];
  paginatedAnnouncements: AnnouncementDTO[] = [];
  announcementPopup: boolean = false;
  currentPage: number = 0;
  pageSize: number = 5; // Number of announcements per page
  totalPages: number = 0;

  constructor(private userService: userInfo, private fb: FormBuilder) {}

  ngOnInit() {
    this.announcementForm = this.fb.group({
      title: ['', Validators.required],
      message: ['', Validators.required]
    });

    this.userService.getFullUser().subscribe(user => {
      this.user = user;
      console.log('State User: ', this.user);
    });

    this.userService.getCompanyID().subscribe(companyId => {
      if (this.user && companyId !== undefined) {
        this.companyId = companyId;
        this.fetchAnnouncements();
      }
    });
  }

  async fetchAnnouncements() {
    try {
      const response = await fetch(`http://localhost:8080/company/${this.companyId}/announcements`);
      const data: AnnouncementDTO[] = await response.json();
      this.announcements = data.map((announcement: any) => ({
        ...announcement,
        date: new Date(announcement.date).toLocaleDateString()
      }));
      this.totalPages = Math.ceil(this.announcements.length / this.pageSize);
      this.updatePaginatedAnnouncements();
    } catch (error) {
      console.error('Error fetching announcements:', error);
    }
  }

  updatePaginatedAnnouncements() {
    const start = this.currentPage * this.pageSize;
    const end = start + this.pageSize;
    this.paginatedAnnouncements = this.announcements.slice(start, end);
  }

  newAnnouncementPopup() {
    this.announcementPopup = !this.announcementPopup;
  }

  async submitAnnouncement() {
    if (this.announcementForm && this.announcementForm.valid) {
      const { title, message } = this.announcementForm.value;
      const newAnnouncement = {
        title,
        message,
        author: this.user,
      };

      const options = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(newAnnouncement)
      };

      try {
        const response = await fetch(`http://localhost:8080/company/${this.companyId}/announcement`, options);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        this.announcementForm.reset();
        this.announcementPopup = false;
        this.fetchAnnouncements(); // Refresh the list of announcements
      } catch (error) {
        console.error('Error posting announcement:', error);
      }
    }
  }

  goToPage(page: number) {
    this.currentPage = page;
    this.updatePaginatedAnnouncements();
  }

  goToNextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.goToPage(this.currentPage + 1);
      window.scrollTo({top: 0, behavior: 'smooth'});
    }
  }

  goToPreviousPage() {
    if (this.currentPage > 0) {
      this.goToPage(this.currentPage - 1);
      window.scrollTo({top: 0, behavior: 'smooth'});
    }
  }
}
