package com.techlab.inicio;
import java.util.ArrayList;

public class SaludoPersonalizado {

    public static void main(String[] args) {
        //Tipo de datos
        //Numeros
        int i;
        int edad = 28;
        long edadTierra = 1983745L;
        long edadPersona=20L;

        //numeros con decimales
        float dinero= 123.3f;
        double masDinero= 123.45f;

        //texto
        String nombre= "Augusto";

        //Arraylist
        ArrayList<String> productos= new ArrayList<>();

       productos.add("Pepitos");
       productos.add("Oreo");
       productos.add("Coca-cola");
       productos.add("Cerveza");

       System.out.println("Al comienzo el array tiene "+productos.size()+" elementos");

       for (i=0; i<4; i++){
           System.out.println("Se cargo: " +productos.get(i));
           if(productos.get(i) == "Oreo")
               System.out.println("Que rica que es la oreo =D");
       }

       System.out.println("Se elimina" +productos.get(0));
       productos.remove(0);

       System.out.println(productos.size());



        System.out.println("Hola mundo jeje"+ nombre);
    }
}
