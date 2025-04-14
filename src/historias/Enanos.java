package historias;

import java.io.IOException;

import clases.PlayerData;
import clases.Razas;
import clases.PersonajePrinc;
import utilidades.LectorBuffRead;
import utilidades.TextoLento;
import utilidades.TextosAscii;

public abstract class Enanos{
    private static final String EL_CODICE_MALDITO_1_1 = "Llegas a Durkazad una pequeña ciudad de los enanos en donde destaca su hermosa personalidad y sus fiestas muy animadas.";
    private static final String EL_CODICE_MALDITO_1_2 = "Llegas de noche pero notas que hay mucho ruido, llegas justo a tiempo para las fiestas de la cosecha.";
    private static final String EL_CODICE_MALDITO_1_3 = "En medio de la enorme plaza de la ciudad notas una gran multitud de personas bailando y gritando por bendiciones a su diosa Velgrimara.";
    private static final String EL_CODICE_MALDITO_1_4 = "Decides meterte en la fiesta y una de las señoras te coge del brazo y te lleva con ellos a bailar.";
    private static final String EL_CODICE_MALDITO_1_5 = "Pasas una noche increíble bailando, bebiendo y comiendo acompañado de unos enanos que te tratan de una forma excelente.";
    private static final String EL_CODICE_MALDITO_1_6 = "Mientras estás sentado alrededor de una gran hoguera escuchas la historia de un libro de aventuras que llevan a una gran cantidad de tesoros que te fascina.";
    private static final String EL_CODICE_MALDITO_1_7 = "Al terminar la fiesta cansado de tanto alcohol te retiras a la primera posada que consigues apreciar y te desplomas en la cama.";
    private static final String EL_CODICE_MALDITO_1_8 = "Por la noche tienes un sueño, sueñas con un libro, ogros, cuevas y un ser rojo gigante, al despertarte, encuentras un libro grueso en tu mesilla.";
    private static final String EL_CODICE_MALDITO_1_9 = "Al abrirlo solo puedes apreciar la primera página, que cuenta la historia de un goblin, que sumido en su avaricia es consumido por la magia negra y asesina a sus propios hermanos,\naturdido cierras el libro y lo metes en la mochila.";
    private static final String EL_CODICE_MALDITO_1_10 = "Recoges todas tus cosas y abandonas la pequeña ciudad contento de lo bien que pasaste la noche anterior.";
    private static final String EL_CODICE_MALDITO_2_1 = "El camino es tranquilo, pero tu mente no lo está. \nA pesar de las emociones de la fiesta, el libro que apareció en tu mesilla sigue rondando tus pensamientos. \nCada vez que intentas abrirlo, solo la primera página es legible: la historia del goblin consumido por la magia negra.";
    private static final String EL_CODICE_MALDITO_2_2 = "Sigues tu camino por senderos montañosos hasta que una extraña sensación recorre tu espalda. \nSientes que te observan. A lo lejos, entre los árboles, unas pequeñas sombras se mueven con rapidez. \nGoblins.";
    private static final String EL_CODICE_MALDITO_2_3 = "Decides adelantarte y encontrar un refugio seguro. \nAl llegar a un claro, encuentras una vieja cabaña de piedra abandonada. \nEntras con cautela y, mientras revisas el lugar, el libro en tu mochila comienza a vibrar. \nAl sacarlo, notas que una nueva página es legible:";
    private static final String EL_CODICE_MALDITO_2_4 = "\"El goblin caído no estaba solo. \nSus seguidores, cegados por la codicia, se ocultaron en las sombras, esperando su regreso.\"";
    private static final String EL_CODICE_MALDITO_2_5 = "Un ruido interrumpe tu lectura. Algo ha entrado en la cabaña.";
    private static final String EL_CODICE_MALDITO_2_5_VICTORIA = "Tras el encuentro, decides continuar tu viaje, con la sensación de que algo o alguien te está guiando hacia un destino incierto.";
    private static final String EL_CODICE_MALDITO_2_5_DERROTA = "Has muerto. El grupo de goblins te han masacrado. \nPasan por encima de ti y se llevan el libro. \nCon el despiertan el maleficio y resuena en todo el mundo; \n\"Ha renacido el titan del ragnarok tiemblen por el propio peso de sus pecados\".";
    private static final String EL_CODICE_MALDITO_3_1 = "Siguiendo pistas recogidas en antiguas ruinas y de viajeros en el camino, llegas a una cueva oculta en un valle olvidado. \nLas paredes están cubiertas de extrañas inscripciones, algunas coinciden con el texto del libro.";
    private static final String EL_CODICE_MALDITO_3_2 = "Mientras exploras, una presencia maligna llena el aire. Un eco profundo resuena en la cueva:";
    private static final String EL_CODICE_MALDITO_3_3 = "\"Has leído demasiado\".";
    private static final String EL_CODICE_MALDITO_3_4 = "De las sombras emerge una figura envuelta en túnicas rasgadas y con una máscara de hueso. \nEs un ser corrompido, un antiguo hechicero goblin que ha trascendido la muerte y ahora funge como guardián del libro.";
    private static final String EL_CODICE_MALDITO_3_5 = "\"Este conocimiento no es para los vivos\".";
    private static final String EL_CODICE_MALDITO_3_6 = "Sin darte tiempo a responder, alza su bastón y desata una ola de magia oscura.";
    private static final String EL_CODICE_MALDITO_3_6_VICTORIA = "Tras una feroz lucha, logras derrotar al Lich, quien desaparece en una nube de cenizas, dejando solo su máscara. \nCuando la recoges, una nueva página del libro se vuelve legible, revelando la ubicación de un templo olvidado donde yace el origen de la maldición.";
    private static final String EL_CODICE_MALDITO_3_6_DERROTA = "Has muerto. El lich absorbe tu alma y te combiertes en parte del ejercito de la muerte; la mano derecha del titan del ragnarok";
    private static final String EL_CODICE_MALDITO_3_7 = "Tu destino está claro.";
    private static final String EL_CODICE_MALDITO_4_1 = "Siguiendo las instrucciones del libro, llegas al templo en ruinas, oculto en un pantano brumoso. \nA medida que te adentras, las paredes parecen susurrar historias de traición y poder. \nFinalmente, llegas a la cámara central.";
    private static final String EL_CODICE_MALDITO_4_2 = "Un altar de piedra negra domina la sala. \nEncima de él, una figura dormida, un goblin de piel rojiza con cicatrices que parecen arder como brasas.";
    private static final String EL_CODICE_MALDITO_4_3 = "El libro tiembla en tus manos y, sin previo aviso, la criatura despierta. Sus ojos brillan con un fuego infernal.";
    private static final String EL_CODICE_MALDITO_4_4 = "\"¿Has venido a liberarme… o a perecer como los demás?\"";
    private static final String EL_CODICE_MALDITO_4_5 = "Este no es un simple goblin. Es el ser del que hablaban las historias, el que vendió su alma por poder. \nY ahora, ha renacido en la forma de un titán de fuego y sombras.";
    private static final String EL_CODICE_MALDITO_4_5_VICTORIA = "Cuando la batalla concluye, el templo comienza a derrumbarse. \nAl salir con vida, el libro en tus manos se convierte en cenizas, como si su propósito hubiera sido cumplido.";
    private static final String EL_CODICE_MALDITO_4_5_DERROTA = "Has muerto y contigo las esperanzas del mundo. \nResuena en todo el mundo; \n\"Ha renacido el titan del ragnarok tiemblen por el propio peso de sus pecados\".";
    private static final String EL_CODICE_MALDITO_4_6 = "Pero en tu mente, aún resuenan las últimas palabras del goblin caído:";
    private static final String EL_CODICE_MALDITO_4_7 = "\"El poder siempre encontrará un nuevo huésped...\"";

    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_1 = "Llegas a Mithralyn una gran ciudad de los enanos llena de lujosos edificios y un espléndido ayuntamiento.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_2 = "Mithralyn destaca por su gran variedad de oportunidades, de las que se suele decir que generan fortunas descomunales.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_3 = "Todos ellos nacen de la gran cantidad de cuevas de metales preciosos que tiene la ciudad, y de entre todos los metales, el mithril.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_4 = "El mithril es un metal muy valioso que se suele utilizar en gran variedad de armas de clase alta dada su gran versatilidad,\n al poder almacenar mana, afilarse muy bien y tener una gran resistencia.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_5 = "Al llegar sumido vas en busca de mejorar tu arma, y entras en la primera de las muchísimas herrerías que hay en la plaza central.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_6 = "Dentro te das un paseo por toda la herrería, la cual exuda una temperatura demasiado caliente.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_7 = "Te das cuenta de que no puedes pagar ninguna de las armas y te empiezas a ir, pero antes de salir, alguien te toca la espalda.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_8 = "Es un enano de la herrería, pero eso es lo máximo que llegas a apreciar, lleva una mascarilla para el humo, unas gafas de aviador y una boina.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_9 = "El te dice; -Niño, no tan rapido, me hace falta un estudiante, estamos cortos de personal, ven conmigo-";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_10 = "Y se marcha hacia dentro de la herrería.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_11 = "Casi sin ganas le sigues, venías a por un arma asi que no te vas a ir a casa sin nada, al menos te llevarás una aventura.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_12 = "Entras a una sala llena de hornos al rojo vivo, y delante de cada uno hay puestos de herreria con enanos en ellos.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_13 = "Dentro hace más calor aunque afuera, como si hubieses entrado al mismísimo infierno.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_14 = "El señor te lleva hasta un puesto vacío y te dice;-Te dejaré este puesto para ti, si lo aceptas.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_15 = "-No pagamos mucho, pero no hace falta que vengas todos los días ni hagas nada exagerado, eso sí,\n si alguna vez necesitamos ayuda, prestanos una mano.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_16 = "Acto seguido te da una bolsa con monedas y deja un martillo en tu puesto, tu le dices;-Y qué pasa si no vuelvo.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_17 = "Él, que ya se estaba yendo a la recepción se gira y te dice; -Niño… volverás, tenlo por seguro.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_1_18 = "Cansado del calor de la forja y desanimado por no poder comprar nada en la tienda coges el dinero y el martillo y te marchas de la tienda.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_1 = "Durante las primeras jornadas en Mithralyn, te dedicas a tareas básicas: encender hornos, moldear clavos y reparar herramientas desgastadas. \nPero con el tiempo, empiezas a entender la esencia del oficio. \nCada pieza de metal cuenta una historia, y el martillo es la pluma con la que se escriben.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_2 = "El enano que te reclutó, Maese Durin, sigue observándote con ojos críticos, pero de vez en cuando te deja trabajar en piezas más importantes. \nUn día, mientras limpias un viejo yunque, te entrega un pequeño lingote de acero y dice:";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_3 = "\"Haz algo con esto. Lo que sea\".";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_4 = "Es tu primera verdadera prueba. Trabajas sin descanso, moldeando el metal una y otra vez. \nTus primeras creaciones son torpes, pero poco a poco empiezas a mejorar. \nFinalmente, forjas una daga simple pero equilibrada.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_5 = "Durin la examina con una mueca de aprobación y dice:";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_5_DERROTA = "\"Por favor, abandona la forja; no sirves ni para una simple daga\". \nAbandonas la forja totalmente humillado, pasas por un callejon y un grupo de ladrones pasa por encima de tu cuerpo robandote todas tus pertenencias. \nHas muerto.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_5_VICTORIA = "\"Bien… pero aún te falta mucho\".";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_2_6 = "Te quedas en la herrería, mejorando tu técnica y ayudando con encargos menores, pero empiezas a notar que los materiales de calidad están reservados para los maestros herreros. \nPara conseguirlos, tendrás que salir de la ciudad.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_1 = "Un día, después de varias semanas de práctica, Maese Durin te llama a su taller privado. \nSobre la mesa hay un trozo de mithril puro.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_2 = "\nSi quieres demostrar tu valía, forja algo con esto. No un arma cualquiera. Algo digno de un verdadero herrero\n.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_3 = "Es un desafío mayor de lo que imaginaste.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_4 = "El mithril es diferente a cualquier otro metal que hayas trabajado. \nEs ligero como una pluma, pero más resistente que el acero más fuerte. \nSi no lo calientas a la temperatura exacta, se vuelve quebradizo. \nSi lo enfrías demasiado rápido, se deforma.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_5 = "Día tras día, intentas forjar algo digno, pero cada intento termina en fracaso. Frustrado, decides tomarte un descanso de la forja. \nSalir de la ciudad te ayuda a despejar la mente.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_6 = "Al regresar, algo ha cambiado en ti. \nCon una nueva comprensión del metal, vuelves a la herrería y reintentar el proceso. \nEsta vez, sientes que cada golpe del martillo es más preciso, como si el metal respondiera a tu voluntad.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_7 = "Después de semanas de trabajo, crear una espada de mithril perfecta: ligera, afilada y resistente. \nCuando se la presentas a Durin, él la lanza contra la pared de piedra con toda su fuerza.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_7_VICTORIA = "Tu espada choca contra la pared. En lugar de romperse, la espada se clava profundamente en la roca.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_7_DERROTA = "Tu espada choca contra la pared. Rebota y en el aire se destruye en una gran cantidad de trozos como si de un cristal se tratase. \n\"Por favor, abandona la forja; no sirves ni para una simple daga\". \nAbandonas la forja totalmente humillado, pasas por un callejon y un grupo de ladrones pasa por encima de tu cuerpo robandote todas tus pertenencias. \nHas muerto.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_8 = "Durin sonríe.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_9 = "\"Es hora de tu prueba final\".";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_3_10 = "Te lleva a las profundidades de Mithralyn, donde se encuentra La Forja, el desafío definitivo de los herreros. \"Todavía queda tiempo, vuelve cuando estés preparado\".";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_1 = "El calor en la caverna más profunda de Mithralyn es sofocante. \nLa piedra brilla con un tono rojizo, y el sonido del metal resonando contra metal llena el aire. \nEn el centro de la sala se encuentra el horno más antiguo y poderoso de la ciudad.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_2 = "Pero entonces, algo ocurre. \nLas llamas crecen con furia, y de ellas emerge una figura colosal hecha de metal fundido y fuego vivo: La Forja.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_3 = "\"No es solo un enemigo\" dice Durin. Es la prueba definitiva. \nUn reflejo del sacrificio, el esfuerzo y la dedicación de todo aquel que busca la perfección en la herrería.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_4 = "La criatura ruge, y la batalla comienza.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_5 = "La Forja ataca con golpes devastadores, lanzando fuego líquido y ondas de choque. \nCada movimiento es una prueba de todo lo que has aprendido. \nDebes esquivar, calcular cada golpe y resistir el calor abrasador.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_5_VICTORIA = "Tras una lucha agotadora, logras romper el núcleo de la criatura con un último y poderoso golpe de tu martillo. \nLa Forja se derrumba en un mar de brasas moribundas.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_5_DERROTA = "La Forja esta muy caliente y ya no te quedan fuerzas para seguir avanzando en la lucha. \nCaes al suelo ardiendo, has muerto. \nEl maese Durin se va de la cueva sin mirar hacia atras, como si sintiese verguenza por tu sacrificio.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_6 = "Cuando el humo se disipa, te encuentras de pie, victorioso.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_7 = "Durin asiente con respeto.";
    private static final String LA_CREACION_DEL_ARTEFACTO_MITICO_4_8 = "\"Ahora, eres uno de nosotros\".";

    private static final String EL_PUEBLO_ENANO_OWARF_1_1 = "Llegas al Owarf.\nUn pueblo enano relativamente nuevo pero que se ha expandido muy rápido en los últimos años y ya puede competir hasta con la capital Stoneheim.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_2 = "Al llegar notas que la población esta formada mayoritariamente por enanos.\nEstos desprecian a todas las otras razas, incluso puedes apreciar que son comunes los esclavos semihumanos.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_3 = "Sea donde sea que vayas siempre te sigue alguna que otra mirada de desprecio.\nPero tu sientes que puedes mejorar este pueblo, liberar a los semihumanos o eliminar el resentimiento que se ha podido crear hacia tu raza.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_4 = "Sumido en tu afán de descubrimiento recorres la ciudad en busca de algo que hacer; andando por un callejón te encuentras con un enano y un minotauro pegándole una golpiza a un semihumano conejo.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_5 = "Le ayudas (Escribe ayudar).";
    private static final String EL_PUEBLO_ENANO_OWARF_1_5_1 = "Intentas hablar con el minotauro para que deje de pegarlo (Escribe hablar).";
    private static final String EL_PUEBLO_ENANO_OWARF_1_5_1_1 = "El enano te dice; -Otra raza inferior se atreve a faltarme el respeto, destrúyelo Dominus- manda al minotauro a por ti. Comienza la batalla.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_5_2 = "Te cansas de el abuso que esta haciendo el minotauro y lo vas a resolver con la violencia (Escribe batalla). Comienza la pelea.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_5_1_VICTORIA = "Victoria. El minotauro yace en el suelo desmayado por los golpes, el enano se va corriendo aterrorizado.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_5_1_DERROTA = "Derrota. Yaces en el suelo desmayado, te levantas tras unas horas y sigues recorriendo la ciudad.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_6 = "Pasas de largo, no te quieres involucrar (Escribe pasar).";
    private static final String EL_PUEBLO_ENANO_OWARF_1_7 = "Llegas a el gremio de comerciantes, no sueles entrar pero escuchas un montón de ruido dentro por lo que te da curiosidad, abres la puerta y pasas.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_8 = "Dentro puedes ver a dos grupos de enanos peleándose entre si sobre si financiar un producto en desarrollo de la capital.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_9 = "Los escuchas y notas que el problema es que no están seguros de su beneficio y no quieren arriesgarse.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_10 = "Les das un consejo (Escribe consejo).";
    private static final String EL_PUEBLO_ENANO_OWARF_1_10_1 = "Les encanta tu consejo y te añaden al grupo, con tu ayuda haces que consigan mucho beneficio del proyecto.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_10_2 = "Después de estar casi todo el día ayudándoles, te retiras con una palmadita en la espalda.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_11 = "Te haces pasar por el representante del proyecto de la capital (Escribe representante).";
    private static final String EL_PUEBLO_ENANO_OWARF_1_11_3_1 = "No te creen, ellos no han llamado a nadie para nada.)";
    private static final String EL_PUEBLO_ENANO_OWARF_1_11_3_2 = "Te echan con una patada en el culo.";
    private static final String EL_PUEBLO_ENANO_OWARF_1_12 = "Pasas de largo (Escribe pasas).";
    private static final String EL_PUEBLO_ENANO_OWARF_1_13 = "Después de tus aventuras, te das un paseo por el pueblo para familiarizarte.";

    /**
     * Clase de los Enanos que recoge las partes de la Historia El Pueblo Enano
     * Owarf
     */
    public class ElPuebloEnanoOwarf extends Enanos {
        /**
         * Primera parte de la historia de los enanos; El pueblo enano de Owarf.
         * <p>
         * En esta primera parte el jugador se encontrara con un pueblo enano que tiene
         * una alta discriminacion ante todos los otros seres vivos que pasen por sus
         * caminos.
         * 
         * @param primerDesenlaceBucleSalir
         * @param segundoDesenlaceBucleSalir
         * @param elecionIntrahistoria
         * @param buffer
         * @see HistoriaDatos
         * @see PersonajePrinc
         */
        public static void ElPuebloEnanoOwarfParte1(
                String elecionIntrahistoria,
                PersonajePrinc personajePrincipal)
                throws IOException, InterruptedException {
            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_1);
            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_2);
            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_3);

            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_4);

            elecionIntrahistoria = LectorBuffRead.leer((EL_PUEBLO_ENANO_OWARF_1_5 + "\n"
                    + EL_PUEBLO_ENANO_OWARF_1_6 + "\n"),
                    "ayudar", "pasar");

            if (elecionIntrahistoria.equals("ayudar")) {

                elecionIntrahistoria = LectorBuffRead.leer((EL_PUEBLO_ENANO_OWARF_1_5_1 + "\n"
                        + EL_PUEBLO_ENANO_OWARF_1_5_2 + "\n"),
                        "hablar", "batalla");

                if (elecionIntrahistoria.equals("hablar")) {
                    TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_5_1_1);
                    if (personajePrincipal.CombateEntero(Enemigos.MINOTAURO.getVida(), Enemigos.MINOTAURO.getDaño())) {
                        TextosAscii.setCyan();
                        TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_5_1_VICTORIA);
                    } else {
                        TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_5_1_DERROTA);
                    }
                } else if (elecionIntrahistoria.equals("batalla")) {
                    if (personajePrincipal.CombateEntero(Enemigos.MINOTAURO.getVida(), Enemigos.MINOTAURO.getDaño())) {
                        TextosAscii.setCyan();
                        TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_5_1_VICTORIA);
                    } else {
                        TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_5_1_DERROTA);
                    }
                }

            } else if (elecionIntrahistoria.equals("pasar")) {
                TextoLento.printSlow("Pasas de largo.");
            }

            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_7);
            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_8);

            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_9);
            elecionIntrahistoria = LectorBuffRead.leer((EL_PUEBLO_ENANO_OWARF_1_10 + "\n"
                    + EL_PUEBLO_ENANO_OWARF_1_11 + "\n"
                    + EL_PUEBLO_ENANO_OWARF_1_12 + "\n"),
                    "consejo", "representante", "pasas");
            if (elecionIntrahistoria.equals("consejo")) {
                TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_10_1);
                TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_10_2);
            } else if (elecionIntrahistoria.equals("representante")) {
                TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_11_3_1);
                TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_11_3_2);
                personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
                personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_PUEBLO_ENANO_OWARF.getValue(), PlayerData.HISTORIA.getValue());// El pueblo enanos owarf
                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
            } else if (elecionIntrahistoria.equals("pasas")) {
            }
            TextoLento.printSlow(EL_PUEBLO_ENANO_OWARF_1_13);
        }
    }

    /**
     * Clase de los Enanos que recoge las partes de la Historia La Creacion del
     * Artefacto Mitico
     */
    public class LaCreacionDelArtefactoMitico extends Enanos {

        /**
         * Primera parte de la historia de los enanos; La creacion del artefacto mitico,
         * Los Hornos de Hefesto.
         * <p>
         * En esta primera parte el jugador tendra la oportunidad de apreciar uno de los
         * trabajos
         * que mas dedicacion merecen, la forja; alli se hara con una posicion que en
         * futuras partes
         * tendra que ir mejorando.
         * 
         * @param buffer
         * @see HistoriaDatos
         * @see PersonajePrinc
         */
        public static void LaCreacionDelArtefactoMiticoParte1(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_1);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_3);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_5);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_6);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_7);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_8);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_9);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_10);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_11);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_12);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_13);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_14);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_15);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_16);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_17);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_1_18);
            personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_CREACION_DEL_ARTEFACTO_MITICO.getValue(), PlayerData.HISTORIA.getValue());// La creacion del artefacto mitico
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
        }

        /**
         * Segunda parte de la historia de los enanos; La creacion del artefacto mitico,
         * El Camino del Acero.
         * <p>
         * En esta tercera parte el jugador se enfrenta a un peligro cotidiano para los
         * herreros,
         * una pelea contra el hierro.
         * 
         * @param primerDesenlaceBucleSalir
         * @param buffer
         * 
         * @see HistoriaDatos
         * @see Metodos
         */
        public static void LaCreacionDelArtefactoMiticoParte2(
                PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_1);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_3);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_5);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.pruebaAptitud(1, 0, 4)) {
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_5_VICTORIA);
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_6);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_CREACION_DEL_ARTEFACTO_MITICO.getValue(), PlayerData.HISTORIA.getValue());// La creacion del artefacto mitico
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
            } else {
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_2_5_DERROTA);
                LectorBuffRead.continuarHistoria();
            }

        }

        /**
         * Tercera parte de la historia de los enanos; La creacion del artefacto mitico,
         * El Fuego de la Ambición.
         * <p>
         * En esta tercera parte el jugador se enfrenta a un peligro cotidiano para los
         * herreros,
         * una pelea contra el hierro, y , a diferencia de la anterior parte, contra el
         * mas mitico metal,
         * el mithril.
         * 
         * @param primerDesenlaceBucleSalir
         * @param buffer
         * 
         * @see HistoriaDatos
         * @see Metodos
         * @see PersonajePrinc
         */
        public static void LaCreacionDelArtefactoMiticoParte3(
                PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_1);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_3);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_5);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_6);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_7);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.pruebaAptitud(2, 0, 4)) {
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_7_VICTORIA);
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_8);
                LectorBuffRead.continuarHistoria();
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_9);
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_10);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_CREACION_DEL_ARTEFACTO_MITICO.getValue(), PlayerData.HISTORIA.getValue());// La creacion del artefacto mitico
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
            } else {
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_3_7_DERROTA);
                LectorBuffRead.continuarHistoria();
            }
        }

        /**
         * Cuarta parte de la historia de los enanos; La creacion del artefacto mitico,
         * El Enfrentamiento con La Forja.
         * <p>
         * En esta cuarta parte final el jugador tiene la ultima tarea de enfrentarse
         * contra la forja y tomar su puesto como verdadero herrero.
         * 
         * @param buffer
         * 
         * @see HistoriaDatos
         * @see clases
         * @see Batalla
         * @see PersonajePrinc
         */
        public static void LaCreacionDelArtefactoMiticoParte4(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_1);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_3);
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_5);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.CombateEntero(Enemigos.LA_FORJA.getVida(), Enemigos.LA_FORJA.getDaño())) {
                TextosAscii.setCyan();
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_5_VICTORIA);
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_6);
                LectorBuffRead.continuarHistoria();
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_7);
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_8);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_LA_CREACION_DEL_ARTEFACTO_MITICO.getValue(), PlayerData.HISTORIA.getValue());// La creacion del artefacto mitico
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
            } else {
                TextoLento.printSlow(LA_CREACION_DEL_ARTEFACTO_MITICO_4_5_DERROTA);
                LectorBuffRead.continuarHistoria();
            }
        }
    }

    /**
     * Clase de los Enanos que recoge las partes de la Historia Los Enanos de Oro
     */
    public class ElCodiceMaldito extends Enanos {

        /**
         * Primera parte de la historia de los enanos; El Codice Maldito, La Noche de la
         * Cosecha.
         * <p>
         * En esta primera parte el jugador se encuentra con un pequeño poblado con
         * gente muy amable
         * y una historia que relata un futuro muy oscuro.
         * 
         * @see HistoriaDatos
         * @see PersonajePrinc
         */
        public static void ElCodiceMalditoParte1(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(EL_CODICE_MALDITO_1_1);
            TextoLento.printSlow(EL_CODICE_MALDITO_1_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_1_3);
            TextoLento.printSlow(EL_CODICE_MALDITO_1_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_1_5);
            TextoLento.printSlow(EL_CODICE_MALDITO_1_6);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_1_7);
            TextoLento.printSlow(EL_CODICE_MALDITO_1_8);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_1_9);
            TextoLento.printSlow(EL_CODICE_MALDITO_1_10);
            LectorBuffRead.continuarHistoria();
            personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_CODICE_MALDITO.getValue(), PlayerData.HISTORIA.getValue());// El codice maldito
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
        }

        public static void ElCodiceMalditoParte2(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(EL_CODICE_MALDITO_2_1);
            TextoLento.printSlow(EL_CODICE_MALDITO_2_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_2_3);
            TextoLento.printSlow(EL_CODICE_MALDITO_2_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_2_5);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.CombateEntero(Enemigos.GOBLIN_GRUPO.getVida(), Enemigos.GOBLIN_GRUPO.getDaño())) {
                TextosAscii.setCyan();
                TextoLento.printSlow(EL_CODICE_MALDITO_2_5_VICTORIA);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_CODICE_MALDITO.getValue(), PlayerData.HISTORIA.getValue());// El codice maldito
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
            } else {
                TextoLento.printSlow(EL_CODICE_MALDITO_2_5_DERROTA);
                LectorBuffRead.continuarHistoria();
            }
        }

        public static void ElCodiceMalditoParte3(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(EL_CODICE_MALDITO_3_1);
            TextoLento.printSlow(EL_CODICE_MALDITO_3_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_3_3);
            TextoLento.printSlow(EL_CODICE_MALDITO_3_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_3_5);
            TextoLento.printSlow(EL_CODICE_MALDITO_3_6);
            LectorBuffRead.continuarHistoria();

            if (personajePrincipal.CombateEntero(Enemigos.LICH.getVida(), Enemigos.LICH.getDaño())) {
                TextosAscii.setCyan();
                TextoLento.printSlow(EL_CODICE_MALDITO_3_6_VICTORIA);
                TextoLento.printSlow(EL_CODICE_MALDITO_3_7);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_CODICE_MALDITO.getValue(), PlayerData.HISTORIA.getValue());// El codice maldito
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
            } else {
                TextoLento.printSlow(EL_CODICE_MALDITO_3_6_DERROTA);
                LectorBuffRead.continuarHistoria();
            }
        }

        public static void ElCodiceMalditoParte4(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(EL_CODICE_MALDITO_4_1);
            TextoLento.printSlow(EL_CODICE_MALDITO_4_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_4_3);
            TextoLento.printSlow(EL_CODICE_MALDITO_4_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(EL_CODICE_MALDITO_4_5);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.CombateEntero(Enemigos.TITAN_DEL_RAGNAROK.getVida(),
                    Enemigos.TITAN_DEL_RAGNAROK.getDaño())) {
                TextosAscii.setCyan();
                TextoLento.printSlow(EL_CODICE_MALDITO_4_5_VICTORIA);
                TextoLento.printSlow(EL_CODICE_MALDITO_4_6);
                LectorBuffRead.continuarHistoria();
                TextoLento.printSlow(EL_CODICE_MALDITO_4_7);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Enano.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Enanos
                personajePrincipal.setHistoria(PlayerData.HISTORIA_EL_CODICE_MALDITO.getValue(), PlayerData.HISTORIA.getValue());// El codice maldito
                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
            } else {
                TextoLento.printSlow(EL_CODICE_MALDITO_4_5_DERROTA);
                LectorBuffRead.continuarHistoria();
            }
        }
    }

}
