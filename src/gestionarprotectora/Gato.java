/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarprotectora;

/**
 *
 * @author DAW1-M
 */
public class Gato extends Animal {

    private String Pelaje;
    private boolean esAgresivo;

    public Gato(int id, String nombre, int edad, Fecha fechaEntrada, String Pelaje) {
        super(id, nombre, edad, fechaEntrada);
        this.Pelaje = Pelaje;
        this.esAgresivo = false;
    }

    @Override
    double calcularTasaAdopcion() {
        return esAgresivo ? 50.0 + 15.0 : 50.0 + 30.0;
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau Miau");
    }

    @Override
    public void jugar() {
        System.out.println("Juega con un raton");
    }

    @Override
    public String toString() {
        String text;
        text = super.fichaAnimal() 
                + "Pelaje: " + this.Pelaje + "\t" + "Agresivo: " + (this.esAgresivo ? "Si" : "No")
                + "\nTasa de adopcion: " + calcularTasaAdopcion();
        return text;
    }
}
