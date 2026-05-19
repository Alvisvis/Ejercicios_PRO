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

    static Protectora protectora = new Protectora();
    
    public static void main(String[] args) {
        
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
