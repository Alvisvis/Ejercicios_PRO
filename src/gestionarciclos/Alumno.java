/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarciclos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW1-M
 */
public class Alumno extends Persona {

    private String ciclo;
    private List<Calificaciones> calificaciones;

    public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String ciclo) {
        super(dni, nombre, apellidos, fechaNacimiento);
        this.ciclo = ciclo;
        this.calificaciones = new ArrayList<>();
    }

    public void matricular(Modulo modulo) {

    }

//    public void calificar(Modulo modulo, int nota) {
//        
//    }
//    
//    public boolean promociones() {
//        if (true) {
//            
//        }
//    }
//    
//    public double getNotaMedia() {
//        double media = 0.0;
//        for (Calificaciones calificacione : calificaciones) {
//            calificacione.getNotaFinal();
//        }
//        return media;
//    }
    @Override
    public String toString() {
        String text;
        text = String.format("%-15s, -5-4d ", ciclo, calificaciones);
        return text;
    }

}
