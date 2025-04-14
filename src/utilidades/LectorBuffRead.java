package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Esta clase se encarga de las lecturas con bufferedreader
 */
public class LectorBuffRead{

    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Este metodo pide al usuario si quiere tirar un dado 
     *  @return un tipo boleano que representa si quiere o no tirar el dado el usuario
     * 
     */
    public static boolean Confirmacion () throws IOException, InterruptedException {
        boolean confirmacion;
        
        TextoLento.printSlow("¿Quieres tirar el dado de veinte? (Si quieres tirarlo escribe \"si\")");
        String confirmacionTexto = buffer.readLine();
        if (confirmacionTexto.equalsIgnoreCase("si") 
        || confirmacionTexto.equalsIgnoreCase("Afirmativo")
        || confirmacionTexto.equalsIgnoreCase("s")) {
            confirmacion = true;
        }else {
            confirmacion = false;
        }
        return confirmacion;
    }
    /**
     * Este metodo lee lo que escribe el usuario y si esta dentro de 
     * sus opciones que se pasan por parametro lo devuelve
     * sino vuelve a pedir el dato con el mensaje dado por parametros hasta que se cumpla
     * @param mensaje
     * @param valorMin
     * @param valorMax
     * @return int
     * 
     */
    public static int leer (String mensaje, int valorMin, int valorMax) throws IOException, InterruptedException{
        int numeroDevolver = 0;
        boolean salirWhile = false;
        do {
            try {
                TextoLento.printSlow(mensaje);
                numeroDevolver = Integer.parseInt(buffer.readLine());
                if (numeroDevolver == valorMin || numeroDevolver == valorMax || (numeroDevolver > valorMin && numeroDevolver < valorMax)) {
                salirWhile = true;
                }else{
                    salirWhile = false;
                    TextoLento.printSlow("Por favor elija una de las opciones.");
                }
            } catch (NumberFormatException e) {
                TextoLento.printSlow("Por favor escriba un numero.");
                salirWhile = false;
            }
        } while (salirWhile == false);
        return numeroDevolver;
    }
    /**
     * Metodo de espera para darle tiempo al jugador para que pueda leer la historia.
     * Le pide al jugador que pulse la tecla enter para seguir con la historia.
     * 
     */
    public static void continuarHistoria () throws IOException, InterruptedException{
        TextoLento.printSlow("Pulse 'enter' para continuar la historia");
        buffer.readLine();
    }
    /**
     * Este metodo lee lo que escribe el usuario y si esta dentro de 
     * sus opciones que se pasan por parametro lo devuelve 
     * sino vuelve a pedir el dato con el mensaje dado por parametros hasta que se cumpla
     * @param texto
     * @param opcion1
     * @param opcion2
     * @return String
     * 
     */
    public static String leer (String texto, String opcion1, String opcion2) throws IOException, InterruptedException{
        String textoDevuelto = "";
        boolean salirWhile = false;
        do {
            TextoLento.printSlow(texto);
            textoDevuelto = buffer.readLine();
            if (textoDevuelto.equalsIgnoreCase(opcion1) || textoDevuelto.equalsIgnoreCase(opcion2)) {
                salirWhile = true;
            } else {
                salirWhile = false;
                TextoLento.printSlow("Por favor elija una de las opciones.");
            }
        } while (salirWhile == false);
        return textoDevuelto;
    }
    /**
     * Este metodo lee lo que escribe el usuario y si esta dentro de 
     * sus opciones que se pasan por parametro lo devuelve 
     * sino vuelve a pedir el dato con el mensaje dado por parametros hasta que se cumpla
     * @param texto
     * @param opcion1
     * @param opcion2
     * @param opcion3
     * @return String
     * 
     */
    public static String leer (String texto, String opcion1, String opcion2, String opcion3) throws IOException, InterruptedException{
        String textoDevuelto = "";
        boolean salirWhile = false;
        do {
            TextoLento.printSlow(texto);
            textoDevuelto = buffer.readLine();
            if (textoDevuelto.equals(opcion1)) {
                salirWhile = true;
            } else if (textoDevuelto.equals(opcion2)) {
                salirWhile = true;
            } else if (textoDevuelto.equals(opcion2)) {
                salirWhile = true;
            } else{
                salirWhile = false;
                TextoLento.printSlow("Por favor elija una de las opciones.");
            }
        } while (salirWhile == false);
        return textoDevuelto;
    }
    /**
     * Este metodo lee lo que escribe el usuario y si esta dentro de 
     * la opcion que se pasa por parametro lo devuelve
     * sino vuelve a pedir el dato con el mensaje dado por parametros hasta que se cumpla
     * @param texto
     * @param opcion1
     * @return String
     * 
     */
    public static String leer (String texto, String opcion1) throws IOException, InterruptedException{
        String textoDevuelto = "";
        boolean salirWhile = false;
        do {
            TextoLento.printSlow(texto);
            textoDevuelto = buffer.readLine();
            if (textoDevuelto.equals(opcion1)) {
                salirWhile = true;
            } else if (textoDevuelto != null){
                salirWhile = true;
            }
        } while (salirWhile == false);
        return textoDevuelto;
    }

    /**
     * Este metodo lee lo que escribe el jugador y lo devuelve si el jugador ha escrito algo.
     * @param texto
     * @return String escrito por el jugador
     * 
     */
    public static String leer (String texto) throws IOException, InterruptedException{
        String textoDevuelto = "";
        boolean textoEscrito = false;
        do {
            TextoLento.printSlow(texto);

            textoDevuelto = buffer.readLine();
            if (textoDevuelto.isEmpty()) {
                TextoLento.printSlow("Por favor escriba algo.");
                textoEscrito = false;
            }
            else {textoEscrito = true;} 
        } while (!textoEscrito);
        return textoDevuelto;
    }

    /**
     * Permite al usuario seleccionar una partida guardada de una lista de partidas disponibles.
     * Muestra las partidas disponibles y solicita al usuario que introduzca un número correspondiente.
     * Si la entrada no es válida o no pertenece a la lista, se repite la solicitud hasta que sea válida.
     *
     * @param partidasGuardadas Lista de partidas guardadas disponibles (números de partida).
     * @return El número de la partida seleccionada por el usuario.
     */
    public static int elegirPartida (List<Integer> partidasGuardadas) throws InterruptedException, IOException{
        

        System.out.println("Estas son las partidas guardadas disponibles:");
        System.out.print("Partidas guardadas: ");
        for (Integer partida : partidasGuardadas) {
            System.out.print(partida + ",");
        }System.out.println();

        int seleccion = -1;
        boolean eleccionValida = false;

        while (!eleccionValida) {
            System.out.print("Elige el número de partida que quieres cargar: ");
            try {
                seleccion = Integer.parseInt(buffer.readLine());
                if (partidasGuardadas.contains(seleccion)) {
                    eleccionValida = true;
                } else {
                    System.out.println("Ese número no corresponde a ninguna partida guardada.");
                }
            } catch (NumberFormatException e) {
                TextoLento.printSlow("Por favor escriba un numero.");
                eleccionValida = false;
            }
        }

        return seleccion;
    }
}
