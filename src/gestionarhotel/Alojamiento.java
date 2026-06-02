/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarhotel;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW1-M
 */
public class Alojamiento implements IGestionarReserva {

    private String nombre;
    private int numeroHuespedes;
    private boolean conTerraza;
    private ArrayList<Reserva> reservas;

    public Alojamiento(String nombre, int numeroHuespedes, boolean conTerraza) {
        this.nombre = nombre;
        this.numeroHuespedes = numeroHuespedes;
        this.conTerraza = conTerraza;
        this.reservas = new ArrayList<>();
    }

    public void cargarReserva(String fichero) {
        try (Scanner sc = new Scanner(new File(fichero))) {
            String linea = sc.nextLine();
            String[] atributos = linea.split(";");

            String nombre = atributos[1];
            int numeroHuespede = Integer.parseInt(atributos[2]);
            boolean conTerraza = Boolean.parseBoolean(atributos[3]);

            if (atributos[0].contains("Habitacion")) {
                
            } else if (atributos[0].contains("Apartamento")) {

            }

        } catch (Exception e) {
        }
    }

    @Override
    public boolean insertar(Reserva nuevaReserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(Fecha fechaInicio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean disponible(Reserva nuevaReserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
