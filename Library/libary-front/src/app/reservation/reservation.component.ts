import { Component, OnInit } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { ReservationService } from '../reservation.service';
import { Students } from '../students';
import { forEach } from '@angular/router/src/utils/collection';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

   
  formatsDateTest: string[] = [
    'dd/MM/yyyy'
    ];
  
  dateNow : Date = new Date();
  dateNowISO = this.dateNow.toISOString();
  
  //now.formatDate(value: string | number | Date, format: string, locale: string, timezone?: string): string


  reservation: Observable<Students[]>;
  books:Object[];
  constructor(private restclient:ReservationService) {
   
   }
   
  ngOnInit() {

    // this.restclient.getBooks().subscribe(
    //   (reservationlist)=> this.reservation=reservationlist,
    //      (err)=> console.log(err)
    // );
    this.upDate();
    
  }
  upDate(){
    console.log("ss"+this.dateNowISO);
        this.reservation=this.restclient.getBooks();
  }
  deleteReservations(id:Number){
    console.log(id);
    this.restclient.deleteReservations(id).subscribe((d)=>
    
    this.upDate());
    
  }
}
