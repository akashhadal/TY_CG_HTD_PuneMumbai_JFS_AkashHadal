import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductListComponent } from './product-list/product-list.component';
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

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    AddProductComponent,
    ProductListComponent,
    UserListComponent,
    AdminDiscussionBoardComponent,
    UserProductListComponent,
    VisitorProductListComponent,
    CartComponent,
    OrderComponent,
    PaymentComponent,
    UserDiscussionBoardComponent,
    UserProfileComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
