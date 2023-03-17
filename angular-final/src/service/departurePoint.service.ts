import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DeparturePoint} from "../app/model/departurePoint";

@Injectable({
  providedIn: 'root'
})
export class DeparturePointService {

  private Api = 'http://localhost:8080/api/departurePoint'

  constructor(private httpClient: HttpClient) {
  }

  findAll1(): Observable<DeparturePoint[]> {
    return this.httpClient.get<DeparturePoint[]>(this.Api)
  }
}
