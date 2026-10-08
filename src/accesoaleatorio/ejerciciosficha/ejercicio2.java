package accesoaleatorio.ejerciciosficha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio2 {
    private static int po=4;
    private static int total=16;
    private static File directorio=new File("src/accesoaleatorio/ejerciciosficha/ficheros");

    private static File fichero=new File(directorio+"/enteros.dat");

    static void main() throws FileNotFoundException {
        Scanner sc =new Scanner(System.in);
    boolean salida=false;
        int respuesta=0;
        while (salida==false){
            System.out.println("Introduzca un numero del 0 al 9");
            respuesta=sc.nextInt();
            if(respuesta>=0&&respuesta<=9){
                salida=true;
            }
        }

        try(RandomAccessFile meter=new RandomAccessFile(fichero,"rw")){
            meter.seek(meter.length());
            for (int i=0;i<=respuesta;i++){
                meter.writeInt(respuesta);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(RandomAccessFile leer=new RandomAccessFile(fichero,"r")){
            int rellenos= Math.toIntExact(leer.length()/4);
            for (int i=0;i<rellenos;i++){
                System.out.print(leer.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException("algo a pasado");

        }


    }
}
