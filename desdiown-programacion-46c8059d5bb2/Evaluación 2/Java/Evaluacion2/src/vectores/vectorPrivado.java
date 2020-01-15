package vectores;
import java.util.concurrent.ThreadLocalRandom; //Range random number generator
public class vectorPrivado {
    private int[] arrayActual;
    public vectorPrivado(int longitudArray,boolean darOrdenado)
    {
        this.generarVector(longitudArray);
        if(darOrdenado)
        {
            this.ordenarArray();
        }
    }
    public void visualizarVector()
    {
        System.out.println("Visualizador de vector:");
        System.out.println("-----------------------");
        for(int i = 0; i < this.arrayActual.length; i++) {
            System.out.println("Clave: " + i + ", Valor:" + this.arrayActual[i]);
        }
    }
    public void generarVector(int longitudArray)
    {
        int[] vectorGenerado = new int[longitudArray];
        if(longitudArray > 0)
        {
            for(int i = 0; i < longitudArray; i++)
            {
                vectorGenerado[i] = ThreadLocalRandom.current().nextInt(0,10); //10 No incluido
            }
        }
        else
        {
            System.out.println("El array ha de contener al menos un elemento.");
            System.exit(0);
        }
        this.arrayActual = vectorGenerado;
    }
    public int devolverPosicion(int posicion) //Getter
    {
        return this.arrayActual[posicion];
    }
    public void modificarPosicion(int posicion,int newVal) //Getter
    {
        this.arrayActual[posicion] = newVal;
    }
    public void enviarElemento(int elemento, boolean devolverOrdenado) //Setter
    {
        int[] enviarElemento = new int[(this.arrayActual.length+1)];
        enviarElemento[this.arrayActual.length] = elemento;
        if(devolverOrdenado)
        {
            this.ordenarArray();
        }
    }
    public void ordenarArray() //Orderer
    {
        int cuentaintercambios=0;
	for(boolean ordenado=false;!ordenado;)
        {
            for(int i=0;i<this.arrayActual.length-1;i++)
            {
                if(this.arrayActual[i]>this.arrayActual[i+1])
                {
                    int variableauxiliar=this.arrayActual[i];
                    this.arrayActual[i]=this.arrayActual[i+1];
                    this.arrayActual[i+1]=variableauxiliar;
                    cuentaintercambios++;
                }
            }
            if (cuentaintercambios==0){
		ordenado=true;
            }
            cuentaintercambios=0;
        }
    }
    public int buscarEnArray(int numeroABuscar)
    {
        int numeroEncontrado = -1;
        int posicionActual = 0;
        for(int numeroAhora:this.arrayActual)
        {
            if(numeroAhora == numeroABuscar)
            {
                numeroEncontrado = posicionActual;
                break;
            }
            posicionActual++;
        }
        return numeroEncontrado;
    }
}