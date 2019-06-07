import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Students } from './students';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:HttpClient) { }

  baseUrl="http://localhost:9595/library/getReservations";

  getBooks() :Observable<Students[]>{
    return this.http.get<Students[]>(this.baseUrl);
  }

  deleteReservations(id:Number) : Observable<void>{
   console.log(("http://localhost:9595/library/deleteStudentDetails/"+`${id}`));
   return this.http.delete<void>("http://localhost:9595/library/deleteStudentDetails/"+`${id}`);
   
  }


}
