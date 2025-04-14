package historias;

import java.io.IOException;

import utilidades.LectorBuffRead;
import clases.Asesino;
import clases.Curandero;
import clases.Guerrero;
import clases.Mago;
import clases.Paladin;
import clases.Partida;
import clases.Razas;
import clases.Tanque;

public class Tutorial {
    public static void tutorial() throws IOException, InterruptedException {
        Partida partida = new Partida();
        String nombreJugador = LectorBuffRead.leer("Como vas a queres llamar a tu personaje:");
        Razas razaPersonaje = null;

        switch (LectorBuffRead.leer(
                "Cual quieres que sea la raza de tu personaje (Escriba un numero):\n1.-Enano, da un punto mas a la constitucion.\n2.-Humano, da 10 de dinero base mas; no sirve mucho en el tutorial.\n3.-Elfo, da un punto mas de agilidad.\n4.-Orco, da un punto mas de fuerza.",
                1, 4)) {
            case 1:
                // Raza enano
                razaPersonaje = Razas.Enano;// da un punto mas de Constitucion
                
                break;
            case 2:
                // Clase humano
                razaPersonaje = Razas.Humano;// da 10 mas de dinero base
                
                break;
            case 3:
                // Clase elfo
                razaPersonaje = Razas.Elfo;// da un punto mas de Dextreza
                
                break;
            case 4:
                // Clase orco
                razaPersonaje = Razas.Orco;// da un punto mas de Fuerza
                
                break;
        }

        switch (LectorBuffRead.leer(
                "Cual quieres que sea la clase de tu personaje (Escriba un numero):\n1.-Mago. 2.-Guerrero. 3.-Asesino.\n4.-Curandero. 5.-Paladin. 6.-Tanque.",
                1, 6)) {
            case 1:
                // Clase Mago
                partida.setPersonajePrincipalPartida(new Mago(nombreJugador, razaPersonaje, partida));
                break;
            case 2:
                // Clase guerrero
                partida.setPersonajePrincipalPartida(new Guerrero(nombreJugador, razaPersonaje, partida));
                break;
            case 3:
                // Clase asesino
                partida.setPersonajePrincipalPartida(new Asesino(nombreJugador, razaPersonaje, partida));
                break;
            case 4:
                // Clase curandero
                partida.setPersonajePrincipalPartida(new Curandero(nombreJugador, razaPersonaje, partida));
                break;
            case 5:
                // Clase paladin
                partida.setPersonajePrincipalPartida(new Paladin(nombreJugador, razaPersonaje, partida));
                break;
            case 6:
                // Clase tanque
                partida.setPersonajePrincipalPartida(new Tanque(nombreJugador, razaPersonaje, partida));
                break;
        }

        System.out.println("Bienvenido al tutorial");
        System.out.println("En este tutorial vas a jugar con la clase 'Mago'");
        System.out.println("Estadisticas:");
        for (int i = 0; i < partida.getPersonajePrincipalPartida().getEstadisticas().length; i++) {
            System.out.println(partida.getPersonajePrincipalPartida().getNombreEstadistica(i) + " = "
                    + partida.getPersonajePrincipalPartida().getEstadisticas()[i]);
        }
        utilidades.LectorBuffRead.continuarHistoria();
        System.out.println("Equipamiento:");
        System.out.print("Mano 1: " + partida.getPersonajePrincipalPartida().getEquipamiento()[0]);
        System.out.print("  Mano 2: " + partida.getPersonajePrincipalPartida().getEquipamiento()[1]);
        System.out.println("  Cabeza: " + partida.getPersonajePrincipalPartida().getEquipamiento()[2]);
        System.out.print("Cuerpo: " + partida.getPersonajePrincipalPartida().getEquipamiento()[3]);
        System.out.println("  Pies: " + partida.getPersonajePrincipalPartida().getEquipamiento()[4]);
        utilidades.LectorBuffRead.continuarHistoria();

        System.out.println("Ahora vamos a tener un combate ejemplo contra un goblin tutorial:");
        String salirCombate;
        do {
            if (partida.getPersonajePrincipalPartida().CombateEntero(Enemigos.GOBLIN.getVida(),
                    Enemigos.GOBLIN.getDaño())) {
                System.out.println("Has vencido al goblin, le has quitado toda la vida antes de tu morir");
            } else {
                System.out.println("Has perdido contra el goblin, has perdido toda tu vida antes de derrotarlo.");
            }
            salirCombate = utilidades.LectorBuffRead.leer("¿Quieres volver a pelear contra el goblin? escribe 'si'");
        } while (salirCombate.equalsIgnoreCase("si"));

        System.out.println("Tambien vamos a dar un ejemplo de otra mecanica del juego, las pruebas de aptitud");
        do {
            if (partida.getPersonajePrincipalPartida().pruebaAptitud(1, 1, 2)) {
                System.out.println("Has superado la prueba.");
            } else {
                System.out.println("No has superado la prueba");
            }
            salirCombate = utilidades.LectorBuffRead.leer("¿Quieres volver a probar la prueba? escribe 'si'");
        } while (salirCombate.equalsIgnoreCase("si"));

        System.out.println("Ya se ha terminado el tutorial, ya estas preparado para comenzar con la historia principal.\n");
    }
}
