package binario.ejerciciostema1.ficha;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Fejercicio4 {
    static void main(String[] args) throws IOException {
        File archivo=new File("src/binario/ejerciciostema1/ficha/archivos/datosbeca.bin");
        if(!archivo.exists()){
            archivo.createNewFile();
            iniciar(archivo);
        }else {iniciar(archivo);}
    }
    public static void iniciar(File archivo) throws IOException {
        Scanner sc =new Scanner(System.in);
        System.out.println("Antes de empezar introduzca el numero de becarios que va a introducir");
        int n=sc.nextInt();
        try(DataOutputStream escribe= new DataOutputStream(new FileOutputStream(archivo))){
            for(int i=0;i<n;i++){


            System.out.println("Ingrese su nombre");
        String nombre=sc.next();
        sc.nextLine();
        System.out.println("ingrese sus pellidos");
        String apellidos=sc.nextLine();
        System.out.println("Eres H(Hombre) o M(Mujer)");
        String sexo= sc.next();
        System.out.println("Ingrese su edad");
        int edad=sc.nextInt();
        if(edad<20||edad>60){
            throw new IOException("Edad invalido");
        }
        System.out.println("Di cauntas asignaturas has suspendido");
        int suspensas=sc.nextInt();
                if(suspensas<0||suspensas>4){
                    throw new IOException("No se puede suspender suficiente");
                }
        System.out.println("Reside con su familia? Si o No");
        String famili=sc.next();
        System.out.println("Ingrese el ingreso anual de la familia");
        double ingreso=sc.nextDouble();
        System.out.println("Indica si tiene beca.");
        String beca=sc.next().toLowerCase(Locale.ROOT);



            escribe.writeUTF(nombre);
            escribe.writeUTF(apellidos);
            escribe.writeUTF(sexo);
                escribe.writeInt(edad);
            escribe.writeInt(suspensas);
            escribe.writeUTF(famili);
            escribe.writeDouble(ingreso);
            escribe.writeUTF(beca);
            }
        }
        try(DataInputStream leer= new DataInputStream(new FileInputStream(archivo))){
            for(int i=0;i<n;i++){
            String nombre2=leer.readUTF();
            String apellidos2=leer.readUTF();
            String sexo2=leer.readUTF();
                int edad2=leer.readInt();
            int suspensas2=leer.readInt();
            String famili2=leer.readUTF();
            double ingreso2=leer.readDouble();
            String beca2=leer.readUTF();
                System.out.println(nombre2+" "+apellidos2+" "+sexo2+" "+edad2+" "+suspensas2+" "+famili2+" "+ingreso2+" "+beca2);
        }}
    }
}
