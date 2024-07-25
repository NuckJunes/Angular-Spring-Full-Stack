import { CanActivate, CanActivateFn, Router } from '@angular/router';
import { GeneralService } from './general.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class GeneralGuard {
  constructor(private generalService: GeneralService, private router: Router) {}

  canActivate(): Observable<boolean> {
    if (this.generalService.isLoggedIn()) return new Observable((observer) => observer.next(true));
    else {
      this.router.navigate(['/login']);
      return new Observable((observer) => observer.next(false));
    }
  }
}
