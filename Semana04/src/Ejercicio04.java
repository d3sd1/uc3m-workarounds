
public class Ejercicio04 {

	public static void main(String[] args) {
		int a,b;
		float c=3; //Pasa a ser 3.0 por el autocasteo interno de Java.
		boolean r,s,t,u,v,w,x;
		a = 3;
		b = 8;
		r = a == 0;
		s = a != 0;
		t = a <= b;
		u = b >= a;
		v = b > a;
		w = b < a;
		x = c == 3.0;
		System.out.println("r:" + r);
		System.out.println("s:" + s);
		System.out.println("t:" + t);
		System.out.println("u:" + u);
		System.out.println("v:" + v);
		System.out.println("w:" + w);
		System.out.println("x:" + x);
		/*
		 * Output:
		  	r:false
			s:true
			t:true
			u:true
			v:true
			w:false
			x:true
		 * Respuesta:
		 * r es false ya que está comparando 3 == 0, y la expresión es falsa. (Comparador de igualdad).
		 * s es true ya que está comparando si 3 != 0, y la expresión es verdadera. (Comparador de desigualdad).
		 * t es true ya que está comparando si 3 <= 8, y la expresión es verdadera (Comparador menor o igual que).
		 * u es true ya que está comparando si 8 >= 3, y la expresión es verdadera (Comparador mayor o igual que).
		 * v es true ya que está comparando si 8 > 3, y la expresión es verdadera (Comparador mayor que).
		 * w es false ya que está comparando si 8 < 3, y la expresión es falsa (Comparador menor que).
		 * x es true ya que está comparando si 3 == 3.0, y la expresión es cierta (Comparador de igualdad),
		 * 	ya que al introducir un entero a una variable float 
		 * internamente java hace un autocasteo a tipo float, y le añade los decimales correspondientes (3 pasaría a ser 3.0).
		 */
	}

}
