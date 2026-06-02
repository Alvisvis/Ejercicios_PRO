/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionarhotel;

/**
 *
 * @author DAW1-M
 */
public interface IGestionarReserva {

    public boolean insertar(Reserva nuevaReserva);

    public void ordenar();

    public boolean borrar(Fecha fechaInicio);

    public boolean disponible(Reserva nuevaReserva);
}
