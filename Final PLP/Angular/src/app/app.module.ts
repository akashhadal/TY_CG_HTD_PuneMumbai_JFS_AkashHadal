import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { BookingsComponent } from './bookings/bookings.component';
import { ServicesComponent } from './services/services.component';
import { ReservationComponent } from './reservation/reservation.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HotelPoliciesComponent } from './hotel-policies/hotel-policies.component';
import { TariffPlanFacilitiesComponent } from './tariff-plan-facilities/tariff-plan-facilities.component';
import { FoodMenuComponent } from './food-menu/food-menu.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AdminControlComponent } from './admin-control/admin-control.component';
import { EmployeesCounterComponent } from './employees-counter/employees-counter.component';
import { CustomersCounterComponent } from './customers-counter/customers-counter.component';
import { RoomsCounterComponent } from './rooms-counter/rooms-counter.component';
import { HotelsCounterComponent } from './hotels-counter/hotels-counter.component';
import { AddHotelComponent } from './add-hotel/add-hotel.component';
import { SearchedHotelsComponent } from './searched-hotels/searched-hotels.component';
import { AddManagerComponent } from './add-manager/add-manager.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ManagerControlComponent } from './manager-control/manager-control.component';
import { ManagerCounterComponent } from './manager-counter/manager-counter.component';
import { DeleteUpdateManagerComponent } from './delete-update-manager/delete-update-manager.component';
import { DeleteUpdateEmployeeComponent } from './delete-update-employee/delete-update-employee.component';
import { AddRoomComponent } from './add-room/add-room.component';
import { SearchedHotelsDetailsComponent } from './searched-hotels-details/searched-hotels-details.component';
import { BookRoomComponent } from './book-room/book-room.component';
import { AdminHotelCounterComponent } from './admin-hotel-counter/admin-hotel-counter.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { PaymentModeComponent } from './payment-mode/payment-mode.component';
import { FilterPipe } from './filter.pipe';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { CardPaymentComponent } from './card-payment/card-payment.component';
import { BookingDoneComponent } from './booking-done/booking-done.component';
import { ManagerHotelCounterComponent } from './manager-hotel-counter/manager-hotel-counter.component';
import { ManagerRoomsCounterComponent } from './manager-rooms-counter/manager-rooms-counter.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { VisitorComponent } from './visitor/visitor.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SignInComponent,
    AboutUsComponent,
    BookingsComponent,
    ServicesComponent,
    ReservationComponent,
    FoodOrderComponent,
    PageNotFoundComponent,
    HotelPoliciesComponent,
    TariffPlanFacilitiesComponent,
    FoodMenuComponent,
    UserRegisterComponent,
    UserProfileComponent,
    AdminControlComponent,
    EmployeesCounterComponent,
    CustomersCounterComponent,
    RoomsCounterComponent,
    HotelsCounterComponent,
    AddHotelComponent,
    SearchedHotelsComponent,
    AddManagerComponent,
    AddEmployeeComponent,
    ManagerControlComponent,
    ManagerCounterComponent,
    DeleteUpdateManagerComponent,
    DeleteUpdateEmployeeComponent,
    AddRoomComponent,
    SearchedHotelsDetailsComponent,
    BookRoomComponent,
    AdminHotelCounterComponent,
    UpdateProfileComponent,
    PaymentModeComponent,
    FilterPipe,
    CancelBookingComponent,
    CardPaymentComponent,
    BookingDoneComponent,
    ManagerHotelCounterComponent,
    ManagerRoomsCounterComponent,
    ContactUsComponent,
    VisitorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
