package Ampliacion.Ampliados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        File directorio =new File("src/Ampliacion/Ampliados/cosas");
        File fichero = new File(directorio+"/frases.txt");
        if (!directorio.exists()){
            directorio.mkdir();
            fichero.createNewFile();
            entra(fichero);
        } else if (directorio.exists()&&!fichero.exists()) {
            fichero.createNewFile();
            entra(fichero);
        }
        else {
            entra(fichero);
        }
    }
    public static void entra(File fichero) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean salida= false;
        while(salida==false){
        System.out.println("Ingresa la frase que desea guardar a en el documento.Cuando quieras dejar de escribir escriba x");
        String frases= sc.nextLine();
        if (frases.equals("x")){
            System.out.println("Se a terminado de escribir");
            salida=true;
        }
        else {
            BufferedWriter escribir= new BufferedWriter(new FileWriter(fichero,true));
            escribir.write(frases);
            escribir.newLine();
        }}

    }
}
