/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarciclos;

/**
 *
 * @author DAW1-M
 */
public class Calificaciones {
    private Modulo modulo;
    private int notaFinal;

    public Calificaciones(Modulo modulo) {
        this.modulo = modulo;
        this.notaFinal = 0;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Modulo getModulo() {
        return modulo;
    }
    
    
}
