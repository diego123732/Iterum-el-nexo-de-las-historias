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
 * Clase en la que se juntan las historias de la segunda parte de la historia
 */
public class Parte2 {
    /**
     * Metodo que junta todas las historias de la segunda parte de cada raza
     * @param personajePrincipal
     * @throws IOException
     * @throws InterruptedException
     */
    public static void Historia(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
        String eleccionIntraHistoria = "";
        System.out.println("\nParte 2.\n");
        switch (personajePrincipal.getHistoria()[0]) {

            // Camino de los elfos
            case 1:
                TextosAscii.setVerde();
                switch (personajePrincipal.getHistoria()[1]) {
                    // Historia 1: Zelda
                    case 1:
                        Zelda.ZeldaParte2(personajePrincipal);
                        break;
                    // Historia 2: Los protectores del bosque
                    case 2:
                        LosProtectoresDelBosque.LosProtectoresDelBosqueParte2(eleccionIntraHistoria,
                                personajePrincipal);
                        break;
                    // Historia 3: Las ruinas antiguas de Jistav
                    default:
                        // LasRuinasAntiguasDeJistav.LasRuinasAntiguasDeJistavParte2();
                        break;
                }
                break;
            // Camino de los Humanos
            case 2:
            TextosAscii.setAmarillo();
                switch (personajePrincipal.getHistoria()[1]) {
                    // Historia 1: La mujer de morado
                    case 1:
                        LaMujerDeMorado.LaMujerDeMoradoParte2(personajePrincipal);
                        break;
                    // Historia 2: La guerra de reyes hermanos
                    case 2:
                        // LaGuerraDeReyesHermanos.LaGuerraDeReyesHermanosParte2();
                        break;
                    // Historia 3: El goblin del tutorial
                    default:
                        ElGoblinDelTutorial.ElGoblinDelTutorialParte2(personajePrincipal);
                        break;
                }
                break;
            // Camino de los enanos
            case 3:
            TextosAscii.setCyan();
                switch (personajePrincipal.getHistoria()[1]) {
                    // Historia 1: El pueblo enano Owarf
                    case 1:
                        // ElPuebloEnanoOwarf.ElPuebloEnanoOwarfParte2();
                        break;
                    // Historia 2: La creacion del artefacto mitico
                    case 2:
                        LaCreacionDelArtefactoMitico.LaCreacionDelArtefactoMiticoParte2(personajePrincipal);
                        break;
                    // Historia 3: El codice maldito
                    default:
                        ElCodiceMaldito.ElCodiceMalditoParte2(personajePrincipal);
                        break;
                }
                break;
            // Camino de los orcos
            case 4:
            TextosAscii.setRojo();
                switch (personajePrincipal.getHistoria()[1]) {
                    // Historia 1: Mordor
                    case 1:
                        Mordor.MordorParte2(personajePrincipal);
                        break;
                    // Historia 2: La rebelion goblin
                    case 2:
                        LaRebelionGoblin.LaRebelionGoblinParte2(personajePrincipal);
                        break;
                    // Historia 3: La guerra del clan piel blanca
                    default:
                        // LaGuerraDelClanPielBlanca.LaGuerraDelClanPielBlancaParte2();
                        break;
                }
                break;
            default:
                break;
        }
    }
}
