package InterfaceList;

public class NodoLista {

    String nom;
    private int calif1;
    private int calif2;
    private int calif3;
    private double media;

    public void setNom(String nom){
        this.nom=nom;
    }
    
    public void setCalif1(int calif1){
        this.calif1=calif1;
    }
    
    public void setCalif2(int calif2){
        this.calif2=calif2;
    }
    
    public void setCalif3(int calif3){
        this.calif3=calif3;
    }
    
    public void setMedia(double media){
        this.media=media;
    }
    
    @Override
    public String toString() {
        return (nom + " " + calif1 + " " + calif2 + " " + calif3 + " " + "media= " + media);
    }
}
