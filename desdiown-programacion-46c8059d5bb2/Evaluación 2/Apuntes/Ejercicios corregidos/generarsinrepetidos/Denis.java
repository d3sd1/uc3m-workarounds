/*
DENIS JIMENEZ ALVARO 
 */
package generarAlumnos;

/**
GENERAR UN NÚMERO DE 4 CIFRAS QUE NO TENGAN NINGÚN NÚMERO REPETIDO 
EL NÚMERO SE VUELVE A GENERAR UNA Y OTRA VEZ HASTA QUE NO TENGA
NINGUNA CIFRA REPETIDA. 
 */
public class Denis {
    
    public static void main(String args[]){//MÉTODO PRINCIPAL
        
        int v[] = new int[4];
        boolean repetido = false; 
        
        while (repetido == false){
            int num = (int)(Math.random()*9000+1000); //GENERA UN NUMERO DE 4 CIFRAS AL AZAR
            System.out.println("El numero generado es : " +num);
            deEnteroaArray(num,v); //PASA EL NUMERO ENTERO A UN ARRAY
            verificar(v);//VERIFICA SI EL ARRAY TIENE ELEMENTOS REPETIDOS
            if(verificar(v) == true){
            System.out.println("Se repiten cifras:" +
            " volviendo a generar otro número...");
            }
            else{
           // System.out.println("No se repite ningún número el array es :");
           // visualizar(v); //VISUALIZA EL ARRAY
            repetido = true; 
            }
       }
    
    }
    //DEFINICIÓN DE LOS MÉTODOS 
    public static void deEnteroaArray(int num, int v[]){
        int aux = num; 
        for(int i=v.length-1; i>=0; i--){
            v[i] = aux%10;
            aux = aux/10;
        }
    }
    public static boolean verificar(int v[]){
      boolean repetido = false;
      for(int i=0; i<v.length; i++){
       for(int j=i+1; j<v.length; j++){
           if(v[i] == v[j]){
               repetido = true;
           }
        }
    }
    return repetido;
    }
    public static void visualizar(int v[]){
        for(int i=0; i<v.length; i++){
        System.out.println("V[" +i+"] = "+v[i]);
        }
    } 
}
