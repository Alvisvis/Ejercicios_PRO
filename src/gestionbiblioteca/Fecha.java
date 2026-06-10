/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author dam14
 */
public class Fecha implements Serializable {

    private int dia;
    private int mes;
    private int anho;
    Calendar calendario = new GregorianCalendar();

    public Fecha(int dia, int mes, int anyo) {

        if (this.esFechaCorrecta(dia, mes, anyo)) {
            this.dia = dia;
            this.mes = mes;
            this.anho = anyo;
        } else {
            this.dia = calendario.get(GregorianCalendar.DATE);
            this.mes = calendario.get(GregorianCalendar.MONTH);
            this.anho = calendario.get(GregorianCalendar.YEAR);
        }
    }

    private boolean esBisiesto(int anyo) {
        boolean vRetorno = false;
        //if ((anho % 4 == 0) && ((anho %100 != 0) || (anho % 400 == 0)))
        if ((anyo % 4 == 0) && ((anyo % 100 == 0) || (anyo % 400 == 0))) {
            vRetorno = true;
        }
        return vRetorno;
    }

    private boolean esFechaCorrecta(int dia, int mes, int anyo) {
        boolean correcto = true;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia < 0 || dia > 31) {
                    correcto = false;
                }
                break;
            case 2:
                if (this.esBisiesto(anyo)) {
                    if (dia < 0 || dia > 29) {
                        correcto = false;
                    } else if (dia < 0 || dia > 28) {
                        correcto = false;
                    }
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia < 0 || dia > 30) {
                    correcto = false;
                }
                break;
        }
        return correcto;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, anho);
    }

    public static Fecha stringToFecha(String s) {
        
        String[] delimitador = s.split("/");

        int dia = Integer.parseInt(delimitador[0]);
        int mes = Integer.parseInt(delimitador[1]);
        int anyo = Integer.parseInt(delimitador[2]);

        Fecha fechaNueva = new Fecha(dia, mes, anyo);
        return fechaNueva;
    }

}
