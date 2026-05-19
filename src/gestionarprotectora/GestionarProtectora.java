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

    static Protectora prot = new Protectora();

    public static void main(String[] args) {
        prot.leerBinario();
        int op;
        do {
            menu();
            op = Entrada.entero("Que opcion elijas? ");
            switch (op) {
                case 1:
                    prot.listarAnimales();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    String _nombreArchivos = Entrada.cadena("Cual es el nombre del archivo? ");
                    prot.cargarAnimales(_nombreArchivos);
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
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
