import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Destination} from "../app/model/destination";

@Injectable({
  providedIn: 'root'
})
export class DestinationService {
  private Api = 'http://localhost:8080/api/destination'

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Destination[]> {
    return this.httpClient.get<Destination[]>(this.Api)
  }
}
