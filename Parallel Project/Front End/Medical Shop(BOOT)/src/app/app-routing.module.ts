import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { AuthGuard } from './auth.guard';
import { UserListComponent } from './user-list/user-list.component';
import { AdminDiscussionBoardComponent } from './admin-discussion-board/admin-discussion-board.component';
import { UserProductListComponent } from './user-product-list/user-product-list.component';
import { VisitorProductListComponent } from './visitor-product-list/visitor-product-list.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { PaymentComponent } from './payment/payment.component';
import { UserDiscussionBoardComponent } from './user-discussion-board/user-discussion-board.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'addProduct', component: AddProductComponent, canActivate: [AuthGuard], data: { expectedRole: 'User' } },
  { path: 'getProduct', component: ProductListComponent, canActivate: [AuthGuard], data: { expectedRole: 'Admin' } },
  { path: 'userList', component: UserListComponent, canActivate: [AuthGuard], data: { expectedRole: 'Admin' } },
  { path: 'adminDiscussionBoard', component: AdminDiscussionBoardComponent, canActivate: [AuthGuard], data: { expectedRole: 'Admin' } },
  { path: 'getUserProduct', component: UserProductListComponent, canActivate: [AuthGuard], data: { expectedRole: 'User' } },
  { path: 'getVisitorProduct', component: VisitorProductListComponent },
  { path: 'cart', component: CartComponent, canActivate: [AuthGuard], data: { expectedRole: 'User' } },
  { path: 'order', component: OrderComponent, canActivate: [AuthGuard], data: { expectedRole: 'User' }},
  { path: 'payment', component: PaymentComponent, canActivate: [AuthGuard], data: { expectedRole: 'User' }},
  { path: 'userDiscussionBoard', component: UserDiscussionBoardComponent, canActivate: [AuthGuard], data: { expectedRole: 'User' }},
  { path: 'userProfile', component: UserProfileComponent, canActivate: [AuthGuard], data: { expectedRole: 'User' }},
  { path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
