package Ampliacion.Ampliados;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
    static void main() {
        File ruta = new File("src/Ampliacion/Ampliados/cosas");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo que deses leer, no pongas el .txt");
        File fichero = new File(ruta+"/"+sc.nextLine()+".txt");

        if(!fichero.exists()) {
            System.out.println("El archivo no existe o lo has escrito mal");
        }else  {
            try {
                BufferedReader leer=new BufferedReader(new FileReader(fichero));
                String linea;
                int contar=0;
                while ((linea=leer.readLine())!=null){
                    if(contar==24){
                        contar=0;
                        sc.nextLine();
                        System.out.println(linea);
                    }else{
                        System.out.println(linea);
                        contar++;
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
