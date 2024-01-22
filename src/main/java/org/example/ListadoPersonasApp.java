package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        var salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                salir = operacion(consola, personas);
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error" + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                **** Listado Personas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Qué opción deseas?");
    }

    private static boolean operacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> { // Agregar persona
                System.out.print("Proporcioname el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporcioname el teléfono: ");
                var tel = consola.nextLine();
                System.out.print("Proporcionmame el email: ");
                var email = consola.nextLine();
                var persona = new Persona(nombre, tel, email);
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }
            case 2 -> { // Listar personas
                System.out.println("Listado de personas: ");
                // Uso de función lambda y método de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 -> { // Salir del ciclo
                System.out.println("Hasta pronto");
                salir = true;
            }
            default -> System.out.println("Opción errónea " + opcion);
        }
        return salir;
    }

}