package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Metodo que se encarga de crear la conexion con la base de datos
 */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "Password1234";
    /**
     * Metodo que devuelve la conexion con la base de datos
     * @return
     * @throws SQLException
     */
    public static Connection Conexion () throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
