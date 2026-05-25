/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarciclos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author DAW1-M
 */
public class Modulo implements Serializable {

    private String nombre;
    private int horas;

    public Modulo(String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public String toString() {
        return "Modulo{" + "nombre=" + nombre + ", horas=" + horas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modulo other = (Modulo) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

}
