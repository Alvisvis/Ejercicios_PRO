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
public class Revision implements Serializable{
    private Fecha fecha;
    private String diagnostico;

    public Revision(Fecha fecha, String diagnostico) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        String text;
        text = "Historial Medico: \n" + String.format("Fecha: %12s ---> Daignostico: %15s", fecha, diagnostico);
        return text;
    }
    
    
}
