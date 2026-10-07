package accesoaleatorio.ejerciciosficha;

import java.io.File;
import java.util.Scanner;

public class ejercicio1 {
    private File directorio=new File("src/accesoaleatorio/ejerciciosficha/ficheros");
    private File fichero=new File(directorio+"/enteros.dat");
    private int po=2;
    static void main() {
        Scanner sc=new Scanner(System.in);
        boolean salida=false;
        while (salida==false){
        System.out.println("Ingrese un numero del 0 al 9");
        int respuesta=sc.nextInt();
        if (respuesta>=0&&respuesta<=9){
            salida=true;
        }
        }



    }
}
