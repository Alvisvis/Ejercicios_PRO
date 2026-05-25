/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarciclos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW1-M
 */
public class Alumno extends Persona implements Serializable {

    private String ciclo;
    private List<Calificacion> calificaciones;

    public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String ciclo) {
        super(dni, nombre, apellidos, fechaNacimiento);
        this.ciclo = ciclo;
        this.calificaciones = new ArrayList<>();
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void matricular(Modulo modulo) {
        if (!estaMatriculado(modulo)) {
            Calificacion calificacion = new Calificacion(modulo);
            calificaciones.add(calificacion);
            System.out.println("Alumnno matriculado con exito");

        }
    }

    public boolean estaMatriculado(Modulo modulo) {
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
        if (horasAprobadas >= horasTotal * 0.5) {
            System.out.println("El alumno si promociona");
        }
        return promociona;
    }

    public double getNotaMedia() {
        double suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.getNotaFinal();
        }
        double media = calificaciones.isEmpty() ? 0 : suma / calificaciones.size();
        return media;
    }

    @Override
    public String toString() {
        String text = super.toString();
        text += String.format(" %-15s", ciclo);
        return text;
    }

}
