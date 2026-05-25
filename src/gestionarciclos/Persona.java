/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarciclos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DAW1-M
 */
public  class Persona implements Serializable{

    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        String text;
        text = String.format("%-9s %-15s %-15s %-10s", dni, nombre, apellidos, fechaNacimiento);
        return text;
    }

}
