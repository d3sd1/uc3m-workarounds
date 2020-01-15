import {Component, OnInit} from '@angular/core';
import {GeolocalizacionService} from './geolocalizacion.service';
@Component({
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    title = 'app';
    public miNumero: number = 0;
    constructor(private geo: GeolocalizacionService) {
        console.log(geo.getCoords());
    }

    ngOnInit() {
        this.miNumero = 0;
    }

    public getMiNumero(): number {
        return this.miNumero;
    }
    public setMiNumero() {
        this.miNumero++;
    }

}
