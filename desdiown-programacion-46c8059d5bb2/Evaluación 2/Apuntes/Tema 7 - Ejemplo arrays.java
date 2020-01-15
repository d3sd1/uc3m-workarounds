
package pruebas;


public class EjemplosArrays {
    
    public static void main(String[]args){
    
        int array[];     
        array = new int [5];
        
        for(int i=0; i<array.length; i++){
        
            array[i]=(int)(Math.random()*10);
        }
        for(int j=0; j<array.length; j++){
        
            System.out.println("array["+j+"]= "+array[j]);
        }
        
        System.out.println("ver con for-each");
        
        int s=0;
        for(int elemento:array){
        
            System.out.println(elemento);
            s=s+elemento;
        }
        System.out.println("la suma es: "+s);
    }
    
}
