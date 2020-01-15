import java.util.Scanner;

class TrianguloRectangulo {
    private float base;
    private float altura;
	public TrianguloRectangulo(float base, float altura) {
		this.base = base;
		this.altura = altura;
	}
	public TrianguloRectangulo() {
	}
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float calcularPerimetro() {
		//los triángulos rectángulos tienen 3 lados iguales (y la base es un lago), así que multiplicar la base por 3 lados.
		return this.base * 3;
	}
	
	public float calcularArea() {
		return this.base * this.altura;
	}
    
}


public class Ejercicio02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		TrianguloRectangulo tr = new TrianguloRectangulo();

		System.out.println("Introduce la base del triángulo (CM)");
		tr.setBase(teclado.nextFloat());
		System.out.println("Introduce la altura del triángulo (CM)");
		tr.setAltura(teclado.nextFloat());
		
		System.out.println("Introduce 0 para calcular el área y 1 para calcular el perímetro.");
		
		switch(teclado.nextInt()) {
		case 0:
			System.out.println("Área del triángulo: " + tr.calcularArea() + " CM.");
			break;
		case 1:
			System.out.println("Perímetro del triángulo: " + tr.calcularPerimetro() + " CM.");
			break;
			default:
				System.out.println("Opción no reconocida.");
		}
		
		teclado.close();
	}
}
