import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Destination} from "../model/destination";
import {DeparturePoint} from "../model/departurePoint";
import {Car} from "../model/car";
import {CarService} from "../../service/car.service";
import {DestinationService} from "../../service/destination.service";
import {DeparturePointService} from "../../service/departurePoint.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CarType} from "../model/car-type";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  formGroupCar: FormGroup;
  diemDenList: Destination[] = [];
  diemDiList: DeparturePoint[] = [];
  car: Car;
  carTypeList: CarType[];

  constructor(private carService: CarService,
              private destinationService: DestinationService,
              private departurePointService: DeparturePointService,
              private router: Router) {
  }


  ngOnInit(): void {
    this.destinationService.findAll().subscribe(a => {
      this.diemDenList = a;
    });
    this.departurePointService.findAll1().subscribe(b => {
      this.diemDiList = b;
    })
    this.carService.findAllBusType().subscribe(c => {
      this.carTypeList = c
    })
    this.formGroupCar = new FormGroup({
      id: new FormControl(),
      carNumber: new FormControl(),
      carType: new FormControl(),
      busCompanyName: new FormControl(),
      departurePoint: new FormControl(),
      destination: new FormControl(),
      phoneNumber: new FormControl(),
      email: new FormControl(),
      departure: new FormControl(),
      arrival: new FormControl(),
    })
  }

  create() {
    this.car = this.formGroupCar.value;
    this.carService.createCar(this.car).subscribe(() => {
      alert('thêm mới thành công');
      this.router.navigateByUrl("/car")
    })
  }
}
