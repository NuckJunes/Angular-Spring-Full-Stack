import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import FullUserDTO from "../app/models/FullUserDTO";

@Injectable({
    providedIn: 'root',
})
export class userInfo {
    private fullUserSource = new BehaviorSubject<FullUserDTO|undefined>(undefined);
    fullUser = this.fullUserSource.asObservable();

    private companyIDSource = new BehaviorSubject<number>(0);
    companyID = this.companyIDSource.asObservable();

    private teamIDSource = new BehaviorSubject<number>(0);
    teamID = this.teamIDSource.asObservable();

    updateFullUserSource(newFullUser: FullUserDTO) {
        this.fullUserSource.next(newFullUser);
    }

    updateCompanyIDSource(newCompanyID: number) {
        this.companyIDSource.next(newCompanyID);
    }

    updateTeamIDSource(newTeamID: number) {
        this.teamIDSource.next(newTeamID);
    }

    getFullUser() {
        return this.fullUserSource;
    }

    getCompanyID() {
        return this.companyIDSource;
    }

    getTeamID() {
        return this.teamIDSource;
    }
}