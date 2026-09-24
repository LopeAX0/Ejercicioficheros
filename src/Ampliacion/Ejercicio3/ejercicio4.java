package Ampliacion.Ejercicio3;

import java.io.File;
import java.io.IOException;

public class ejercicio4 {
    static void main() throws IOException {
        File archivo = new File("src/Ampliacion/Ejercicio3/Copias/config.txt");
        File directorio = new File("src/Ampliacion/Ejercicio3/Copias/");
        if (!archivo.exists()){
            System.out.println("El archivo no existe");
        }
        else {
            archivo.delete();
            System.out.println("El archivo a sido borrado correctamente.");
        }

        if(!directorio.exists()){
            System.out.println("El directorio no existe");
        }
        else {
            directorio.delete();
            System.out.println("El directorio a sido eleminado correctamente.");
        }


    }
}
