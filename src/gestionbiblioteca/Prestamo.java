/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 2DAM
 */
public class Prestamo implements Serializable{

    //Atributos
    private String codigoMaterial;
    private String nombreUsuario;
    private Fecha fechaPrestamo;
    private Fecha fechaDevolucion;

    public Prestamo(String codigoMaterial, String nombreUsuario, Fecha fechaPrestamo, Fecha fechaDevolucion) {
        this.codigoMaterial = codigoMaterial;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean estaActivo() {
        boolean activo = true;
        if (this.fechaDevolucion != null) {
            activo = false;
        }
        return activo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Fecha getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Fecha fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Fecha fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigoMaterial);
        hash = 97 * hash + Objects.hashCode(this.fechaPrestamo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestamo other = (Prestamo) obj;
        if (!Objects.equals(this.codigoMaterial, other.codigoMaterial)) {
            return false;
        }
        return Objects.equals(this.fechaPrestamo, other.fechaPrestamo);
    }

    @Override
    public String toString() {
        return "Prestamo{" + "codigoMaterial=" + codigoMaterial + ", nombreUsuario=" + nombreUsuario + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + '}';
    }

}
