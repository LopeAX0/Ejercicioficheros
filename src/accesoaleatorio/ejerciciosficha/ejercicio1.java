package accesoaleatorio.ejerciciosficha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio1 {
    private static File directorio=new File("src/accesoaleatorio/ejerciciosficha/ficheros");
    private static File fichero=new File(directorio+"/enteros.dat");
    private static int po=4;
    private static int total=16;
    static void main() {
        Scanner sc=new Scanner(System.in);
        boolean salida=false;
        int respuesta=0;
        while (salida==false){
        System.out.println("Ingrese un numero del 0 al 9");
         respuesta=sc.nextInt();
        if (respuesta>=0&&respuesta<=9){
            salida=true;
        }
        }
        int su2=0;
        int su1=0;
        try(RandomAccessFile meter=new RandomAccessFile(fichero,"rw")){
            for(int i=0;i<total;i++){
               if(i>=6){
                   meter.writeInt(2);
                   su2++;
                   System.out.println("Se a metido el 2"+su2);
               }
               else {
                   meter.writeInt(1);
                   su1++;
                   System.out.println("Se a metido el 1c "+su1);

               }

            }
            System.out.println("Registros almacenados correctamente.");
            System.out.println("Lo que ahi dentro");
            for(int i=0;i<total;i++){
                meter.seek(i*4);
                System.out.print(meter.readInt()+" ");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }

        try(RandomAccessFile sustituir=new RandomAccessFile(fichero,"rw")){
            for(int i=6;i<total;i++){
                sustituir.seek(i*4);
                sustituir.writeInt(respuesta);
                sustituir.seek(i*4);

            }
            System.out.println("Lo que ahi dentro2");
            for(int i=0;i<total;i++){
                sustituir.seek(i*4);
                int pri=sustituir.readInt();
                System.out.print(pri+" ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
    /*package accesoaleatorio.ejerciciosficha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio1 {

        static void main() {
            Scanner sc = new Scanner(System.in);
            int[] numeros = new int[16];
            numeros= new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
            try(RandomAccessFile archivo = new RandomAccessFile("src/accesoaleatorio/ejerciciosficha/ficheros/enteros.dat", "rw")) {
                for (int i = 0; i < numeros.length; i++) {
                    archivo.writeInt(numeros[i]);
                }
                System.out.println("Por que numero deseas susituir el 2?");
                int numero = sc.nextInt();
                archivo.seek(0);
                for (int i = 0; i < numeros.length; i++) {
                    int valor = archivo.readInt();
                    if (valor == 2) {
                        archivo.seek(archivo.getFilePointer() - 4);
                        archivo.writeInt(numero);
                    }
                }
                System.out.println("Se han sustituido todos los 2 por " + numero);
                for (int i = 0; i < numeros.length; i++) {
                    archivo.seek(i * 4);
                    System.out.println(archivo.readInt());
                }
            } catch (Exception e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }

*/
}
