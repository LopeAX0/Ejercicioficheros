package binario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ejercicio1 {
    static void main() throws IOException {
        File ruta=new File("src/binario/archivos/cosa.dat");
        if(!ruta.exists()){
            ruta.createNewFile();
            System.out.println("Creado archivo");
        }
        try(FileOutputStream escribir= new FileOutputStream(ruta)){
            int linea=99;
            for(int i=0; i<=linea;i++){
                escribir.write(i);

            }
            escribir.close();
        }

    }
}
