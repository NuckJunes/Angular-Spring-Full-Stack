import { Component, HostListener } from '@angular/core';
import { GeneralService } from '../../services/general.service';
import { Router, RouterModule } from '@angular/router';
import { NgClass, NgIf } from '@angular/common';

@Component({
  selector: 'app-navmenu',
  standalone: true,
  imports: [NgClass,NgIf,RouterModule],
  templateUrl: './navmenu.component.html',
  styleUrl: './navmenu.component.css'
})
export class NavmenuComponent {
  isAdmin = true;
  toggleMenu = false;
  profile: any;
  companyName: any;
  scrolled = false;

  constructor(private generalService: GeneralService, private router: Router) {}

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
