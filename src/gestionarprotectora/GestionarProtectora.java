/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionarprotectora;

/**
 *
 * @author DAW1-M
 */
public class GestionarProtectora {

    public static void main(String[] args) {
        Protectora prot = new Protectora();
        
        if (prot != null) prot = prot.leerBinario();
        

        int op;
        do {
            menu();
            op = Entrada.entero("Que opcion elijas? ");
            switch (op) {
                case 1 -> {
                    System.out.printf("%4d %8s %3d %6s %7f\n");
                    prot.listarAnimales();
                    System.out.println("");
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                    String _nombreArchivos = Entrada.cadena("Cual es el nombre del archivo? ");
                    prot.cargarAnimales(_nombreArchivos);
                }
                case 5 -> {
                }
                case 6 -> {
                }
                case 7 -> {
                }
                case 8 -> {
                }
            }

        } while (op != 0);
        prot.guardarBinario();
    }

    public static void menu() {
        System.out.println("========= GESTIÓN PROTECTORA MUNDO ANIMAL =========");
        System.out.println("1. Listar animales");
        System.out.println("2. Ver ficha detallada de un animal");
        System.out.println("3. Dar de alta nuevo animal");
        System.out.println("4. Cargar lote de animales desde un archivo");
        System.out.println("5. Añadir revisión medica a un animal");
        System.out.println("6. Tramitar adopcion");
        System.out.println("7. Exportar historial de un animal a texto");
        System.out.println("8. Historico de adopciones");
        System.out.println("0- Salir");
    }
}
