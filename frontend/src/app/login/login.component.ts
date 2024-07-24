import { Component } from '@angular/core';
import { post } from '../../services/api';
import { HttpClient } from '@angular/common/http';
import { GeneralService } from '../../services/general.service';
import { Router } from '@angular/router';
import UserRequestDto from '../models/UserRequestDto';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  userData: any;
  isInvalid = false;
  isPending = false;
  userId = 0;
  user: UserRequestDto = {
    credentials: {
      username: '',
      password: '',
    },
    profile: {
      firstName: '',
      lastName: '',
      email: '',
      phone: '',
    },
    admin: false,
  };

  username = '';
  password = '';

  constructor(
    private generalService:GeneralService,
    private router: Router,
    private http: HttpClient
  ) {}

  storeUsername(value: string) {
    this.username = value;
  }

  storePassword(value: string) {
    this.password = value;
  }
  
    login() {
    //let response = post("users", ["login"], {username: this.password})
    this.generalService.login(this.username, this.password).subscribe({
      next: (data) => {
        this.userData = JSON.parse(JSON.stringify(data));
        console.log(this.userData)
        this.userId = this.userData.id;
        this.user.profile = this.userData.profile;
        this.user.credentials =this.userData.credentials;
        this.user.admin = this.userData.admin;
        this.userData.status = 'JOINED';
        console.log(this.user.admin)
        localStorage.setItem('user', JSON.stringify(this.userData));
        if (this.userData.status === 'PENDING') this.isPending = true;
        else {
         // if (this.userData.admin) {
          //  this.router.navigate(['/select-company']);
         // }
           {
            localStorage.setItem('companyId', this.userData.companies[0].id);
            localStorage.setItem(
              'companyName',
              this.userData.companies[0].name
            );
            this.router.navigate(['/']);
          }
        }
      },
      error: (e) => {
        console.error(e);
        this.isInvalid = true;
      },
    });
  }

}
