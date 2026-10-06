package com.techlab.product;

import com.techlab.product.model.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Category> categories = new ArrayList<>();
        loadCategories(categories);

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

    public static void loadCategories(ArrayList<Category> categories) {
        categories.add(new Category("Alimentos", "Productos y bebidas para el consumo diario"));
        categories.add(new Category("Deportes", "Artículos y accesorios para actividades deportivas y recreativas"));
        categories.add(new Category("Mascotas", "Productos alimenticios para el cuidado de mascotas"));
        categories.add(new Category("Herramientas", "Herramientas y accesorios para trabajos de reparación y mantenimiento"));
    }

    public static void listCategories(ArrayList<Category> categories) {
        System.out.println("\n--- CATEGORÍAS DISPONIBLES ---");

        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public static Category selectExistingCategory(Scanner scanner, ArrayList<Category> categories) {
        while (true) {
            int idCategory = readInteger(scanner, "Ingrese el ID de la categoría: ");

            Category category = searchCategoryById(categories, idCategory);

            if (category != null) {
                return category;
            }

            System.out.println("Error: la categoría no existe.");
        }
    }

    public static Category searchCategoryById(ArrayList<Category> categories, int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
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

    public static int readIntegerNonNegative(Scanner scanner, String message) {
        while (true) {
            int value = readInteger(scanner, message);

            if (value < 0) {
                System.out.println("Error: el valor no puede ser negativo.");
                continue;
            }

            return value;
        }
    }

    public static double readDoubleNonNegative(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine());

                if (value < 0) {
                    System.out.println("Error: el precio no puede ser negativo.");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número decimal válido.");
            }
        }
    }

    public static String readTextNonEmpty(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine();

            if (!text.trim().isEmpty()) {
                return text.trim();
            }

            System.out.println("Error: el texto no puede estar vacío.");
        }
    }
}

