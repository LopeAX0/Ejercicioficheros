package accesoaleatorio.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class añadir {
    private static int po=36;
    static void main() {
        File directorio=new File("src/accesoaleatorio/ejemplos/archivos");
        File archivo=new File(directorio+"/empleados.dat");
        int[] identificadores = {1, 2, 3, 4};

        System.out.println("Porfavor ingrese el nuevo id");
        Scanner sc=new Scanner(System.in);
        int opcion=sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese los apellidos");
        String apellidos=sc.nextLine();
        System.out.println("ingrese el departamento");
        int departamento=sc.nextInt();
        System.out.println("Ingrese el salario");
        double nuevo=sc.nextDouble();


        try(RandomAccessFile fichero=new RandomAccessFile(archivo,"rw")) {
            boolean existe = false;
            while (fichero.getFilePointer()<fichero.length()){
                int id=fichero.readInt();
                if (id==opcion){
                    existe=true;
                    break;
                }
                fichero.seek(fichero.getFilePointer()+20+4+8);
            }
            if (existe){
                System.out.println("Ya existe un empleado con ese identificador");
                return;
            }
            fichero.seek(fichero.length());
            fichero.writeInt(opcion);
            StringBuffer apellidoEmpleado=new StringBuffer(apellidos);
            apellidoEmpleado.setLength(10);
            fichero.writeInt(departamento);
            fichero.writeDouble(nuevo);
            System.out.println("empleado añadido con exito.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}
