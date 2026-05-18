/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author DAW1-M
 */
public abstract class Animal implements IInteractuable, Serializable {

    private int id;
    private String nombre;
    private int edad;
    private Fecha fechaEntrada;
    private ArrayList<Revision> historialMedico;

    public Animal(int id, String nombre, int edad, Fecha fechaEntrada) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaEntrada = fechaEntrada;
        this.historialMedico = new ArrayList<>();
    }

    abstract double calcularTasaAdopcion();

    @Override
    public abstract void emitirSonido();

    @Override
    public abstract void jugar();

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final Animal other = (Animal) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Revision> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(ArrayList<Revision> historialMedico) {
        this.historialMedico = historialMedico;
    }

    @Override
    public String toString() {
        String text;
        text = String.format("%5d %16s %5d %12d %7f", id, nombre, edad, fechaEntrada, calcularTasaAdopcion());
        return text;
    }

    public String fichaAnimal() {
        String text;
        text = String.format("%5d %10s %5d %12d\n", id, nombre, edad, fechaEntrada);
        return text;
    }
}
