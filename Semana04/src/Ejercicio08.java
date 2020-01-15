
public class Ejercicio08 {

	public static void main(String[] args) {
		int a=5,b=3,c=20,d=20;
		c-=++a/b-3+a%b;
		d-=++a/(b+3-4*a)%b;
		 System.out.println("c:" + c);
		 System.out.println("d:" + d); 
		 /*
		  * Output:
		   	c:21
			d:20
		  * Respuesta:
		  * c vale 21 ya que se está restando el valor
		  * actual de c (20) al resultado de la operación
		  * ++a/b-3+a%b, la cual sería:
		  * 6/3-3+5%3, que da como resultado -1.
		  * c = 20 - (-1) = 21.
		  * 
		  * d vale 20, ya que está restando el valor actual de
		  * d (20) entre la operación:
		  * ++a/(b+3-4*a)%b, la cual sería similar a:
		  * 7/(3+3-4*)%3, que da como resultado 0.
		  * d = 20 - 0 = 0.
		  * 
		  * En este ejercicio llaman mucho la atención los paréntesis.
		  * Los paréntesis facilitan la lectura del código.
		  */
	}

}

/*
 * Para paliar un poco la monotonía, dejo esto para alegrarme
 * donde no moleste.
 *         .=     ,        =.
  _  _   /'/    )\,/,/(_   \ \
   `//-.|  (  ,\\)\//\)\/_  ) |
   //___\   `\\\/\\/\/\\///'  /
,-"~`-._ `"--'_   `"""`  _ \`'"~-,_
\       `-.  '_`.      .'_` \ ,-"~`/
 `.__.-'`/   (-\        /-) |-.__,'
   ||   |     \O)  /^\ (O/  |
   `\\  |         /   `\    /
     \\  \       /      `\ /
      `\\ `-.  /' .---.--.\
        `\\/`~(, '()      ('
         /(O) \\   _,.-.,_)
        //  \\ `\'`      /
  jgs  / |  ||   `""""~"`
     /'  |__||
¡¡POR QUE NO PONÉIS PARÉNTESIS CON TABULACIONES!!
 */
