package binario.ejerciciostema1.ficha;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Fejercicio1 {
    static void main(String[] args) throws IOException {
        File archivo=new File("src/binario/ejerciciostema1/ficha/archivos/num_aleat.bin");
        if(!archivo.exists()){
            archivo.createNewFile();
            iniciar(archivo);
        }else {iniciar(archivo);}
    }
    public static void iniciar(File archivo) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingresa la cantidad de numeros que se van a generar");
        int numero=sc.nextInt();
        System.out.println("Ingresa el numero maximo que puede aparecer");
        int max=sc.nextInt();
        System.out.println("ingresa el minimo");
        int min=sc.nextInt();
        Random random=new Random();

        try(DataOutputStream escribir=new DataOutputStream(new FileOutputStream(archivo,true))){
            escribir.writeUTF("Esta cadena a sido de "+numero+" y va del "+min+" al "+max);
            for(int i=0;i<numero;i++){
                int aleatorio=random.nextInt((max-min)+1)+min;

                escribir.writeInt(aleatorio);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(DataInputStream leer=new DataInputStream(new FileInputStream(archivo))){
            while (true){
                String cabecera = leer.readUTF();
                System.out.println("\n" + cabecera);
                int cantidadNumeros = Integer.parseInt(cabecera.split(" ")[5]);
                System.out.print("Números: ");
                for (int i = 0; i < cantidadNumeros; i++) {
                    System.out.print(leer.readInt() + " ");
                }
                System.out.println();

            }
    }catch (EOFException e) {

            System.out.println("\n--- Fin del archivo alcanzado con éxito ---");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
