package utilidades;

public class TextosAscii {
    private static final String COLOR_NEGRO = "\u001B[30m";
    private static final String COLOR_ROJO = "\u001B[31m";
    private static final String COLOR_VERDE = "\u001B[32m";
    private static final String COLOR_AMARILLO = "\u001B[33m";
    private static final String COLOR_AZUL = "\u001B[34m";
    private static final String COLOR_MAGENTA = "\u001B[35m";
    private static final String COLOR_CYAN = "\u001B[36m";
    private static final String COLOR_BLANCO = "\u001B[37m";
    private static final String COLOR_RESET = "\u001B[0m";
    /**
     * Metodo que cambia el color de la pantalla al negro
     */
    public static void setNegro() { System.out.print(COLOR_NEGRO);}
    /**
     * Metodo que cambia el color de la pantalla al rojo
     */
    public static void setRojo() { System.out.print(COLOR_ROJO); }
    /**
     * Metodo que cambia el color de la pantalla al verde
     */
    public static void setVerde() { System.out.print(COLOR_VERDE); }
    /**
     * Metodo que cambia el color de la pantalla al amarillo
     */
    public static void setAmarillo() { System.out.print(COLOR_AMARILLO); }
    /**
     * Metodo que cambia el color de la pantalla al azul
     */
    public static void setAzul() { System.out.print(COLOR_AZUL); }
    /**
     * Metodo que cambia el color de la pantalla al morado/magenta
     */
    public static void setMagenta() { System.out.print(COLOR_MAGENTA); }
    /**
     * Metodo que cambia el color de la pantalla al azul cyan
     */
    public static void setCyan() { System.out.print(COLOR_CYAN); }
    /**
     * Metodo que cambia el color de la pantalla al blanco
     */
    public static void setBlanco() { System.out.print(COLOR_BLANCO); }

    /**
     * Metodo que devuelve el texto String del color predefinido
     * @return String color predefinido
     */
    public static String getRESET () { return COLOR_RESET;}
    /**
     * Metodo que devuelve el texto String del color rojo
     * @return String color rojo
     */
    public static String getROJO () {return COLOR_ROJO;}
    /**
     * Metodo que devuelve el texto String del color verde
     * @return String color verde
     */
    public static String getVERDE () {return COLOR_VERDE;}
    /**
     * Metodo que devuelve el texto String del color azul
     * @return String color azul
     */
    public static String getAZUL () {return COLOR_AZUL;}
    /**
     * Metodo que devuelve el texto String del color amarillo
     * @return String color amarillo
     */
    public static String getAMARILLO () {return COLOR_AMARILLO;}

    /**
     * Metodo que devuelve el texto ascii de bienvenida
     * @return
     */
    public static String getTextoBienvenida () {
        String texto = "\r\n" + //
                        "██████  ██ ███████ ███    ██ ██    ██ ███████ ███    ██ ██ ██████   ██████  \r\n" + //
                        "██   ██ ██ ██      ████   ██ ██    ██ ██      ████   ██ ██ ██   ██ ██    ██ \r\n" + //
                        "██████  ██ █████   ██ ██  ██ ██    ██ █████   ██ ██  ██ ██ ██   ██ ██    ██ \r\n" + //
                        "██   ██ ██ ██      ██  ██ ██  ██  ██  ██      ██  ██ ██ ██ ██   ██ ██    ██ \r\n" + //
                        "██████  ██ ███████ ██   ████   ████   ███████ ██   ████ ██ ██████   ██████  \r\n" + //
                        "                                                                            \r\n" + //
                        "                                                                            \r\n" + //
                        "";
        return texto;
    }

    /**
     * Metodo que cambia el color de la pantalla al predefinido
     */
    public static void resetColor() { System.out.print(COLOR_RESET); }

    /**
     * Metodo que formatea un muñeco que simula el personaje del enemigo al jugador
     * @return El muñeco formateado
     */
    public static String[] getEnemigo () {
        String[] enemigo = {
            "  /\\", 
            " /||\\",
            " /  \\",
            "ENEMIGO"
        };
        return enemigo;
    };

    /**
     * Metodo que formatea un muñeco que simula el personaje del jugador
     * @return El muñeco formateado
     */
    public static String[] getJugador () {
        String[] jugador = {
        "  /\\", 
        " /||\\",
        " /  \\",
        "JUGADOR"
        };
        return jugador;
    };
    
    /**
     * Metodo que simula una barra de vida segun la vida maxima que pueda tener el jugador 
     * @param vida
     * @param vidaMax
     * @param color
     * @return
     */
    public static String barraVida(int vida,int vidaMax, String color) {
        int porcentajeVida = (vida*100)/vidaMax;
        int longitud = 20;
        int barras = (int) ((double) porcentajeVida / 100 * longitud);
        String barraVida;
        if (porcentajeVida >= 100) {
            barraVida = color + "[" + "█".repeat(longitud) + "]";
        }else if (porcentajeVida <= 0) {
            barraVida = color + "[" + " ".repeat(longitud) + "]";
        }
        else{
        barraVida = color + "[" + "█".repeat(barras) + " ".repeat(longitud - barras) + "]";
        }
        return barraVida;
    }

    /**
     * Metodo que pinta por pantalla una tabla formateada con todo lo que pasa en la partida
     * @see barraVida
     * @param vidaEnemigo
     * @param vidaEnemigoMax
     * @param vidaJugador
     * @param vidaJugadorMax
     * @param dañoAJugador
     * @param dañoAEnemigo
     * @param dadoVeinte
     */
    public static void pintarCombate (double vidaEnemigo, double vidaEnemigoMax, double vidaJugador, double vidaJugadorMax,double dañoAJugador, double dañoAEnemigo, double dadoVeinte ) {
        
        String[] jugador = TextosAscii.getJugador();
        String[] enemigo = TextosAscii.getEnemigo();
        for (int i = 0; i < jugador.length; i++) {
            TextosAscii.setVerde();System.out.printf("%"+ (jugador[i].length() +18) + "s", jugador[i]);
            TextosAscii.setRojo();System.out.printf("%45s%n",enemigo[i]);
        }
        TextosAscii.resetColor();

        // Primera linea marco superior con las esquinas del recuadro
        //Parte jugador
        TextosAscii.setVerde();System.out.print("╔");System.out.print("═".repeat(41));System.out.print("╗  ");

        //Parte enemigo
        TextosAscii.setRojo();System.out.print("╔");System.out.print("═".repeat(41));System.out.println("╗ ");
        TextosAscii.resetColor();
        
        String texto1Jugador = "Has hecho " + dañoAEnemigo + " puntos de daño";
        String textoVida = "Vida restante: ";
        String textoDado = "Has sacado " + (int) dadoVeinte + " en el dado de veinte";
        String texto1Enemigo = "Ha hecho " + dañoAJugador + " puntos de daño";
        String texto2Jugador = "Te quedan " + vidaJugador + " puntos de vida";
        String texto2Enemigo = "Le quedan " + vidaEnemigo + " puntos de vida";
        String barraVidaJugador = TextosAscii.barraVida((int) vidaJugador, (int) vidaJugadorMax, TextosAscii.getVERDE());
        String barraVidaEnemigo = TextosAscii.barraVida((int) vidaEnemigo, (int) vidaEnemigoMax, TextosAscii.getROJO());

        //Segunda linea el daño que hace cada personaje
        //Parte Jugador
        TextosAscii.setVerde();
        System.out.printf("%s%"+ (texto1Jugador.length() + 7) + 
        "s%" + (10 - String.valueOf(dañoAEnemigo).length()) +"s","║", texto1Jugador,"║");

        //Parte enemigo
        TextosAscii.setRojo();
        System.out.printf("%3s%"+ (texto1Enemigo.length() + 8) + 
        "s%" + (10 - String.valueOf(dañoAJugador).length()) +"s%n","║", texto1Enemigo,"║");

        if (dadoVeinte == 0) {//Si no ha querido tirar el dado, su valor es cero y no lo decimos por consola
            //Tercera linea salto de linea para los dos si no ha tirado el dado
            //Parte jugador
            TextosAscii.setVerde();
            System.out.printf("%s%42s", "║","║");
            //Parte enemigo
            TextosAscii.setRojo();
            System.out.printf("%3s%42s%n", "║","║");
        } else {
            //Tercera linea el dado de veinte del jugador y un salto de linea para el enemigo
            //Parte jugador
            TextosAscii.setVerde();
            System.out.printf("%s%"+ (textoDado.length() + 6) + 
            "s%" + (4 - String.valueOf((int)dadoVeinte).length()) +"s","║", textoDado,"║");
            //Parte enemigo
            TextosAscii.setRojo();System.out.printf("%3s%42s%n", "║","║");
        }

        //Cuarta linea mensaje comun de vida restante
        //Parte jugador
        TextosAscii.setVerde();        
        System.out.printf("%s%"+ (textoVida.length() + 14) + "s%13s","║", textoVida,"║");

        // Parte enemigo
        TextosAscii.setRojo();
        System.out.printf("%3s%"+ (textoVida.length() + 14) + "s%13s%n","║", textoVida,"║");

        //Quinta linea, puntos de vida restante
        //Parte jugador
        TextosAscii.setVerde();
        System.out.printf("%s%"+ (texto2Jugador.length() + 8) + 
        "s%" + (9 - String.valueOf(vidaJugador).length()) +"s","║", texto2Jugador,"║");

        //Parte enemigo
        TextosAscii.setRojo();
        System.out.printf("%3s%"+ (texto2Enemigo.length() + 8) + 
        "s%" + (9 - String.valueOf(vidaEnemigo).length()) +"s%n","║", texto2Enemigo,"║");

        //Sexta linea, barra de vida
        //Parte jugador
        TextosAscii.setVerde();
        System.out.printf("%s%"+ (barraVidaJugador.length()
         + 9) + "s%11s","║", barraVidaJugador,"║");

        //Parte enemigo
        TextosAscii.setRojo();
        System.out.printf("%3s%"+ (barraVidaEnemigo.length()
         + 9) + "s%11s%n","║", barraVidaEnemigo,"║");

         //Septima linea, Final de la tabla, parte de abajo con sus esquinas
        //Parte jugador
        TextosAscii.setVerde();System.out.print("╚");System.out.print("═".repeat(41));System.out.print("╝  ");
        //Parte enemigo
        TextosAscii.setRojo();System.out.print("╚");System.out.print("═".repeat(41));System.out.println("╝ ");
        //Devolver el color a default
        TextosAscii.resetColor();
    }
}
