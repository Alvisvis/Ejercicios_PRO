/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
            System.out.print(animale.toString() + "    ");
            animale.emitirSonido();
        }
    }

    public void listarAnimalesFicha() {
        for (Animal animale : animales) {
            System.out.print(animale.fichaAnimal() + "\n");
        }
    }

//    public Animal getAnimal(String nombre) {
//        for (Animal a : animales) {
//            if (a != null && a.getNombre().equals(nombre)) {
//                return a;
//            }
//        }
//        return null;
//
//    }
    public Animal getAnimal(int _id) {
        for (Animal a : animales) {
            if (a != null && a.getId() == _id) {
                return a;
            }
        }
        return null;

    }

    public void anadirAnimal(Animal a) {
        if (a != null) {
            animales.add(a);
            System.out.println("Animal añadido");
        } else {
            System.out.println("Este animal ya exite");
        }
    }

    public void eliminarAnimal(int id) {
        if (getAnimal(id) != null) {
            Animal a = getAnimal(id);
            animales.remove(a);
        }
    }

    public void listarAdoptados() {
        for (Adopcion adopcione : adopciones) {
            System.out.println(adopcione.toString());
        }
    }

//    public Adopcion getAdopcion(int id) {
//        for (Adopcion ado : adopciones) {
//            if (ado != null && ado.getAdoptado().getId() == id) {
//                return ado;
//            }
//        }
//        return null;
//    }
    public void anadirAdopcion(Adopcion ado) {
        if (ado != null) {
            adopciones.add(ado);
            eliminarAnimal(ado.getAdoptado().getId());
            System.out.println("Adopcion tramitada con exito para " + ado.getAdoptado().getNombre());
        } else {
            System.out.println("Ha ocurrrido un error");
        }
    }

    public void anadirRevisionMedica(Revision revi, int id) {
        if (id > 100) {
            Animal a = getAnimal(id);
            a.getHistorialMedico().add(revi);
            System.out.println("Historial Actualizado");
        }

    }

    //METODOS ARCHIVOS
    public void guardarAnimales(String _nombreArchivos, Animal a) {
        try (FileWriter fw = new FileWriter(_nombreArchivos, true)) {
            fw.write(a.fichaAnimal());
            System.out.println("Guardado Exitosamente");
        } catch (Exception e) {
            System.out.println("Algo fallo ");
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
                    Perro p = new Perro(Animal.getContador(), nombre, edad, fecha, raza, entrenado);
                    anadirAnimal(p);
                } else if (atributos[0].equals("Gato")) {
                    String pelaje = atributos[5];
                    boolean esAgresivo = Boolean.parseBoolean(atributos[6]);
                    Gato g = new Gato(Animal.getContador(), nombre, edad, fecha, pelaje, esAgresivo);
                    anadirAnimal(g);
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("El archivo " + _nombreArchivos + " no ha sido encontrado");
        }
    }

    public Protectora leerBinario() {
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
