import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BeerService {

  private baseUrl = '//localhost:8080/api/v1';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.baseUrl + '/beers');
  }

  getStrong(): Observable<any> {
    return this.http.get(this.baseUrl + '/strong-beers');
  }

}
