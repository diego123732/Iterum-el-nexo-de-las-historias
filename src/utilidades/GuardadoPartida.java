package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import clases.Asesino;
import clases.Curandero;
import clases.Guerrero;
import clases.Mago;
import clases.Paladin;
import clases.Partida;
import clases.PersonajePrinc;
import clases.Razas;
import clases.Tanque;

public class GuardadoPartida {
    private static final String PATH_GUARDADO_DATOS = "src\\datosguardar\\DatosIterum.txt";

    public static int elegirPartida() throws IOException, InterruptedException {
        int numeroPartida = 0;
        if (!new File(PATH_GUARDADO_DATOS).exists()) {
            numeroPartida = 1;
            NuevaPartida(numeroPartida);
        } else if (PartidasGuardadas().isEmpty()) {
            numeroPartida = 1;
            NuevaPartida(numeroPartida);
        } else {
            if (LectorBuffRead.leer("¿Quieres continuar con una partida guardada?" +
                    "\nEscribe 's' o 'n' (Si o no)", "s", "n").equalsIgnoreCase("s")) {
                numeroPartida = LectorBuffRead.elegirPartida(PartidasGuardadas());
            } else {
                numeroPartida = PartidaLibre();
                NuevaPartida(numeroPartida);
                
            }
        }
        return numeroPartida;
    }

    public static void NuevaPartida(int numeroPartida) throws IOException, InterruptedException {

        try {
            // El lugar donde va a estar la nueva partida que se crea
            File nuevaPartida = new File(PATH_GUARDADO_DATOS);

            // Se crea el nuevo archivo y si se ha creado bien mete los datos iniciales
            if (nuevaPartida.createNewFile()) {
                try (BufferedWriter escribir = new BufferedWriter(new FileWriter(nuevaPartida))) {
                    escribir.write("Numero partida = " + numeroPartida);
                    escribir.newLine();
                    escribir.write("PersonajeNombre = nada");
                    escribir.newLine();
                    escribir.write("PersonajeRaza = nada");
                    escribir.newLine();
                    escribir.write("PersonajeClase = nada");
                    escribir.newLine();
                    escribir.write("PersonajeDinero = 15");
                    escribir.newLine();
                    escribir.write("PersonajeEstadisticas = 0-0-0-0-0-0");
                    escribir.newLine();
                    escribir.write("PersonajeEquipamiento = 0-0-0-0-0");
                    escribir.newLine();
                    escribir.write("PersonajeHistoria = 0-0-0-0-0-0");
                    escribir.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                List<String> datosGuardar = new ArrayList<>();
                List<String> auxiliarFormacion = leerArchivo();
                datosGuardar = DatosActualizados(numeroPartida, datosGuardar, auxiliarFormacion);

                escribirArchivo(datosGuardar);

            }
        } catch (IOException e) {
            System.out.println("Salio mal");
            e.printStackTrace();
        }
    }

    public static List<String> DatosActualizados(int numeroPartida, List<String> datosGuardar,
            List<String> auxiliarFormacion) {
        if (numeroPartida < PartidasGuardadas().getFirst()) {
            datosGuardar.add("Numero partida = " + numeroPartida);
            datosGuardar.add("PersonajeNombre = nada");
            datosGuardar.add("PersonajeRaza = nada");
            datosGuardar.add("PersonajeClase = nada");
            datosGuardar.add("PersonajeDinero = 15");
            datosGuardar.add("PersonajeEstadisticas = 0-0-0-0-0-0");
            datosGuardar.add("PersonajeEquipamiento = 0-0-0-0-0");
            datosGuardar.add("PersonajeHistoria = 0-0-0-0-0-0");
            datosGuardar.addAll(auxiliarFormacion);
            /**
             * Añade los datos correspondientes a la primera partida y luego
             * los que ya estaban dentro del archivo
             */
        } else {
            boolean partidaAñadida = false;
            int contador = 0;
            boolean numeroPartidaAnteriorEncontrado = false;
            int numeroPartidaAnterior = NumeroPartidaAnterior(numeroPartida);
            do {
                if (auxiliarFormacion.get(contador).startsWith("Numero partida = "
                        + numeroPartidaAnterior)) {
                    numeroPartidaAnteriorEncontrado = true;
                }
                if (auxiliarFormacion.get(contador).startsWith("PersonajeHistoria")
                        && numeroPartidaAnteriorEncontrado == true && !partidaAñadida) {
                    datosGuardar.add(auxiliarFormacion.get(contador));
                    datosGuardar.add("");
                    datosGuardar.add("-----------------------------------------");
                    datosGuardar.add("-----------------------------------------");
                    datosGuardar.add("");
                    datosGuardar.add("Numero partida = " + numeroPartida);
                    datosGuardar.add("PersonajeNombre = nada");
                    datosGuardar.add("PersonajeRaza = nada");
                    datosGuardar.add("PersonajeClase = nada");
                    datosGuardar.add("PersonajeDinero = 15");
                    datosGuardar.add("PersonajeEstadisticas = 0-0-0-0-0-0");
                    datosGuardar.add("PersonajeEquipamiento = 0-0-0-0-0");
                    datosGuardar.add("PersonajeHistoria = 0-0-0-0-0-0");
                    partidaAñadida = true;
                }
                else{
                    datosGuardar.add(auxiliarFormacion.get(contador));
                }
                
                contador++;
            } while (contador<auxiliarFormacion.size());
        }
        return datosGuardar;
    }

    public static List<Integer> PartidasGuardadas() {
        List<Integer> numeroPartidasGuardadas = new ArrayList<>();
        List<String> datosGuardados = new ArrayList<>();
        datosGuardados = leerArchivo();
        Iterator<String> iteradorDatos = datosGuardados.iterator();
        while (iteradorDatos.hasNext()) {
            String cadenaAuxiliar = iteradorDatos.next();
            if (cadenaAuxiliar.startsWith("Numero partida = ")) {
                numeroPartidasGuardadas.add(Integer.parseInt(cadenaAuxiliar.split("Numero partida = ", 2)[1].trim()));
            }
        }
        return numeroPartidasGuardadas;
    }

    public static int PartidaLibre() {
        List<Integer> numeroPartidasGuardadas = PartidasGuardadas();
        int contador = 1;

        // Busca la primera partida que no esté en la lista de partidas guardadas
        while (numeroPartidasGuardadas.contains(contador)) {
            contador++;  // Incrementamos el contador hasta encontrar un número libre
        }

        return contador;  // Devolvemos el número libre encontrado
    }

    public static int NumeroPartidaAnterior(int numeroPartida) {
        int numeroPartidaAnterior = -1;
        for (Integer numerosPartida : PartidasGuardadas()) {
            if (numerosPartida < numeroPartida && numerosPartida > numeroPartidaAnterior) {
                numeroPartidaAnterior = numerosPartida;
            }
        }
        return numeroPartidaAnterior;
    }

    public static List<String> leerArchivo() {
        List<String> lineasArchivo = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(PATH_GUARDADO_DATOS))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                lineasArchivo.add(linea);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return lineasArchivo;
    }

    public static void reescribirDatos(List<String> datos, String Clave, String datoNuevo, int numeroPartida) {
        boolean partidaEncontrada = false;
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).startsWith("Numero partida = " + numeroPartida)) {
                partidaEncontrada = true;
            }
            if (datos.get(i).startsWith(Clave + " = ") && partidaEncontrada) {
                datos.set(i, Clave + " = " + datoNuevo);
                partidaEncontrada = false;
            }
        }
    }

    public static void escribirArchivo(List<String> datos) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(PATH_GUARDADO_DATOS))) {
            for (String linea : datos) {
                buffer.write(linea);
                buffer.newLine();
            }
            buffer.flush();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void CambiarDatosPartida(String DatoCambiar, String NuevoDato, int numeroPartida) {

        List<String> datos = leerArchivo();// mete todo el archivo en datos
        reescribirDatos(datos, DatoCambiar, NuevoDato, numeroPartida);// busca la partida a la que se quiere hacer referencia
        escribirArchivo(datos);// vuelve a escribir otra vez todo el archivo entero

    }

    public static String DevolverDatoConcretoPartida(String clave, int numeroPartida) {
        List<String> datos = leerArchivo();
        boolean partidaEncontrada = false;
        boolean datoEncontrado = false;
        String datoDevuelto = "";
        int contador = 0;
        do {
            if (datos.get(contador).startsWith("Numero partida = " + numeroPartida)) {
                partidaEncontrada = true;
            }
            if (partidaEncontrada && datos.get(contador).startsWith(clave)) {
                datoDevuelto = datos.get(contador).split(clave + " = ", 2)[1].trim();
                datoEncontrado = true;
                partidaEncontrada = false;
            }
            contador++;
        } while (!datoEncontrado && contador < datos.size());
        return datoDevuelto;
    }

    public static void guardarPartida(int numeroPartida, PersonajePrinc personajePrinc) {
        try {
            CambiarDatosPartida("PersonajeNombre", personajePrinc.getNombre(), numeroPartida);
            CambiarDatosPartida("PersonajeRaza", personajePrinc.getRaza().toString(), numeroPartida);
            CambiarDatosPartida("PersonajeClase", personajePrinc.getOcupacion().toString(), numeroPartida);
            CambiarDatosPartida("PersonajeDinero", String.valueOf(personajePrinc.getDinero()), numeroPartida);

            String estadisticas = "";
            // Cambia todo el array a otro de Strings para que quede mejor en el archivo txt
            for (int i = 0; i < personajePrinc.getEstadisticas().length - 1; i++) {
                estadisticas += (String.valueOf(personajePrinc.getEstadisticas()[i])) + "-";
            }
            // Lo hace fuera del for para que no salga el ultimo guion
            estadisticas += String
                    .valueOf(personajePrinc.getEstadisticas()[personajePrinc.getEstadisticas().length - 1]);

            CambiarDatosPartida("PersonajeEstadisticas", estadisticas, numeroPartida);

            String Equipamiento = "";
            // Cambia todo el array a otro de Strings para que quede mejor en el archivo txt
            for (int i = 0; i < personajePrinc.getEquipamiento().length - 1; i++) {
                Equipamiento += (personajePrinc.getEquipamiento()[i]) + "-";
            }
            // Lo hace fuera del for para que no salga el ultimo guion
            Equipamiento += personajePrinc.getEquipamiento()[personajePrinc.getEquipamiento().length - 1];

            CambiarDatosPartida("PersonajeEquipamiento", Equipamiento, numeroPartida);

            String Historia = "";
            // Cambia todo el array a otro de Strings para que quede mejor en el archivo txt
            for (int i = 0; i < personajePrinc.getHistoria().length - 1; i++) {
                Historia += (String.valueOf(personajePrinc.getHistoria()[i])) + "-";
            }
            // Lo hace fuera del for para que no salga el ultimo guion
            Historia += (String.valueOf(personajePrinc.getHistoria()[personajePrinc.getHistoria().length - 1]));

            CambiarDatosPartida("PersonajeHistoria", Historia, numeroPartida);
        } catch (Exception e) {
            System.out.println("Error al guardar al personaje: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static PersonajePrinc devolverPersonaje(int numeroPartida, PersonajePrinc personajePrinc) {

        // El dato guardado del dinero se le pone al jugador
        personajePrinc.setDinero(Integer.parseInt(DevolverDatoConcretoPartida("PersonajeDinero", numeroPartida)));

        // El dato guardado las estadisticas se le pone al jugador
        String[] fragmentadoEst = (DevolverDatoConcretoPartida("PersonajeEstadisticas", numeroPartida)).split("-", 6);
        for (int i = 0; i < personajePrinc.getEstadisticas().length; i++) {
            personajePrinc.setEstadisticas(i, Integer.parseInt(fragmentadoEst[i]));
        }

        // El dato guardado del equipamiento se le pone al jugador
        String[] fragmentadoEquip = (DevolverDatoConcretoPartida("PersonajeEquipamiento", numeroPartida)).split("-", 5);
        for (int i = 0; i < personajePrinc.getEquipamiento().length; i++) {
            personajePrinc.setEquipamiento(i, fragmentadoEquip[i]);
        }

        // El dato guardado del equipamiento se le pone al jugador
        String[] fragmentadoHistoria = (DevolverDatoConcretoPartida("PersonajeHistoria", numeroPartida)).split("-", 6);
        for (int i = 0; i < personajePrinc.getEquipamiento().length; i++) {
            personajePrinc.setHistoria(Integer.parseInt(fragmentadoHistoria[i]), i);
        }
        return personajePrinc;
    }

    public static PersonajePrinc devolverPersonaje(int numeroPartida, Partida partida) {
        PersonajePrinc personajePrinc = null;
        Razas personajeRaza = null;
        switch (DevolverDatoConcretoPartida("PersonajeRaza", numeroPartida)) {
            case "Orco":
                personajeRaza = Razas.Orco;
                break;

            case "Elfo":
                personajeRaza = Razas.Elfo;
                break;

            case "Humano":
                personajeRaza = Razas.Humano;
                break;

            case "Enano":
                personajeRaza = Razas.Enano;
                break;

            default:
                break;
        }

        switch (DevolverDatoConcretoPartida("PersonajeClase", numeroPartida)) {
            case "Guerrero":
                personajePrinc = new Guerrero(DevolverDatoConcretoPartida("PersonajeNombre", numeroPartida), 
                personajeRaza, partida);
                break;

            case "Mago":
            personajePrinc = new Mago(DevolverDatoConcretoPartida("PersonajeNombre", numeroPartida), 
            personajeRaza, partida);
                break;

            case "Asesino":
            personajePrinc = new Asesino(DevolverDatoConcretoPartida("PersonajeNombre", numeroPartida), 
            personajeRaza, partida);
                break;

            case "Curandero":
            personajePrinc = new Curandero(DevolverDatoConcretoPartida("PersonajeNombre", numeroPartida), 
            personajeRaza, partida);
                break;

            case "Paladin":
            personajePrinc = new Paladin(DevolverDatoConcretoPartida("PersonajeNombre", numeroPartida), 
            personajeRaza, partida);
                break;

            case "Tanque":
            personajePrinc = new Tanque(DevolverDatoConcretoPartida("PersonajeNombre", numeroPartida), 
            personajeRaza, partida);
                break;

            default:
                break;
        }
        personajePrinc = devolverPersonaje(numeroPartida, personajePrinc);
        return personajePrinc;
    }

    public static boolean PartidaEmpezada(int numeroPartida) {
        boolean partidaEmpezada = false;
        try {
            if (!(DevolverDatoConcretoPartida("PersonajeRaza", numeroPartida).equals("nada"))) {
                partidaEmpezada = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return partidaEmpezada;
    }
}
