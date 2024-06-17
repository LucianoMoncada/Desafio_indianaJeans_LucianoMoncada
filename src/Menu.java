import cl.praxis.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private final ProductoServicio productoServicio;
    private final Exportador exportadorTxt;

    public Menu() {
        productoServicio = new ProductoServicio();
        exportadorTxt = new ExportadorTxt();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1 Listar Producto");
            System.out.println("2 Agregar Producto");
            System.out.println("3 Exportar Datos");
            System.out.println("4 Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    Utilidad.limpiarPantalla();
                    productoServicio.listarProductos();
                    Utilidad.esperar(2);
                    break;
                case 2:
                    Utilidad.limpiarPantalla();
                    agregarProducto(scanner);
                    break;
                case 3:
                    Utilidad.limpiarPantalla();
                    exportarDatos();
                    Utilidad.esperar(2);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private void agregarProducto(Scanner scanner) {
        System.out.println("Crear Producto");
        System.out.print("Ingresar nombre articulo: ");
        String articulo = scanner.nextLine();
        System.out.print("Ingresa precio: ");
        String precio = scanner.nextLine();
        System.out.print("Ingresa descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingresa código: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingresa talla: ");
        String talla = scanner.nextLine();
        System.out.print("Ingresa marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingresa color: ");
        String color = scanner.nextLine();

        Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
        productoServicio.agregarProducto(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    private void exportarDatos() {
        try {
            exportadorTxt.exportar(productoServicio.getListaProductos(), "productos.txt");
            System.out.println("Datos exportados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}



