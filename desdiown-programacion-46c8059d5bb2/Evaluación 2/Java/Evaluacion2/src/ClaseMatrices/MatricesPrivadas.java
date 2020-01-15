package ClaseMatrices;
import java.util.concurrent.ThreadLocalRandom; //Range random number generator
public class MatricesPrivadas {
    private int[][] matrizActual;
    public MatricesPrivadas(int longitudArray,boolean darOrdenado)
    {
        this.generarMatriz(longitudArray,longitudArray);
        if(darOrdenado)
        {
            this.ordenarMatriz();
        }
    }
    public MatricesPrivadas(int longitudArray,boolean darOrdenado,boolean irregular)
    {
        int longitudIrregular = 0;
        if(irregular == true)
        {
            longitudIrregular = -1;
        }
        this.generarMatriz(longitudArray,longitudIrregular);
        if(darOrdenado)
        {
            this.ordenarMatriz();
        }
    }
    public void visualizarMatriz()
    {
        System.out.println("Visualizador de matriz:");
        System.out.println("-----------------------");
        for(int i = 0; i < this.matrizActual.length; i++) {
            for(int i2 = 0; i2 < this.matrizActual[i].length; i2++)
            {
                System.out.println("Posición: " + i + " Clave: " + i2 + ", Valor:" + this.matrizActual[i][i2]);
            }
        }
    }
    public void generarMatriz(int longitudArray, int longitudSubarray)
    {
        int[][] matrizGenerada = new int[longitudArray][];
        if(longitudArray > 0)
        {
            for(int i = 0; i < longitudArray; i++)
            {
                if(longitudSubarray == -1) //¿Es irregular?
                {
                    longitudSubarray = ThreadLocalRandom.current().nextInt(1,11);
                    matrizGenerada[i] = new int[longitudSubarray];
                }
                else
                {
                    matrizGenerada[i] = new int[longitudSubarray];
                }
                for(int i2 = 0; i2 < longitudSubarray; i2++)
                {
                    matrizGenerada[i][i2] = ThreadLocalRandom.current().nextInt(0,10); //10 No incluido
                }
            }
        }
        else
        {
            System.out.println("El array ha de contener al menos un elemento.");
            System.exit(0);
        }
        this.matrizActual = matrizGenerada;
    }
    public int devolverPosicion(int x, int y) //Getter
    {
        return this.matrizActual[x][y];
    }
    public void modificarPosicion(int x, int y, int newVal) //Getter
    {
        this.matrizActual[x][y] = newVal;
    }
    public void ordenarMatriz() //Orderer
    {
        int cuentaintercambios=0;
	for(boolean ordenado=false;!ordenado;)
        {
            for(int x=0;x<this.matrizActual.length-1;x++)
            {
                for(int i=0;i<this.matrizActual[x].length-1;i++)
                {
                    if(this.matrizActual[x][i]>this.matrizActual[x][i+1])
                    {
                        int variableauxiliar=this.matrizActual[x][i];
                        this.matrizActual[x][i]=this.matrizActual[x][i+1];
                        this.matrizActual[x][i+1]=variableauxiliar;
                        cuentaintercambios++;
                    }
                }
            }
            if (cuentaintercambios==0){
		ordenado=true;
            }
            cuentaintercambios=0;
        }
    }
    public int buscarEnMatriz(int numeroABuscar)
    {
        int numeroEncontrado = -1;
        int posicionActual = 0;
        for(int[] subMatriz:this.matrizActual)
        {
            for(int numeroAhora:subMatriz)
            {
                if(numeroAhora == numeroABuscar)
                {
                    numeroEncontrado = posicionActual;
                    break;
                }
                posicionActual++;
            }
        }
        return numeroEncontrado;
    }
}