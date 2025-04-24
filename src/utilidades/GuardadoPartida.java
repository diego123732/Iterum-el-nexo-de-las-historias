package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    /**
     * Metodo que gestiona cual es el numero de partida que el jugador va a elegir dependiendo de si 
     * quiere empezar una nueva partida o una ya empezada
     * @return devuelve el numero de la partida que sera utilizado en la partida para guardarla
     * @see NuevaPartida
     * @see PartidasGuardadas
     * @see LectorBuffRead.elegirPartida
     * @throws IOException
     * @throws InterruptedException
     */
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

    /**
     * Metodo que gestiona y crea una nueva partida cuando el jugador elije 
     * empezar una nueva partida o no tiene partidas empezadas
     * @see DatosActualizados
     * @see escribirArchivo
     * @param numeroPartida
     * @throws IOException
     * @throws InterruptedException
     */
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
                    escribir.write("Fecha Inicio Partida = ");
                    escribir.newLine();
                    escribir.write("Duracion Partida = 00:00:00");
                    escribir.newLine();
                    escribir.write("Dinero Total = 15");
                    escribir.newLine();
                    escribir.write("Daño Total = 0");
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

    /**
     * Metodo que devuelve como tiene que estar formado el txt segun el numero de la partida 
     * que se vaya a jugar y si ya hay partidas en el archivo
     * <p>
     * Basicamente si el archivo esta vacio añade la primera partida y sino decide donde colocar 
     * la nueva partida dependiendo de las que ya hay dentro, para que el texto salga ordenado 
     * por el numero de partida
     * @param numeroPartida
     * @param datosGuardar
     * @param auxiliarFormacion
     * @return Un array con todo el texto ordenado que luego se mete en el archivo .txt
     */
    public static List<String> DatosActualizados(int numeroPartida, List<String> datosGuardar,
            List<String> auxiliarFormacion) {
        if (PartidasGuardadas().isEmpty()) {
            datosGuardar.add("Numero partida = " + numeroPartida);
            datosGuardar.add("PersonajeNombre = nada");
            datosGuardar.add("PersonajeRaza = nada");
            datosGuardar.add("PersonajeClase = nada");
            datosGuardar.add("PersonajeDinero = 15");
            datosGuardar.add("PersonajeEstadisticas = 0-0-0-0-0-0");
            datosGuardar.add("PersonajeEquipamiento = 0-0-0-0-0");
            datosGuardar.add("PersonajeHistoria = 0-0-0-0-0-0");
            datosGuardar.add("Fecha Inicio Partida = ");
            datosGuardar.add("Duracion Partida = 00:00:00");
            datosGuardar.add("Dinero Total = 15");
            datosGuardar.add("Daño Total = 0");
            datosGuardar.addAll(auxiliarFormacion);
            /**
             * Añade los datos correspondientes a la primera partida y luego
             * los que ya estaban dentro del archivo
             */
        }
        else if (numeroPartida < PartidasGuardadas().getFirst()) {
            datosGuardar.add("Numero partida = " + numeroPartida);
            datosGuardar.add("PersonajeNombre = nada");
            datosGuardar.add("PersonajeRaza = nada");
            datosGuardar.add("PersonajeClase = nada");
            datosGuardar.add("PersonajeDinero = 15");
            datosGuardar.add("PersonajeEstadisticas = 0-0-0-0-0-0");
            datosGuardar.add("PersonajeEquipamiento = 0-0-0-0-0");
            datosGuardar.add("PersonajeHistoria = 0-0-0-0-0-0");
            datosGuardar.add("Fecha Inicio Partida = ");
            datosGuardar.add("Duracion Partida = 00:00:00");
            datosGuardar.add("Dinero Total = 15");
            datosGuardar.add("Daño Total = 0");
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
                if (auxiliarFormacion.get(contador).startsWith("Daño Total")
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
                    datosGuardar.add("Fecha Inicio Partida = ");
                    datosGuardar.add("Duracion Partida = 00:00:00");
                    datosGuardar.add("Dinero Total = 15");
                    datosGuardar.add("Daño Total = 0");
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

    /**
     * Metodo que busca en todo el archivo txt y cuenta cuales son las partidas guardadas
     * @return un array con los numeros de las partidas guardadas
     */
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

    /**
     * Metodo que busca que numero de partida esta libre, esta hecho para que empiece por el numero 1 aposta, 
     * lo que hace que nunca pueda haber una partida numero 0
     * <p>
     * Un ejemplo de lo que hace el metodo y para que esta hecho: Si estan las partidas 1,3 y 4 
     * en el archivo el metodo pasaria por el uno y luego al dos y al encontrar que el 2 no esta en 
     * el archivo lo devolveria, para asi rellenar ese hueco con el metodo {@link NuevaPartida} en el hueco 2
     * @return el numero de la partidalibre
     */
    public static int PartidaLibre() {
        List<Integer> numeroPartidasGuardadas = PartidasGuardadas();
        int contador = 1;

        // Busca la primera partida que no esté en la lista de partidas guardadas
        while (numeroPartidasGuardadas.contains(contador)) {
            contador++;  // Incrementamos el contador hasta encontrar un número libre
        }

        return contador;  // Devolvemos el número libre encontrado
    }

    /**
     * Metodo que devuelve cual es la partida menor a la que se quiere añadir 
     * @param numeroPartida
     * @return El numero de la partida anterior por orden de numero de la partida
     */
    public static int NumeroPartidaAnterior(int numeroPartida) {
        int numeroPartidaAnterior = -1;
        for (Integer numerosPartida : PartidasGuardadas()) {
            if (numerosPartida < numeroPartida && numerosPartida > numeroPartidaAnterior) {
                numeroPartidaAnterior = numerosPartida;
            }
        }
        return numeroPartidaAnterior;
    }

    /**
     * Metodo que lee el archivo txt y devuelve un array de String con su contenido
     * @return un array de String con el contenido del txt
     */
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

    /**
     * Metodo que recibe un ArrayList y lo devuelve con el dato que busca 
     * por la clave cambiado por el que recibe por parametros 
     * @param datos
     * @param Clave
     * @param datoNuevo
     * @param numeroPartida
     */
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

    /**
     * Metodo que recibe un ArrayList de String y lo vuelca entero en un archivo txt
     * @param datos
     */
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

    /**
     * Metodo que Mezcla la reescritura de datos {@link reescribirDatos} 
     * con la escritura en el txt {@link escribirArchivo} para meter los datos nuevos al archivo
     * @param DatoCambiar
     * @param NuevoDato
     * @param numeroPartida
     */
    public static void CambiarDatosPartida(String DatoCambiar, String NuevoDato, int numeroPartida) {

        List<String> datos = leerArchivo();// mete todo el archivo en datos
        reescribirDatos(datos, DatoCambiar, NuevoDato, numeroPartida);// busca la partida a la que se quiere hacer referencia
        escribirArchivo(datos);// vuelve a escribir otra vez todo el archivo entero

    }

    /**
     * Metodo que devuelve un dato concreto buscandolo con una clave de una partida por el dato clave {@link numeroPartida}
     * @param clave
     * @param numeroPartida
     * @return El dato buscado en formato String
     */
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

    /**
     * Metodo que guarda la partida del personaje cada vez que se termina una parte de la historia
     * @param numeroPartida
     * @param partida
     */
    public static void guardarPartida(int numeroPartida, Partida partida) {
        PersonajePrinc personajePrinc = partida.getPersonajePrincipalPartida();
        try {
            String fechaFormateada = partida.getFECHA_INICIO_PARTIDA()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            CambiarDatosPartida("Fecha Inicio Partida",fechaFormateada, numeroPartida);

            String duracionPartidaFormateada = String.format("%02d:%02d:%02d", 
            partida.getDuracionPartida().toHours(), (partida.getDuracionPartida().toMinutes()%60), (partida.getDuracionPartida().getSeconds()%60));
            CambiarDatosPartida("Duracion Partida", duracionPartidaFormateada, numeroPartida);
            partida.setHoraInicioPartida(LocalTime.now());

            CambiarDatosPartida("Dinero Total", String.valueOf(partida.getDineroTotalPartida()) , numeroPartida);
            CambiarDatosPartida("Daño Total", String.valueOf(partida.getDañoTotalPartida()), numeroPartida);

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
            ManipulacionBD.GuardarDatos(partida);
        } catch (Exception e) {
            System.out.println("Error al guardar al personaje: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Metodo que devuelve la partida jugada para seguir jugandola
     * @param numeroPartida
     * @return El objeto {@link Partida} recuperado
     */
    public static Partida cargarPartida (int numeroPartida) {
        int dineroTotalPartida = Integer.parseInt(DevolverDatoConcretoPartida("Dinero Total", numeroPartida));
        double dañoTotalPartida = Double.parseDouble(DevolverDatoConcretoPartida("Daño Total", numeroPartida));
        Partida partida = new Partida(LocalDateTime.parse(
            DevolverDatoConcretoPartida("Fecha Inicio Partida", numeroPartida),
             DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
             dineroTotalPartida,
             dañoTotalPartida,
             Duration.between(LocalTime.MIDNIGHT, LocalTime.parse(DevolverDatoConcretoPartida("Duracion Partida", numeroPartida))));

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
    
        partida.setPersonajePrincipalPartida(personajePrinc);
        return partida;
    }

    /**
     * Metodo que valora si la partida ya ha empezado o no
     * @param numeroPartida
     * @return si la partida ha empezado boolean
     */
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

    /**
     * Metodo numero tres del menu principal que devuelve las partidas guardadas (si hay) ya mostradas por pantalla
     * @throws InterruptedException
     * @throws IOException
     */
    public static void devolverContenidoArchivo () throws InterruptedException, IOException{
        if (new File(PATH_GUARDADO_DATOS).exists()) {
            List<String> contenidoArchivo = leerArchivo();
            for (String string : contenidoArchivo) {
                System.out.println(string);
            }
        if (contenidoArchivo.isEmpty()) {
            System.out.println("No hay partidas guardadas");
        }
        }else {
            System.out.println("No hay partidas guardadas");
        }
    }

    /**
     * Metodo que al terminar la partida elimina la partida del archivo txt de guardado 
     * y se guarda finalmente en la base de datos
     * @param numeroPartida
     * @param partida
     */
    public static void EliminarPartida (int numeroPartida, Partida partida) {
        ManipulacionBD.UltimoGuardado(partida);
        List<String> contenidoArchivo = leerArchivo();
        if (numeroPartida == 1) {
            for (int i = 0; i < 12; i++) {
                contenidoArchivo.remove(i);
            }
        }
        else {
            
            int ubicacionPartida = -1;
            boolean partidaEncontrada = false;
            int contador = 0;
            do {
                if (contenidoArchivo.get(contador).startsWith("Numero partida = " + numeroPartida)) {
                    ubicacionPartida = contador;
                    partidaEncontrada = true;
                }
                contador++;
            } while (!partidaEncontrada);
            for (int i = (ubicacionPartida + 11); i >= (ubicacionPartida - 4); i--) {
                contenidoArchivo.remove(i);
            }
        }

        escribirArchivo(contenidoArchivo);
    }
}
