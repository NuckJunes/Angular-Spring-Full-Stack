import { NgClass, NgFor, NgIf } from '@angular/common';
import { Component, Input, input, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatDialogConfig } from '@angular/material/dialog';
import FullUserDTO from '../models/FullUserDTO';
import ProfileDTO from '../models/ProfileDTO';
import { post, get } from '../../services/api';
import { UserRegFormComponent } from './user-reg-form/user-reg-form.component';
import { userInfo } from '../../services/userInfo';
import { HttpClient } from '@angular/common/http';
import { NavmenuComponent } from "../navmenu/navmenu.component";

@Component({
  selector: 'app-user-reg',
  standalone: true,
  imports: [NgFor, MatInputModule, MatButtonModule, NgClass, UserRegFormComponent, NgIf, NavmenuComponent],
  templateUrl: './user-reg.component.html',
  styleUrl: './user-reg.component.css'
})
export class UserRegComponent implements OnInit {
  users: FullUserDTO[] = [];
  showUserOverlay = false;
  companyId:string='';

  constructor(private http: HttpClient, private dialog: MatDialog, private userInfo: userInfo) { }

  ngOnInit(): void {
    this.userInfo.getCompanyID().subscribe((value) => {
      this.companyId =localStorage.getItem("companyId")??'';
      this.getUsers();
    });
  }

  getUsers() {
    const url = `http://localhost:8080/company/${this.companyId}/users`;
    this.http.get<any>(url).subscribe({
      next: (res) => {
        this.users = res;
        console.log(res)
      },
      error: (e) => console.error(e)
    });
  }

  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
}
