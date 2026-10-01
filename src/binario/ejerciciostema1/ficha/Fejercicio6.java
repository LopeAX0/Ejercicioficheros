package binario.ejerciciostema1.ficha;

import java.io.*;
import java.util.Scanner;

public class Fejercicio6 {
    static void main(String[] args) throws IOException {
        File archivo=new File("src/binario/ejerciciostema1/ficha/archivos/datospersonas.dat");
       Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese cuantas personas va a introducir");
        int n=sc.nextInt();

        if(!archivo.exists()){
            archivo.createNewFile();
            iniciar(archivo,n);
        }else {iniciar(archivo,n);}
    }
    static void iniciar(File archivo,int personas) throws IOException {
        Scanner sc=new Scanner(System.in);
        try(DataOutputStream escribir=new DataOutputStream(new FileOutputStream(archivo))){
            for(int i=0;i<personas;i++){
                System.out.println("Ingrese su nombre");
                String nombre=sc.next();
                sc.nextLine();
                System.out.println("Ingrese su apellido");
                String apellidos=sc.nextLine();
                System.out.println("Ingrese su edad");
                int edad=sc.nextInt();
                System.out.println("Ingrese su numero de telefono");
                int telefono=sc.nextInt();
                System.out.println("Ingrese su email");
                String email=sc.next();
                sc.nextLine();
                System.out.println("Ingrese su ciudad de residencia");
                String ciudad=sc.nextLine();
                sc.nextLine();
                System.out.println("Ingrese su nacionalidad");
                String nacionalidad=sc.nextLine();
                sc.nextLine();
                System.out.println("Ingrese su profesion");
                String profe=sc.nextLine();
                escribir.writeUTF(nombre);
                escribir.writeUTF(apellidos);
                escribir.writeInt(edad);
                escribir.writeInt(telefono);
                escribir.writeUTF(email);
                escribir.writeUTF(ciudad);
                escribir.writeUTF(nacionalidad);
                escribir.writeUTF(profe);
            }
            try(DataInputStream leer=new DataInputStream(new FileInputStream(archivo))){
                for(int i=0;i<personas;i++){
                    String nombre2=leer.readUTF();
                    String apellidos2=leer.readUTF();
                    int edad2=leer.readInt();
                    int telefono2=leer.readInt();
                    String email2=leer.readUTF();
                    String ciudad2=leer.readUTF();
                    String nacionalidad2=leer.readUTF();
                    String profesion2=leer.readUTF();
                    System.out.println(nombre2+" "+apellidos2+" "+edad2+" "+telefono2+" "+email2+" "+ciudad2+" "+nacionalidad2+" "+profesion2);
                }
            }catch (EOFException e) {

                System.out.println("\n--- Fin del archivo alcanzado con éxito ---");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }

    }
}
