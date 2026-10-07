package accesoaleatorio.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejemplo_sobre_escribir {
    private static int po=36;
    static void main() {
        File directorio=new File("src/accesoaleatorio/ejemplos/archivos");
        File archivo=new File(directorio+"/empleados.dat");
        int[] identificadores = {1, 2, 3, 4};

        System.out.println("Porfavor ingrese un id para buscar");
        Scanner sc=new Scanner(System.in);
        int opcion=sc.nextInt();
        System.out.println("Ingrese el nuevo salario");
        double nuevo=sc.nextDouble();

        try(RandomAccessFile leer=new RandomAccessFile(archivo,"rw")){
            long posicion=(long) (opcion-1) * po;
            if (posicion>=leer.length()){
                System.out.println("El empleado no  existe");
            }
            leer.seek(posicion+28);
            System.out.println("Salario antiguo "+leer.readDouble());
            leer.seek(posicion+28);
            leer.writeDouble(nuevo);
            leer.seek(posicion+28);
            System.out.println("Salario nuevo: "+leer.readDouble());
            System.out.println("salario actualizado correctamente");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
        sc.close();
    }
}
