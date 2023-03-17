import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Car} from "../app/model/car";
import {CarType} from "../app/model/car-type";

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private Api = 'http://localhost:8080/api/car'
  private Api2 = 'http://localhost:8080/api/carType'

  constructor(private httpClient: HttpClient) {
  }


  findAllBusType(): Observable<CarType[]> {
    return this.httpClient.get<CarType[]>(this.Api2)
  }

  findAll(): Observable<Car[]> {
    return this.httpClient.get<Car[]>(this.Api)
  }

  findByIdCar(id: number): Observable<Car> {
    return this.httpClient.get<Car>(this.Api + '/' + id)
  }

  editCar(id: number, car: Car): Observable<Car> {
    return this.httpClient.put<Car>('http://localhost:8080/api/car/edit' + '/' + id, car)
  }

  deleteCar(id: number): Observable<Car> {
    return this.httpClient.delete<Car>('http://localhost:8080/api/car/delete' + '/' + id);
  }

  createCar(car: Car): Observable<Car> {
    return this.httpClient.post<Car>('http://localhost:8080/api/car/create', car)
  }
}
