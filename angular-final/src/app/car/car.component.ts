import {Component, OnInit} from '@angular/core';
import {Car} from "../model/car";
import {CarService} from "../../service/car.service";

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  carList: Car[] = []
  idDelete: number;
  carNumber: string;

  constructor(private carService: CarService) {
  }

  ngOnInit(): void {
    this.carService.findAll().subscribe(item => {
      this.carList = item;
    })
  }


  getId(id: number, carNumber: string) {
    this.idDelete = id;
    this.carNumber = carNumber
  }

  delete() {
    this.carService.deleteCar(this.idDelete).subscribe(() => {
      alert('xóa thành công')
      this.ngOnInit()
    })
  }
}
