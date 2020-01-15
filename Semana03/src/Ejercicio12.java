
public class Ejercicio12 {

	public static void main(String[] args) {
		byte b1 = 1, b2 = 2, b3;
		b3 = b2 + b1;
		b3 = b2 - b1;
		b3 = b2 * b1;
		b3 = b2 / b1;
		b3 = b2 % b1;
		
		short s1 = 3, s2 = 4, s3;
		s3 = s2 + s1;
		s3 = s2 - s1;
		s3 = s2 * s1;
		s3 = s2 / s1;
		s3 = s2 % s1;
		
		int i1 = 5, i2 = 6, i3;
		i3 = i2 + i1;
		i3 = i2 - i1;
		i3 = i2 * i1;
		i3 = i2 / i1;
		i3 = i2 % i1;
		
		long l1 = 7, l2 = 8, l3;
		l3 = l2 + l1;
		l3 = l2 - l1;
		l3 = l2 * l1;
		l3 = l2 / l1;
		l3 = l2 % l1;
		
		char c1 = 9, c2 = 10, c3;
		c3 = c2 + c1;
		c3 = c2 - c1;
		c3 = c2 * c1;
		c3 = c2 / c1;
		c3 = c2 % c1;
		
		/*
		 * Respuesta:
		 * Se producen fallos con char, short y byte, ya que los
		 * operandores convierten a entero las operaciones anteriores
		 * antes de realizarse. Es decir, internamente, al operar, el
		 * byte se convierte a entero para poder operar. Una vez operado, 
		 * da como resultado un entero, que no se puede asignar a byte.
		 * Se podría asignar haciendo un casting, de todas maneras.
		 */
	}
}
