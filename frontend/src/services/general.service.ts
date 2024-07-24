import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string): Observable<string> {
    return this.http.post<any>('http://localhost:8080/users/login', {
      username: username.toLowerCase(),
      password: password,
    });
  }
  logout(): void {
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('user') != null;
  }
}
