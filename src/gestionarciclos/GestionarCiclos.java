/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionarciclos;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author DAW1-M
 */
public class GestionarCiclos {

    private static List<Alumno> listaAlumnos = new ArrayList<>();
    private static List<Profesor> listaProfesores = new ArrayList<>();
    private static List<Modulo> listaModulos = new ArrayList<>();

    private static final Modulo m1 = new Modulo("Programacion", 500);
    private static final Modulo m2 = new Modulo("IPEII", 500);

    private static final Alumno a1 = new Alumno("12345678z", "Fulanito", "Menganito", LocalDate.now(), "DAM");
    private static final Alumno a2 = new Alumno("87654321x", "Juanito", "Alimaña", LocalDate.now(), "DAM");
    private static final Alumno a3 = new Alumno("14253678g", "Pepa", "La Cerdita", LocalDate.now(), "DAW");

    private static final Profesor p1 = new Profesor("12345678z", "Francisco", "Miranda", LocalDate.now(), "DAM");
    private static final Profesor p2 = new Profesor("87654321x", "Martin", "Rodriguez", LocalDate.now(), "DAM");
    private static final Profesor p3 = new Profesor("14253678g", "Paco", "Paquito", LocalDate.now(), "DAW");

    public static void main(String[] args) {
        // TODO code application logic here
        GestionarCiclos ciclo = new GestionarCiclos();
        int op;
        listaAlumnos.add(a1);
        listaAlumnos.add(a2);
        listaAlumnos.add(a3);

        listaProfesores.add(p1);
        listaProfesores.add(p2);
        listaProfesores.add(p3);

        listaModulos.add(m1);
        listaModulos.add(m2);

        a1.matricular(m1);
        a2.matricular(m1);
        a3.matricular(m2);

        p1.asignarModulo(m1);
        p2.asignarModulo(m2);
        do {
            menuPrincipal();
            op = Entrada.entero("Selecciona una opcion: ");
            switch (op) {
                case 1:
                    ciclo.darAltaAlumno();
                    break;
                case 2:
                    ciclo.darAltaProfesor();
                    break;
                case 3:

                    break;
                case 4:
                    ciclo.asignarNota();
                    break;
                case 5:
                    ciclo.mostrarExpedienteAlumno();
                    break;
                case 6:
                    Profesor profe = null;
                    String dni = Entrada.cadena("Cual es el dni del profesor quieres saber sus alumnos? ");
                    for (Profesor lista : listaProfesores) {
                        if (lista.getDni().equals(dni)) {
                            profe = lista;
                            break;
                        }
                    }
                    ciclo.mostrarListadoAlumnoProfesor(profe);
                    break;

                case 7:

                    break;
            }
        } while (op
                != 0);
    }

    public static void menuPrincipal() {
        System.out.println("---------------- Gestionar ciclos ----------------");
        System.out.println("1. Insertar alumno");
        System.out.println("2. Insertar profesor");
        System.out.println("3. Cargar fichero de texto con los alumnos y profesores");
        System.out.println("4- Asignar nota");
        System.out.println("5. MOstrar expediente alumno (ordenado por módulos");
        System.out.println("6. Mostrar listado alumnado de un profesor (ordenado por apellidos del alumnado");
        System.out.println("7. Exportar expediente alumno a fichero de texto");
        System.out.println("0. Salir");
    }

    public void darAltaAlumno() {
        Alumno a;
        String dni = Entrada.cadena("Introduce el dni del alumno: ");
        String nombre = Entrada.cadena("Introduce el nombre del alumno: ");
        String apellidos = Entrada.cadena("Introduce los apellidos del alumno: ");
        LocalDate fecha = LocalDate.parse(Entrada.cadena("Introduce la fecha de entrada del alumno: "));
        String ciclo = Entrada.cadena("Introduce el ciclo del alumno: ");
        a = new Alumno(dni, nombre, apellidos, fecha, ciclo);

        if (listaAlumnos.add(a)) {
            System.out.println("Alumno agregado exitosamente");
        } else {
            System.out.println("No se ha agregado al alumnado");
        }

    }

    public void darAltaProfesor() {
        Profesor p;
        String dni = Entrada.cadena("Introduce el dni del alumno: ");
        String nombre = Entrada.cadena("Introduce el nombre del alumno: ");
        String apellidos = Entrada.cadena("Introduce los apellidos del alumno: ");
        LocalDate fecha = LocalDate.parse(Entrada.cadena("Introduce la fecha de entrada del alumno: "));
        String especialidad = Entrada.cadena("Introduce el ciclo del alumno: ");
        p = new Profesor(dni, nombre, apellidos, fecha, especialidad);

        if (listaProfesores.add(p)) {
            System.out.println("El profesor agregado exitosamente");
        } else {
            System.out.println("No se ha agregado al profesor");
        }

    }

    public void mostrarExpedienteAlumno() {
        listaAlumnos.sort((o1, o2) -> o1.getCiclo().compareTo(o2.getCiclo()));
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno.toString());
        }
    }

    public void mostrarListadoAlumnoProfesor(Profesor profe) {

        List<Alumno> alumnosProfesor = new ArrayList<>();

        for (Alumno alumno : listaAlumnos) {

            for (Calificacion c : alumno.getCalificaciones()) {

                if (profe.imparteModulo(c.getModulo())) {
                    alumnosProfesor.add(alumno);
                }
            }
        }
        listaAlumnos.sort((o1, o2) -> o1.getApellidos().compareTo(o2.getApellidos()));
        for (Alumno alumno : alumnosProfesor) {
            System.out.println(alumno.toString());
        }

    }

    public void asignarNota() {
        String dniAlu = Entrada.cadena("Cual es el dni del alumno? ");
        for (Alumno listaAlumno : listaAlumnos) {
            if (listaAlumno.getDni().equals(dniAlu)) {
                String nomModulo = Entrada.cadena("Cual es el modulo al que le dara nota? ");
                for (Modulo listaModulo : listaModulos) {
                    if (listaModulo.getNombre().equals(nomModulo)) {
                        int nota = Entrada.entero("Cual es la nota que tendra el alumno? ");
                        listaAlumno.calificar(listaModulo, nota);
                    }
                }
            }
        }
    }

}
//    public void guardarFichero(String _nombreFichero){
//        try (ObjectInputStream obs = new ObjectInputStream(new FileInputStream(_nombreFichero))){
//            Profesor p = new Profesor(_nombreFichero, _nombreFichero, _nombreFichero, LocalDate.MIN, _nombreFichero)
//            listaProfesores = obs.read();
//        } catch (Exception e) {
//        }
//    }

