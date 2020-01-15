package cadenas1516;

import java.util.Scanner;


public class Ahorcado {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        
        int a=0;
        String respuesta;
        
        
        char op;
        do{
        int vidas=6;
        boolean fin=true;
        
        String palabra=generarPalabra();
        //char[]ocultar=llenarArray(palabra);
        char[]Arraycaracteres=llenar(palabra);
        
        System.out.print("Juego del ahorcado: ");
        System.out.println("Tienes 6 vidas para intentar acertar la palabra");
        System.out.println("\nLa palabra tiene "+palabra.length()+" caracteres");
        visualizar(Arraycaracteres);
        
        do{
            
        System.out.print("\nIntroduce una letra o resuelve: ");
        respuesta=teclado.next();
        char letra=respuesta.charAt(0);
        if(respuesta.length()==1){
            if(palabra.indexOf(letra)==-1){
                vidas--;
                System.out.println("Esa letra no esta. Te quedan "+vidas+" vidas");
                dibuja(vidas);
            }
            else{
                for(int i=0; i<palabra.length(); i++){
                    if(palabra.charAt(i)==letra){
                        Arraycaracteres[i]=letra;
                    }
                }
            
            visualizar(Arraycaracteres);
            }
        }
        else{
                if (respuesta.equals(palabra)){
                    fin=false;
                    System.out.println("Has acertado!");
                }
                else{
                    vidas--;
                    System.out.println("Has fallado. Te quedan "+vidas+" vidas");
                    dibuja(vidas);
                }
       }
       }while(vidas>0&&fin);
       System.out.println("Quieres jugar otra vez? s/n");
       String aux=teclado.next();
       op=aux.charAt(0);
       }while(op=='s');
       
    }
    
    public static void visualizar(char[]vector){
        for(char elemento:vector){
            System.out.print(elemento+"  ");
        }    
    }
    
    
    public static char[] llenarArray(String cad){
        char[]v=new char[cad.length()];
        for(int i=0; i<cad.length(); i++){
            v[i]=cad.charAt(i);
        }
        return v;
    }
    
    public static char[] llenar(String cad){
        char[]h=new char[cad.length()];
        for(int i=0; i<cad.length(); i++){
            h[i]='*';
        }
        return h;
    }
    
    public static String generarPalabra(){
        
        String palabra="0";
        int opcion=(int)(Math.random()*8+1);
        
        switch(opcion){
            case 1: palabra="perro";
                    break;
            case 2: palabra="gato";
                    break;
            case 3: palabra="elefante";
                    break;
            case 4: palabra="caballo";
                    break;
            case 5: palabra="gallina";
                    break;
            case 6: palabra="serpiente";
                    break;
            case 7: palabra="cocodrilo";
                    break;
            case 8: palabra="armadillo";
                    break;
        }
        return palabra;
        
  
        
    }
     public static void dibuja(int fase) {
        switch(fase) {
        case 6:
            System.out.println("");
            System.out.println("                     ");
            System.out.println("                     ");
            System.out.println("                     ");
            System.out.println("           ooo       ");
            System.out.println("           ooo       ");
            System.out.println("            o        ");
            System.out.println("          ooooo      ");
            System.out.println("         o  o  o     ");
            System.out.println("         o o o o     ");
            System.out.println("           o o       ");
            System.out.println("          o   o      ");
            System.out.println("         o     o     ");
            System.out.println("ooooooooooooooooooooo");
            System.out.println("");
            System.out.println("");
            break;

        case 5:
            System.out.println("");
            System.out.println("   o                 ");
            System.out.println("   o                 ");
            System.out.println("   o                 ");
            System.out.println("   o       ooo       ");
            System.out.println("   o       ooo       ");
            System.out.println("   o        o        ");
            System.out.println("   o      ooooo      ");
            System.out.println("   o     o  o  o     ");
            System.out.println("   o     o o o o     ");
            System.out.println("   o       o o       ");
            System.out.println("   o      o   o      ");
            System.out.println("   o     o     o     ");
            System.out.println("ooooooooooooooooooooo");
            System.out.println("");
            System.out.println("");
            break;

        case 4:
            System.out.println("");
            System.out.println("   oooooooooooo      ");
            System.out.println("   o                 ");
            System.out.println("   o                 ");
            System.out.println("   o       ooo       ");
            System.out.println("   o       ooo       ");
            System.out.println("   o        o        ");
            System.out.println("   o      ooooo      ");
            System.out.println("   o     o  o  o     ");
            System.out.println("   o     o o o o     ");
            System.out.println("   o       o o       ");
            System.out.println("   o      o   o      ");
            System.out.println("   o     o     o     ");
            System.out.println("ooooooooooooooooooooo");
            System.out.println("");
            System.out.println("");
            break;

        case 3:
            System.out.println("");
            System.out.println("   oooooooooooo      ");
            System.out.println("   o   o             ");
            System.out.println("   o  o              ");
            System.out.println("   o o     ooo       ");
            System.out.println("   oo      ooo       ");
            System.out.println("   o        o        ");
            System.out.println("   o      ooooo      ");
            System.out.println("   o     o  o  o     ");
            System.out.println("   o     o o o o     ");
            System.out.println("   o       o o       ");
            System.out.println("   o      o   o      ");
            System.out.println("   o     o     o     ");
            System.out.println("ooooooooooooooooooooo");
            System.out.println("");
            System.out.println("");
            break;

        case 2:
            System.out.println("");
            System.out.println("   oooooooooooo      ");
            System.out.println("   o   o    o        ");
            System.out.println("   o  o     o        ");
            System.out.println("   o o     ooo       ");
            System.out.println("   oo      ooo       ");
            System.out.println("   o        o        ");
            System.out.println("   o      ooooo      ");
            System.out.println("   o     o  o  o     ");
            System.out.println("   o     o o o o     ");
            System.out.println("   o       o o       ");
            System.out.println("   o      o   o      ");
            System.out.println("   o     o     o     ");
            System.out.println("ooooooooooooooooooooo");
            System.out.println("");
            System.out.println("");
            break;

        case 1:
            System.out.println("");
            System.out.println("   oooooooooooo      ");
            System.out.println("   o   o    o        ");
            System.out.println("   o  o     o        ");
            System.out.println("   o o     ooo       ");
            System.out.println("   oo      ooo       ARGGG !!!!!!!");
            System.out.println("   o        o        ");
            System.out.println("   o       ooo       ");
            System.out.println("   o      o o o      ");
            System.out.println("   o     o o o o     ");
            System.out.println("   o       o o       ");
            System.out.println("   o      o   o      ");
            System.out.println("   o      o   o      ");
            System.out.println("ooooooooo o   o ooooo");
            System.out.println("        o       o    ");
            System.out.println("        o       o    ");
            System.out.println("");
            System.out.println("");
        }
     }
}
