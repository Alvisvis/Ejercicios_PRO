/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
public class Biblioteca implements Serializable, IGestionPrestamo {

    //Atributo
    private String nombre;
    private ArrayList<Material> materiales;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.materiales = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void cargarMateriales(String _nombreFichero) {
        try (Scanner sc = new Scanner(new File(_nombreFichero))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] atributos = linea.split(";");

                //Atributos Comunes
                String codigo = atributos[1];
                String titulo = atributos[2];
                int annioPubli = Integer.parseInt(atributos[3]);

                //Atributos segun tipo
                if (atributos[0].equals("Libro")) {
                    String autor = atributos[4];
                    int numPagi = Integer.parseInt(atributos[5]);

                    Material libro = new Libro(codigo, titulo, annioPubli, autor, numPagi);
                    materiales.add(libro);
                } else if (atributos[0].equals("Revista")) {
                    int numero = Integer.parseInt(atributos[4]);
                    String mesPubli = atributos[5];

                    Material revista = new Revista(codigo, titulo, annioPubli, numero, mesPubli);
                    materiales.add(revista);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (NumberFormatException e) {
            System.out.println("Ha fallado los atributos, hay uno mal indicado o de mas");
        }
    }

    @Override
    public boolean insertarPrestamo(Prestamo p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean devolverPrestamo(Prestamo p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Prestamo buscarPrestamo(String codigoMaterial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
