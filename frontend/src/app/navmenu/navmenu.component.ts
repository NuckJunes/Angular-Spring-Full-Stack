import { Component, HostListener } from '@angular/core';
import { GeneralService } from '../../services/general.service';
import { Router } from '@angular/router';
import { NgClass, NgIf } from '@angular/common';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-navmenu',
  standalone: true,
  imports: [NgClass,NgIf,LoginComponent],
  templateUrl: './navmenu.component.html',
  styleUrl: './navmenu.component.css'
})
export class NavmenuComponent {
  isAdmin = true;

  profile: any;
  companyName: any;
  scrolled = false;

  constructor(private generalService:GeneralService, private router: Router) {}

  ngOnInit() {
    this.isAdmin = JSON.parse(localStorage.getItem('user') as string).admin;
    const user = JSON.parse(localStorage.getItem('user')!);
    if (user) this.profile = user.profile;
    const companyName = String(localStorage.getItem('companyName')!);
    if (companyName) this.companyName = companyName;
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.scrolled = window.scrollY > 0;
  }

  logout() {
    if (this.generalService.isLoggedIn()) this.generalService.logout();
  }

  goHome() {
    this.router.navigateByUrl('');
  }
}
