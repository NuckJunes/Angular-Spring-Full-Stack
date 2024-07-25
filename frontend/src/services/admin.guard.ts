import { Injectable } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const user = localStorage.getItem('user');
    if (!user) {
      this.router.navigate(['/login']);
      return false;
    }

    const userData = JSON.parse(user);
    if (!userData.admin) {
      this.router.navigate(['/login']);
      return false;
    }

    return true;
  }
}
