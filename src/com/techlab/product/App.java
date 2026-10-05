package com.techlab.product;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n======================================================");
            System.out.println(" SISTEMA DE GESTIÓN - TECHLAB");
            System.out.println("======================================================");
            System.out.println("1 - Agregar producto");
            System.out.println("2 - Listar productos");
            System.out.println("3 - Buscar producto");
            System.out.println("4 - Modificar producto");
            System.out.println("5 - Eliminar producto");
            System.out.println("6 - Listar categorías");
            System.out.println("0 - Salir");
            System.out.println("======================================================");

            option = readInteger(scanner, "Ingrese una opción: ");

            switch (option) {
                case 1:
                    System.out.println("Opción 1: Agregar producto.");
                    break;
                case 2:
                    System.out.println("Opción 2: Listar productos.");
                    break;
                case 3:
                    System.out.println("Opción 3: Buscar producto.");
                    break;
                case 4:
                    System.out.println("Opción 4: Modificar producto.");
                    break;
                case 5:
                    System.out.println("Opción 5: Eliminar producto.");
                    break;
                case 6:
                    System.out.println("Opción 6: Listar categorías.");
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nError: la opción ingresada no es válida.");
            }

        } while (option != 0);

        scanner.close();
    }

    public static int readInteger(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }
}
