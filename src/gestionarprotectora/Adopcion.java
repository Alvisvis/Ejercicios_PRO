/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.Serializable;

/**
 *
 * @author DAW1-M
 */
public class Adopcion implements Serializable {

    private Fecha fechaSolicitud;
    private String nombreAdoptante;
    private Animal adoptado;

    public Adopcion(Fecha fechaSolicitud, String nombreAdoptante, Animal adoptado) {
        this.fechaSolicitud = fechaSolicitud;
        this.nombreAdoptante = nombreAdoptante;
        this.adoptado = adoptado;
    }

    public Animal getAdoptado() {
        return adoptado;
    }

    @Override
    public String toString() {
        String text;
        text = String.format("%-8s %12s %16s", fechaSolicitud, nombreAdoptante, adoptado.getNombre() + "(ID: "+ adoptado.getId() + ")");
        return text;
    }

}
