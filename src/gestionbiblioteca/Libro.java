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
public class Libro extends Material implements Serializable {

    //Atributo
    private String autor;
    private int numeroPaginas;

    public Libro(String codigo, String titulo, int anioPublicacion, String autor, int numeroPaginas) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    double calcularMulta(int diasRetraso) {
        double multa = diasRetraso * 0.50;
        return multa;
    }

    @Override
    public String toString() {
        String text;
        text = super.toString() + String.format("%-5s %-5s", autor, numeroPaginas);
        return text;
    }
    
    

}
