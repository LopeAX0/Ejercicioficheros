package Ampliacion.Ampliados;

import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
    static void main() throws IOException {
        File ruta = new File("src/Ampliacion/Ampliados/cosas");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo que deses leer, no pongas el .txt");
        File fichero = new File(ruta+"/"+sc.nextLine()+".txt");
        if(!fichero.exists()) {
            System.out.println("El archivo no existe");
        }
        else {
            BufferedReader contarlinea =new BufferedReader(new FileReader(fichero));
            String linea;
            int cont=0;


            while ((linea= contarlinea.readLine())!=null){
                cont++;
            }
            System.out.println("El archivo que eligio tiene: "+cont+" lineas.");
        }
    }
}
