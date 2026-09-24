package Ampliacion.Ejercicio4;

import java.io.*;

public class ejercicio3 {
    static void main() throws IOException {
        File original = new File("src/Ampliacion/Ejercicio4/cosas/datos.txt");
        File copia = new File("src/Ampliacion/Ejercicio4/cosas/copia.txt");

        if(!original.exists()){
            System.out.println("No se a podido copiar debido a que no existe el archivo el que desea copiar");
        }
        else {
            copia.createNewFile();
            try( BufferedReader leer= new BufferedReader(new FileReader(original));
            BufferedWriter escribir = new BufferedWriter(new FileWriter(copia));){
                String linea;
                while((linea= leer.readLine()) !=null){
                    escribir.write(linea);
                    escribir.newLine();
                }
            }
            System.out.println("Ya se a terminado de copiar el archivo");
        }
    }
}
