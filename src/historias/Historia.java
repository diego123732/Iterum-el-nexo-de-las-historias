package historias;

import java.io.IOException;

import utilidades.Aleatoriedad;
import utilidades.GuardadoPartida;
import utilidades.LectorBuffRead;
import utilidades.ManipulacionBD;
import utilidades.TextoLento;
import clases.Asesino;
import clases.Curandero;
import clases.Guerrero;
import clases.Mago;
import clases.Paladin;
import clases.Partida;
import clases.PlayerData;
import clases.Razas;
import clases.Tanque;


public class Historia {
    
    public static void MensajeBase () {
        String Mensaje_base = "Bienvenido";
        //Serie de mensajes que pueden aparecer
        String texto_base1 = "Inicias tu aventura, el mundo te desea suerte. ";
        String texto_base_1 = "La necesitaras";
        String texto_base_2 = "Perder solo es el primer paso para ganar.";
        String texto_base_3 = "Por ahora...";
        String texto_base_4 = "No todo es lo que parece.";
        String texto_base_5 = "El mejor ataque es una buena defensa";
        int numeroRandom = Aleatoriedad.devolverNumero(1, 5);

        switch (numeroRandom) {
            case 1:
                Mensaje_base = texto_base1 +texto_base_1;
                break;

            case 2:
                Mensaje_base = texto_base1 +texto_base_2;
                break;

            case 3:
                Mensaje_base = texto_base1 +texto_base_3;
                break;

            case 4:
                Mensaje_base = texto_base1 +texto_base_4;
                break;

            case 5:
                Mensaje_base = texto_base1 + texto_base_5;
                break;
        }
        System.out.println(Mensaje_base);//Mensaje base, independiente, va cambiando en funcion de su metodo aleatorio, es un void, que devuelve un println
    }
    public static void historia(int numeroPartida) throws IOException, InterruptedException{
        Partida partida = null;
        if (GuardadoPartida.PartidaEmpezada(numeroPartida)) {
            partida = GuardadoPartida.cargarPartida(numeroPartida);
        }
        else {
            partida = new Partida();
            ManipulacionBD.PrimerGuardarDatos(partida);
            
            TextoLento.printSlow("Que comience la historia");
            String nombreJugador = LectorBuffRead.leer("Como vas a queres llamar a tu personaje:");
            Razas razaPersonaje = null;

            switch (LectorBuffRead.leer(
                    "Cual quieres que sea la raza de tu personaje (Escriba un numero):\n1.-Enano.  2.-Humano.\n3.-Elfo.   4.-Orco.",
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
            GuardadoPartida.guardarPartida(numeroPartida, partida);
        }

        if (!(partida.getPersonajePrincipalPartida().getHistoria()[PlayerData.HISTORIA_PARTE1.getValue()]
        == PlayerData.HISTORIA_TERMINADA.getValue())) {//Si la primera parte no esta terminada
            // Mensaje inicial en la historia
            MensajeBase();
            // Historia principal, primera parte
            Parte1.Historia(partida.getPersonajePrincipalPartida());
            GuardadoPartida.guardarPartida(numeroPartida, partida);
            System.out.println("Partida guardada automaticamente...");
        }
        

        if (partida.getPersonajePrincipalPartida().getHistoria()[PlayerData.HISTORIA_PARTE1.getValue()] 
        == PlayerData.HISTORIA_TERMINADA.getValue() && 
        partida.getPersonajePrincipalPartida().getHistoria()[PlayerData.HISTORIA_PARTE2.getValue()]
        != PlayerData.HISTORIA_TERMINADA.getValue()) {// Si la parte 1 esta terminada y la parte 2 no lo esta

            // Historia principal, segunda parte
            Parte2.Historia(partida.getPersonajePrincipalPartida());
            GuardadoPartida.guardarPartida(numeroPartida, partida);
            TextoLento.printSlow("Partida guardada automaticamente...");
        }

        if (partida.getPersonajePrincipalPartida().getHistoria()[PlayerData.HISTORIA_PARTE2.getValue()] 
        == PlayerData.HISTORIA_TERMINADA.getValue() && 
        partida.getPersonajePrincipalPartida().getHistoria()[PlayerData.HISTORIA_PARTE3.getValue()]
        != PlayerData.HISTORIA_TERMINADA.getValue()) {// Si la parte 2 esta terminada y la parte 3 no lo esta

            // Historia principal, tercera parte
            Parte3.Historia(partida.getPersonajePrincipalPartida());
            GuardadoPartida.guardarPartida(numeroPartida, partida);
            TextoLento.printSlow("Partida guardada automaticamente...");
        }

        if (partida.getPersonajePrincipalPartida().getHistoria()[PlayerData.HISTORIA_PARTE3.getValue()] 
        == PlayerData.HISTORIA_TERMINADA.getValue()) {// Si la parte 3 esta terminada
            
            // Historia principal, cuarta parte
            Parte4.Historia(partida.getPersonajePrincipalPartida());
            GuardadoPartida.guardarPartida(numeroPartida, partida);
            TextoLento.printSlow("Partida guardada automaticamente...");
        }
        System.out.println("Partida finalizada.");
        GuardadoPartida.EliminarPartida(numeroPartida, partida);
    }
    

}
