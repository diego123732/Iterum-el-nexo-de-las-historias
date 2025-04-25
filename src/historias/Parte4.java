package historias;

import java.io.IOException;

import clases.PersonajePrinc;
import historias.Elfos.LosProtectoresDelBosque;
import historias.Elfos.Zelda;
import historias.Enanos.ElCodiceMaldito;
import historias.Enanos.LaCreacionDelArtefactoMitico;
import historias.Humanos.ElGoblinDelTutorial;
import historias.Humanos.LaMujerDeMorado;
import historias.Orcos.LaRebelionGoblin;
import historias.Orcos.Mordor;
import utilidades.TextosAscii;

/**
 * Clase en la que se juntan las historias de la cuarta parte de la historia
 */
public class Parte4 {

    /**
     * Metodo que junta todas las historias de la cuarta parte de cada raza
     * @param personajePrincipal
     * @throws IOException
     * @throws InterruptedException
     */
    public static void Historia(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
        String eleccionIntraHistoria = "";
        System.out.println("\nParte 4.\n");
        switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA_RAZA.getValue()]) {

            // Camino de los elfos
            case 1:
            TextosAscii.setVerde();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    case 1:
                        // Historia 1: Zelda
                        Zelda.ZeldaParte4(personajePrincipal);
                        break;
                    // Historia 2: Los protectores del bosque
                    case 2:
                        LosProtectoresDelBosque.LosProtectoresDelBosqueParte4(eleccionIntraHistoria,
                                personajePrincipal);
                        break;
                    // Historia 3: Las ruinas antiguas de Jistav
                    default:
                        // LasRuinasAntiguasDeJistav.LasRuinasAntiguasDeJistavParte4();
                        break;
                }
                break;

            // Camino de los Humanos
            case 2:
            TextosAscii.setAmarillo();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    // Historia 1: La mujer de morado
                    case 1:
                        LaMujerDeMorado.LaMujerDeMoradoParte4(personajePrincipal);
                        break;
                    // Historia 2: La guerra de reyes hermanos
                    case 2:
                        // LaGuerraDeReyesHermanos.LaGuerraDeReyesHermanosParte4();
                        break;
                    // Historia 3: El goblin del tutorial
                    default:
                        ElGoblinDelTutorial.ElGoblinDelTutorialParte4(personajePrincipal);
                        break;
                }
                break;
            // Camino de los enanos
            case 3:
            TextosAscii.setCyan();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    // Historia 1: El pueblo enano Owarf
                    case 1:
                        // ElPuebloEnanoOwarf.ElPuebloEnanoOwarfParte4();
                        break;
                    // Historia 2: La creacion del artefacto mitico
                    case 2:
                        LaCreacionDelArtefactoMitico.LaCreacionDelArtefactoMiticoParte4(personajePrincipal);
                        break;
                    // Historia 3: El codice maldito
                    default:
                        ElCodiceMaldito.ElCodiceMalditoParte4(personajePrincipal);
                        break;
                }
                break;
            // Camino de los orcos
            case 4:
            TextosAscii.setRojo();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    // Historia 1: Mordor
                    case 1:
                        Mordor.MordorParte4(personajePrincipal);
                        break;
                    // Historia 2: La rebelion goblin
                    case 2:
                        LaRebelionGoblin.LaRebelionGoblinParte4(personajePrincipal);
                        break;
                    // Historia 3: La guerra del clan piel blanca
                    default:
                        // LaGuerraDelClanPielBlanca.LaGuerraDelClanPielBlancaParte4();
                        break;
                }
                break;
            default:
                break;
        }

    }
}