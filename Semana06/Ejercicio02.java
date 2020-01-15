
public class Ejercicio02 {

	public static void main(String[] args) {
		float actualNum = 1.0F;
		while(actualNum < 100) {
			actualNum += 1.5F;
			if(actualNum == 100.0) {
				System.out.print(actualNum + ".");
			}
			else {
				System.out.print(actualNum + ", ");
			}
		}
	}

}
