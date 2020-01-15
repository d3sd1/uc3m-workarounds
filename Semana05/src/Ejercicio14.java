import java.util.Scanner;

public class Ejercicio14 {
	public static void main(String[] args) {
		double cantidad = 0;
		double cantidadDesglosada = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca una cantidad monetaria: ");
		cantidad = input.nextDouble();

		if(cantidad == 0) {
			System.out.println("Debes introducir una cantidad monetaria.");
		}
		else if(cantidad < 0) {
			System.out.println("La cantidad monetaria ha de ser positiva.");
		}
		else {
			/* Se va desglosando de mayor a menor. Si la cantidad actual es mayor que el billete, se pone dicho billete. */
			/* No lo hago con funciones ni arrays porque no se han dado en clase pero facilitaría mucho todo :( */
			cantidadDesglosada = cantidad;

			//Billetes de 500
			int billetes500 = 0;
			while(cantidadDesglosada >= 500) {
				cantidadDesglosada -= 500;
				billetes500++;
			}
			if(billetes500 > 0) {
				System.out.println(billetes500 + " Billete" + (billetes500 > 1 ? "s":"") + " de 500€,");
			}
			
			//Billetes de 200
			int billetes200 = 0;
			while(cantidadDesglosada >= 200) {
				cantidadDesglosada -= 200;
				billetes200++;
			}
			if(billetes200 > 0) {
				System.out.println(billetes200 + " Billete" + (billetes200 > 1 ? "s":"") + " de 200€,");
			}

			//Billetes de 100
			int billetes100 = 0;
			while(cantidadDesglosada >= 100) {
				cantidadDesglosada -= 100;
				billetes100++;
			}
			if(billetes100 > 0) {
				System.out.println(billetes100 + " Billete" + (billetes100 > 1 ? "s":"") + " de 100€,");
			}
			
			//Billetes de 50
			int billetes50 = 0;
			while(cantidadDesglosada >= 50) {
				cantidadDesglosada -= 50;
				billetes50++;
			}
			if(billetes50 > 0) {
				System.out.println(billetes50 + " Billete" + (billetes50 > 1 ? "s":"") + " de 50€,");
			}

			//Billetes de 20
			int billetes20 = 0;
			while(cantidadDesglosada >= 20) {
				cantidadDesglosada -= 20;
				billetes20++;
			}
			if(billetes20 > 0) {
				System.out.println(billetes20 + " Billete" + (billetes20 > 1 ? "s":"") + " de 20€,");
			}

			//Billetes de 10
			int billetes10 = 0;
			while(cantidadDesglosada >= 10) {
				cantidadDesglosada -= 10;
				billetes10++;
			}
			if(billetes10 > 0) {
				System.out.println(billetes10 + " Billete" + (billetes10 > 1 ? "s":"") + " de 10€,");
			}

			//Billetes de 5
			int billetes5 = 0;
			while(cantidadDesglosada >= 5) {
				cantidadDesglosada -= 5;
				billetes5++;
			}
			if(billetes5 > 0) {
				System.out.println(billetes5 + " Billete" + (billetes5 > 1 ? "s":"") + " de 5€,");
			}

			//Monedas de 2
			int monedas2 = 0;
			while(cantidadDesglosada >= 2) {
				cantidadDesglosada -= 2;
				monedas2++;
			}
			if(monedas2 > 0) {
				System.out.println(monedas2 + " Moneda" + (monedas2 > 1 ? "s":"") + " de 2€,");
			}

			//Monedas de 1
			int monedas1 = 0;
			while(cantidadDesglosada >= 1) {
				cantidadDesglosada -= 1;
				monedas1++;
			}
			if(monedas1 > 0) {
				System.out.println(monedas1 + " Moneda" + (monedas1 > 1 ? "s":"") + " de 1€,");
			}

			//Monedas de 0,5
			int monedas50 = 0;
			while(cantidadDesglosada >= 0.5) {
				cantidadDesglosada -= 0.5;
				monedas50++;
			}
			if(monedas50 > 0) {
				System.out.println(monedas50 + " Moneda" + (monedas50 > 1 ? "s":"") + " de 0.50€,");
			}

			//Monedas de 0,2
			int monedas20 = 0;
			while(cantidadDesglosada >= 0.2) {
				cantidadDesglosada -= 0.2;
				monedas20++;
			}
			if(monedas20 > 0) {
				System.out.println(monedas20 + " Moneda" + (monedas20 > 1 ? "s":"") + " de 0.20€,");
			}
			
			//Monedas de 0,1
			int monedas10 = 0;
			while(cantidadDesglosada >= 0.1) {
				cantidadDesglosada -= 0.1;
				monedas10++;
			}
			if(monedas10 > 0) {
				System.out.println(monedas10 + " Moneda" + (monedas10 > 1 ? "s":"") + " de 0.10€,");
			}
			
			//Monedas de 0,05
			int monedas05 = 0;
			while(cantidadDesglosada >= 0.05) {
				cantidadDesglosada -= 0.05;
				monedas05++;
			}
			if(monedas05 > 0) {
				System.out.println(monedas05 + " Moneda" + (monedas05 > 1 ? "s":"") + " de 0.05€,");
			}
			
			//Monedas de 0,02
			int monedas02 = 0;
			while(cantidadDesglosada >= 0.02) {
				cantidadDesglosada -= 0.02;
				monedas02++;
			}
			if(monedas02 > 0) {
				System.out.println(monedas02 + " Moneda" + (monedas02 > 1 ? "s":"") + " de 0.02€,");
			}
			
			//Monedas de 0,01
			int monedas01 = 0;
			while(cantidadDesglosada >= 0.01) {
				cantidadDesglosada -= 0.01;
				monedas01++;
			}
			if(monedas01 > 0) {
				System.out.println(monedas01 + " Moneda" + (monedas01 > 1 ? "s":"") + " de 0.01€,");
			}
		}
	}
}
