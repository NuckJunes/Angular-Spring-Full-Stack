import { Component, HostListener } from '@angular/core';
import { GeneralService } from '../../services/general.service';
import { Router, RouterModule } from '@angular/router';
import { NgClass, NgIf } from '@angular/common';
import { userInfo } from '../../services/userInfo';
import FullUserDTO from '../models/FullUserDTO';

@Component({
  selector: 'app-navmenu',
  standalone: true,
  imports: [NgClass,NgIf,RouterModule],
  templateUrl: './navmenu.component.html',
  styleUrl: './navmenu.component.css'
})
export class NavmenuComponent {
  toggleMenu = false;
  companyName: any;
  scrolled = false;
  user: FullUserDTO | undefined = undefined;

  constructor(private generalService: GeneralService, private router: Router, private userInfo: userInfo) {
    userInfo.getFullUser().subscribe(user => {
      this.user = user;
    });
    userInfo.getCompanyName().subscribe(company => {
      this.companyName = company;
    })
  }

  ngOnInit() {

  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.scrolled = window.scrollY > 0;
  }

  logout() {
    if (this.generalService.isLoggedIn()) this.generalService.logout();
  }

  goHome() {
    this.router.navigateByUrl('/announcements');
  }

  toggleMobileMenu() {
    this.toggleMenu = !this.toggleMenu;
  }
}
