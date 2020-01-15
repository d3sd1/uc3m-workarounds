package Semana11;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));
        System.out.println("Introduce el texto");
        String texto = input.next();
        String[] palabras = texto.split(" ");

        for(int i = 1; i <= 10; i++) {
            int wordsWithThisLength = 0;
            for(String palabra:palabras) {
                if(palabra.length() == i) {
                    wordsWithThisLength++;
                }
            }
            System.out.println("Palabras de longitud " + i + ": " + wordsWithThisLength);
        }

        char[] vocales = new char[]{
                'a',
                'e',
                'i',
                'o',
                'u'
        };
        for(char vocal:vocales) {
            int wordsStartsWithThisLetter = 0;
            for(String palabra:palabras) {
                if(palabra.toLowerCase().charAt(0) == vocal) {
                    wordsStartsWithThisLetter++;
                }
            }
            System.out.println("Palabras que empiezan por " + vocal + ": " + wordsStartsWithThisLetter);
        }

        input.close();
    }
}
