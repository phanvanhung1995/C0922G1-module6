import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {NavbarComponent} from "./navbar/navbar.component";
import {CarComponent} from "./car/car.component";
import {EditCarComponent} from "./edit-car/edit-car.component";
import {CreateComponent} from "./create/create.component";


const routes: Routes = [
  {path: '', component: NavbarComponent},
  {path: 'car', component: CarComponent},
  {path: 'edit/:id', component: EditCarComponent},
  {path: 'create', component: CreateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
