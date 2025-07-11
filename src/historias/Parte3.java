package historias;

import java.io.IOException;

import clases.PersonajePrinc;

import utilidades.TextosAscii;
/**
 * Clase en la que se juntan las historias de la cuarta parte de la historia
 */
public class Parte3 {
    /**
     * Metodo que junta todas las historias de la tercera parte de cada raza
     * @param personajePrincipal
     * @throws IOException
     * @throws InterruptedException
     */
    public static void Historia(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {

        String eleccionIntraHistoria = "";
        System.out.println("\nParte 3.\n");
        switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA_RAZA.getValue()]) {
            case 0:

                break;
            // Camino de los elfos
            case 1:
            TextosAscii.setVerde();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    // Historia 1: Zelda
                    case 1:
                        Elfos.ZeldaParte3(eleccionIntraHistoria, personajePrincipal);
                        break;
                    // Historia 2: Los protectores del bosque
                    case 2:
                        Elfos.LosProtectoresDelBosqueParte3(eleccionIntraHistoria,
                                personajePrincipal);
                        break;
                    // Historia 3: Las ruinas antiguas de Jistav
                    default:
                        // LasRuinasAntiguasDeJistav.LasRuinasAntiguasDeJistavParte3();
                        break;
                }
                break;
            // Camino de los Humanos
            case 2:
            TextosAscii.setAmarillo();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    // Historia 1: La mujer de morado
                    case 1:
                        Humanos.LaMujerDeMoradoParte3(personajePrincipal);
                        break;
                    // Historia 2: La guerra de reyes hermanos
                    case 2:
                        // LaGuerraDeReyesHermanos.LaGuerraDeReyesHermanosParte3();
                        break;
                    // Historia 3: El goblin del tutorial
                    default:
                        Humanos.ElGoblinDelTutorialParte3(personajePrincipal);
                        break;
                }
                break;
            // Camino de los enanos
            case 3:
            TextosAscii.setCyan();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    // Historia 1: El pueblo enano Owarf
                    case 1:
                        // ElPuebloEnanoOwarf.ElPuebloEnanoOwarfParte3();
                        break;
                    // Historia 2: La creacion del artefacto mitico
                    case 2:
                        Enanos.LaCreacionDelArtefactoMiticoParte3(personajePrincipal);
                        break;
                    // Historia 3: El codice maldito
                    default:
                        Enanos.ElCodiceMalditoParte3(personajePrincipal);
                        break;
                }
                break;
            // Camino de los orcos
            case 4:
            TextosAscii.setRojo();
                switch (personajePrincipal.getHistoria()[DatosHistoria.HISTORIA.getValue()]) {
                    // Historia 1: Mordor
                    case 1:
                        Orcos.MordorParte3(personajePrincipal);
                        break;
                    // Historia 2: La rebelion goblin
                    case 2:
                        Orcos.LaRebelionGoblinParte3(personajePrincipal);
                        break;
                    // Historia 3: La guerra del clan piel blanca
                    default:
                        // LaGuerraDelClanPielBlanca.LaGuerraDelClanPielBlancaParte3();
                        break;
                }
                break;
            default:
                break;
        }

    }
}
