import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CarService} from "../../service/car.service";
import {DestinationService} from "../../service/destination.service";
import {DeparturePointService} from "../../service/departurePoint.service";
import {Destination} from "../model/destination";
import {DeparturePoint} from "../model/departurePoint";
import {Car} from "../model/car";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CarType} from "../model/car-type";

@Component({
  selector: 'app-edit-car',
  templateUrl: './edit-car.component.html',
  styleUrls: ['./edit-car.component.css']
})
export class EditCarComponent implements OnInit {
  formGroupCar: FormGroup;
  destinations: Destination[] = [];
  departurePoints: DeparturePoint[] = [];
  car: Car;
  idEdit: number;
  carTypeList: CarType[];

  constructor(private carService: CarService,
              private destinationService: DestinationService,
              private departurePointService: DeparturePointService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit(): void {
    this.destinationService.findAll().subscribe(a => {
      this.destinations = a;
    });
    this.departurePointService.findAll1().subscribe(b => {
      this.departurePoints = b;
    });
    this.carService.findAllBusType().subscribe(c => {
      this.carTypeList = c
    });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.idEdit = +paramMap.get('id');
      this.carService.findByIdCar(this.idEdit).subscribe(item => {
        this.car = item;
        this.formGroupCar = new FormGroup({
          id: new FormControl(item.id),
          carNumber: new FormControl(item.carNumber),
          carType: new FormControl(item.carType.name),
          busCompanyName: new FormControl(item.busCompanyName),
          departurePoint: new FormControl(item.departurePoint?.name),
          destination: new FormControl(item.destination?.name),
          phoneNumber: new FormControl(item.phoneNumber),
          email: new FormControl(item.email),
          departure: new FormControl(item.departure),
          arrival: new FormControl(item.arrival),
        })
      })
    })
  }

  edit() {
    this.car = this.formGroupCar.value
    this.carService.editCar(this.idEdit, this.car).subscribe(() => {
      alert('sửa thành công')
      this.router.navigateByUrl('/car')
    })
  }
}
