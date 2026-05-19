/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW1-M
 */
public class Protectora implements Serializable {

    private ArrayList<Animal> animales;
    private ArrayList<Adopcion> adopciones;

    public Protectora() {
        this.animales = new ArrayList<>();
        this.adopciones = new ArrayList<>();
    }

    public Protectora(ArrayList<Animal> animales, ArrayList<Adopcion> adopciones) {
        this.animales = animales;
        this.adopciones = adopciones;
    }

    public void listarAnimales() {
        for (Animal animale : animales) {
            System.out.print(animale.toString());
        }
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
        try (Scanner sc = new Scanner(new File(_nombreArchivos))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] atributos = linea.split(",");

                //Atributos en comun
                int id = Integer.parseInt(atributos[1]);
                String nombre = atributos[2];
                int edad = Integer.parseInt(atributos[3]);
                Fecha fecha = Fecha.stringToFecha(atributos[4]);

                if (atributos[0].equals("Perro")) {
                    String raza = atributos[5];
                    boolean entrenado = Boolean.parseBoolean(atributos[6]);
                    Perro p = new Perro(id, nombre, edad, fecha, raza, entrenado);
                    anadirAnimal(p);
                } else if (atributos[0].equals("Gato")) {
                    String pelaje = atributos[5];
                    boolean esAgresivo = Boolean.parseBoolean(atributos[6]);
                    Gato g = new Gato(id, nombre, edad, fecha, pelaje, esAgresivo);
                    anadirAnimal(g);
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("El archivo " + _nombreArchivos + " no ha sido encontrado");
        }
    }

    public  Protectora leerBinario() {
        Protectora p = new Protectora();
        try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream("protectora.dat"))) {
            p = (Protectora) ob.readObject();
            ob.close();
        } catch (Exception e) {
            System.out.println("No se ha podido leer el archivo");
        }
        return p;
    }

    public void guardarBinario() {
        try (ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("protectora.dat"))) {

//            obs.writeObject(animales);
//            obs.writeObject(adopciones);
            Protectora p = new Protectora(animales, adopciones);
            obs.writeObject(p);
            obs.close();
            System.out.println("datos guardados");
        } catch (Exception e) {
            System.out.println("No se ha podido escribir los datos");
        }
    }

}
