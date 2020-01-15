package ejerMatrices;

public class Ejer7 {
    public static void main(String[] args)
    {
        ClaseMatrices caller = new ClaseMatrices();
        double[][] temperaturas = caller.crearMatrizDouble(12,30);
        int thisMonth = 0;
        int diaMasCalurosoAño = 0;
        double temperaturaMayorAño = 0;
        for(double[] mes:temperaturas)
        {
            int thisDay = 0;
            double sumatemperaturas = 0;
            double maxTemp = 0;
            int diaMaxTemp = 0;
            double minTemp = 0;
            int diaminTemp = 0;
            for(double dia:mes)
            {
                if(temperaturas[thisMonth][thisDay] > maxTemp)
                {
                    maxTemp = temperaturas[thisMonth][thisDay];
                    diaMaxTemp = (int) dia;
                }
                if(temperaturas[thisMonth][thisDay] < minTemp)
                {
                    minTemp = temperaturas[thisMonth][thisDay];
                    diaminTemp = (int) dia;
                }
                if(temperaturas[thisMonth][thisDay] > temperaturaMayorAño)
                {
                    temperaturaMayorAño = temperaturas[thisMonth][thisDay];
                    diaMasCalurosoAño = (int) dia;
                }
            }
            double temperaturamedia = sumatemperaturas/30;
            System.out.println("Temperatura media: " + temperaturamedia);
            System.out.println("Día más temperatura: " + diaMaxTemp + " (Temperatura: " + maxTemp + ")");
            System.out.println("Día menor temperatura: " + minTemp + " (Temperatura: " + diaminTemp + ")");
        }
    }
}