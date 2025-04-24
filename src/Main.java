
import java.io.IOException;

import historias.Historia;
import historias.Tutorial;
import utilidades.GuardadoPartida;
import utilidades.ManipulacionBD;
import utilidades.TextoLento;
import utilidades.TextosAscii;
/**
 * Clase base de la aplicación
 */
public class Main {
    /**
     * Metodo Principal 'main' de la aplicación
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ManipulacionBD.CrearBDNoExistente();
        boolean salirMenu = false;
        int numeroPartida = 0;
        TextosAscii.resetColor();
        System.out.println(TextosAscii.getTextoBienvenida());
        TextoLento.printSlow("Bienvenido a Iterum, el nexo de las historias.");
        TextoLento.printSlow("Un mundo donde cada decisión que tomes abrirá caminos únicos llenos de desafíos y descubrimientos.");
        TextoLento.printSlow("Iterum es un RPG basado en texto, donde la narrativa cobra vida y tú eres el protagonista de tu propia aventura.");
        TextoLento.printSlow("Explorarás un universo marcado por cuatro razas ancestrales: Orcos, Elfos, Enanos y Humanos.");
        TextoLento.printSlow("Cada una con su propia historia, cultura y forma de ver el mundo.");
        TextoLento.printSlow("Prepárate para tomar decisiones difíciles, enfrentarte a lo desconocido y dejar tu huella en este mundo cambiante.");
                System.out.println();
        do {

            TextoLento.printSlow("Elija una opcion del menu:");
            switch (utilidades.LectorBuffRead.leer("1: Historia Principal  2: Tutorial 3: Partidas Guardadas  4: Salir del juego", 1, 4)) {
                case 1:
                    numeroPartida = GuardadoPartida.elegirPartida();

                    // Y el hueco se lo lleva la historia para meter los datos luego
                    Historia.historia(numeroPartida);
                    break;

                case 2:
                    Tutorial.tutorial();
                    break;

                case 3:
                    GuardadoPartida.devolverContenidoArchivo();
                    break;

                case 4:
                    TextoLento.printSlow("Saliendo...");
                    salirMenu = true;
                    break;

                default:
                    break;
            }
        } while (!salirMenu);

    }
}
