import { NgFor } from '@angular/common';
import { Component } from '@angular/core';

interface user {
  first: string;
  last: string;
  email: string;
  admin: boolean;
  active: boolean;
  status: string;
}

@Component({
  selector: 'app-user-reg',
  standalone: true,
  imports: [NgFor],
  templateUrl: './user-reg.component.html',
  styleUrl: './user-reg.component.css'
})
export class UserRegComponent {

  users: user[] = [];

  getUsers() {
    
  }
}
