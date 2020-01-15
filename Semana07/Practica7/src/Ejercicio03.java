public class Ejercicio03 {
	public static void main(String[] args) {
		String[][] año = new String[12][]; //se inicializa a 12 por el numero de meses.

		/* Enero */
		año[0] = new String[31];
		/* Febrero */
		año[1] = new String[28];
		/* Marzo */
		año[2] = new String[31];
		/* Abril */
		año[3] = new String[30];
		/* Mayo */
		año[4] = new String[31];
		/* Junio */
		año[5] = new String[30];
		/* Julio */
		año[6] = new String[31];
		/* Agosto */
		año[7] = new String[31];
		/* Septiembre */
		año[8] = new String[30];
		/* Octubre */
		año[9] = new String[31];
		/* Noviembre */
		año[10] = new String[30];
		/* Diciembre */
		año[11] = new String[31];
		
		/* Rellenar */
		año[0][5] = "Hoy no hay clase";
		año[9][19] = "Examen parcial ";
		
		/* Output */
		System.out.println("El número de filas es " + año.length);
		for(int i = 0; i < año.length; i++) {
			System.out.println("El numero de columnas en la fila " + i + " es " + año[i].length);
		}
	}
}
