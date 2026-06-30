package principal;

import java.util.Scanner;

import dao.ProductoDAO;
import modelo.Producto;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ProductoDAO dao = new ProductoDAO();

        int opcion;

        do {

            System.out.println("\n====================================");
            System.out.println("          SISTEMA KAJA");
            System.out.println("====================================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    teclado.nextLine(); // Limpiar el buffer

                    Producto producto = new Producto();

                    System.out.print("Nombre del producto: ");
                    producto.setNombre(teclado.nextLine());

                    System.out.print("Categoría: ");
                    producto.setCategoria(teclado.nextLine());

                    System.out.print("Precio: ");
                    producto.setPrecio(teclado.nextDouble());

                    System.out.print("Stock: ");
                    producto.setStock(teclado.nextInt());

                    dao.insertarProducto(producto);

                    break;

                case 2:

                    dao.listarProductos();

                    break;

                case 3:
                    System.out.println("Buscar producto");
                    break;

                case 4:

                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    int idActualizar = teclado.nextInt();
                    teclado.nextLine();

                    Producto productoActualizar = dao.buscarProductoPorId(idActualizar);

                    if (productoActualizar != null) {

                        System.out.println("\nProducto encontrado.");

                        System.out.println("Nombre actual: " + productoActualizar.getNombre());
                        System.out.print("Nuevo nombre: ");
                        productoActualizar.setNombre(teclado.nextLine());

                        System.out.println("Categoría actual: " + productoActualizar.getCategoria());
                        System.out.print("Nueva categoría: ");
                        productoActualizar.setCategoria(teclado.nextLine());

                        System.out.println("Precio actual: " + productoActualizar.getPrecio());
                        System.out.print("Nuevo precio: ");
                        productoActualizar.setPrecio(teclado.nextDouble());

                        System.out.println("Stock actual: " + productoActualizar.getStock());
                        System.out.print("Nuevo stock: ");
                        productoActualizar.setStock(teclado.nextInt());

                        dao.actualizarProducto(productoActualizar);

                    } else {

                        System.out.println("No existe un producto con ese ID.");

                    }

                    break;

                case 5:

                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idEliminar = teclado.nextInt();
                    teclado.nextLine();

                    Producto productoEliminar = dao.buscarProductoPorId(idEliminar);

                    if (productoEliminar != null) {

                        System.out.println("\nProducto encontrado:");
                        System.out.println("Nombre: " + productoEliminar.getNombre());

                        System.out.print("¿Está seguro de eliminar este producto? (S/N): ");
                        String respuesta = teclado.nextLine();

                        if (respuesta.equalsIgnoreCase("S")) {

                            dao.eliminarProducto(idEliminar);

                        } else {

                            System.out.println("Operación cancelada.");

                        }

                    } else {

                        System.out.println("No existe un producto con ese ID.");

                    }

                    break;

                case 6:
                    System.out.println("Gracias por utilizar KAJA.");
                    break;

                default:
                    System.out.println("Opción no válida.");

            }

        } while (opcion != 6);

        teclado.close();

    }

}