
package generarAlumnos;


public class Miguel_Angel_Díaz{
    
    public static void main(String[]args){
    
        boolean repetido;
        int v[]=new int[4];
        int num;
        do{
            num=(int)(Math.random()*9000+1000);
            rellenar(v,num);
            repetido=comprobar(v);
        }while(repetido==true);
        
        System.out.println(num);
        
    }
    
    public static void rellenar(int v[],int num){
    
        
        int a=3;
        for(int i=0; i<v.length; i++){
        
            v[a]=num%10;
            num=num/10;
            a--;
        }
    }
    
    public static boolean comprobar(int v[]){
    
        boolean repetido=false;
        for(int i=0; i<v.length; i++){
        
            for(int j=i+1; j<v.length; j++){
            
                if(v[i]==v[j]){
                    repetido=true;
                    break;
                }
            }
        }
        return repetido;
    }
    
}
