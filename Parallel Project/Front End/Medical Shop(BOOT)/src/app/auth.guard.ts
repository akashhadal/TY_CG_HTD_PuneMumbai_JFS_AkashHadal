import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    constructor(private auth: AuthService) { }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): boolean {

        const expectedRoleArray = next.data.expectedRole;
        const userDetails = JSON.parse(localStorage.getItem('user'));
        let expectedRole = '';
        console.log(userDetails.loginBean.role);

        expectedRole = userDetails.loginBean.role;
        console.log(expectedRole);

        if (this.auth.isLoggedIn() && userDetails && expectedRole === userDetails.loginBean.role) {
            console.log('user athenticated');
            return true;
        } else {
            console.log(userDetails.loginBean.role);
            console.log('user not athenticated');
            return false;
        }
    }
}
