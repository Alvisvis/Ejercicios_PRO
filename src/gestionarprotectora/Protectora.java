/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW1-M
 */
public class Protectora {

    private ArrayList<Animal> animales;
    private ArrayList<Adopcion> adopciones;

    public Protectora() {
        this.animales = new ArrayList<>();
        this.adopciones = new ArrayList<>();
    }

    public Animal getAnimal(int _id, String nombre) {
        for (Animal a : animales) {
            if (a != null && a.getId() == _id && a.getNombre().equals(nombre)) {
                return a;
            }
        }
        return null;

    }

    public void anadirAnimal(Animal a) {
        int id = a.getId();
        String nombre = a.getNombre();

        if (getAnimal(id, nombre) == null) {
            animales.add(a);
            System.out.println("Animal añadido");
        } else {
            System.out.println("Este animal ya exite");
        }

    }

    public void cargarAnimales(String _nombreArchivos) {
        File fichero;
        Scanner sc;
        Animal a;
        try {
            sc = new Scanner(new File(_nombreArchivos));
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] atributos = linea.split(",");
                if (atributos[0].equals("Perro")) {
                    int id = Integer.parseInt(atributos[1]);
                    String nombre = atributos[2];
                    int edad = Integer.parseInt(atributos[3]);
                    Fecha fecha = Fecha.stringToFecha(atributos[4]);
                    String raza = atributos[5];
                    boolean entrenado = Boolean.parseBoolean(atributos[6]);
//                        anadirAnimal(a) = new Perro(id, nombre, edad, fecha, raza, entrenado);

                }

            }
        } catch (Exception e) {
        }
    }
}
//Codigo comentado de ejemplo para hacer ficheros de texto

//        File fichero;
//        Scanner sc = null;
//        try {
//            sc = new Scanner(new File(rutatxtC));
//
//            while (sc.hasNextLine()) {
//                String linea = sc.nextLine();
//                String[] atributos = linea.split("#");
//
//                if (atributos[0].equals("Cliente")) {
//                    String dni = atributos[1];
//                    String nombre = atributos[2];
//                    String direccion = atributos[3];
//                    String localidad = atributos[4];
//                    String codigoPostal = atributos[5];
//                    anadirCliente(clientes[numCliente++] = new Cliente(dni, nombre, direccion, localidad, codigoPostal));
//                }
//              } catch (Exception e) {
//            System.out.println("Error leyendo clientes:" + e.getMessage());
//        }
// public static boolean escribirArchivo(String ruta, String datos, boolean _sobreEscribir) {
//        boolean correcto = false;
//
//        File archivo = new File(ruta);
//        FileWriter fichero = null;
//
//        try {
//            fichero = new FileWriter(archivo, _sobreEscribir);
//
//            System.out.println("Guardando información............");
//
//            fichero.write(datos);
//            fichero.close();
//
//            System.out.println("Información guardada");
//            correcto = true;
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("Fichero no encontrado");
//
//        } catch (IOException e) {
//            System.out.println("Mensaje:  " + e.getMessage());
//        }
//
//        return correcto;
//    }
//
//    public static String leerArchivo(String ruta) {
//        File fichero = new File(ruta);
//        Scanner sc = null;
//        StringBuilder contenido = new StringBuilder();
//
//        try {
//            System.out.println("Leyendo el contenido del fichero..........\n\n");
//            sc = new Scanner(fichero);
//
//            // leer línea a linea el fichero
//            while (sc.hasNextLine()) {
//                contenido.append(sc.nextLine()).append("\n");
//            }
//
//            System.out.println("\n --->>   Lectura completada");
//
//        } catch (Exception e) {
//            System.out.println("Mensaje:  " + e.getMessage());
//        } finally {
//            try {
//                if (sc != null) {
//                    sc.close();
//                }
//            } catch (Exception e2) {
//                System.out.println("Mensaje fichero:   " + e2.getMessage());
//            }
//        }
//        return contenido.toString();
//    }
//}
