package binario.ejerciciostema1.ficha;

import java.io.*;

public class Fejercicio5 {
    static void main(String[] args) throws IOException {
        File archivo=new File("src/binario/ejerciciostema1/ficha/archivos/datosbeca.bin");
        if(!archivo.exists()){
            archivo.createNewFile();
            iniciar(archivo);
        }else {iniciar(archivo);}
    }
    public static void iniciar(File archivo) throws IOException {
        try(DataInputStream leer=new DataInputStream(new FileInputStream(archivo))){
            while (true){
                String nombre2=leer.readUTF();
                String apellidos2=leer.readUTF();
                String sexo2=leer.readUTF();
                int edad2=leer.readInt();
                int suspensas2=leer.readInt();
                String famili2=leer.readUTF();
                double ingreso2=leer.readDouble();
                String beca2=leer.readUTF();
                if(beca2.equals("Si")||beca2.equals("si")){
                    System.out.print("El becad@: "+nombre2+" "+apellidos2);
                cuantia(ingreso2,edad2,suspensas2,famili2);
                }

            }
        }catch (EOFException e) {

            System.out.println("\n--- Fin del archivo alcanzado con éxito ---");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void cuantia(double ingresos, int edad, int suspensas, String vive) throws IOException {
        int basefija=1500;
        int aumentoporfami=500;
        int aumentoaños=200;
        int salida=basefija;
        if(ingresos<=12000){
            salida+=aumentoporfami;
        }
        if(edad<23){
            salida+=aumentoaños;
        }
        switch (suspensas){
            case 0:{
                salida+=500;
                break;}
            case 1:{
                salida+=200;break;
            }
            default:{
                break;
            }
        }

        if(vive.toLowerCase().equals("no")){
            salida+=1000;
        }
        System.out.print(" tiene una cuantia de "+salida);
        System.out.println();



    }
}
