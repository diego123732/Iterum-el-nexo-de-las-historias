package utilidades;

import java.nio.channels.Pipe.SourceChannel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ManipulacionBD {
    public static void CrearBDNoExistente () {
        String sentenciaContenido = "create database if not exists iterum";
        try {
            Connection baseDatos = ConexionBD.Conexion();

            Statement sentencia = baseDatos.createStatement();
            sentencia.execute(sentenciaContenido);
        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
