import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate {

    userDetails = JSON.parse(localStorage.getItem('user'));

    constructor(private auth: AuthService) { }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): boolean {

        const expectedRoleArray = next.data.expectedRole;
        const userDetails = JSON.parse(localStorage.getItem('user'));
        let expectedRole = '';
        console.log(userDetails.adminUserBean.userType);

        expectedRole = userDetails.adminUserBean.userType;
        console.log(expectedRole);

        if (this.auth.isLoggedIn() && userDetails && expectedRole === userDetails.adminUserBean.userType) {
            console.log('user athenticated');
            return true;
        } else {
            console.log('user not athenticated');
            return false;
        }
    }
}
