/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peliculas_pro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author mgb
 */
public class Cine implements Serializable, IOrdenar {

    private String autor;
    private ArrayList<Pelicula> peliculas;

    public Cine(String autor) {
        this.autor = autor;
        this.peliculas = new ArrayList<>();
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void verPeliculas() {
        String text;
        text = "Cine: " + autor + "\nPeliculas: ";
        System.out.println(text);

        if (peliculas == null || peliculas.isEmpty()) {
            cargarBinario();
        }

        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.toString());
        }
    }

    public void anadirPelicula(Pelicula peli) {
        if (peli != null) {
            peliculas.add(peli);
            System.out.println("Pelicula añadida");
        } else {
            System.out.println("Esta Pelicula ya exite");
        }
    }

    public Pelicula buscarPelicula(String titulo) {
        for (Pelicula peli : peliculas) {
            if (peli != null && peli.getTitulo().equals(titulo)) {
                return peli;
            }
        }
        return null;
    }

    public void eliminarPelicula(Pelicula pe) {
        if (buscarPelicula(pe.getTitulo()) == null) {
            System.out.println("Esa pelicula no existe");
        } else {
            System.out.println(buscarPelicula(pe.getTitulo()).toString());
            peliculas.remove(pe);
            System.out.println("Pelicula eliminada");
        }
    }

    @Override
    public void ordenarLista(Comparator criterio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cargarFichero(String nombreFichero) {
        System.out.println(nombreFichero);
        try (Scanner sc = new Scanner(new File(nombreFichero))) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] atributos = linea.split("; ");

                //Atributos
                String titulo = atributos[0];
                String genero = atributos[1];
                String pais = atributos[2];
                int dia = Integer.parseInt(atributos[3]);
                int mes = Integer.parseInt(atributos[4]);
                int anno = Integer.parseInt(atributos[5]);
                Fecha fecha = new Fecha(dia, mes, anno);
                int duracion = Integer.parseInt(atributos[6]);

                Pelicula peli = new Pelicula(fecha, genero, titulo, pais, duracion);
                anadirPelicula(peli);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");

        } catch (NumberFormatException e) {
            System.out.println("Error al convertir numeros del fichero");
        }
    }

    //---------------------------------------------------------------
    /**
     * Metodo que carga los datos binarios
     *
     * @return
     */
    public Cine cargarBinario() {
        Cine cinepolis = new Cine(this.autor);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Peliculas.dat"))) {
            cinepolis = (Cine) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Ha habido un fallo" + e);
        }
        return cinepolis;
    }

    //---------------------------------------------------------------
    /**
     * Metodo que guarda los datos binarios
     *
     * @param cinepolis
     */
    public void guardaBinario() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Peliculas.dat"))) {

            oos.writeObject(this);
        } catch (Exception e) {
            System.out.println("Ha habido un fallo" + e);
        }
    }
}
