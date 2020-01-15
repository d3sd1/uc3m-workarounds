import {Injectable} from '@angular/core';

@Injectable()
export class GeolocalizacionService {
    getCoords() {

        if (navigator.geolocation) {
            return navigator.geolocation.getCurrentPosition(this.devolverPosicion);
        } else {
            return "ERROR DE GEOLOCALIZACIÓN";
        }
    }
    private devolverPosicion(position: any) {
        /* Devuelve un objeto con las propiedades lat y lng */
        return {
            "lat": position.coords.latitude,
            "lng": position.coords.longitude
        };
    }
}
