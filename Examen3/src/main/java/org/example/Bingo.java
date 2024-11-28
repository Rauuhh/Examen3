package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public void bingo(){
        Random aleatorio = new Random();
        Scanner entrada =  new Scanner(System.in);

        int muestra = aleatorio.nextInt((40 + 1));
        while (muestra < 10)
        {
            muestra = aleatorio.nextInt((40 + 1));
        }


        int tamano[] = new int[muestra];
        int bolas[] = new int[muestra];


        for (int i = 0; i < tamano.length; i++) {
            bolas[i] = aleatorio.nextInt(90)+1;
            for (int j = 0; j < tamano.length ; j++) {
                while (bolas[i] == tamano[j])
                {
                    bolas[i] = aleatorio.nextInt(90)+1;
                }
            }
        }
        System.out.println( muestra + " bolas extraidas hasta ahora: " + Arrays.toString(bolas));

        int bingo[][] = new int [3][3];
        System.out.println("**** Introduce los datos de tu carton ***");
        for (int i = 0; i < bingo.length; i++)
        {
            System.out.println("Fila " + (i+1));
            System.out.println("Introduce valores de la fila");
            String fila = entrada.next();
            String fila2[] = fila.split("-");

            if (bingo.length != fila2.length )
            {
                System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N)");
                return;
            }
            for (int j = 0; j < bingo[0].length; j++) {
                bingo[i][j] = Integer.parseInt(fila2[j]);
            }

        }
        System.out.println("Datos del carton introducido");
        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[0].length; j++) {
                System.out.print(bingo[i][j] + " ");
            }
            System.out.print("\n");
        }
        int contador = 0;
        int pabingo = 0;
        System.out.println("Premios");

        bucle1:
        for (int i = 0; i < bingo.length; i++) {
            bucle2:
            for (int j = 0; j < bingo[0].length; j++) {
                for (int k = 0; k < bolas.length; k++) {
                    if (bingo[i][j] == bolas[k])
                    {
                        contador++;
                        continue bucle2;
                    }

                }
            }

            if (contador == 3)
            {
                System.out.println("Linea " + (i+1) + " = CORRECTA!!");
                pabingo++;
            }else
            {
                System.out.println("Linea " + (i+1) + " = No");
            }
            contador = 0;
        }

        if (pabingo == 3)
        {
            System.out.println("Hay bingo");
        }
    }
}
