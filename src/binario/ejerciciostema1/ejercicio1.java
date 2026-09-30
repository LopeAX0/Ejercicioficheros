package binario.ejerciciostema1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ejercicio1 {
    static void main() throws IOException {
        File ruta =new File("src/binario/ejerciciostema1/ficheros");
        File archivo=new File(ruta+"/ejercicio1.dat");
        archivo.createNewFile();
        try(FileOutputStream escribir=new FileOutputStream(archivo)){
            int fin=50;
            for (int i=0;i<fin+1;i++){
            escribir.write(i);
            }
        }finally {

        }
        try (FileInputStream leer=new FileInputStream(archivo)){
            int linea;
            while ((linea = leer.read()) != -1) {
                System.out.println(linea);
            }
        }
    }

}
