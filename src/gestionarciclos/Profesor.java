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
public class Profesor extends Persona {

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

    public void asignarModulo(Modulo modulo) {
        String nombre = Entrada.cadena("Introduce el nombre del modulo: ");
        int hora = Entrada.entero("¿Cuantas horas son el modulo? ");
        
        
    }

    public void eliminarModulo(Modulo modulo) {

    }

    @Override
    public String toString() {
        return "Profesor{" + "especialidad=" + especialidad + ", modulosImpartidos=" + modulosImpartidos + '}';
    }
    
}
