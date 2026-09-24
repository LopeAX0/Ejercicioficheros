package Ampliacion.Ejercicio3;

import java.io.File;
import java.io.IOException;

public class ejercicio2 {
    static void main() throws IOException {
        try {
            File directorio = new File("src/Ampliacion/Ejercicio3/Copias/config.txt");
            if (directorio.exists()) {
                System.out.println("El archivo ya existe");
            } else {
                directorio.createNewFile();
                System.out.println("El archivo a sido creado correctamente.");
            }
        } catch (Exception e){
            System.out.println("no se encuentra el directorio");
        }
    }

}
