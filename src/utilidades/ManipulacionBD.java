package utilidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ManipulacionBD {
    public static void CrearBDNoExistente () {
        String creacionBD = "create database if not exists iterum;";
        String usoBD = "use iterum;";
        String tablasBD = 
        "create table if not exists partidas (" + 
        "ID int auto_increment primary key," +
        "NombrePersonaje varchar(100)," +
        "DineroPersonaje int default 15," + 
        "RazaPersonaje varchar(7)," + 
        "OcupacionPersonaje varchar (10)," +
        "EstadisticasPersonaje varchar(12)," +
        "EquipamientoPersonaje varchar(100)," +
        "HistoriaPersonaje varchar(12)," + 
        "FECHA_INICIO_PARTIDA date not null," +
        "FechaFinalPartida date," +
        "MinutosPartida int);";
        try {
            Connection baseDatos = ConexionBD.Conexion();

            Statement sentencia = baseDatos.createStatement();
            sentencia.execute(creacionBD);

            sentencia.execute(usoBD);
            sentencia.execute(tablasBD);
        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
