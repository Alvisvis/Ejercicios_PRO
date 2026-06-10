/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import java.io.Serializable;

/**
 *
 * @author 2DAM
 */
public class Revista extends Material implements Serializable {

    //Atributo
    private int numero;
    private String mesPublicacion;

    public Revista(String codigo, String titulo, int anioPublicacion, int numero, String mesPublicacion) {
        super(codigo, titulo, anioPublicacion);
        this.numero = numero;
        this.mesPublicacion = mesPublicacion;
    }

    @Override
    double calcularMulta(int diasRetraso) {
        double multa = diasRetraso * 0.20;
        return multa;
    }

    @Override
    public String toString() {
        String text;
        text = super.toString() + String.format("%-5s %-5s", numero, mesPublicacion);
        return text;
    }
    
}
