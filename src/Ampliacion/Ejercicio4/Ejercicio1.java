package Ampliacion.Ejercicio4;

import java.io.*;

public class Ejercicio1 {
    static void main() throws IOException {
        File directorio=new File("src/Ampliacion/Ejercicio4/cosas");
        File nombre=new File(directorio+"/datos.txt");

        if (!directorio.exists()){
            directorio.mkdir();
            nombre.createNewFile();
            System.out.println("directorio y el fichero a sido creado correctamente");
            entra(nombre);
        } else if (nombre.exists()) {
            System.out.println("El fichero ya existe");
            entra(nombre);

        }
        else if(directorio.exists()&&!nombre.exists()) {
            nombre.createNewFile();
            System.out.println("El fichero ya a sido creado");
            entra(nombre);
        }

    }
    public static void entra(File nombre) throws FileNotFoundException {
        try(BufferedReader palabras = new BufferedReader(new FileReader(nombre))){
            String linea;
            int cont=0;
            while((linea= palabras.readLine()) != null){
                cont++;

            }
            System.out.println("El fichero contiene: "+cont+" lineas.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
