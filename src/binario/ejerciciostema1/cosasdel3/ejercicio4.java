package binario.ejerciciostema1.cosasdel3;

import java.io.*;
import java.util.Scanner;

public class ejercicio4 {
    static void main() throws IOException {
        File archivo=new File("src/binario/ejerciciostema1/cosasdel3/tienda.dat");
        if (!archivo.exists()){
            archivo.createNewFile();
            existe(archivo);
        }else {
            existe(archivo);
        }
    }
    public static void existe(File archivo) throws FileNotFoundException {


        try(Scanner sc=new Scanner(System.in);){
            DataOutputStream escribir=new DataOutputStream(new FileOutputStream(archivo));
            for(int i=0; i<3;i++) {
                System.out.println("Ingresa el nombre del producto");
                String nombre = sc.next();
                System.out.println("ingresa el precio");
                Double precio = sc.nextDouble();
                System.out.println("ingrese el stock del producto");
                int stock = sc.nextInt();

                Producto p1 = new Producto(nombre, precio, stock);

                escribir.writeUTF(p1.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(DataInputStream leer=new DataInputStream(new FileInputStream(archivo))){
            for (int i=0;i<3;i++){
                String prueba= leer.readUTF();
                System.out.println(prueba);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
