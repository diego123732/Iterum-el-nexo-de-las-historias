package historias;

import java.io.IOException;

import utilidades.LectorBuffRead;
import utilidades.TextoLento;
import utilidades.TextosAscii;
import clases.Asesino;
import clases.Curandero;
import clases.Guerrero;
import clases.Mago;
import clases.Ocupaciones;
import clases.Paladin;
import clases.Partida;
import clases.PersonajePrinc;
import clases.Razas;
import clases.Tanque;

public class Tutorial {
    private static void TablaEstadisticasPersonajes () {

        PersonajePrinc mago = new Mago("Tutorial", Razas.Humano, null);
        PersonajePrinc guerrero = new Guerrero("Tutorial", Razas.Humano, null);
        PersonajePrinc asesino = new Asesino("Tutorial", Razas.Humano, null);
        PersonajePrinc paladin = new Paladin("Tutorial", Razas.Humano, null);
        PersonajePrinc tanque = new Tanque("Tutorial", Razas.Humano, null);
        PersonajePrinc curandero = new Curandero("Tutorial", Razas.Humano, null);

        System.out.println("╔" + "═".repeat(15) + "╦" + "═".repeat(12) + "╦" + "═".repeat(12) 
        + "╦" + "═".repeat(12) + "╦" + "═".repeat(12) + "╦" + "═".repeat(12) + "╦" 
        + "═".repeat(17) + "╦" + "═".repeat(11) + "╗");
        System.out.printf("║ %13s ║%s ║%s ║%s ║%s ║%s ║%s      ║ %s ║%n","Estadistica","Estadistica"
        ,"Estadistica","Estadistica","Estadistica","Estadistica","Estadistica", "Personaje");
        System.out.printf("║ %8s      ║%6s      ║%6s      ║%6s      ║%6s      ║%6s      ║ %s      ║  %8s ║%n",
         1,2,3,4,5,6, "Prominente", "");
         System.out.println("╠" + "═".repeat(15) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) 
         + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" 
         + "═".repeat(17) + "╬" + "═".repeat(11) + "╣");

        System.out.printf("║ %8s      ║%6s      ║%6s      ║%6s      ║%6s      ║%6s      ║ %s     ║  %s  ║%n"
        ,asesino.getEstadisticas()[0],asesino.getEstadisticas()[1],asesino.getEstadisticas()[2],asesino.getEstadisticas()[3]
        ,asesino.getEstadisticas()[4],asesino.getEstadisticas()[5], "Destreza(1)", Ocupaciones.Asesino);
        System.out.println("╠" + "═".repeat(15) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) 
         + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" 
         + "═".repeat(17) + "╬" + "═".repeat(11) + "╣");
        
        
         System.out.printf("║ %8s      ║%6s      ║%6s      ║%6s      ║%6s      ║%6s      ║ %s       ║  %s ║%n"
        ,guerrero.getEstadisticas()[0],guerrero.getEstadisticas()[1],guerrero.getEstadisticas()[2],guerrero.getEstadisticas()[3]
        ,guerrero.getEstadisticas()[4],guerrero.getEstadisticas()[5], "Fuerza(1)", Ocupaciones.Guerrero);
        System.out.println("╠" + "═".repeat(15) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) 
         + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" 
         + "═".repeat(17) + "╬" + "═".repeat(11) + "╣");

         System.out.printf("║ %8s      ║%6s      ║%6s      ║%6s      ║%6s      ║%6s      ║ %s ║  %s     ║%n"
        ,mago.getEstadisticas()[0],mago.getEstadisticas()[1],mago.getEstadisticas()[2],mago.getEstadisticas()[3]
        ,mago.getEstadisticas()[4],mago.getEstadisticas()[5], "Inteligencia(1)", Ocupaciones.Mago);
        System.out.println("╠" + "═".repeat(15) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) 
         + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" 
         + "═".repeat(17) + "╬" + "═".repeat(11) + "╣");

         System.out.printf("║ %8s      ║%6s      ║%6s      ║%6s      ║%6s      ║%6s      ║ %s     ║  %s║%n"
        ,curandero.getEstadisticas()[0],curandero.getEstadisticas()[1],curandero.getEstadisticas()[2],curandero.getEstadisticas()[3]
        ,curandero.getEstadisticas()[4],curandero.getEstadisticas()[5], "Caracter(1)", Ocupaciones.Curandero);
        System.out.println("╠" + "═".repeat(15) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) 
         + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" 
         + "═".repeat(17) + "╬" + "═".repeat(11) + "╣");

         System.out.printf("║ %8s      ║%6s      ║%6s      ║%6s      ║%6s      ║%6s      ║ %s ║  %s   ║%n"
        ,tanque.getEstadisticas()[0],tanque.getEstadisticas()[1],tanque.getEstadisticas()[2],tanque.getEstadisticas()[3]
        ,tanque.getEstadisticas()[4],tanque.getEstadisticas()[5], "Constitucion(1)", Ocupaciones.Tanque);
        System.out.println("╠" + "═".repeat(15) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) 
         + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" + "═".repeat(12) + "╬" 
         + "═".repeat(17) + "╬" + "═".repeat(11) + "╣");

         System.out.printf("║ %8s      ║%6s      ║%6s      ║%6s      ║%6s      ║%6s      ║ %s    ║  %s  ║%n"
        ,paladin.getEstadisticas()[0],paladin.getEstadisticas()[1],paladin.getEstadisticas()[2],paladin.getEstadisticas()[3]
        ,paladin.getEstadisticas()[4],paladin.getEstadisticas()[5], "Sabiduria(1)", Ocupaciones.Paladin);
        System.out.println("╚" + "═".repeat(15) + "╩" + "═".repeat(12) + "╩" + "═".repeat(12) 
         + "╩" + "═".repeat(12) + "╩" + "═".repeat(12) + "╩" + "═".repeat(12) + "╩" 
         + "═".repeat(17) + "╩" + "═".repeat(11) + "╝");
    }

    private static void EquipamientoDañoBase () {
        PersonajePrinc mago = new Mago("Tutorial", Razas.Humano, null);
        PersonajePrinc guerrero = new Guerrero("Tutorial", Razas.Humano, null);
        PersonajePrinc asesino = new Asesino("Tutorial", Razas.Humano, null);
        PersonajePrinc paladin = new Paladin("Tutorial", Razas.Humano, null);
        PersonajePrinc tanque = new Tanque("Tutorial", Razas.Humano, null);
        PersonajePrinc curandero = new Curandero("Tutorial", Razas.Humano, null);
        System.out.println(TextosAscii.getRESET());
        System.out.println(Ocupaciones.Asesino + 
        ": Mano1:"+ TextosAscii.getVERDE() + asesino.getEquipamiento()[0] + TextosAscii.getRESET()
        + ", Mano2:"+ TextosAscii.getVERDE() + asesino.getEquipamiento()[1] + TextosAscii.getRESET() + 
        ", Cabeza:"+ TextosAscii.getVERDE() + asesino.getEquipamiento()[2] + TextosAscii.getRESET()
        + ", Cuerpo:"+ TextosAscii.getVERDE() + asesino.getEquipamiento()[3] + TextosAscii.getRESET() + 
        ", Pies:"+ TextosAscii.getVERDE() + asesino.getEquipamiento()[4] + TextosAscii.getRESET()
        + ", Daño: "+ TextosAscii.getROJO() + Double.toString(asesino.DañoSegunArmas()) );
        System.out.println(TextosAscii.getRESET());

        System.out.println(Ocupaciones.Guerrero + 
        ": Mano1: "+ TextosAscii.getVERDE() + guerrero.getEquipamiento()[0] + TextosAscii.getRESET()
        + ", Mano2: " + guerrero.getEquipamiento()[1] + 
        ", Cabeza: "+ TextosAscii.getVERDE() + guerrero.getEquipamiento()[2] + TextosAscii.getRESET()
        + ", Cuerpo: "+ TextosAscii.getVERDE() + guerrero.getEquipamiento()[3] + TextosAscii.getRESET() + 
        ", Pies: "+ TextosAscii.getVERDE() + guerrero.getEquipamiento()[4] + TextosAscii.getRESET()
        + ", Daño: "+ TextosAscii.getROJO() + Double.toString(guerrero.DañoSegunArmas()) );
        System.out.println(TextosAscii.getRESET());

        System.out.println(Ocupaciones.Mago + 
        ": Mano1: "+ TextosAscii.getVERDE() + mago.getEquipamiento()[0] + TextosAscii.getRESET()
        + ", Mano2: " + mago.getEquipamiento()[1] + 
        ", Cabeza: "+ TextosAscii.getVERDE() + mago.getEquipamiento()[2] + TextosAscii.getRESET()
        + ", Cuerpo: "+ TextosAscii.getVERDE() + mago.getEquipamiento()[3] + TextosAscii.getRESET() + 
        ", Pies: "+ TextosAscii.getVERDE() + mago.getEquipamiento()[4] + TextosAscii.getRESET()
        + ", Daño: "+ TextosAscii.getROJO() + Double.toString(mago.DañoSegunArmas()) );
        System.out.println(TextosAscii.getRESET());

        System.out.println(Ocupaciones.Curandero + 
        ": Mano1: "+ TextosAscii.getVERDE() + curandero.getEquipamiento()[0] + TextosAscii.getRESET()
        + ", Mano2: " + curandero.getEquipamiento()[1] + 
        ", Cabeza: "+ TextosAscii.getVERDE() + curandero.getEquipamiento()[2] + TextosAscii.getRESET()
        + ", Cuerpo: " + curandero.getEquipamiento()[3] + 
        ", Pies: "+ TextosAscii.getVERDE() + curandero.getEquipamiento()[4]+ TextosAscii.getRESET()
        + ", Daño: "+ TextosAscii.getROJO() + Double.toString(curandero.DañoSegunArmas()) );
        System.out.println(TextosAscii.getRESET());

        System.out.println(Ocupaciones.Tanque + 
        ": Mano1: "+ TextosAscii.getVERDE() + tanque.getEquipamiento()[0] + TextosAscii.getRESET()
        + ", Mano2: "+ TextosAscii.getVERDE() + tanque.getEquipamiento()[1] + TextosAscii.getRESET() + 
        ", Cabeza: "+ TextosAscii.getVERDE() + tanque.getEquipamiento()[2] + TextosAscii.getRESET()
        + ", Cuerpo: "+ TextosAscii.getVERDE() + tanque.getEquipamiento()[3] + TextosAscii.getRESET() + 
        ", Pies: "+ TextosAscii.getVERDE() + tanque.getEquipamiento()[4] + TextosAscii.getRESET()
        + ", Daño: "+ TextosAscii.getROJO() + Double.toString(tanque.DañoSegunArmas()) );
        System.out.println(TextosAscii.getRESET());

        System.out.println(Ocupaciones.Paladin + 
        ": Mano1: "+ TextosAscii.getVERDE() + paladin.getEquipamiento()[0] + TextosAscii.getRESET()
        + ", Mano2: "+ TextosAscii.getVERDE() + paladin.getEquipamiento()[1] + TextosAscii.getRESET()
         + ", Cabeza: "+ TextosAscii.getVERDE() + paladin.getEquipamiento()[2] + TextosAscii.getRESET()
        + ", Cuerpo: "+ TextosAscii.getVERDE() + paladin.getEquipamiento()[3] + TextosAscii.getRESET() + 
        ", Pies: "+ TextosAscii.getVERDE() + paladin.getEquipamiento()[4] + TextosAscii.getRESET()
        + ", Daño: "+ TextosAscii.getROJO() + Double.toString(paladin.DañoSegunArmas()) );
        System.out.println(TextosAscii.getRESET());
    }
    public static void tutorial() throws IOException, InterruptedException {
        TextoLento.printSlow("Bienvenido al tutorial");
        TextoLento.printSlow("En este tutorial vas a aprender las principales mecanicas que tiene este videojuego para que te puedas ir acostumbrando a la partida.");
        TextoLento.printSlow("Iterum no es un juego complicado pero si que tiene eleciones complicadas a lo largo de las historias, \npor lo que el primer consejo es que tengas cuidado con los caminos que quieras tomar.");
        TextoLento.printSlow("Otra cuestion decisiva es la eleccion de personajes puesto que cada uno tiene un estilo de juego diferente.");
        TextoLento.printSlow("Cada uno de estos personajes se dividen por unas estadisticas diferentes; adicionalmente cada uno tiene un equipamiento que favorece a sus estadisticas y una habilidad unica diferente.");
        TextoLento.printSlow("A continuacion tienes una tabla con las estadisticas y habilidades de cada personaje:");
        LectorBuffRead.continuarHistoria();
        TablaEstadisticasPersonajes();
        LectorBuffRead.continuarHistoria();

        TextoLento.printSlow("Tambien los equipamientos que tienen los personajes al empezar la historia y el daño que hacen al empezar.");
        EquipamientoDañoBase();
        LectorBuffRead.continuarHistoria();
        Partida partida = new Partida();
        String nombreJugador = "Tutorial";
        Razas razaPersonaje = null;

        TextoLento.printSlow("Ahora vamos a hacer una simulacion de como seria el inicio de una partida en la historia principal;");
        TextoLento.printSlow("Primero te pediria que creases tu personaje para la historia:");
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
        System.out.println("Daño base: " + partida.getPersonajePrincipalPartida().DañoSegunArmas());
        System.out.println();
        System.out.println("Como ves, la clase hace que el daño que inflijas sea diferente segun que clase escojas.");
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
