import {DeparturePoint} from "./departurePoint";
import {Destination} from "./destination";
import {CarType} from "./car-type";

export interface Car {
  id?: number;
  carNumber?: string;
  carType?: CarType;
  busCompanyName?: string;
  departurePoint?: DeparturePoint;
  destination?: Destination;
  phoneNumber?: string;
  email?: string;
  departure?: string;
  arrival?: string;
}
