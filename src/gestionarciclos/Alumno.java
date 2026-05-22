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
    private List<Calificacion> calificaciones;

    public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String ciclo) {
        super(dni, nombre, apellidos, fechaNacimiento);
        this.ciclo = ciclo;
        this.calificaciones = new ArrayList<>();
    }

//    public void matricular(Modulo modulo) {
//        for (Calificaciones calificacion : calificaciones) {
//            if (calificacion.getModulo().getNombre().equals(modulo.getNombre())) {
//                System.out.println("Este alumno ya esta matriculado en este modulo");
//                return;
//            }
//            calificacion = new Calificaciones(modulo);
//            calificaciones.add(calificacion);
//            System.out.println("Alumnno matriculado con exito");
//
//        }
//    }
    public void matricular(Modulo modulo) {
        if (!estaMatriculado(modulo)) {
            Calificacion calificacion = new Calificacion(modulo);
            calificaciones.add(calificacion);
            System.out.println("Alumnno matriculado con exito");

        }
    }

    private boolean estaMatriculado(Modulo modulo) {
        boolean esta = false;
        for (Calificacion calificacion : calificaciones) {
            if (calificacion.getModulo().getNombre().equals(modulo.getNombre())) {
                esta = true;
                break;
            }
        }
        return esta;
    }

    public void calificar(Modulo modulo, int nota) {
        if (!estaMatriculado(modulo)) {
            Calificacion cali = new Calificacion(modulo);
            cali.setNotaFinal(nota);
        }
    }

    public boolean promociones() {
        int horasAprobadas = 0, horasTotal = 0;
        boolean promociona = false;

        for (Calificacion calificacion : calificaciones) {
            int horas = calificacion.getModulo().getHoras();
            horasTotal += horas;

            if (calificacion.getNotaFinal() >= 5) {
                horasAprobadas += horas;
            }
        }
        if (horasAprobadas >= horasAprobadas * 0.5) {
            System.out.println("El alumno si promociona");
        }
        return promociona;
    }

    public double getNotaMedia() {
        double media = 0.0;
        for (Calificacion calificacione : calificaciones) {
            media = calificacione.getNotaFinal() / 2;
        }
        return media;
    }

    @Override
    public String toString() {
        String text = super.toString();
        text += String.format(" %-15s, -5-4d ", ciclo, calificaciones);
        return text;
    }

}
