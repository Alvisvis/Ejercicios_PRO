/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
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

    public static long diasEntreFechas(Fecha f1, Fecha f2) {

        GregorianCalendar fecha1 = new GregorianCalendar(
                f1.getAnho(),
                f1.getMes() - 1,
                f1.getDia());

        GregorianCalendar fecha2 = new GregorianCalendar(
                f2.getAnho(),
                f2.getMes() - 1,
                f2.getDia());

        long milisegundos = Math.abs(fecha2.getTimeInMillis() - fecha1.getTimeInMillis());

        return milisegundos / (1000 * 60 * 60 * 24);
    }

}
