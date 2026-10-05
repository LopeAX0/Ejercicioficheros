package accesoaleatorio.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejemploseek {
    private static int po=36;
    static void main() {
        File directorio=new File("src/accesoaleatorio/ejemplos/archivos");
        File archivo=new File(directorio+"/empleados.dat");

        System.out.println("Porfavor ingrese un id para buscar");
        Scanner sc=new Scanner(System.in);
        int opcion=sc.nextInt();

        try(RandomAccessFile leer=new RandomAccessFile(archivo,"r")){
            long posicion=(long) (opcion-1) * po;
            while(leer.getFilePointer()<archivo.length()){
                int ide=leer.readInt();
                char[] apellido=new char[10];
                for(int i=0;i<apellido.length;i++){
                    apellido[i]= leer.readChar();
                }
                int departamento=leer.readInt();
                double salrio=leer.readDouble();
                System.out.println("Id: "+ide+", Apellido: "+new String (apellido).trim()+", Departamento: "+departamento+", Salario: "+salrio);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }
}
