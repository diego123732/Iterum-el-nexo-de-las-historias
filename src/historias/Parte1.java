package historias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import clases.PersonajePrinc;

import historias.Elfos.LasRuinasAntiguasDeJistav;
import historias.Elfos.LosProtectoresDelBosque;
import historias.Elfos.Zelda;
import historias.Enanos.ElCodiceMaldito;
import historias.Enanos.ElPuebloEnanoOwarf;
import historias.Enanos.LaCreacionDelArtefactoMitico;
import historias.Humanos.ElGoblinDelTutorial;
import historias.Humanos.LaGuerraDeReyesHermanos;
import historias.Humanos.LaMujerDeMorado;
import historias.Orcos.LaGuerraDelClanPielBlanca;
import historias.Orcos.LaRebelionGoblin;
import historias.Orcos.Mordor;

import utilidades.Aleatoriedad;
import utilidades.TextoLento;
import utilidades.TextosAscii;

/**
 * Clase en la que se juntan las historias de la primera parte de la historia junto con el inicio de esta
 */
public class Parte1 {

    /**
     * Metodo de la historia primera parte en donde el jugador elige el camino que
     * va a tomar la historia
     * y tiene una pelea a modo de iniciacion contra un goblin
     * 
     * @throws IOException
     */
    public static void Historia(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
        Random random = new Random();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String texto_base2 = "Ante tu persistente temperamento niegas que la fuerza del viento determine tu destino, y miras al horizonte.";
        String texto_destino1Enanos = "A tu derecha un camino de enanos, sumido en la innovacion y en el progreso caracteristico de estos pequeños genios.";
        String textoDestino1Elfos = "Y a tu izquierda un bosque que irradia un brillo de espiritus y el olor de la sangre de los protectores del bosque.";
        String texto_destino2Humanos = "A tu derecha se pueden apreciar los reinos humanos, sumidos en la codicia y en su obsesion de poder.";
        String textoDestino2Orcos = "Y a tu izquierda puedes apreciar unos terrenos desolados y oscuros, casi de forma artificial.\nDe ellos irradia un sentimiento de odio muy profundo hacia cualquer cosa.";
        String texto_base3 = "Que camino deseas escoger valiente aventurero (Introduzca izquierda o derecha en funcion de hacia donde quiera ir).";
        String victoria_goblin = "Termina la batalla, el goblin yace en el suelo desangrado, tu te incorporas y dices:-No sera posible que un misero goblin bloquee mi camino. Recibes 10 monedas";
        String derrota_goblin = "Termina la batalla, yaces en el suelo, con tantos cortes que te es imposible levantarte, has muerto";
        String opcion1_respuesta;
        boolean booleansalir = false;
        int numeroSuerteDestino = random.nextInt(2) + 1;
        // primera pantalla videojuego
        if (numeroSuerteDestino == 1) {// una vertiente de dos razas
            TextoLento.printSlow(texto_base2);
            TextosAscii.setCyan();TextoLento.printSlow(texto_destino1Enanos);
            TextosAscii.setVerde();TextoLento.printSlow(textoDestino1Elfos);TextosAscii.resetColor();
            TextoLento.printSlow(texto_base3);
        } else {// la otra vertiente
            TextoLento.printSlow(texto_base2);
            TextosAscii.setAmarillo();TextoLento.printSlow(texto_destino2Humanos);
            TextosAscii.setRojo();TextoLento.printSlow(textoDestino2Orcos);TextosAscii.resetColor();
            TextoLento.printSlow(texto_base3);
        }
        do {
            opcion1_respuesta = buffer.readLine();// pilla la respuesta derecha o izquierda
            if (opcion1_respuesta.equals("izquierda") || opcion1_respuesta.equals("derecha")) {
                booleansalir = true;
            } else {
                System.out.println("Te has equivocado de respuesta");
            }
        } while (booleansalir == false);

        TextoLento.printSlow("Te aventuras hacia la " + opcion1_respuesta
                + ".\nDespues de un no muy largo trayecto aparece ante ti un pequeño engendro de color verde, un goblin.\nEste se aproxima hacia ti sin buenas intenciones");
        System.out.println("¡Que comience la batalla!(Primera batalla, batalla tutorial)");// Batalla tutorial contra
                                                                                           // goblin, clasico

        // batalla inicio contra goblin tutorial
        if (personajePrincipal.CombateEntero(Enemigos.GOBLIN.getVida(), Enemigos.GOBLIN.getDaño())) {
            System.out.println(victoria_goblin);
            MetodoCaminos(numeroSuerteDestino, opcion1_respuesta, personajePrincipal);
        } else {
            System.out.println(derrota_goblin);
        }

    }

    /**
     * Metodo de historia primera parte que muestra la primera parte de la historia
     * segun el camino que haya elegido el jugador, si derecha o izquierda, y un numero
     * aleatorio
     * <p>
     * Los metodos de las historias estan en el archivo Historias
     * 
     * @param numeroDestino,camino
     * @throws IOException
     * @see historias
     */
    public static void MetodoCaminos(int numeroDestino, String camino, PersonajePrinc personajePrincipal)
            throws IOException, InterruptedException {

        String elecionIntrahistoria = "";
        String elecionIntrahistoria2 = "";
        String elecionIntrahistoria3 = "";
        int numeroAleatorio;
        switch (numeroDestino) {
            case 1:
                if (camino.equals("derecha")) {// Camino enanos
                    TextosAscii.setCyan();
                    numeroAleatorio = Aleatoriedad.devolverNumero(1, 3);// numero random para dividir entre las tres historias
                    System.out.println("\nHistoria " + numeroAleatorio + "/3 Enanos");
                    System.out.println("Parte 1.\n");
                    switch (numeroAleatorio) {
                        case 1:// Camino 1: El pueblo de Owarf
                            ElPuebloEnanoOwarf.ElPuebloEnanoOwarfParte1(elecionIntrahistoria3, personajePrincipal);
                            break;

                        case 2:// Camino 2: La creación del artefacto mítico
                            LaCreacionDelArtefactoMitico.LaCreacionDelArtefactoMiticoParte1(personajePrincipal);
                            break;

                        default:// Camino 3: El codice maldito.
                            ElCodiceMaldito.ElCodiceMalditoParte1(personajePrincipal);
                            break;
                    }

                }

                else {// Camino elfos

                    TextosAscii.setVerde();
                    numeroAleatorio = Aleatoriedad.devolverNumero(1, 3);
                    System.out.println("\nHistoria " + numeroAleatorio + "/3 Elfos");
                    System.out.println("Parte 1.\n");
                    switch (numeroAleatorio) {
                        case 1:// Camino uno: Zelda
                            Zelda.ZeldaParte1(personajePrincipal);
                            break;
                        case 2:// Camino dos: Los protectores del bosque
                            LosProtectoresDelBosque.LosProtectoresDelBosqueParte1(elecionIntrahistoria,
                                    personajePrincipal);
                            break;

                        default:// Camino tres: Las ruinas antiguas de Jistav
                            LasRuinasAntiguasDeJistav.LasRuinasAntiguasDeJistavParte1(elecionIntrahistoria3,
                                    personajePrincipal);
                            break;
                    }
                }
                break;

            default:
                if (camino.equals("derecha")) {// Camino humanos

                    TextosAscii.setAmarillo();
                    numeroAleatorio = Aleatoriedad.devolverNumero(1, 3);
                    System.out.println("\nHistoria " + numeroAleatorio + "/3 Humanos");
                    System.out.println("Parte 1.\n");
                    switch (numeroAleatorio) {
                        case 1:// Camino uno: La mujer de morado
                            LaMujerDeMorado.LaMujerDeMoradoParte1(personajePrincipal);
                            break;
                        case 2:// Camino dos: La guerra de reyes hermanos
                            LaGuerraDeReyesHermanos.LaGuerraDeReyesHermanosParte1(elecionIntrahistoria,
                                    elecionIntrahistoria2, elecionIntrahistoria3, personajePrincipal);
                            break;

                        default:// Camino tres: El goblin del tutorial
                            ElGoblinDelTutorial.ElGoblinDelTutorialParte1(personajePrincipal);
                            break;
                    }
                }

                else {// Camino orcos

                    TextosAscii.setRojo();
                    numeroAleatorio = Aleatoriedad.devolverNumero(1, 3);
                    System.out.println("\nHistoria " + numeroAleatorio + "/3 Orcos");
                    System.out.println("Parte 1.\n");
                    switch (numeroAleatorio) {
                        case 1:// Camino uno: Mordor
                            Mordor.MordorParte1(personajePrincipal);
                            break;
                        case 2:// Camino dos:El concilio de la muerte
                            LaRebelionGoblin.LaRebelionGoblinParte1(personajePrincipal);
                            break;

                        default:// Camino tres: La guerra del clan piel blanca
                            LaGuerraDelClanPielBlanca.LaGuerraDelClanPielBlancaParte1(elecionIntrahistoria,
                                    personajePrincipal);
                            break;
                    }
                }
                break;
        }
        System.out.println();

    }
}