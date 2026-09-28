package binario;

import java.io.*;
import java.util.Scanner;

public class ejercicio2 {
    static void main() throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        String nombre= sc.nextLine();
        System.out.println("introduzca su edad");
        int edad= sc.nextInt();
        System.out.println("ingrese su nota media");
        Double media=sc.nextDouble();

        File ruta=new File("src/binario/archivos/cosa2.dat");
        if (!ruta.exists()){
            ruta.createNewFile();
        }
        try(DataOutputStream escribir=new DataOutputStream(new FileOutputStream(ruta))){
            escribir.writeUTF(nombre);
            escribir.writeInt(edad);
            escribir.writeDouble(media);
        }
        try(DataInputStream leer=new DataInputStream(new FileInputStream(ruta))) {
            String nombre2 = leer.readUTF();
            int edad2 = leer.readInt();
            double nota = leer.readDouble();
            System.out.println("Nombre: " + nombre2);
            System.out.println("Edad: " + edad2);
            System.out.println("media: "+ nota);

        }
    }
}
