package clases;

import java.io.IOException;

import utilidades.TextosAscii;

public class Guerrero extends PersonajePrinc {
    public Guerrero(String nombre, Razas raza, Partida partida) {
        super(
            nombre, 
            raza, 
            Ocupaciones.Guerrero, 
            15, 
            Ocupaciones.Guerrero.getEstadisticas(), // Estadísticas del enum de ocupaciones
            Ocupaciones.Guerrero.getEquipamiento(), // Equipamiento del enum de ocupaciones
            partida
        );
    }

    /**
     * Metodo que devuelve la vida del personaje al terminar el combate
     * <p>
     * Adicionalmente utiliza un metodo de habilidad especial,
     * en este caso al ser la clase Guerrero reduce el daño que va a recibir y
     * aumenta el daño en funcion de su Fuerza dividido entre dos, estadistica 2 de 6.
     * 
     * @param vida_enemigo,damageEnemigo
     * @return devuelve un tipo boolean, si el jugador ha ganado o perdido el
     *         combate.
     * @throws IOException
     * @see batalla
     * @see habilidadEspecial
     * @see devolverVida
     * @see TextosAscii
     */
    public boolean CombateEntero(double vidaEnemigo, double damageEnemigo) throws IOException, InterruptedException {

        double vidaEnemigoCombate = vidaEnemigo;
        double damageEnemigoCombate = damageEnemigo;
        double vidaPersonajeCombate = devolverVida();
        double vidaPersonajeMaxima = vidaPersonajeCombate;
        double damagePersonajeCombate;
        double dadoVeinte;
        int contadorHabilidadEspecial = 3;

        TextosAscii.resetColor();//Para resetear el color a blanco de posibles colores que traigan las historias
        System.out.println("Comienza el combate");
        do {
            double[] estadisticasPersonajeCombate = Combate();
            damagePersonajeCombate = estadisticasPersonajeCombate[0];
            dadoVeinte = estadisticasPersonajeCombate[1];
            if (contadorHabilidadEspecial == 0) {// 101 == 5
                damagePersonajeCombate += habilidadEspecial();
                vidaPersonajeCombate += 0;
                damageEnemigoCombate -= habilidadEspecial();
                contadorHabilidadEspecial = 3;
            } else {
                contadorHabilidadEspecial--;
            }
            vidaEnemigoCombate -= damagePersonajeCombate;
            vidaPersonajeCombate -= damageEnemigoCombate;
            TextosAscii.pintarCombate(vidaEnemigoCombate, vidaEnemigo, vidaPersonajeCombate, 
            vidaPersonajeMaxima, damageEnemigoCombate, damagePersonajeCombate, dadoVeinte);

            // Se añaden estadisticas a la partida
            // Se añade al daño total el daño cada vez que golpea
            this.getPartidaPersonaje()
                    .setDañoTotalPartida((this.getPartidaPersonaje().getDañoTotalPartida() + damagePersonajeCombate));
        } while (vidaEnemigoCombate > 0 && vidaPersonajeCombate > 0);
        System.out.println("\n");
        return (vidaPersonajeCombate > 0);
    }

    /**
     * Metodo que devuelve un numero en funcion de la estadistica base mas
     * prominente del personaje.
     */
    public double habilidadEspecial() {
        return (this.getEstadisticas()[1] / 2);
    }
}
