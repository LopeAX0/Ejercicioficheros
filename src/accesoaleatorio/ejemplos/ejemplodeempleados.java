package accesoaleatorio.ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class ejemplodeempleados {
    static void main() {
        File directorio=new File("src/accesoaleatorio/ejemplos/archivos");
        File archivo=new File(directorio+"/empleados.dat");
        int [] ide={1,2,3,4};
        String[] apellido={"García","Colome","Cruz","Cano"};
        int[] depart={10,20,10,30};
        double[] salario={1800.50,2100.00,1950.75,2300.25};
        try(RandomAccessFile meter=new RandomAccessFile(archivo,"rw")){
            for(int i=0;i<ide.length;i++){
                meter.writeInt(ide[i]);
                StringBuffer apellidos=new StringBuffer(apellido[i]);
                apellidos.setLength(10);
                meter.writeChars(apellidos.toString());
                meter.writeInt(depart[i]);
                meter.writeDouble(salario[i]);
            }
            System.out.println("Registros almacenados correctamente.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }
}
