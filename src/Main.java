
import java.io.IOException;

import historias.Historia;
import historias.Tutorial;
import utilidades.GuardadoPartida;
import utilidades.TextoLento;
import utilidades.TextosAscii;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean salirMenu = false;
        int numeroPartida = 0;
        TextosAscii.resetColor();
        System.out.println("Bienvenido a Iterum, el nexo de las historias.");
        do {
            
            TextoLento.printSlow("Elija una opcion del menu:");
            switch (utilidades.LectorBuffRead.leer("1: Historia Principal  2: Tutorial  3: Salir del juego", 1, 3)) {
                case 1:
                    numeroPartida = GuardadoPartida.elegirPartida();

                    //Y el hueco se lo lleva la historia para meter los datos luego
                    Historia.historia(numeroPartida);
                    break;

                case 2:
                    Tutorial.tutorial();
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    salirMenu = true;
                    break;

                default:
                    break;
            }
        } while (!salirMenu);

    }
}
