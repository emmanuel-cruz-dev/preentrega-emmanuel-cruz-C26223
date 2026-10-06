package com.techlab.product;

import com.techlab.product.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
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
                    addProduct(scanner, products, categories);
                    break;
                case 2:
                    productsList(products);
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
        categories.add(new Category("Mascotas", "Productos alimenticios para el cuidado de mascotas"));
        categories.add(new Category("Deportes", "Artículos y accesorios para actividades deportivas y recreativas"));
        categories.add(new Category("Herramientas", "Herramientas y accesorios para trabajos de reparación y mantenimiento"));
    }

    public static void addProduct(
            Scanner scanner,
            ArrayList<Product> products,
            ArrayList<Category> categories
    ) {
        System.out.println("\n--- INGRESAR PRODUCTO ---");
        System.out.println("1 - Producto alimenticio");
        System.out.println("2 - Producto para mascotas");
        System.out.println("3 - Producto deportes");
        System.out.println("4 - Producto Herramientas");

        int type;
        do {
            type = readInteger(scanner, "Seleccione el tipo de producto: ");

            if (type != 1 && type != 2 && type != 3 && type != 4) {
                System.out.println("Error: debe elegir entre 1, 2, 3 o 4.");
            }

        } while (type != 1 && type != 2 && type != 3 && type != 4);

        String name = readTextNonEmpty(scanner, "Ingrese el nombre del producto: ");
        double price = readDoubleNonNegative(scanner, "Ingrese el precio del producto: ");

        listCategories(categories);
        Category category = selectExistingCategory(scanner, categories);

        Product product = switch (type) {
            case 1 -> {
                double weightKg = readDoubleNonNegative(scanner, "Ingrese el peso del producto: ");
                yield new ProductFood(name, price, category, weightKg);
            }
            case 2 -> {
                String flavor = readTextNonEmpty(scanner, "Ingrese el sabor: ");
                yield new ProductPet(name, price, category, flavor);
            }
            case 3 -> {
                String sport = readTextNonEmpty(scanner, "Ingrese el deporte: ");
                yield new ProductSport(name, price, category, sport);
            }
            case 4 -> {
                int warrantyMonths = readInteger(scanner, "Ingrese los meses de garantía: ");
                yield new ProductTool(name, price, category, warrantyMonths);
            }
            default -> throw new IllegalStateException("Tipo inválido: " + type);
        };

        products.add(product);

        System.out.println("Producto ingresado correctamente.");
        System.out.println("Resumen del objeto creado:");
        System.out.println(product);
    }

    public static void productsList(ArrayList<Product> products) {
        System.out.println("\n--- LISTADO DE PRODUCTOS ---");

        if (products.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
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

