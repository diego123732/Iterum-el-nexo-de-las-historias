package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static Connection Conexion () throws SQLException{
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String contraseña = "Password1234";

        return DriverManager.getConnection(url, usuario, contraseña);
    }
}
