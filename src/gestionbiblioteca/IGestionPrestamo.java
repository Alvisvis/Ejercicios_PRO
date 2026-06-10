/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionbiblioteca;

/**
 *
 * @author 2DAM
 */
public interface IGestionPrestamo {

    boolean insertarPrestamo(Prestamo p);

    boolean devolverPrestamo(Prestamo p);

    void ordenarPrestamo();

    Prestamo buscarPrestamo(String codigoMaterial);

}
