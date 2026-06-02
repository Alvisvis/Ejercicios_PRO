/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package peliculas_pro;

;

import java.util.Comparator;

/**
 *
 * @author DAW1-M
 */
public class Peliculas_PRO {

    //---------------------------------------------------------------
    public static void main(String[] args) {
        Cine miCine = new Cine("Alvis");
        miCine = miCine.cargarBinario();

        int opcion = menu();
        while (opcion != 0) {
            switch (opcion) {
                case 1 ->
                    miCine.verPeliculas();
                case 2 -> {
                    String nombreFichero = ES.leerCadena("¿Cual es el nombre del fichero? ");
                    miCine.cargarFichero(nombreFichero);
                }
                case 3 -> {
                    String titulo = ES.leerCadena("Cual es el titulo de la pelicula?");
                    miCine.eliminarPelicula(miCine.buscarPelicula(titulo));
                }
                case 4 -> {
                    String titulo = ES.leerCadena("Cual es el titulo de la pelicula que quieres modificar? ");
                    miCine.modificarPelicula(miCine.buscarPelicula(titulo));
                }
                case 5 -> {
                    int criterio = ES.leerEntero("""
                                                 \u00bfDe que forma quieres ordenar las peliculas?
                                                 1. Por Fechas
                                                 2. Por Titulos
                                                 3. Por Paises
                                                 4. Por G\u00e9nero
                                                 Introduce una de estas opciones: """);
                    switch (criterio) {
                        case 1 -> {
//                            miCine.ordenarLista(Comparator.comparing(Pelicula::getFecha));
                        }
                        case 2 -> {
                            miCine.ordenarLista(Comparator.comparing(Pelicula::getTitulo));
                        }
                        case 3 -> {
                            miCine.ordenarLista(Comparator.comparing(Pelicula::getPais)
                                    .thenComparing(Pelicula::getTitulo));
                        }
                        case 4 -> {
                            miCine.ordenarLista(Comparator.comparing(Pelicula::getGenero)
                                    .thenComparing(Pelicula::getTitulo));
                        }
                    }
                }
            }
            ES.leerCadena("\nPulse INTRO para continuar.");
            opcion = menu();
        }
        miCine.guardaBinario();
        System.out.println("Fin de la ejecución de la aplicación.");
    }

    //---------------------------------------------------------------
    /**
     * Método que muestra el menú de la aplicación
     *
     * @return la opción elegida por el usuario
     */
    public static int menu() {
        int opcion;
        System.out.println("Gestión de reservas de habitaciones y apartamentos");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Ver peliculas.");
        System.out.println("2. Cargar peliculas desde fichero.");
        System.out.println("3. Dar de baja una pelicula.");
        System.out.println("4. Modificar datos de una pelicula.");
        System.out.println("5. Ordenar peliculas.");
        System.out.println("0. Salir");
        opcion = ES.leerEntero("\n¿Opción?: ");
        return opcion;
    }

    //---------------------------------------------------------------
    /**
     * Método que muestra el menú de ordenación
     *
     * @return la opción elegida por el usuario
     */
    public static int menuOrdenar() {
        int opcion;
        System.out.println("Ordenar peliculas:");
        System.out.println("\t1. Por fechas.");
        System.out.println("\t2. Por titulos.");
        System.out.println("\t3. Por paises.");
        System.out.println("\t4. Por genero.");
        opcion = ES.leerEntero("\n¿Opción?: ");
        return opcion;
    }

}
