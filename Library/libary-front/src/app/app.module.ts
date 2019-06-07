import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReservationComponent } from './reservation/reservation.component';
import { ReservationService } from './reservation.service';
@NgModule({
  declarations: [
    AppComponent,
    ReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ReservationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
