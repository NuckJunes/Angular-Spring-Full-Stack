import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import FullUserDTO from '../models/FullUserDTO';
import { Router } from '@angular/router';
import { userInfo } from '../../services/userInfo';
import CompanyDTO from '../models/CompanyDTO';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-select-company',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './select-company.component.html',
  styleUrl: './select-company.component.css'
})
export class SelectCompanyComponent {

  user: FullUserDTO | undefined = undefined;
  companies: CompanyDTO[] = [];

  constructor(private router: Router, private userInfo: userInfo) {
    userInfo.getFullUser().subscribe(user => {
      this.user = user;
      this.companies = user?.companies as CompanyDTO[];
    })
  };

  ngOnInit() {

  };

  selectCompany(event: Event) {
    const selectedName = (event.target as HTMLSelectElement).value;
    const selectedCompany = this.companies.find(company => company.name === selectedName);
    console.log(selectedCompany);
    if (selectedCompany) { 
      this.userInfo.updateCompanyIDSource(selectedCompany.id);
      this.userInfo.updateCompanyNameSource(selectedCompany.name);
      this.router.navigateByUrl('');
    }
  }

}
