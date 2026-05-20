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
public class Perro extends Animal implements Serializable {

    private String raza;
    private boolean entrenado;

    public Perro(String nombre, int edad, Fecha fechaEntrada, String raza, boolean entrenado) {
        super(nombre, edad, fechaEntrada);
        this.raza = raza;
        this.entrenado = entrenado;
    }

    public Perro(int id, String nombre, int edad, Fecha fechaEntrada, String raza, boolean entrenado) {
        super(id, nombre, edad, fechaEntrada);
        this.raza = raza;
        this.entrenado = entrenado;
    }

    @Override
    double calcularTasaAdopcion() {
        return entrenado ? 50.0 + 40.0 : 50.0 + 60.0;
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau Guau");
    }

    @Override
    public void jugar() {
        System.out.println("Juega con un hueso");
    }

    @Override
    public String fichaAnimal() {
        String text;
        text = super.fichaAnimal()
                + String.format("Pelaje: %-12s Agresivo: %-5s\nTasa de adopción: %-1.1s€\n",
                        this.raza, (this.entrenado ? "Si" : "No"), calcularTasaAdopcion())
                + super.getHistorialMedico().toString();

        return text;
    }
}
