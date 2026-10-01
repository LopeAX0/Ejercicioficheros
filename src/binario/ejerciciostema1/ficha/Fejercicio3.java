package binario.ejerciciostema1.ficha;

import java.io.*;
import java.util.Scanner;

public class Fejercicio3 {
    static void main(String[] args) throws IOException {
        File archivo=new File("src/binario/ejerciciostema1/ficha/archivos/datosbeca.bin");
        if(!archivo.exists()){
            archivo.createNewFile();
            iniciar(archivo);
        }else {iniciar(archivo);}
    }
    public static void iniciar(File archivo) throws IOException {
        Scanner sc =new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        String nombre=sc.next();
        sc.nextLine();
        System.out.println("ingrese sus pellidos");
        String apellidos=sc.nextLine();
        System.out.println("Eres H(Hombre) o M(Mujer)");
        String sexo= sc.next();
        System.out.println("Di cauntas asignaturas has suspendido");
        int suspensas=sc.nextInt();
        System.out.println("Reside con su familia? Si o No");
        String famili=sc.next();
        System.out.println("Ingrese el ingreso anual de la familia");
        double ingreso=sc.nextDouble();
        System.out.println("Indica si tiene beca.");
        String beca=sc.next();

        try(DataOutputStream escribe= new DataOutputStream(new FileOutputStream(archivo))){
            escribe.writeUTF(nombre);
            escribe.writeUTF(apellidos);
            escribe.writeUTF(sexo);
            escribe.writeInt(suspensas);
            escribe.writeUTF(famili);
            escribe.writeDouble(ingreso);
            escribe.writeUTF(beca);
        }
    }
}