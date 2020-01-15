package Ejer_Vectores;

public class Two {
    public static void main(String[] args)
    {
        int[] ramdom1 = new int[10];
        for(int i = 0;i < 10;i++)
        {
            ramdom1[i] = (int) (Math.random() * 100);
        }
        int[] ramdom2 = new int[10];
        for(int i = 0;i < 10;i++)
        {
            ramdom2[i] = (int) (Math.random() * 100);
        }
        int[] ramdom3 = new int[10];
        for(int i = 0;i < 10;i++)
        {
            ramdom3[i] = ramdom1[i] + ramdom2[i];
            System.out.println(ramdom3[i]);
        }
    }
}