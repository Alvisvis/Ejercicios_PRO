/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author DAW1-M
 */
public class Entrada {

    public static String inicializar(String _msg) {
        String buzon = "";
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.print(_msg);

        try {
            buzon = teclado.readLine();
        } catch (Exception e) {
            System.out.println("Entrada incorrecta");
        }
        return buzon;
    }

    public static int entero(String _msg) {
        int valor = Integer.parseInt(inicializar(_msg));
        return valor;
    }

    public static int entero() {
        int valor = Integer.parseInt(inicializar(""));
        return valor;
    }

    public static double real(String _msg) {
        double valor = Double.parseDouble(inicializar(_msg));
        return valor;
    }

    public static String cadena() {
        String valor = inicializar("");
        return valor;
    }

    public static String cadena(String _msg) {
        String valor = inicializar(_msg);
        return valor;
    }

    public static char caracter() {
        String valor = inicializar("");
        return valor.charAt(0);
    }

    public static boolean booleano(String _msg) {
        boolean respuesta = false;
        String valor = inicializar(_msg);
        try {
            if (valor.toUpperCase().equals("SI") || valor.toUpperCase().equals("S")) {
                respuesta = true;
            } else if (valor.toUpperCase().equals("NO") || valor.toUpperCase().equals("N")) {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println("El dato introducido no es correcto");
            System.out.println("Por favor, introduzca SI, NO, S, N, no, si, s o n");
        }
        return respuesta;
    }
}

