package binario.ejerciciostema1;

import java.io.*;
import java.util.Scanner;

public class ejercicio2 {
    static void main() throws IOException {
        File ruta =new File("src/binario/ejerciciostema1/ficheros");
        File archivo=new File(ruta+"/ejercicio2.dat");
        archivo.createNewFile();
        int fin=3;
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream(archivo));
        try(Scanner sc = new Scanner(System.in);){

        for (int i=0;i<fin;i++) {

            System.out.println("Ingresa tu nombre");
            String nombre = sc.nextLine();
            System.out.println("ingrese su nota media");
            Double media = Double.parseDouble(sc.nextLine());
            escribir.writeUTF(nombre);
            escribir.writeDouble(media);
        }
        }

        try(DataInputStream leer=new DataInputStream(new FileInputStream(archivo))){
        for (int i=0;i<fin;i++){

            String nombre2 = leer.readUTF();
            double nota = leer.readDouble();
            System.out.println("Nombre: " + nombre2);

            System.out.println("media: "+ nota);

        }
        }
    }


}
