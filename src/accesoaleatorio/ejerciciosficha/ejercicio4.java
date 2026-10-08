package accesoaleatorio.ejerciciosficha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio4 {
    private static final File RUTA_FICHERO = new File("src/accesoaleatorio/ejerciciosficha/ficheros");
    private static final File NOMBRE_FICHERO = new File(RUTA_FICHERO+"/juegos.dat");

  private static   int[] Orden = {1, 2, 3, 4};
    private static  String[] Nombres = {"Halo", "Teken", "Sims",
            "Fifa"};
    private static int[] edades = {17, 18, 8, 16};
    private static String[] clasificaciones = {"Aventura", "Acción", "Sandbox", "Deportes"};
    private static int po=48;

    static void main() throws FileNotFoundException {
        Scanner sc =new Scanner(System.in);
        System.out.println("ingrse una edad para recomendate juegos");
        int edad=sc.nextInt();
        boolean encontrado=false;
        try (RandomAccessFile fichero = new RandomAccessFile(NOMBRE_FICHERO, "r")) {
            long fin = fichero.length() / 48;
            for (int i=0;i< fin;i++){
                //Escribe identificador
                 int idor= fichero.readInt();
                //Escribe nombre de tamaño fijo 10 caracteres
                char [] nombre=new char[10];
                for(int e=0;e< nombre.length;e++){
                    nombre[e]=fichero.readChar();

                }
                int idedad= fichero.readInt();

                //Escribe clasificación
                char [] clasi=new char[10];
                for(int e=0;e< clasi.length;e++){
                    clasi[e]=fichero.readChar();

                }
                if (idedad<=edad){
                    System.out.printf("Orden:" + idor + ", Nombre: " + new String (nombre).trim()+ ", Edad: " + idedad + ", Clasificación: " + new String (clasi).trim()+"\n");
                    encontrado=true;
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(encontrado==false){
            System.out.println("No ahi ningun juego con dicha edad ");
        }

    }
}
