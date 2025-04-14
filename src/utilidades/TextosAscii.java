package utilidades;

public class TextosAscii {
    // Métodos que solo establecen el color (sin println)
    public static void setNegro() { System.out.print("\u001B[30m");}
    public static void setRojo() { System.out.print("\u001B[31m"); }
    public static void setVerde() { System.out.print("\u001B[32m"); }
    public static void setAmarillo() { System.out.print("\u001B[33m"); }
    public static void setAzul() { System.out.print("\u001B[34m"); }
    public static void setMagenta() { System.out.print("\u001B[35m"); }
    public static void setCyan() { System.out.print("\u001B[36m"); }
    public static void setBlanco() { System.out.print("\u001B[37m"); }

    public static String getRESET () { return "\u001B[0m";}
    public static String getROJO () {return "\u001B[31m";}
    public static String getVERDE () {return "\u001B[32m";}
    public static String getAZUL () {return "\u001B[34m";}
    public static String getAMARILLO () {return "\u001B[33m";}

    // Resetear color
    public static void resetColor() { System.out.print("\u001B[0m"); }

    public static String[] getEnemigo () {
        String[] enemigo = {
            "  /\\", 
            " /||\\",
            " /  \\",
            "ENEMIGO"
        };
        return enemigo;
    };

    public static String[] getJugador () {
        String[] jugador = {
        "  /\\", 
        " /||\\",
        " /  \\",
        "JUGADOR"
        };
        return jugador;
    };
    
    // Genera barra de vida
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
