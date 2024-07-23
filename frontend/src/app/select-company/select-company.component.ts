import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-select-company',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './select-company.component.html',
  styleUrl: './select-company.component.css'
})
export class SelectCompanyComponent {

  companies: string[] = ['FedEx', 'Cook Systems', 'Google'];

}
