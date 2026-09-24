package Ampliacion.Ampliados;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
    static void main() throws IOException {


    File ruta = new File("src/Ampliacion/Ampliados/cosas");
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el nombre del archivo que deses leer, no pongas el .txt");

    File fichero = new File(ruta + "/" + sc.nextLine() + ".txt");
            if(!fichero.exists())

    {
        System.out.println("El archivo no existe");
    }
            else

    {
        BufferedReader contarlinea = new BufferedReader(new FileReader(fichero));
        String linea;
        int cont = 0;


        while ((linea = contarlinea.readLine()) != null) {
            cont++;
        }
        String[] ultimo = new String[cont];


        BufferedReader leer = new BufferedReader(new FileReader(fichero));
        int posicion = cont - 1;
        while ((linea = leer.readLine()) != null) {
            ultimo[posicion] = linea;
            posicion--;
        }

        BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta + "/salida.txt"));

        for (int i = 0; i < ultimo.length; i++) {
            escribir.write(ultimo[i]);
            escribir.newLine();

        }
        escribir.close();


    }
}
}
