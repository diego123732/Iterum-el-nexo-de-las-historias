package historias;

import java.io.IOException;

import utilidades.LectorBuffRead;
import utilidades.TextoLento;
import utilidades.TextosAscii;
import clases.Ocupaciones;
import clases.PersonajePrinc;
import clases.PlayerData;
import clases.Razas;

public abstract class Humanos{
    private static final String GUERRA_DE_REYES_HERMANOS_1_1 = "Llegas al reino de Aetheria, uno de los reinos más grandes del continente humano.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_2 = "Te das una vuelta por la capital, a donde vas primero.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3 = "A la taberna (Escribe taberna).";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_1 = "Entras a la taberna \"Nadie sabe nada\", dentro te encuentras un panorama diverso.\nGente por los suelos, algún que otro concurso de bofetadas y un par de humoristas en una esquina sin mucho éxito.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_2 = "Cuando llegas a la barra, escuchas una voz aguda y amigable de detrás de la mesa; -Hola, soy Bebélico Tragopequeño, qué se te ofrece.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_3 = "Al mirar detrás de la barra te encuentras un gnomo muy pequeño fuera de la baja estatura de su raza.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_4 = "-¿Perdone, quiere algo? -S, si, -dices tartamudeando- ¿Qué tiene?";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5 = "El camarero te da la carta; tienen cerveza y varios cócteles de dudosa procedencia. ¿Qué vas a beber?";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_1 = "Una cerveza (Escribe cerveza)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_2 = "Un cóctel fulgor estelar (Escribe fulgor)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_3 = "Un Amatista de los Abismos (Escribe amatista)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_4 = "Un Suspiro del Dragón Morado (Escribe dragon)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_5 = "Un Cenizas del Guerrero (Escribe cenizas)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_6 = "Un Bendición de la Tierra (Escribe tierra)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_7 = "Un Elixir de la Mente (Escribe mente)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_8 = "Te bebes un vaso de agua (Escribe agua)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_3_5_DESENLACE_BAR = "Tras una noche de mierda en un sitio peor, sales en búsqueda de más aventuras.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4 = "Al gremio de aventureros (Escribe gremio).";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_1 = "Te metes dentro del gremio, la gente te mira con desprecio por ser el nuevo.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_2 = "No hay mucho, tienes dos opciones: ir a hablar con la guía del gremio o mirar el tablón de misiones, ¿qué haces?";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_3 = "Hablar con la guía (Escribe guia)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_3_1 = "La señora guía te dice que este reino está pasando por una guerra civil entre su rey y su hermano por una guerra de sucesión.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_3_2 = "Ella te pide por favor que tomes una misión, como están en guerra no hay ejército que elimine a los monstruos y están teniendo muchos problemas.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_3_3 = "Vas a mirar al tablón de misiones.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_4 = "Ir a mirar el tablón de misiones (Escribe misiones)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_1 = "Tienes varias misiones: una misión de recolección de flores para una señora, una misión de exterminio de un campamento de goblins o una misión de caza de un lobo superior.";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_2 = "¿Qué misión vas a coger?";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_3 = "Las flores de la señora (Escribe flores)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_4 = "El campamento goblin (Escribe goblin)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_5 = "El lobo superior (Escribe lobo)";
    private static final String GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_6 = "Recoges la misión y te pones en marcha.";

    private static final String LA_MUJER_DE_MORADO_1_1 = "Llegas a Cagnes-sur-Mer, una ciudad humana con diversidad de razas, a tu alrededor ves elfos, enanos y varias clases de semihumanos.";
    private static final String LA_MUJER_DE_MORADO_1_2 = "Mientras estas recorriendo la ciudad aprecias una fragancia que te atrae, la sigues y te encuentras con una chica, en cuanto la ves empieza a correr, tú la sigues.";
    private static final String LA_MUJER_DE_MORADO_1_3 = "La chica gira hacia un callejón sin salida, tú entras, ya no está, pero en donde termina su fragancia, al fondo del callejón en el suelo hay una carta.";
    private static final String LA_MUJER_DE_MORADO_1_4 = "La abres: ";
    private static final String LA_MUJER_DE_MORADO_1_5 = "\"Si me quieres encontrar ven aquí.\" Seguido de una dirección, está en una ciudad al lado de Cagnes-sur-Mer.";
    private static final String LA_MUJER_DE_MORADO_1_5_MAGO = "\"Si me quieres encontrar ven aquí.\" Seguido de una dirección, es una torre mágica muy prestigiosa en.";
    private static final String LA_MUJER_DE_MORADO_2_1 = "Tu viaje a Nicaea es largo, con incontables senderos cruzando bosques y montañas. \nDurante el trayecto, empiezas a notar que no estás solo. \nSombras extrañas se mueven en los árboles, y una sensación de inquietud te invade. \n¿Quién más sabe de la carta?";
    private static final String LA_MUJER_DE_MORADO_2_2 = "Una noche, mientras acampas junto a un riachuelo, el silencio del bosque se rompe con un chasquido entre los arbustos. \nTe pones en guardia justo antes de que tres figuras encapuchadas emerjan de la oscuridad, blandiendo dagas curvas con símbolos extraños grabados en sus hojas. \nNo dicen palabra alguna, pero sus intenciones son claras. Sin otra opción, desenvainas tu arma y combates contra ellos.";
    private static final String LA_MUJER_DE_MORADO_2_2_VICTORIA = "Son ágiles y coordinados, pero logras repeler el ataque, hiriendo a uno mientras los otros dos huyen hacia la espesura.";
    private static final String LA_MUJER_DE_MORADO_2_2_DERROTA = "Has muerto. \nLos asesinos pisan tu cuerpo moribundo y se llevan la carta en busca de su remitente.";
    private static final String LA_MUJER_DE_MORADO_2_3 = "Respiras con dificultad. \n¿Quiénes eran? ¿Qué querían de ti? \nLas marcas en sus armas y túnicas te resultan inquietantes, pero sin más información, sigues tu camino.";
    private static final String LA_MUJER_DE_MORADO_2_4 = "Finalmente, llegas a la imponente ciudad de Nicaea. \nSus torres de mármol blanco se alzan hasta el cielo, hogar de algunos de los más poderosos hechiceros del reino.";
    private static final String LA_MUJER_DE_MORADO_2_5 = "Antes de entrar en la torre mágica mencionada en la carta, decides explorar la ciudad. \nNicaea es vasta y está repleta de misterios y oportunidades. \nPosiblemente aquí puedas encontrar información sobre los atacantes o prepararte mejor para lo que está por venir.";
    private static final String LA_MUJER_DE_MORADO_3_1 = "El ataque a la torre no fue un accidente. \nLa chica te revela que sus perseguidores pertenecen a un antiguo culto dedicado a Zhaelor, el Dios de los Caminos Perdidos. \nSe dice que Zhaelor otorga poder a aquellos que desean erradicar el orden y la estabilidad, reemplazándolos con la confusión y el caos absoluto.";
    private static final String LA_MUJER_DE_MORADO_3_2 = "Escapando por un pasadizo oculto en la torre, ella te revela la verdad. \nEs una descendiente de una antigua orden de guardianes vinculados a la Mujer de Morado, la deidad celestial de la bondad y la armonía entre mundos. \nLos cultistas buscan eliminar su linaje para erradicar su conexión con el equilibrio universal.";
    private static final String LA_MUJER_DE_MORADO_3_3 = "Tras varias jornadas de viaje, llegas a un antiguo templo escondido en las montañas. \nSu entrada está resguardada por estatuas colosales, cubiertas de inscripciones que narran la guerra entre la Mujer de Morado y las deidades oscuras. \nLa chica cree que dentro de este templo está la clave para derrotar a la secta.";
    private static final String LA_MUJER_DE_MORADO_3_4 = "Al cruzar la puerta principal, una figura encapuchada emerge de las sombras.";
    private static final String LA_MUJER_DE_MORADO_3_5 = "\"Ya es tarde... el destino ha sido sellado\", murmura antes de atacarte con un poder más allá de lo humano.";
    private static final String LA_MUJER_DE_MORADO_3_5_VICTORIA = "El combate es difícil, pero logras prevalecer. \nSin embargo, el templo aún guarda muchos secretos. \nAntes de continuar con tu misión, decides explorar sus ruinas en busca de conocimiento, aliados o recursos que puedan ser útiles para la batalla final.";
    private static final String LA_MUJER_DE_MORADO_3_5_DERROTA = "Has muerto. \nEl asesino corre a por la mujer y la mutila. \nTu muerte romperá el control entre los dioses y sumirá al mundo en un ciclo eterno de maldad y discordia.";
    private static final String LA_MUJER_DE_MORADO_4_1 = "El enfrentamiento contra los cultistas ha llegado a su clímax. \nDesde las ruinas del templo, eres testigo de cómo el líder de la secta convoca una entidad ancestral.";
    private static final String LA_MUJER_DE_MORADO_4_2 = "Ante ti se forma una silueta humanoide, pero no de carne, sino de cristal oscuro. \nSu cuerpo está cubierto de fisuras por donde escapan luces de distintos colores, como si su forma frágil contuviera un poder inmenso a punto de estallar. \nSu rostro es un reflejo vacío, una superficie que muestra tus propios temores y dudas.";
    private static final String LA_MUJER_DE_MORADO_4_3 = "\"Tu fe es débil\", susurra con una voz etérea, resonando en tu mente.";
    private static final String LA_MUJER_DE_MORADO_4_4 = "A medida que avanza, el suelo bajo él se transforma en un espejo, reflejando no solo tu imagen, sino fragmentos de otros mundos y tiempos. \nSus ataques no son solo físicos, sino ilusiones que intentan quebrantar tu voluntad.";
    private static final String LA_MUJER_DE_MORADO_4_5 = "Con la chica a tu lado, enfrentas al ser cristalino, luchando no solo contra su poder, sino contra la confusión que genera en tu mente.";
    private static final String LA_MUJER_DE_MORADO_4_5_VICTORIA = "El combate es arduo, pero con un golpe final, la estructura cristalina se quiebra, desmoronándose en fragmentos luminosos.";
    private static final String LA_MUJER_DE_MORADO_4_5_DERROTA = "Has muerto, y contigo el mundo empieza a desmoronarse. \nLas rocas empiezan a fluir, el aire se transforma en agua y la gravedad se invierte. \nEl mundo tal y como lo conocías, se esfuma como si fuese polvo.";
    private static final String LA_MUJER_DE_MORADO_4_6 = "La entidad deja escapar un último murmullo antes de desaparecer:";
    private static final String LA_MUJER_DE_MORADO_4_7 = "\"El equilibrio nunca es eterno...\"";
    private static final String LA_MUJER_DE_MORADO_4_8 = "El templo retoma su silencio y la oscuridad que lo envolvía se desvanece. \nHas vencido.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_1_1 = "Mientras te estás yendo, lejos de tu mirada, una gran y espesa niebla empieza a engullir al goblin que habías dejado moribundo en el suelo.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_1_2 = "Al esfumarse esa niebla, aparece una pequeña sombra. \"Así que hay un aventurero abusando de mis peones...\"";
    public static final String EL_GOBLIN_DEL_TUTORIAL_1_3 = "Sigues tu camino sin darte cuenta de los problemas que te has buscado, o los que podrías haber esquivado.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_2_1 = "Tu viaje continúa por los páramos solitarios, con la sensación de que algo te observa desde la distancia. \n"
            +
            "Conforme avanzas, el aire se vuelve más pesado y un mal presentimiento se apodera de ti.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_2_2 = "Una noche, al detenerte en una posada en medio del camino, el silencio es interrumpido por un estruendo. \n"
            +
            "La puerta estalla en pedazos y una figura imponente entra: un goblin, pero no uno cualquiera. \n" +
            "Es más alto, más musculoso y porta una armadura oscura decorada con inscripciones rúnicas. \n" +
            "Sus ojos brillan con un fuego maligno.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_2_3 = "\"No debiste meterte con nuestro señor...\"";
    public static final String EL_GOBLIN_DEL_TUTORIAL_2_4 = "Sin previo aviso, te ataca con una velocidad inhumana.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_2_4_VICTORIA = "El combate es feroz, obligándote a usar todas tus habilidades para sobrevivir. \n"
            +
            "Finalmente, tras un golpe certero, el goblin cae de rodillas y desaparece en una niebla negra.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_2_4_DERROTA = "Has muerto. \nEl goblin coge tu cuerpo moribundo y lo tira contra la pared, quedando aplastado entre las rendijas de los ladrillos.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_2_5 = "Tras la pelea, decides que es mejor prepararte antes de continuar tu viaje. \n"
            +
            "La región ofrece muchas oportunidades para fortalecer tus habilidades antes de enfrentarte al verdadero peligro que se avecina.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_1 = "Después de tu tiempo de preparación, sigues tu camino hasta un antiguo santuario en ruinas. \n"
            +
            "Se dice que allí se esconde un gran secreto sobre los monstruos que dominan estas tierras. \n" +
            "Pero al llegar, te das cuenta de que no estás solo.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_3_2 = "Una figura encapuchada emerge de las sombras. Sus ropajes están marcados con símbolos extraños, y su voz es como un eco en la oscuridad.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_3_3 = "\"Tu destino ya está sellado... No puedes detener lo inevitable.\"";
    public static final String EL_GOBLIN_DEL_TUTORIAL_3_4 = "Antes de poder reaccionar, una energía oscura te envuelve. Es un portal, y sin poder evitarlo, caes en la negrura.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_3_5 = "Despiertas en un lugar desconocido. Un gran salón de piedra se extiende ante ti, iluminado por antorchas de fuego violeta. "
            +
            "En un trono elevado, el goblin que creíste haber vencido te observa con una sonrisa burlona.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_6 = "\"Bienvenido a nuestro dominio. Has demostrado ser fuerte… pero aún no eres digno.\"";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_7 = "A su alrededor, cinco figuras colosales lo observan. \n" +
            "Cada una representa una raza monstruosa de poder inimaginable. \n" +
            "Te encuentras frente al Concilio de la Muerte, un grupo de entidades que dominan la oscuridad del mundo.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_8 = "El goblin se levanta de su trono y avanza hacia ti. \n" +
            "A medida que se acerca, notas que su cuerpo está cubierto por un manto de insectos. \n" +
            "Su piel parece moverse con vida propia. \n" +
            "Lo entiendes al instante: no es un simple monstruo, es el Monarca de los Bichos, un ser venerado entre las criaturas que reptan y zumban en la oscuridad.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_9 = "Uno de los miembros del Concilio se inclina ligeramente.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_10 = "\"Él es el soberano de las plagas, y tú lo has desafiado sin siquiera entender su verdadero poder. Pero esto es solo el inicio.\"";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_11 = "El goblin extiende una garra y una nube de insectos letales se lanza contra ti. \n"
            +
            "Aprovechando la confusión, corres y saltas por una grieta en la pared. Una caída dolorosa, pero tu única oportunidad de escapar. \n"
            +
            "Atrás, los miembros del Concilio murmuran en la penumbra, observándote con interés.";

    public static final String EL_GOBLIN_DEL_TUTORIAL_3_12 = "\"Veremos cuánto tiempo logras sobrevivir...\"";

    public static final String EL_GOBLIN_DEL_TUTORIAL_4_1 = "En tu viaje, los rumores te llevan a una caverna infestada de criaturas abominables. \n"
            +
            "Dentro, un aura oscura late con una presencia aterradora. Lo sabes de inmediato: el Monarca de los Bichos está aquí.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_2 = "Al adentrarte, las paredes están cubiertas de colmenas y capullos retorcidos. \n"
            +
            "Cada paso que das parece alertar a la misma cueva, y antes de que puedas reaccionar, una sombra emerge de la penumbra.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_3 = "El goblin ha evolucionado. Su cuerpo ahora es una amalgama de quitina y sombras, y sus ojos brillan con un hambre depredadora.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_4 = "\"Huiste... pero nunca podrás escapar de mí. ¡Ahora serás devorado por la plaga!\"";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_5 = "La batalla comienza. \nÉl invoca enjambres de insectos para bloquear tus ataques, su velocidad ha aumentado, y cada golpe suyo parece liberar una nueva horda de criaturas. La cueva misma lucha contra ti.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_5_VICTORIA = "Con esfuerzo y estrategia, logras romper su defensa. Un golpe certero atraviesa su pecho. Por primera vez, el Monarca de los Bichos cae.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_5_DERROTA = "El enjambre está por todo tu cuerpo, se mete por tus ojos, boca, nariz, hasta llegar a todas las entrañas de tu cuerpo. \n"
            +
            "Has muerto. El Monarca de la Plaga te ha vencido y contigo le ha dado de comer al enjambre, como si fueses otro más de los gusanos del camino.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_6 = "Mientras su cuerpo se retuerce en espasmos, las criaturas que lo rodeaban se desmoronan. El silencio cae en la caverna. \n"
            +
            "Entonces, la voz de los otros miembros del Concilio resuena en tu mente.";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_7 = "\"El trono ha quedado vacío. Alguien debe ocuparlo.\"";
    public static final String EL_GOBLIN_DEL_TUTORIAL_4_8 = "Sientes una energía oscura fluir hacia ti. No hay elección. \n"
            +
            "La esencia del Monarca de los Bichos ahora te pertenece. \n" +
            "La transformación comienza.";

    /**
     * Clase de los Humanos que recoge las partes de la Historia La Mujer de Morado
     */
    public class LaMujerDeMorado {

        /**
         * Primera parte de la HistoriaDatos de los humanos; La Mujer de Morado, El
         * mensaje de la brisa.
         * <p>
         * En esta primera parte el usuario se encuentra con un rastro que le lleva
         * hacia la torre de magia
         * 
         * @see HistoriaDatos
         * @see PersonajePrinc
         * @see LA_MUJER_DE_MORADO
         * @see PersonajePrinc
         */
        public static void LaMujerDeMoradoParte1(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_MUJER_DE_MORADO_1_1);
            TextoLento.printSlow(LA_MUJER_DE_MORADO_1_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_MUJER_DE_MORADO_1_3);
            TextoLento.printSlow(LA_MUJER_DE_MORADO_1_4);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.getOcupacion() == Ocupaciones.Mago)
                TextoLento.printSlow(LA_MUJER_DE_MORADO_1_5_MAGO);
            else
                TextoLento.printSlow(LA_MUJER_DE_MORADO_1_5);
            personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_MUJER_DE_MORADO.getValue(), PlayerData.HISTORIA.getValue());// La Mujer de Morado
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
        }

        /**
         * Segunda parte de la HistoriaDatos de los humanos; La Mujer de Morado, El
         * mensaje de la brisa.
         * <p>
         * En esta segunda parte se da a conoces a la acompañante principal de la
         * historia, una descendiente de una Diosa.
         * 
         * @param buffer
         * @see HistoriaDatos
         * @see Batalla
         * @see LA_MUJER_DE_MORADO
         * @see PersonajePrinc
         */
        public static void LaMujerDeMoradoParte2(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_MUJER_DE_MORADO_2_1);
            TextoLento.printSlow(LA_MUJER_DE_MORADO_2_2);

            if (personajePrincipal.CombateEntero(Enemigos.HUMANO_COMANDANTE.getVida(),
                    Enemigos.HUMANO_COMANDANTE.getDaño())) {
                TextosAscii.setAmarillo();
                TextoLento.printSlow(LA_MUJER_DE_MORADO_2_2_VICTORIA);
                TextoLento.printSlow(LA_MUJER_DE_MORADO_2_3);
                TextoLento.printSlow(LA_MUJER_DE_MORADO_2_4);
                LectorBuffRead.continuarHistoria();
                TextoLento.printSlow(LA_MUJER_DE_MORADO_2_5);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_MUJER_DE_MORADO.getValue(), PlayerData.HISTORIA.getValue());// La Mujer de Morado
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
            } else {
                TextoLento.printSlow(LA_MUJER_DE_MORADO_2_2_DERROTA);
            }
        }

        /**
         * Tercera parte de la HistoriaDatos de los humanos; La Mujer de Morado, El
         * Culto en las Sombras.
         * <p>
         * En esta tercera parte se da a conocer al principal problema de la historia el
         * culto que sigue a el Dios Zhaelor, el Dios de los Caminos Perdidos.
         * 
         * @param buffer
         * @see HistoriaDatos
         * @see clases
         * @see Batalla
         * @see LA_MUJER_DE_MORADO
         * @see PersonajePrinc
         */
        public static void LaMujerDeMoradoParte3(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_MUJER_DE_MORADO_3_1);
            TextoLento.printSlow(LA_MUJER_DE_MORADO_3_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_MUJER_DE_MORADO_3_3);
            TextoLento.printSlow(LA_MUJER_DE_MORADO_3_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_MUJER_DE_MORADO_3_5);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.CombateEntero(Enemigos.HUMANO_CULTISTA.getVida(),
                    Enemigos.HUMANO_CULTISTA.getDaño())) {
                TextosAscii.setAmarillo();
                TextoLento.printSlow(LA_MUJER_DE_MORADO_3_5_VICTORIA);
                personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_MUJER_DE_MORADO.getValue(), PlayerData.HISTORIA.getValue());// La Mujer de Morado
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
            } else {
                TextoLento.printSlow(LA_MUJER_DE_MORADO_3_5_DERROTA);
            }
        }

        /**
         * Cuarta parte de la HistoriaDatos de los humanos; La Mujer de Morado, El
         * Juicio Final.
         * <p>
         * En esta cuarta parte el jugador se enfrentara contra el dios de los caminos
         * perdidos para derrocar su reinado de malicia y desesperacion.
         * 
         * @param buffer
         * @see HistoriaDatos
         * @see clases
         * @see Batalla
         * @see LA_MUJER_DE_MORADO
         * @see PersonajePrinc
         */
        public static void LaMujerDeMoradoParte4(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_MUJER_DE_MORADO_4_1);
            TextoLento.printSlow(LA_MUJER_DE_MORADO_4_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_MUJER_DE_MORADO_4_3);
            TextoLento.printSlow(LA_MUJER_DE_MORADO_4_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_MUJER_DE_MORADO_4_5);
            LectorBuffRead.continuarHistoria();

            if (personajePrincipal.CombateEntero(Enemigos.DIOS_ZHAELOR.getVida(), Enemigos.DIOS_ZHAELOR.getDaño())) {
                TextosAscii.setAmarillo();
                TextoLento.printSlow(LA_MUJER_DE_MORADO_4_5_VICTORIA);
                TextoLento.printSlow(LA_MUJER_DE_MORADO_4_6);
                LectorBuffRead.continuarHistoria();
                TextoLento.printSlow(LA_MUJER_DE_MORADO_4_7);
                TextoLento.printSlow(LA_MUJER_DE_MORADO_4_8);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_MUJER_DE_MORADO.getValue(), PlayerData.HISTORIA.getValue());// La Mujer de Morado
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
            } else {
                TextoLento.printSlow(LA_MUJER_DE_MORADO_4_5_DERROTA);
            }
        }
    }

    /**
     * Clase de los Humanos que recoge las partes de la Historia La Guerra de Reyes
     * Hermanos
     */
    public class LaGuerraDeReyesHermanos extends Humanos {

        /**
         * Primera parte de la HistoriaDatos de los humanos; La guerra de los reyes
         * hermanos.
         * <p>
         * En esta primera parte se llega a una ciudad en la que se pueden hacer una
         * gran cantidad
         * de actividades, esstas son tanto como para recolectar informacion, como para
         * mejorar el
         * personaje ante un muy posible escenario peligroso en futuras partes de la
         * HistoriaDatos
         * 
         * @param primerDesenlaceBucleSalir
         * @param segundoDesenlaceBucleSalir
         * @param tercerDesenlaceBucleSalir
         * @param elecionIntrahistoria
         * @param elecionIntrahistoria2
         * @param elecionIntrahistoria3
         * @param buffer
         * @see HistoriaDatos
         * @see PersonajePrinc
         */
        public static void LaGuerraDeReyesHermanosParte1(
                String elecionIntrahistoria,
                String elecionIntrahistoria2,
                String elecionIntrahistoria3,
                PersonajePrinc personajePrincipal)
                throws IOException, InterruptedException {
            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_1);
            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_2);
            LectorBuffRead.continuarHistoria();

            elecionIntrahistoria = LectorBuffRead.leer((GUERRA_DE_REYES_HERMANOS_1_3 + "\n"
                    + GUERRA_DE_REYES_HERMANOS_1_4 + "\n"),
                    "taberna", "gremio");

            switch (elecionIntrahistoria) {
                case "taberna":
                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_3_1);
                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_3_2);
                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_3_3);
                    LectorBuffRead.continuarHistoria();
                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_3_4);
                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_3_5);

                    elecionIntrahistoria2 = LectorBuffRead.leer(
                            (GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_1 + "   \n" +
                                    GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_2 + "   \n" +
                                    GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_3 + "   \n" +
                                    GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_4 + "   \n" +
                                    GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_5 + "   \n" +
                                    GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_6 + "   \n" +
                                    GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_7 + "   \n" +
                                    GUERRA_DE_REYES_HERMANOS_1_3_5_OPCIONES_BAR_8 + "   \n"),
                            elecionIntrahistoria3);

                    switch (elecionIntrahistoria2) {
                        case "cerveza":
                            personajePrincipal.setDinero(personajePrincipal.getDinero() - 5);
                            break;

                        case "fulgor":
                            personajePrincipal.setDinero(personajePrincipal.getDinero() - 5);
                            personajePrincipal.setEstadisticas(0, personajePrincipal.getEstadisticas()[0] + 2);
                            break;

                        case "amatista":
                            personajePrincipal.setDinero(personajePrincipal.getDinero() - 5);
                            personajePrincipal.setEstadisticas(5, personajePrincipal.getEstadisticas()[5] + 2);
                            break;

                        case "dragon":
                            personajePrincipal.setDinero(personajePrincipal.getDinero() - 5);
                            personajePrincipal.setEstadisticas(1, personajePrincipal.getEstadisticas()[1] + 2);
                            break;

                        case "cenizas":
                            personajePrincipal.setDinero(personajePrincipal.getDinero() - 5);
                            personajePrincipal.setEstadisticas(3, personajePrincipal.getEstadisticas()[3] + 2);
                            break;

                        case "tierra":
                            personajePrincipal.setDinero(personajePrincipal.getDinero() - 5);
                            personajePrincipal.setEstadisticas(4, personajePrincipal.getEstadisticas()[4] + 2);
                            break;

                        case "mente":
                            personajePrincipal.setDinero(personajePrincipal.getDinero() - 5);
                            personajePrincipal.setEstadisticas(2, personajePrincipal.getEstadisticas()[2] + 2);
                            break;

                        case "agua":
                            break;

                        default:
                            break;
                    }

                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_3_5_DESENLACE_BAR);

                    break;

                case "gremio":

                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_1);
                    TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_2);
                    elecionIntrahistoria2 = LectorBuffRead.leer((GUERRA_DE_REYES_HERMANOS_1_4_3 + "\n"
                            + GUERRA_DE_REYES_HERMANOS_1_4_4 + "\n"),
                            "guia", "misiones");
                    switch (elecionIntrahistoria2) {
                        case "guia":
                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_3_1);
                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_3_2);
                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_3_3);
                            break;
                        case "misiones":

                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_1);
                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_2);// A partir de aqui
                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_3);
                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_4);
                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_5);
                            elecionIntrahistoria3 = LectorBuffRead.leer(
                                    (GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_2 + "\n"
                                            + GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_3 + "\n"
                                            + GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_4 + "\n"
                                            + GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_5 + "\n"),
                                    "flores", "goblin", "lobo");
                            switch (elecionIntrahistoria3) {
                                case "flores":
                                    break;

                                case "goblin":
                                    break;

                                case "lobo":
                                    break;
                            }

                            TextoLento.printSlow(GUERRA_DE_REYES_HERMANOS_1_4_MISIONES_6);
                            personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_GUERRA_DE_REYES_HERMANOS.getValue(), PlayerData.HISTORIA.getValue());// La guerra de reyes hermanos
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
                            break;

                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }

        }
    }

    /**
     * Clase de los Humanos que recoge las partes de la Historia El Goblin del
     * Tutorial
     */
    public class ElGoblinDelTutorial extends Humanos {

        /**
         * Primera parte de la HistoriaDatos de los humanos; El goblin del tutorial, El
         * Resurgir de las Sombras.
         * <p>
         * En este comienzo de la HistoriaDatos solo hace una introduccion misteriosa de
         * un ser malicioso y que parece poderoso
         * 
         * @see HistoriaDatos
         * @see ElGoblinDelTutorial
         * @see PersonajePrinc
         */
        public static void ElGoblinDelTutorialParte1(PersonajePrinc personajePrincipal) throws InterruptedException{
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_1_1);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_1_2);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_1_3);
            personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_GOBLIN_DEL_TUTORIAL.getValue(), PlayerData.HISTORIA.getValue());// El goblin del tutorial
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
        }

        /**
         * Segunda parte de la HistoriaDatos de los humanos; El goblin del tutorial,
         * Sombras en el Camino.
         * <p>
         * En esta parte el jugador se ve perseguido por mostruos desconocidos.
         * 
         * @param buffer
         * @see HistoriaDatos
         * @see clases
         * @see Batalla
         * @see ElGoblinDelTutorial
         * @see PersonajePrinc
         */
        public static void ElGoblinDelTutorialParte2(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_2_1);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_2_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_2_3);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_2_4);
            LectorBuffRead.continuarHistoria();

            if (personajePrincipal.CombateEntero(Enemigos.GOBLIN_GENERAL.getVida(),
                    Enemigos.GOBLIN_GENERAL.getDaño())) {
                TextosAscii.setAmarillo();
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_2_4_VICTORIA);
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_2_5);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_GOBLIN_DEL_TUTORIAL.getValue(), PlayerData.HISTORIA.getValue());// El goblin del tutorial
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
            } else {
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_2_4_DERROTA);
            }
        }

        /**
         * Tercera parte de la HistoriaDatos de los humanos; El goblin del tutorial, El
         * Concilio de la Muerte.
         * <p>
         * En esta parte el jugador se encuentra con la raiz del problema; el concilio
         * de la muerte y sus monarcas que lo reinan; aunque lamentablemente tiene que
         * correr de esas amenazas.
         * 
         * @param buffer
         * @see HistoriaDatos
         * @see ElGoblinDelTutorial
         * @see PersonajePrinc
         */
        public static void ElGoblinDelTutorialParte3(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_1);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_3);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_5);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_6);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_7);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_8);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_9);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_10);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_11);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_3_12);
            LectorBuffRead.continuarHistoria();
            personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_GOBLIN_DEL_TUTORIAL.getValue(), PlayerData.HISTORIA.getValue());// El goblin del tutorial
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
        }

        /**
         * Cuarta parte de la HistoriaDatos de los humanos; El goblin del tutorial, El
         * Trono de las Plagas.
         * <p>
         * En esta parte el jugador finalmente se encuentra con el monarca de la plaga y
         * pelea contra el.
         * 
         * @param buffer
         * @see HistoriaDatos
         * @see Batalla
         * @see clases
         * @see ElGoblinDelTutorial
         * @see PersonajePrinc
         */
        public static void ElGoblinDelTutorialParte4(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_1);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_3);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_4);
            TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_5);
            LectorBuffRead.continuarHistoria();

            if (personajePrincipal.CombateEntero(Enemigos.MONARCA_DE_LA_PLAGA.getVida(),
                    Enemigos.MONARCA_DE_LA_PLAGA.getDaño())) {
                TextosAscii.setAmarillo();
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_5_VICTORIA);
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_6);
                LectorBuffRead.continuarHistoria();
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_7);
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_8);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Humano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Humanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_GOBLIN_DEL_TUTORIAL.getValue(), PlayerData.HISTORIA.getValue());// El goblin del tutorial
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
            } else {
                TextoLento.printSlow(EL_GOBLIN_DEL_TUTORIAL_4_5_DERROTA);
            }
        }
    }
}
