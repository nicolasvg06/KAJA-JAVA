package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/kaja";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {

        try {

            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa a la base de datos.");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error de conexión: " + e.getMessage());

            return null;

        }

    }

}
