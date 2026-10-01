package binario.ejerciciostema1.ficha;

import java.io.*;
import java.util.Scanner;

public class Fejercicio2 {
    static void main(String[] args) throws IOException {
        File archivo=new File("src/binario/ejerciciostema1/ficha/archivos/coches.bin");
        if(!archivo.exists()){
            archivo.createNewFile();
            iniciar(archivo);
        }else {iniciar(archivo);}
    }
    public static void iniciar(File archivo) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese la matriula del vehiculo");
        String matricula=sc.next();
        System.out.println("Introduzca la marca");
        String marca=sc.next();
        System.out.println("Ingrese el tamaño del deposito");
        Double deposito=sc.nextDouble();
        System.out.println("Ingrese el modelo");
        String model=sc.next();


        try(DataOutputStream escribir=new DataOutputStream(new FileOutputStream(archivo,true))){
            escribir.writeUTF(matricula);
            escribir.writeUTF(marca);
            escribir.writeDouble(deposito);
            escribir.writeUTF(model);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(DataInputStream leer=new DataInputStream(new FileInputStream(archivo))){
            while (true){
                String matricula2=leer.readUTF();
                String marca2= leer.readUTF();
                Double deposito2= leer.readDouble();
                String modelo2= leer.readUTF();
                System.out.println("\n");
                System.out.println("Matricula: "+matricula2);
                System.out.println("Marca: "+marca2);
                System.out.println("Deposito: "+deposito2);
                System.out.println("Modelo: "+modelo2);

            }
        }catch (EOFException e) {

            System.out.println("\n--- Fin del archivo alcanzado con éxito ---");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}
