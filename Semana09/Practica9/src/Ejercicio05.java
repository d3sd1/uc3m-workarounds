import java.util.Scanner;

class Producto {

	private String nombre;
	private float precio;
	private int cantidad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto(String nombre, float precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public Producto() {
		this.nombre = "";
		this.precio = 0;
		this.cantidad = 0;
	}

	public String toString() {
		return "Nombre: " + this.nombre + ", cantidad: " + this.cantidad + ", precio: " + this.precio + "€";
	}
}

public class Ejercicio05 {

	public static void main(String[] args) {

		Producto[] productos = new Producto[10];
		Scanner input = new Scanner(System.in);
		String nombreProducto;
		menu: while(true) {
			System.out.println("Menú - Selecciona una opción");
			System.out.println("1. Alta de producto");
			System.out.println("2. Buscar por nombre");
			System.out.println("3. Modificar stock y precio");
			System.out.println("4. Salir");
			System.out.println("Introduce el número de la opción: ");
			switch(input.nextInt()) {
			case 1:
				altaProducto(productos, input);
				break;
			case 2:
				System.out.println("Introduce el nombre del producto a buscar: ");
				nombreProducto = input.next();
				buscarProducto(productos, nombreProducto);
				break;
			case 3:
				System.out.println("Introduce el nombre del producto a modificar: ");
				nombreProducto = input.next();
				Producto modProducto = buscarProducto(productos, nombreProducto);
				modificarProducto(modProducto, input);
				break;
			case 4:
				System.out.println("Saliendo...");
				break menu;
				default:
					System.out.println("Opción no reconocida.");
			}
		}
		input.close();
	}
	/* Se añaden estos métodos para no sobrecargar el main, aunque se crean y destruyen más objetos, simplifica mucho. */
	private static void altaProducto(Producto[] productos, Scanner input) {
		Producto nuevoProducto = new Producto();
		System.out.println("Introduce el nombre del producto a añadir: ");
		nuevoProducto.setNombre(input.next());
		System.out.println("Introduce la cantidad del producto a añadir: ");
		nuevoProducto.setCantidad(input.nextInt());
		System.out.println("Introduce el precio unitario del producto a añadir: ");
		nuevoProducto.setPrecio(input.nextFloat());
		
		for(int i = 0; i < productos.length; i++) {
			if(productos[i] == null) {
				//posicion libre
				productos[i] = nuevoProducto;
				System.out.println("Producto añadido: " + nuevoProducto);
				return;//terminar la función para prevenir duplicados.
			}
		}
		System.out.println("No hay espacios libres en la tienda. No se pudo añadir el producto" + nuevoProducto);
	}
	private static Producto buscarProducto(Producto[] productos, String nombreProducto) {
		for(Producto p:productos) {
			if(p != null && nombreProducto.equals(p.getNombre())) {
				System.out.println("Producto encontrado: " + p);
				return p;
			}
		}
		System.out.println("Producto no encontrado: " + nombreProducto);
		return null;
	}
	private static void modificarProducto(Producto producto, Scanner input) {
		if(null == producto) {
			return; //si es null no hacemos nada, ya que se ha buscado previamente.
		}
		System.out.println("Introduce la nueva cantidad de " + producto.getNombre());
		producto.setCantidad(input.nextInt());
		System.out.println("Introduce el nuevo precio unitario de " + producto.getNombre());
		producto.setPrecio(input.nextFloat());
	}
}
