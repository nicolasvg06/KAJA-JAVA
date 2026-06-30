package dao;

import conexion.Conexion;
import modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    // INSERTAR PRODUCTO
    public void insertarProducto(Producto producto) {

        String sql = "INSERT INTO productos(nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";

        try {

            Connection conexion = Conexion.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());

            ps.executeUpdate();

            System.out.println("Producto registrado correctamente.");

            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al registrar el producto.");
            System.out.println(e.getMessage());

        }
    }

    // LISTAR PRODUCTOS
    public void listarProductos() {

        String sql = "SELECT * FROM productos";

        try {

            Connection conexion = Conexion.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n=========== LISTA DE PRODUCTOS ===========");

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Categoría: " + rs.getString("categoria"));
                System.out.println("Precio: $" + rs.getDouble("precio"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("-----------------------------------------");

            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al listar los productos.");
            System.out.println(e.getMessage());

        }
    }

    // BUSCAR PRODUCTO POR ID
    public Producto buscarProductoPorId(int id) {

        String sql = "SELECT * FROM productos WHERE id = ?";

        try {

            Connection conexion = Conexion.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Producto producto = new Producto();

                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

                rs.close();
                ps.close();
                conexion.close();

                return producto;
            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al buscar el producto.");
            System.out.println(e.getMessage());

        }

        return null;
    }
    // ACTUALIZAR PRODUCTO
public void actualizarProducto(Producto producto) {

    String sql = "UPDATE productos SET nombre=?, categoria=?, precio=?, stock=? WHERE id=?";

    try {

        Connection conexion = Conexion.conectar();

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getCategoria());
        ps.setDouble(3, producto.getPrecio());
        ps.setInt(4, producto.getStock());
        ps.setInt(5, producto.getId());

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("No se encontró el producto.");
        }

        ps.close();
        conexion.close();

    } catch (SQLException e) {

        System.out.println("Error al actualizar el producto.");
        System.out.println(e.getMessage());

    }

}
// ELIMINAR PRODUCTO
public void eliminarProducto(int id) {

    String sql = "DELETE FROM productos WHERE id = ?";

    try {

        Connection conexion = Conexion.conectar();

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            System.out.println("Producto eliminado correctamente.");

        } else {

            System.out.println("No existe un producto con ese ID.");

        }

        ps.close();
        conexion.close();

    } catch (SQLException e) {

        System.out.println("Error al eliminar el producto.");
        System.out.println(e.getMessage());

    }

}
}
