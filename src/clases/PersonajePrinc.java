package clases;

import java.io.IOException;

import utilidades.Aleatoriedad;
import utilidades.LectorBuffRead;

/**
 * Clase padre de todos los personajes principales y la que tiene una de las
 * mayores cargas de todo el videojuego
 */
abstract public class PersonajePrinc {
    private final String nombre;// Recoge el nombre del personaje del jugador.
    private final Razas raza;// Recoge la raza activa del personaje del jugador, la raza que tiene en el
                             // momento, otros metodos le daran un valor
    private final Ocupaciones ocupacion;// Recoge la clase activa del personaje del jugador, la clase que tiene en el
                                        // momento, otros metodos le daran un valor
    private int dinero;// Recoge el dinero activo del personaje del jugador, el dinero que tiene en el
                       // momento, otros metodos le daran un valor
    private int[] estadisticas;// Destreza, fuerza, inteligencia, caracter, constitucion y sabiduria.
    private String[] equipamiento;// Recoge el equipamiento activo del personaje del jugador, el equipamiento que
                                  // tiene en el momento, otros metodos le daran un valor
    private int[] historia;// Recoge las etapas de la historia por las que ha pasado el jugador
    private Partida partidaPersonaje;

    public PersonajePrinc(String nombre, Razas raza, Ocupaciones ocupacion, int dinero, int[] estadisticas,
            String[] equipamiento, Partida partida) {
        int[] historiaPredeterminada = { 0, 0, 0, 0, 0, 0 };
        this.nombre = nombre;
        this.raza = raza;
        this.ocupacion = ocupacion;
        this.dinero = dinero;
        this.estadisticas = estadisticas;
        this.equipamiento = equipamiento;
        this.historia = historiaPredeterminada;
        this.partidaPersonaje = partida;
        switch (this.raza) {
            case Razas.Enano:
                this.setEstadisticas(PlayerData.CONSTITUCION.getValue(),
                        (this.getEstadisticas()[PlayerData.CONSTITUCION.getValue()] + 1)); // da un punto mas de
                                                                                           // Constitucion
                break;

            case Razas.Humano:
                this.setDinero((this.getDinero() + 10)); // Si es humano tiene mas dinero base
                break;

            case Razas.Orco:
                this.setEstadisticas(PlayerData.FUERZA.getValue(),
                        (this.getEstadisticas()[PlayerData.FUERZA.getValue()] + 1)); // da un punto mas de Fuerza
                break;

            case Razas.Elfo:
                this.setEstadisticas(PlayerData.DESTREZA.getValue(),
                        (this.getEstadisticas()[PlayerData.DESTREZA.getValue()] + 1)); // da un punto mas de Destreza
                break;

            default:
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Razas getRaza() {
        return raza;
    }

    public Ocupaciones getOcupacion() {
        return ocupacion;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
        if (this.partidaPersonaje != null) {
            if (dinero > this.partidaPersonaje.getDineroTotalPartida()) {
                this.partidaPersonaje.setDineroTotalPartida(this.dinero);
            }
        }
    }

    public int[] getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(int[] estadisticas) {
        this.estadisticas = estadisticas;
    }

    public void setEstadisticas(int lugar, int estadisticas) {
        this.estadisticas[lugar] = estadisticas;
    }

    public String[] getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String[] equipamiento) {
        this.equipamiento = equipamiento;
    }

    public void setEquipamiento(int lugar, String equipamiento) {
        this.equipamiento[lugar] = equipamiento;
    }

    public int[] getHistoria() {
        return historia;
    }

    public void setHistoria(int[] historia) {
        this.historia = historia;
    }

    public void setHistoria(int valor, int lugar) {
        this.historia[lugar] = valor;
    }

    /**
     * Metodo que pide el numero del array de estadisticas y devuelve cual es
     * 
     * @param estadisticaNumero
     * @return String, cual es la estadistica
     */
    public String getNombreEstadistica(int estadisticaNumero) {
        String estadisticaTexto = "null";
        if (estadisticaNumero == PlayerData.DESTREZA.getValue()) {
            estadisticaTexto = "Destreza";
        }
        if (estadisticaNumero == PlayerData.FUERZA.getValue()) {
            estadisticaTexto = "Fuerza";
        }
        if (estadisticaNumero == PlayerData.INTELIGENCIA.getValue()) {
            estadisticaTexto = "Inteligencia";
        }
        if (estadisticaNumero == PlayerData.CARACTER.getValue()) {
            estadisticaTexto = "Caracter";
        }
        if (estadisticaNumero == PlayerData.CONSTITUCION.getValue()) {
            estadisticaTexto = "Constitucion";
        }
        if (estadisticaNumero == PlayerData.SABIDURIA.getValue()) {
            estadisticaTexto = "Sabiduria";
        }
        return estadisticaTexto;
    }

    /**
     * metodo que devuelve la vida del personaje en funcion de su equipamiento y
     * estadisticas
     * 
     * @return double
     * @see vida_equipamiento
     * @see PlayerData
     */
    public double devolverVida() {
        double vida_personaje = (this.estadisticas[PlayerData.CONSTITUCION.getValue()] * 5) + VidaEquipamiento();
        return vida_personaje;
    }

    /**
     * metodo que devuelve una fraccion de la vida del personaje en funcion de su
     * equipamiento
     * 
     * @return double
     * @see PlayerData
     */
    public double VidaEquipamiento() {
        double vida_equipamiento = 0;
        switch (this.equipamiento[2]) {// Casco del personaje
            case "Sombrero de mago":
                vida_equipamiento += (PlayerData.SOMBRERO_DE_MAGO_VIDA.getValue()
                        + (this.estadisticas[PlayerData.INTELIGENCIA.getValue()] / 2));
                break;
            case "Yelmo barbuta":
                vida_equipamiento += (PlayerData.YELMO_BARBUTA_VIDA.getValue()
                        + (this.estadisticas[PlayerData.FUERZA.getValue()] / 2));
                break;
            case "Boina":
                vida_equipamiento += (PlayerData.BOINA_VIDA.getValue()
                        + (this.estadisticas[PlayerData.SABIDURIA.getValue()] / 2));
                break;
            case "Capucha":
                vida_equipamiento += (PlayerData.CAPUCHA_VIDA.getValue()
                        + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2));
                break;
            case "Yelmo cónico":
                vida_equipamiento += (PlayerData.YELMO_CONICO_VIDA.getValue()
                        + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2));
                break;

            default:// No tiene nada equipado en la cabeza
                break;
        }
        switch (this.equipamiento[3]) {// Cuerpo del personaje
            case "Túnica":
                vida_equipamiento += (PlayerData.TUNICA_ARMADURA_VIDA.getValue()
                        + (this.estadisticas[PlayerData.INTELIGENCIA.getValue()]));
                break;
            case "Cota de malla":
                vida_equipamiento += (PlayerData.COTA_MALLA_VIDA.getValue()
                        + (this.estadisticas[PlayerData.CONSTITUCION.getValue()]));
                break;
            case "Chaleco de cuero":
                vida_equipamiento += (PlayerData.CHALECO_CUERO_VIDA.getValue()
                        + (this.estadisticas[PlayerData.DESTREZA.getValue()]));
                break;

            default:// No tiene nada equipado en el cuerpo
                break;
        }
        switch (this.equipamiento[4]) {// Pies del personaje
            case "Zapatos de cuero":
                vida_equipamiento += (PlayerData.ZAPATOS_CUERO_VIDA.getValue()
                        + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2));
                break;

            default:// No tiene nada equipado en los pies
                break;
        }

        return vida_equipamiento;
    }

    /**
     * metodo que devuelve el el daño segun las armas que tenga equipadas el jugador
     * y si el jugador quiere tirar el dado
     * 
     * @return dos datos double, el daño total y lo que ha sacado en el dado de
     *         veinte
     * @throws IOException
     * @see PlayerData
     */
    public double[] Combate() throws IOException, InterruptedException {
        double daño_total = 0;
        boolean dadoVeinteTirado = LectorBuffRead.Confirmacion();
        double dadoVeinte = 0;
        if (dadoVeinteTirado) {
            dadoVeinte = utilidades.Aleatoriedad.dadoVeinte();
        }

        if (this.equipamiento[1].isEmpty()) {// en el combate se divide por armas de una o dos manos
            switch (this.equipamiento[0]) /* Calculo de daño en armas de dos manos */ {

                case "Baculo":// daño Baculo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.BACULO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.INTELIGENCIA.getValue()])) * (dadoVeinte / 10)
                            : PlayerData.BACULO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.INTELIGENCIA.getValue()]);
                    break;

                case "Espadón":// daño Espadón
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.ESPADON_DAMAGE.getValue() + (this.estadisticas[PlayerData.FUERZA.getValue()]))
                                    * (dadoVeinte / 10)
                            : PlayerData.ESPADON_DAMAGE.getValue() + (this.estadisticas[PlayerData.FUERZA.getValue()]);
                    break;
                default:// No tiene nada equipado en las manos
                    break;
            }
        } else {
            switch (this.equipamiento[0]) /* Calculo de daño de la primera arma de dos armas de una mano */ {

                case "Daga basica":// daño daga
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2);
                    break;

                case "Crucifijo":// daño crucifijo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.CRUCIFIJO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.SABIDURIA.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.CRUCIFIJO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.SABIDURIA.getValue()] / 2);
                    break;

                case "Mazo":// daño mazo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.MAZO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.MAZO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2);
                    break;

                default:// No tiene nada equipado en los pies
                    break;
            }
            switch (this.equipamiento[1]) /* Calculo de daño de la segunda arma en dos armas de una mano */ {

                case "Escudo":// daño escudo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.ESCUDO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.ESCUDO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2);
                    break;

                case "Daga basica":// daño daga
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2);
                    break;

                default:
                    break;
            }

        }
        return new double[] { daño_total, dadoVeinte };
    }

    /**
     * metodo que devuelve el el daño segun las armas que tenga equipadas el jugador
     * 
     * @return dos datos double, el daño total
     * @throws IOException
     * @see PlayerData
     */
    public double DañoSegunArmas() {
        double daño_total = 0;
        boolean dadoVeinteTirado = false;
        double dadoVeinte = 1;

        if (this.equipamiento[1].isEmpty()) {// en el combate se divide por armas de una o dos manos
            switch (this.equipamiento[0]) /* Calculo de daño en armas de dos manos */ {

                case "Baculo":// daño Baculo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.BACULO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.INTELIGENCIA.getValue()])) * (dadoVeinte / 10)
                            : PlayerData.BACULO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.INTELIGENCIA.getValue()]);
                    break;

                case "Espadón":// daño Espadón
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.ESPADON_DAMAGE.getValue() + (this.estadisticas[PlayerData.FUERZA.getValue()]))
                                    * (dadoVeinte / 10)
                            : PlayerData.ESPADON_DAMAGE.getValue() + (this.estadisticas[PlayerData.FUERZA.getValue()]);
                    break;
                default:// No tiene nada equipado en las manos
                    break;
            }
        } else {
            switch (this.equipamiento[0]) /* Calculo de daño de la primera arma de dos armas de una mano */ {

                case "Daga basica":// daño daga
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2);
                    break;

                case "Crucifijo":// daño crucifijo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.CRUCIFIJO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.SABIDURIA.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.CRUCIFIJO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.SABIDURIA.getValue()] / 2);
                    break;

                case "Mazo":// daño mazo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.MAZO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.MAZO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2);
                    break;

                default:// No tiene nada equipado en los pies
                    break;
            }
            switch (this.equipamiento[1]) /* Calculo de daño de la segunda arma en dos armas de una mano */ {

                case "Escudo":// daño escudo
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.ESCUDO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.ESCUDO_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.CONSTITUCION.getValue()] / 2);
                    break;

                case "Daga basica":// daño daga
                    daño_total += (dadoVeinteTirado)
                            ? (PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2)) * (dadoVeinte / 10)
                            : PlayerData.DAGA_BASICA_DAMAGE.getValue()
                                    + (this.estadisticas[PlayerData.DESTREZA.getValue()] / 2);
                    break;

                default:
                    break;
            }

        }
        return daño_total;
    }

    /**
     * Prueba de aptitud de dos estadisticas, este metodo se encarga de darle a
     * elegir
     * al jugador entre dos estadisticas cada una con su porcentaje de pasar la
     * prueba de aptitud,
     * el jugador elije una de las dos y segun la dificultad pasa la prueba o no.
     * 
     * @param dificultad
     * @param estadistica1
     * @param estadistica2
     * @return pruebaAptitud un tipo boleano que define si el jugador pasa o no la
     *         prueba de aptitud
     * @throws IOException
     * @see Aleatoriedad
     * @see LectorBuffRead
     */
    public boolean pruebaAptitud(int dificultad, int estadistica1,
            int estadistica2) throws IOException, InterruptedException {

        boolean pruebaAptitud = false;
        int eleccionJugador = 0;
        int probabilidadEst1 = (Aleatoriedad.devolverNumero(this.estadisticas[estadistica1]));
        double porcentajeAciertoEst1 = ((probabilidadEst1 * 100) / (dificultad * 10));
        int probabilidadEst2 = (Aleatoriedad.devolverNumero(this.estadisticas[estadistica2]));
        double porcentajeAciertoEst2 = ((probabilidadEst2 * 100) / (dificultad * 10));
        System.out.println("Prueba de aptitud.");
        String estadistica1Nombre = getNombreEstadistica(estadistica1);
        String estadistica2Nombre = getNombreEstadistica(estadistica2);

        System.out.println("Elija una de las estadisticas");
        System.out.println("Estadistica 1: " + estadistica1Nombre +
                " Probabilidad de tener exito: " + porcentajeAciertoEst1 + "%");
        System.out.println("Estadistica 2: " + estadistica2Nombre +
                " Probabilidad de tener exito: " + porcentajeAciertoEst2 + "%");
        String mensaje = "Escribe '1': " + estadistica1Nombre + "  o '2': " + estadistica2Nombre;
        eleccionJugador = LectorBuffRead.leer(mensaje, 1, 2);

        double dificultadPrueba = Aleatoriedad.devolverNumero(0, (dificultad * 10));
        if (eleccionJugador == 1) {
            pruebaAptitud = (probabilidadEst1 >= dificultadPrueba);
        } else {
            pruebaAptitud = (probabilidadEst2 >= dificultadPrueba);
        }
        return pruebaAptitud;
    }

    public abstract boolean CombateEntero(double vida_enemigo, double dañoEnemigo)
            throws IOException, InterruptedException;

    public abstract double habilidadEspecial();

    public Partida getPartidaPersonaje() {
        return partidaPersonaje;
    }

    public void setPartidaPersonaje(Partida partidaPersonaje) {
        this.partidaPersonaje = partidaPersonaje;
    }
}