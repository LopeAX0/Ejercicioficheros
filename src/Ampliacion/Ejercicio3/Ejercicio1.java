package Ampliacion.Ejercicio3;

import java.io.File;
import java.util.Dictionary;

public class Ejercicio1 {
    static void main() {
        File directorio = new File("src/Ampliacion/Ejercicio3/Copias");
        if (directorio.exists()){
            System.out.println("El Directorio ya existe");
        }
        else {
            directorio.mkdir();
            System.out.println("El directorio se a creado correctamente");
        }

    }
}
