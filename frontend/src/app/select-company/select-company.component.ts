import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import FullUserDTO from '../models/FullUserDTO';
import { Router } from '@angular/router';

@Component({
  selector: 'app-select-company',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './select-company.component.html',
  styleUrl: './select-company.component.css'
})
export class SelectCompanyComponent {

  companies: string[] = [];

  constructor(private router: Router) {};

  ngOnInit() {
    const userInfo = localStorage.getItem('user');
    const user: FullUserDTO = userInfo ? JSON.parse(userInfo) : null;

    if (user) {
      user.companies.forEach(company => {
        this.companies.push(company.name);
      });
    } else {
      console.error('No companies found or user data is invalid');
    };
  };

  selectCompany() {
    this.router.navigateByUrl('');
  }

}
