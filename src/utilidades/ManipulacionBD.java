package utilidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import clases.Partida;

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
        "EstadisticasPersonaje varchar(20)," +
        "EquipamientoPersonaje varchar(100)," +
        "HistoriaPersonaje varchar(20)," + 
        "FECHA_INICIO_PARTIDA datetime not null," +
        "FechaFinalPartida datetime," +
        "DuracionPartida varchar(10)" + 
        ");";
        try {
            Connection baseDatos = ConexionBD.Conexion();

            Statement sentencia = baseDatos.createStatement();
            sentencia.execute(creacionBD);

            sentencia.execute(usoBD);
            sentencia.execute(tablasBD);

            sentencia.close();
            baseDatos.close();
        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void PrimerGuardarDatos (Partida partida) {
        String fechaInicioFormateada = partida.getFECHA_INICIO_PARTIDA().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String usoBaseDatos = "use iterum;";
        String sentenciaGuardado = "insert into partidas values (default,null,null,null,null,null,null,null,'"+
        fechaInicioFormateada + 
        "',null,null)";
        try {
            Connection baseDatos = ConexionBD.Conexion();

            Statement sentencia = baseDatos.createStatement();
            sentencia.execute(usoBaseDatos);
            sentencia.execute(sentenciaGuardado);

            sentencia.close();
            baseDatos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void GuardarDatos (Partida partida) {
        //--- Parte Fecha inicio ---//
        String fechaInicioFormateada = "'" +
        partida.getFECHA_INICIO_PARTIDA().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        + "'";
        //--- Parte Estadisticas ---//
        String estadisticasFormateadas = "";
        for (int estadistica : partida.getPersonajePrincipalPartida().getEstadisticas()) {
            estadisticasFormateadas += String.valueOf(estadistica) + "-";
        }//Mete las estadisticas en un String
        if (estadisticasFormateadas.endsWith("-")) {
            estadisticasFormateadas = 
            estadisticasFormateadas.substring(0, estadisticasFormateadas.length() - 1);
        }//Si terminan con un guion lo quita, para que quede mejor en mysql

        //--- Parte Equipamiento ---//
        String equipamientoFormateadas = "";
        for (String equipamiento : partida.getPersonajePrincipalPartida().getEquipamiento()) {
            equipamientoFormateadas += equipamiento + "-";
        }//Mete los equipamientos en un String
        if (equipamientoFormateadas.endsWith("-")) {
            equipamientoFormateadas = 
            equipamientoFormateadas.substring(0, equipamientoFormateadas.length() - 1);
        }//Si terminan con un guion lo quita, para que quede mejor en mysql

        //--- Parte Historia ---//
        String historiasFormateadas = "";
        for (int historias : partida.getPersonajePrincipalPartida().getHistoria()) {
            historiasFormateadas += String.valueOf(historias) + "-";
        }//Mete los valores de cada parte de la historia en un String
        if (historiasFormateadas.endsWith("-")) {
            historiasFormateadas = 
            historiasFormateadas.substring(0, historiasFormateadas.length() - 1);
        }//Si terminan con un guion lo quita, para que quede mejor en mysql

        String duracionPartidaFormateada = String.format("%02d:%02d:%02d", 
        partida.getDuracionPartida().toHours(), (partida.getDuracionPartida().toMinutes()%60), (partida.getDuracionPartida().getSeconds()%60));

        String usoBaseDatos = "use iterum;";

        // --- Sentencias SQL --- //
        String sentenciaGuardado1 = "UPDATE partidas SET NombrePersonaje = '" 
        + partida.getPersonajePrincipalPartida().getNombre() +
            "' WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        String sentenciaGuardado2 = "UPDATE partidas SET DineroPersonaje = " 
        + partida.getDineroTotalPartida() +
            " WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        String sentenciaGuardado3 = "UPDATE partidas SET RazaPersonaje = '" 
        + partida.getPersonajePrincipalPartida().getRaza().toString() +
            "' WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        String sentenciaGuardado4 = "UPDATE partidas SET OcupacionPersonaje = '" 
        + partida.getPersonajePrincipalPartida().getOcupacion().toString() +
            "' WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        String sentenciaGuardado5 = "UPDATE partidas SET EstadisticasPersonaje = '" + estadisticasFormateadas +
            "' WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        String sentenciaGuardado6 = "UPDATE partidas SET EquipamientoPersonaje = '" + equipamientoFormateadas +
            "' WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        String sentenciaGuardado7 = "UPDATE partidas SET HistoriaPersonaje = '" + historiasFormateadas +
            "' WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        String sentenciaGuardado8 = "UPDATE partidas SET DuracionPartida = '" + duracionPartidaFormateada +
            "' WHERE FECHA_INICIO_PARTIDA = " + fechaInicioFormateada + ";";

        try {
            Connection baseDatos = ConexionBD.Conexion();
            Statement sentencia = baseDatos.createStatement();

            // Ejecutar las sentencias por separado
            sentencia.execute(usoBaseDatos);
            sentencia.execute(sentenciaGuardado1);
            sentencia.execute(sentenciaGuardado2);
            sentencia.execute(sentenciaGuardado3);
            sentencia.execute(sentenciaGuardado4);
            sentencia.execute(sentenciaGuardado5);
            sentencia.execute(sentenciaGuardado6);
            sentencia.execute(sentenciaGuardado7);
            sentencia.execute(sentenciaGuardado8);

            sentencia.close();
            baseDatos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
