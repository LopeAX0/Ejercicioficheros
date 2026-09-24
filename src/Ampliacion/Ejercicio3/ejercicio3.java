package Ampliacion.Ejercicio3;

import java.io.File;

public class ejercicio3 {
    static void main() {
        File directorio = new File("src/Ampliacion/Ejercicio3/Copias/");
        String [] elementos= directorio.list();

        if (elementos != null){
            for (String nombre: elementos){
                File elemento=new File(directorio, nombre);

                if(elemento.isDirectory()){
                    System.out.println("Directorio:  "+nombre);
                    File posible= new File(elemento.getAbsolutePath()+"/");
                    if (posible.list()!=null){
                        hijos(posible);
                    }
                }
                else {
                    System.out.println("Fichero:   "+nombre);
                }
            }
        }

    }
    public static void hijos(File directorio){
        String[] elementos =directorio.list();
        if (directorio != null){
            for(String nombre: elementos){
                File elemento=new File(directorio, nombre);

                if(elemento.isDirectory()){
                    System.out.println("    Directorio:  "+nombre);
                    File posible= new File(elemento.getAbsolutePath()+"/");
                    if (posible.list()!=null){
                        hijos(posible);
                    }
                }
                else {
                    System.out.println("    Fichero:   "+nombre);
                }
            }
        }
    }
}
