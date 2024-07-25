import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import FullUserDTO from "../app/models/FullUserDTO";

@Injectable({
    providedIn: 'root',
})
export class userInfo {
    private fullUserSource = new BehaviorSubject<FullUserDTO|undefined>(this.loadFullUserFromLocalStorage());
    fullUser = this.fullUserSource.asObservable();

    private companyIDSource = new BehaviorSubject<number>(this.loadCompanyIDFromLocalStorage());
    companyID = this.companyIDSource.asObservable();

    private companyNameSource = new BehaviorSubject<string>(this.loadCompanyNameFromLocalStorage());
    companyName = this.companyNameSource.asObservable();

    private teamIDSource = new BehaviorSubject<number>(this.loadTeamIDFromLocalStorage());
    teamID = this.teamIDSource.asObservable();

    private teamNameSource = new BehaviorSubject<string>(this.loadTeamNameFromLocalStorage());
    teamName = this.teamNameSource.asObservable();

    updateFullUserSource(newFullUser: FullUserDTO) {
        this.fullUserSource.next(newFullUser);
        localStorage.setItem('user', JSON.stringify(newFullUser));
    }

    updateCompanyIDSource(newCompanyID: number) {
        this.companyIDSource.next(newCompanyID);
        localStorage.setItem('companyId', newCompanyID.toString());
    }

    updateCompanyNameSource(newCompanyName: string) {
        this.companyNameSource.next(newCompanyName);
        localStorage.setItem('companyName', newCompanyName);
    }

    updateTeamIDSource(newTeamID: number) {
        this.teamIDSource.next(newTeamID);
        localStorage.setItem('teamId', newTeamID.toString());
    }

    updateTeamNameSource(newTeamName: string) {
        this.teamNameSource.next(newTeamName);
        localStorage.setItem('teamName', newTeamName);
    }

    getFullUser() {
        return this.fullUserSource;
    }

    getCompanyID() {
        return this.companyIDSource;
    }

    getCompanyName() {
        return this.companyNameSource;
    }

    getTeamID() {
        return this.teamIDSource;
    }

    getTeamName() {
        return this.teamNameSource;
    }

    private loadFullUserFromLocalStorage(): FullUserDTO | undefined {
        try {
            const userString = localStorage.getItem('user');
            return userString ? JSON.parse(userString) : undefined;
        } catch (error) {

        }
        return undefined;
      }
    
      private loadCompanyIDFromLocalStorage(): number {
        try {
            const companyIdString = localStorage.getItem('companyId');
            return companyIdString ? parseInt(companyIdString, 10) : 0;
        } catch(error) {

        }
        return -1;
      }

      private loadCompanyNameFromLocalStorage(): string {
        try {
            const companyName = localStorage.getItem('companyName');
            return companyName ? companyName : '';
        } catch(error) {

        }
        return '';
      }

      private loadTeamIDFromLocalStorage(): number {
        try {
            const teamIdString = localStorage.getItem('teamId');
            return teamIdString ? parseInt(teamIdString, 10) : 0;
        } catch(error) {

        }
        return -1;
      }

      private loadTeamNameFromLocalStorage(): string {
        try {
            const teamName = localStorage.getItem('teamName');
            return teamName ? teamName : '';
        } catch(error) {

        }
        return '';
      }
}