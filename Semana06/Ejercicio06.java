
public class Ejercicio06 {

	public static void main(String[] args) {
		
		byte puntosJ1 = 0, puntosJ2 = 0, puntosJ3 = 0;
		
		for(int tirada = 0; tirada <= 10; tirada++) {
			//1 = cara 0 = cruz
			byte moneda1 =  (byte)(Math.random()*2);
			byte moneda2 =  (byte)(Math.random()*2);
			byte moneda3 =  (byte)(Math.random()*2);

			System.out.println("El jugador 1 ha sacado " + (moneda1 == 1 ? "CARA":"CRUZ"));
			System.out.println("El jugador 2 ha sacado " + (moneda2 == 1 ? "CARA":"CRUZ"));
			System.out.println("El jugador 3 ha sacado " + (moneda3 == 1 ? "CARA":"CRUZ"));
			
			//Determinar ganador
			if(moneda1 != moneda2 && moneda1 != moneda3) {
				System.out.println("Ha ganado el jugador 1 en la tirada " + tirada);
				puntosJ1++;
			}
			else if(moneda2 != moneda1 && moneda2 != moneda3) {
				System.out.println("Ha ganado el jugador 2 en la tirada " + tirada);
				puntosJ2++;
			}
			else if(moneda3 != moneda1 && moneda3 != moneda2) {
				System.out.println("Ha ganado el jugador 3 en la tirada " + tirada);
				puntosJ3++;
			}
			else {
				System.out.println("Ha habido empate en la tirada " + tirada);
			}
			
			//Mostrar resultados actuales
			System.out.println("JUGADOR 1 --> " + puntosJ1 + " PUNTOS");
			System.out.println("JUGADOR 2 --> " + puntosJ2 + " PUNTOS");
			System.out.println("JUGADOR 3 -->  " + puntosJ3 + "  PUNTOS");
		}

		if(puntosJ1 > puntosJ2 && puntosJ1 > puntosJ3) {
			System.out.println("EL GANADOR FINAL HA SIDO EL JUGADOR 1 CON " + puntosJ1 + " PUNTOS.");
		}
		else if(puntosJ2 > puntosJ1 && puntosJ2 > puntosJ3) {
			System.out.println("EL GANADOR FINAL HA SIDO EL JUGADOR 2 CON " + puntosJ2 + " PUNTOS.");
		}
		else if(puntosJ3 > puntosJ2 && puntosJ3 > puntosJ1) {
			System.out.println("EL GANADOR FINAL HA SIDO EL JUGADOR 3 CON " + puntosJ3 + " PUNTOS.");
		}
		else if(puntosJ1 == puntosJ2 && puntosJ1 == puntosJ3) {
			System.out.println("EL GANADOR FINAL NO HA SIDO NADIE. HA HABIDO UN TRIPLE EMPATE.");
		}
		else if(puntosJ1 == puntosJ2 && puntosJ1 > puntosJ3) {
			System.out.println("LOS GANADORES FINALES HAN SIDO LOS JUGADORES 1 Y 2 CON " + puntosJ1 + " PUNTOS CADA UNO.");
		}
		else if(puntosJ3 == puntosJ2 && puntosJ3 > puntosJ1) {
			System.out.println("LOS GANADORES FINALES HAN SIDO LOS JUGADORES 2 Y 3 CON " + puntosJ3 + " PUNTOS CADA UNO.");
		}
		else if(puntosJ1 == puntosJ3 && puntosJ1 > puntosJ2) {
			System.out.println("LOS GANADORES FINALES HAN SIDO LOS JUGADORES 1 Y 3 CON " + puntosJ3 + " PUNTOS CADA UNO.");
		}
	}

}
