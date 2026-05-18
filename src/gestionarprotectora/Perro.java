/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

/**
 *
 * @author DAW1-M
 */
public class Perro extends Animal {

    private String raza;
    private boolean entrenado;

    public Perro(int id, String nombre, int edad, Fecha fechaEntrada, String raza) {
        super(id, nombre, edad, fechaEntrada);
        this.raza = raza;
        this.entrenado = false;
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
    public String toString() {
        String text;
        text = super.fichaAnimal() 
                + "Raza: " + this.raza + "\t" + "Entrenado? " + (this.entrenado ? "Si" : "No")
                + "\nTasa de adopcion: " + calcularTasaAdopcion();
        return text;
    }

    

    
}
