/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peliculas_pro;

import java.io.Serializable;

/**
 *
 * @author DAW1-M
 */
public class Pelicula implements Serializable{

    private String titulo;
    private String genero;
    private String pais;
    private Fecha fecha;
    private int duracion;

    public Pelicula(Fecha fecha, String genero, String titulo, String pais, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.pais = pais;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        String text;
        text = String.format("[%-14s] (%-11s) \"%-12s\" %-8s %-5dm.", fecha, genero, titulo, pais, duracion);
        return text;
    }

}
