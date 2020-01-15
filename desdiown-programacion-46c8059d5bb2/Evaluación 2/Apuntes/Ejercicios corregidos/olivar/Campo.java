/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olivar;

/**
 *
 * @author user
 */
public class Campo {
    private int kilosOlivas; // variable de instancia o miembro dato
    private int edadOlivo;  // variable de instancia o miembro dato
    //static final double PVPOLIVA=0.05; //variable de clase

    Campo(){
     /*   this.edadOlivo=0;
        this.kilosOlivas=0;*/
        //otra forma equivalente
        this(0,0);
    }
    Campo(int edad,int numOlivas){  //primer constructor recibe los valores de los objetos
        this.edadOlivo=edad; //los valores son asignados a las variables de instancia
        this.kilosOlivas=numOlivas;
    }
    Campo(int numOlivas){ //segundo constructor recibe los valores de los objetos
        this.edadOlivo=30; // los valores son asignados a las variables de instancia
        this.kilosOlivas=numOlivas;
    }
    double beneficio(int PVPOLIVA){ //funcion calculo beneficio
        double dinero=kilosOlivas*PVPOLIVA;
        return dinero;
    }
    int getEdad(){
	  return(edadOlivo);
    }
    void setEdad(int edad){
        edadOlivo=edad;
    }
    int getKilos(){
        return (kilosOlivas);
    }
    void sumaEdad(int incremento){ //funcion incremento edad del olivo no devuelve nada
        edadOlivo+=incremento;
    }
    void sumaOlivas(int sumOlivas){ //funcion incremento de olivas no devuelve nada
        kilosOlivas*=sumOlivas;
    }
    @Override
    public String toString(){
        return("kilos="+kilosOlivas+"  edad="+edadOlivo);
    }
    
}
