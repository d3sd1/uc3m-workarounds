import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio04 {
	public static void main(String[] args) {
		System.out.println(">>>>>QUINIELA A<<<<<");
		// A)
		char[] quinielaA = new char[15];
		/* Rellenar */
		for (int i = 0; i < quinielaA.length; i++) {
			int jugadaAleatoria = ThreadLocalRandom.current().nextInt(1, 3 + 1); // Número aleatorio en rango de 1 a 3.
																					// 1 = 1, 2 = 2, 3 = X.
			switch (jugadaAleatoria) {
			case 1:
				quinielaA[i] = '1';
				break;
			case 2:
				quinielaA[i] = '2';
				break;
			case 3:
				quinielaA[i] = 'X';
				break;
			}
		}
		/* Mostrar */
		for (int i = 0; i < quinielaA.length; i++) {
			System.out.println("Jugada " + i + ": " + quinielaA[i]);
		}

		// B)
		System.out.println(">>>>>QUINIELA B<<<<<");
		char[][] quinielaB = new char[38][15];
		/* Rellenar */
		for (int jornada = 0; jornada < quinielaB.length; jornada++) {
			for (int jugada = 0; jugada < quinielaB[jornada].length; jugada++) {
				int jugadaAleatoria = ThreadLocalRandom.current().nextInt(1, 3 + 1); // Número aleatorio en rango de 1 a
																						// 3. 1 = 1, 2 = 2, 3 = X.
				switch (jugadaAleatoria) {
				case 1:
					quinielaB[jornada][jugada] = '1';
					break;
				case 2:
					quinielaB[jornada][jugada] = '2';
					break;
				case 3:
					quinielaB[jornada][jugada] = 'X';
					break;
				}
			}
		}

		/* Mostrar */
		for (int jornada = 0; jornada < quinielaB.length; jornada++) {
			System.out.println("---- JORNADA " + jornada + " ----");
			for (int jugada = 0; jugada < quinielaB[jornada].length; jugada++) {
				System.out.println("Jugada " + jugada + ": " + quinielaB[jornada][jugada]);
			}
		}
	}
}
