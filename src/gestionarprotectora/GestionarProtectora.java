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

        if (prot != null) {
            prot = prot.leerBinario();
        }

        int op;
        do {
            menu();
            op = Entrada.entero("Que opcion elijas? ");
            switch (op) {
                case 1 -> {
                    prot.listarAnimales();
                    System.out.println("");
                }
                case 2 -> {

                }
                case 3 -> {
                    System.out.println("--- DAR DE ALTA NUEVO ANIMAL ---");
                    int animal = Entrada.entero("¿Es (1) Perro o (2) Gato?: ");
                    String nombre = Entrada.cadena("Nombre: ");
                    int edad = Entrada.entero("Edad: ");
                    Fecha fechaEntr = Fecha.stringToFecha(Entrada.cadena("Fecha entrada (dd/mm/aaaa): "));

                    if (animal == 2) {
                        String pelaje = Entrada.cadena("Pelaje: ");
                        boolean agresivo = Entrada.booleano("¿Es agresivo? (si/no): ");

                        Gato g = new Gato(nombre, edad, fechaEntr, pelaje, agresivo);
                        prot.anadirAnimal(g);
                    } else if (animal == 1) {
                        String raza = Entrada.cadena("Raza: ");
                        boolean entrenado = Entrada.booleano("¿Esta entrenado? (si/no): ");

                        Perro p = new Perro(nombre, edad, fechaEntr, raza, entrenado);
                        prot.anadirAnimal(p);
                    }

                }
                case 4 -> {
                    String _nombreArchivos = Entrada.cadena("Cual es el nombre del archivo? ");
                    prot.cargarAnimales(_nombreArchivos);
                }
                case 5 -> {
                    System.out.println("--- AÑADIR REVISION MEDICA ---");
                    int id = Entrada.entero("ID del animal a revisar: ");
                    if (prot.getAnimal(id) != null) {
                        Fecha fechaRevi = Fecha.stringToFecha(Entrada.cadena("Fecha de la revisión (dd/mm/aaaa): "));
                        String descrip = Entrada.cadena("Descripción de la revisión: ");
                        Revision revi = new Revision(fechaRevi, descrip);
                        prot.anadirRevisionMedica(revi, id);
                    } else {
                        System.out.println("Ese id no le pertenece a ningun animal");
                    }
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
