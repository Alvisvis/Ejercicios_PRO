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
public class Profesor extends Persona implements Serializable{

    private String especialidad;
    private List<Modulo> modulosImpartidos;

    public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String especialidad) {
        super(dni, nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
        this.modulosImpartidos = new ArrayList<>();
    }

    public List<Modulo> getModulosImpartidos() {
        return modulosImpartidos;
    }
    public boolean imparteModulo(Modulo modulo) {
        boolean imparte = false;
        if (!getModulosImpartidos().contains(modulo)) {
            imparte = true;
        }
        return imparte;
    }

    public void asignarModulo(Modulo modulo) {
        if (!imparteModulo(modulo)) {
            modulosImpartidos.add(modulo);
            System.out.println("Se le ha asignado el modulo al profesor");
        } else {
            System.out.println("Este profesor ya imparte este modulo");
        }
    }

    public void eliminarModulo(Modulo modulo) {
        if (imparteModulo(modulo)) {
            modulosImpartidos.remove(modulo);
            System.out.println("Se ha eliminado el modulo al profesor");
        } else {
            System.out.println("Este profesor no imparte este modulo");
        }
    }

    @Override
    public String toString() {
        String text;
        text = String.format("%-15s %-10s", especialidad, modulosImpartidos);
        return text;
    }

}
