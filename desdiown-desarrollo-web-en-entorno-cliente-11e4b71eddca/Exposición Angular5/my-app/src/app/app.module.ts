import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { GeolocalizacionService } from './geolocalizacion.service';
import { Componente2Component } from './componente2/componente2.component';
import { MenuComponent } from './menu/menu.component';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: 'inicio', component: AppComponent },
  { path: 'pagina2',      component: Componente2Component },
  { path: '',
    redirectTo: '/inicio',
    pathMatch: 'full'
  }
];


@NgModule({
  declarations: [
    AppComponent,
    Componente2Component,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [GeolocalizacionService],
  bootstrap: [MenuComponent]
})
export class AppModule { }
