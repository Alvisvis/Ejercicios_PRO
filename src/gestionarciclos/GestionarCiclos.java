/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionarciclos;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DAW1-M
 */
public class GestionarCiclos {

    private List<Alumno> listaAlumnos;
    private List<Profesor> listaProfesores;
    private List<Modulo> listaModulos;

    public static void main(String[] args) {
        // TODO code application logic here
        GestionarCiclos ciclo = new GestionarCiclos();
        int op;

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

                    break;
                case 5:

                    break;
                case 6:

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
        String dni = Entrada.cadena("Introduce el dni del alumno");
        String nombre = Entrada.cadena("Introduce el nombre del alumno");
        String apellidos = Entrada.cadena("Introduce los apellidos del alumno");
        LocalDate fecha = LocalDate.parse(Entrada.cadena("Introduce la fecha de entrada del alumno"));
        String ciclo = Entrada.cadena("Introduce el ciclo del alumno");
        a = new Alumno(dni, nombre, apellidos, fecha, ciclo);

        if (listaAlumnos.add(a)) {
            System.out.println("Alumno agregado exitosamente");
        } else {
            System.out.println("No se ha agregado al alumnado");
        }

    }

    public void darAltaProfesor() {
        Profesor p;
        String dni = Entrada.cadena("Introduce el dni del alumno");
        String nombre = Entrada.cadena("Introduce el nombre del alumno");
        String apellidos = Entrada.cadena("Introduce los apellidos del alumno");
        LocalDate fecha = LocalDate.parse(Entrada.cadena("Introduce la fecha de entrada del alumno"));
        String especialidad = Entrada.cadena("Introduce el ciclo del alumno");
        p = new Profesor(dni, nombre, apellidos, fecha, especialidad);

        if (listaProfesores.add(p)) {
            System.out.println("El profesor agregado exitosamente");
        } else {
            System.out.println("No se ha agregado al profesor");
        }

    }

    public void mostrarExpedienteAlumno(String dni) {
        for (Alumno listaAlumno : listaAlumnos) {
            if (listaAlumno.getDni().equals(dni)) {
                System.out.println(listaAlumno.toString());
            }
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

//    public boolean getAlumno(String dni) {
//        boolean existe = false;
//        for (Alumno listaAlumno : listaAlumnos) {
//            if (listaAlumno.getDni().equals(listaAlumno)) {
//                existe = true;
//            }
//        }
//    }
}
//    public void guardarFichero(String _nombreFichero){
//        try (ObjectInputStream obs = new ObjectInputStream(new FileInputStream(_nombreFichero))){
//            Profesor p = new Profesor(_nombreFichero, _nombreFichero, _nombreFichero, LocalDate.MIN, _nombreFichero)
//            listaProfesores = obs.read();
//        } catch (Exception e) {
//        }
//    }

