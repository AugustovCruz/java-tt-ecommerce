package com.techlab.menu;

import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;
// import com.techlab.pedidos.PedidoService;
// import com.techlab.pedidos.StockInsuficienteException;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private ProductoService productoService = new ProductoService();
    // private PedidoService pedidoService = new PedidoService(productoService);

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar/Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Crear un pedido");
            System.out.println("6. Listar pedidos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Ingrese un número: ");
                scanner.next();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarActualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> crearPedido(); // aún no implementado
                case 6 -> listarPedidos(); // aún no implementado
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

            System.out.println();

        } while (opcion != 7);
    }

    private void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Ingrese un número válido para el precio: ");
            scanner.next();
        }
        double precio = scanner.nextDouble();

        System.out.print("Cantidad en stock: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido para el stock: ");
            scanner.next();
        }
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(nombre, precio, stock);
        productoService.agregarProducto(producto);
        System.out.println("✅ Producto agregado con éxito.");
    }

    private void listarProductos() {
        System.out.println("=== Lista de Productos ===");
        List<Producto> productos = productoService.obtenerTodos();
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("ID: " + i + " | " + productos.get(i));
        }
    }

    private void buscarActualizarProducto() {
        listarProductos();
        System.out.print("Ingrese el ID del producto que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Producto producto = productoService.buscarPorId(id);
        if (producto == null) {
            System.out.println("❌ Producto no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + producto.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nuevo precio (actual: " + producto.getPrecio() + "): ");
        double nuevoPrecio = scanner.nextDouble();

        System.out.print("Nuevo stock (actual: " + producto.getStock() + "): ");
        int nuevoStock = scanner.nextInt();
        scanner.nextLine();

        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setStock(nuevoStock);

        System.out.println("✅ Producto actualizado.");
    }

    private void eliminarProducto() {
        listarProductos();
        System.out.print("Ingrese el ID del producto que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = productoService.eliminarProducto(id);
        if (eliminado) {
            System.out.println("✅ Producto eliminado.");
        } else {
            System.out.println("❌ ID inválido.");
        }
    }

    // Métodos para pedidos

    private void crearPedido() {
        System.out.println("Funcionalidad de creación de pedidos aún no implementada.");
    }

    private void listarPedidos() {
        System.out.println("Funcionalidad de listado de pedidos aún no implementada.");
    }
}
