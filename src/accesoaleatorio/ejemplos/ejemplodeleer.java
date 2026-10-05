package accesoaleatorio.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ejemplodeleer {
    static void main() {
        File directorio=new File("src/accesoaleatorio/ejemplos/archivos");
        File archivo=new File(directorio+"/empleados.dat");
        try(RandomAccessFile leer=new RandomAccessFile(archivo,"r")){
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
