package historias;

import java.io.IOException;

import clases.PersonajePrinc;
import clases.PlayerData;
import clases.Razas;
import utilidades.Aleatoriedad;
import utilidades.LectorBuffRead;
import utilidades.TextoLento;
import utilidades.TextosAscii;

public abstract class Elfos {

    private static final String ZELDA_1_1 = "Vas caminando por una pradera, ante ti a lo lejos puedes apreciar un gran castillo.";
    private static final String ZELDA_1_2 = "Te fijas y ves que de el sale un aura oscura con forma de jabali.";
    private static final String ZELDA_1_3 = "De repente escuchas una voz susurrante: -Ayudaaa...";
    private static final String ZELDA_1_4 = "Te giras y dejas de escucharlo, seguido lo vuelves a escuchar pero ahora muy alto: -¡Ayuda, en el castillo!.";
    private static final String ZELDA_1_5 = "Parece que alguien te necesita pero no sabes quien, que haras.(Escribe IR si quieres ir a ayudarla)";
    private static final String ZELDA_2_1 = "Cada paso que das hacia el castillo hace que el aire se torne más denso, pesado. \nLa hierba que antes se mecía con el viento ahora parece marchita bajo tus pies. \nUn escalofrío recorre tu espalda cuando llegas a la imponente puerta de madera, medio abierta.";
    private static final String ZELDA_2_2 = "Al entrar, el eco de tus pisadas resuena en la vastedad del vestíbulo. \nUn candelabro cuelga del techo, con velas que gotean cera negra. \nUn corredor oscuro se extiende ante ti, y de las sombras emerge una silueta tambaleante. \nEs un guardia, su armadura cubierta de un espeso hollín negro. \nAl verte, alza su espada y ruge con un sonido inhumano.";
    private static final String ZELDA_2_3 = "La criatura se lanza hacia ti.";
    private static final String ZELDA_2_4 = "(Batalla contra el Caballero de la muerte)";
    private static final String ZELDA_2_4_VICTORIA = "Tras la confrontación, encuentras una puerta trasera que conduce a un camino escarpado. \nNecesitas descansar y prepararte antes de continuar con tu viaje. \nLas colinas más adelante parecen un buen lugar para reagruparse y tomar decisiones antes de adentrarte en lo desconocido.";
    private static final String ZELDA_2_4_DERROTA = "Caes moribundo al suelo, mientras el caballero se vuelve a su sitio, como si nunca hubieses llegado.";
    private static final String ZELDA_3_1 = "Avanzas por un sendero sombrío, bordeado por árboles retorcidos cuyas ramas parecen susurrar secretos al viento. \nLa luna, alta en el cielo, baña el camino con una luz plateada, pero no es suficiente para disipar la sensación de que algo te observa desde las sombras.";
    private static final String ZELDA_3_2 = "Después de horas de caminata, llegas a las ruinas de una antigua fortaleza, un vestigio de tiempos olvidados que ahora sirve como el último umbral antes de la confrontación final. \nEl castillo, visible a lo lejos, se alza como una silueta imponente contra el horizonte estrellado. \nSabes que no hay vuelta atrás.";
    private static final String ZELDA_3_3 = "Dentro, tras sortear varios pasillos infestados de sombras retorcidas, llegas a la gran sala del trono. \nAhí, sentado en un asiento de piedra tallada con símbolos oscuros, un hombre de rostro pálido y ojos vacíos te observa con curiosidad. \nEn su pecho brilla un orbe oscuro pulsante: la fuente del aura maligna.";
    private static final String ZELDA_3_4 = "\"¿Vienes a salvarme o a condenarme?\" pregunta con una voz hueca.";
    private static final String ZELDA_3_5 = "Su figura tiembla, y la forma del jabalí negro se manifiesta tras él, rugiendo con furia. \nEl castillo entero parece estremecerse.";
    private static final String ZELDA_3_6 = "Debes decidir.";
    private static final String ZELDA_3_7 = "(Escribe \"ATACAR\" para destruir el orbe o \"DIALOGAR\" para intentar liberar al hombre).";
    private static final String ZELDA_3_7_DESTRUCCION = "Destruyes el orbe, este se desace junto al hombre que lo llevaba";
    private static final String ZELDA_3_7_LIBERTAD = "Consigues liberar al hombre del orbe a la fuerza, este pierde toda accion con el orbe y comienza a morir.\n\"Gracias\" te dice el hombre antes de respirar su ultimo aliento";
    private static final String ZELDA_3_7_DERROTA = "Caes hacia el suelo moribundo, pero no te da tiempo a llegar.\nMientras estas cayendo la sombra del jabali te absorbe.";
    private static final String ZELDA_3_8 = "El suelo del castillo comienza a desmoronarse, obligándote a salir apresuradamente por un túnel subterráneo. \nAl otro lado, una vasta llanura se extiende ante ti, iluminada por una luna fantasmal. \nTu destino final se encuentra al otro extremo, \npero hay tiempo para recuperar fuerzas... o explorar los misterios de esta nueva región.";
    private static final String ZELDA_4_1 = "La travesía ha sido larga y peligrosa, pero finalmente llegas a la cima de una colina escarpada desde la que se divisa el castillo en toda su macabra imponencia. \nRodeado de acantilados y un río de aguas turbias, el único acceso es un puente de piedra antigua, agrietado y cubierto de niebla.";
    private static final String ZELDA_4_2 = "A medida que avanzas, el aire se vuelve denso, impregnado con un hedor a muerte y descomposición. \nLa tierra aquí es árida, sin señales de vida, como si el propio suelo hubiera sido maldecido. \nA cada paso, un eco lejano resuena, una mezcla de lamentos y susurros incomprensibles que te rodean sin un origen claro.";
    private static final String ZELDA_4_3 = "El enfrentamiento final está aquí. \nYa sea que hayas destruido el orbe o intentado razonar con su portador, la amenaza real aún no se ha manifestado por completo.";
    private static final String ZELDA_4_4 = "Un rugido profundo retumba en la sala, y el aire se vuelve gélido. \nAnte ti, el hombre que antes estaba en el trono comienza a cambiar. \nSu cuerpo se estira, creciendo hasta alcanzar casi tres metros de altura. \nSu piel se torna cenicienta, y su aura oscura se solidifica en una niebla densa que emana muerte y desesperación.";
    private static final String ZELDA_4_5 = "Los ojos vacíos ahora brillan con un fuego espectral. \nSu silueta, humanoide pero colosal, se encorva con una fuerza descomunal. \nEn sus manos, dedos alargados y afilados como cuchillas emiten un resplandor sombrío.";
    private static final String ZELDA_4_6 = "\"Soy la sombra que nunca desaparece... la condena eterna...\", su voz resuena en todas direcciones.";
    private static final String ZELDA_4_7 = "El castillo tiembla con cada paso que da hacia ti. No hay escapatoria. \nSolo queda el combate final contra la manifestación definitiva de la maldición.";
    private static final String ZELDA_4_8 = "(Que comience el combate).";
    private static final String ZELDA_4_8_DERROTA = "Las sombras te rodean y acabas siendo parte de ellas. \nHas muerto";

    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_1 = "Llegas al bosque sagrado elfo de Eldraine, una protección elfa en la que se encuentra el mítico árbol del mundo, reinado por la sabia Enieri.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_2 = "Pero no llegas en buen momento, el reino humano de Raventhorne esta asediando la ciudad, tu te encuentras en medio de una contienda entre un batallón de cada bando.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3 = "Decides ayudar a los humanos (Escribe humanos).";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA = "El comandante humano te agradece la ayuda y te ofrece un puesto en sus filas.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_1 = "Aceptas (Escribe si).";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_1_1 = "Te unes al ejercito humano de Raventhorne.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_2 = "Ansias mas poder en el ejercito y intentas obtener el titulo del comandante, intentas cortarle el cuello (Escribe batalla).";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_2_VICTORIA = "Te conviertes en el comandante de la 16 legion humana en la guerra contra los elfos";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_2_DERROTA = "Le clavas su propio cuchillo en el cuello, pero te das cuenta que también te había herido gravemente a ti, los dos yaceis en el suelo muertos.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_3 = "Te niegas (Escribe no).";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_3_1 = "Te marchas y sigues tu camino.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_3_DERROTA = "Yaces en el suelo mientras pasan por encima hordas de elfos y humanos.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_4 = "Decides ayudar a los elfos (Escribe elfos).";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_4_VICTORIA = "Ganáis la batalla pero las tropas humanas no cesan, por lo que un elfo te ofrece huir con ellos.\nAl llegar a la ciudad elfa, tienes una audiencia con su majestad Enieri.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_4_VICTORIA_1 = "Muchos de los ministros de la reina votan por tu ejecución por ser de la misma raza que sus conquistadores, pero la reina te salva, ella confía en tu buena voluntad.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_4_VICTORIA_2 = "Ella te agradece sinceramente tu ayuda, aun con las negativas de sus ministros, te da una recompensa y te pide que vuelvas a ayudarlos en futuras ocasiones.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_4_DERROTA = "Yaces en el suelo mientras pasan por encima hordas de elfos y humanos.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_1_5 = "No haces nada y sigues tu camino (Escribe nada).";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_1 = "Tras tu primera victoria, Lord Garrick te encomienda una misión de gran importancia: \ntomar un antiguo templo élfico en los límites del bosque. \nAunque es un lugar sagrado para los elfos, su posición estratégica lo convierte en una clave para la invasión.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_2 = "El asedio es brutal. \nLos elfos defienden el templo con fiereza, pero los números humanos se imponen. \nCuando la batalla cesa, te encuentras en el corazón del santuario, un lugar donde la magia antigua aún susurra entre los árboles centenarios. \nEntonces, el comandante da la orden:";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_3 = "Profanar el templo (\"Escribe Profanar\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_4 = "Preservar el templo (\"Escribe Preservar\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_4_PROFANAR = "Empuñas tu espada y golpeas la piedra sagrada, quebrándola en mil pedazos. \nLos sacerdotes élficos caen de rodillas, gritando mientras la magia del bosque se dispersa en el aire. \nTus compañeros humanos vitorean y Lord Garrick te observa con aprobación. \n\"Tienes el temple de un verdadero guerrero de Raventhorne\", dice. \nSin embargo, mientras el bosque parece apagarse a tu alrededor, sientes una extraña inquietud…";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_4_PRESERVAR = "Detienes tu espada a mitad del golpe y bajas el arma. \n\"No hay honor en destruir lo que no comprendemos\", declaras. \nAlgunos soldados te observan con recelo, pero otros, impresionados por tu juicio, también bajan las armas. \nUn oficial de alto rango frunce el ceño y murmura: \n\"No todos estarán de acuerdo con esto…\".";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_5 = "Tu elección marca el inicio de tu verdadero camino en la guerra.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_1 = "Tras un largo viaje con los elfos, llegas al Corazón del Bosque, donde el Árbol del Mundo se alza imponente. \nEnieri te observa con atención y murmura: \"El bosque te acepta… o te rechaza\".";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_2 = "Cerrando los ojos, sientes que la magia te envuelve y te muestra una visión del futuro:";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_3_MAL = "Ves las raíces ardiendo y los gritos de los elfos ahogándose en la destrucción. \nUna figura oscura, envuelta en fuego, lidera la masacre.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_3_BIEN = "Entre las cenizas, un humano y un elfo se estrechan la mano. \nEl bosque florece de nuevo y el Árbol del Mundo brilla con una luz renovada.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_2_4 = "Cuando despiertas, el Árbol ha dejado su marca en ti. Ahora eres parte de su legado.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_1 = "De regreso en la capital, eres recibido con honores. \nEl rey Alistair observa con interés tu ascenso en la guerra. \n\"Un guerrero con ambición siempre encuentra su camino\", dice, mientras un banquete se sirve en su honor.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_2 = "Durante tu estancia en la corte, descubres un complot: un grupo de nobles, liderados por Lord Cedric, desean acelerar la guerra y utilizar la magia élfica para su propio beneficio. \nEn una noche oscura, Cedric se te acerca con una oferta:";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_3 = "Unirte a la conspiración (\"Escribe Si\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_4 = "Informar al rey (\"Escribe No\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_4_SI = "Cedric te conduce a una sala privada donde otros nobles esperan. \n\"El rey es un viejo tonto\", susurra. \"Los elfos tienen algo más valioso que su tierra… su magia. \nCon tu fuerza, podemos tomar el trono y usar su poder para forjar un imperio inigualable\". \nAceptar su propuesta te pondrá en un camino de ambición y traición, pero te asegurará un lugar en la cima.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_4_NO = "Durante una audiencia con el rey, relatas todo lo que has descubierto. \nSu mirada se endurece y sus manos se cierran en puños. \n\"Así que hasta en mi propia corte hay serpientes\", murmura. \nOrdena la captura de Cedric y sus aliados, lo que fortalece tu lealtad y posición dentro del reino. \nPero los conspiradores no olvidan…";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_1 = "Los elfos comienzan a confiar en ti, pero pronto descubres que uno de sus propios líderes está proporcionando información a los humanos. \nSe dice que lo hace por desesperación, creyendo que la guerra está perdida.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_2 = "Enfrentarlo y ejecutarlo (\"Escribe Ejecutar\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_3 = "Intentar convencerlo (\"Escribe Convencer\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_3_EJECUTAR = "Lo localizas en la noche y lo desafías en combate. \nSu hoja es rápida, pero tu determinación es más fuerte. \nCuando su cuerpo cae, los elfos ven en ti a un verdadero guardián. \nSin embargo, algunos murmuran si fue la decisión correcta…";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_3_3_CONVENCER = "Te acercas a él con palabras en lugar de armas. \n\"No somos enemigos de nosotros mismos\", dices. \nTras una tensa conversación, el elfo baja la cabeza y se arrodilla. \n\"Quizás aún hay esperanza\", susurra. Su destino ahora está ligado al tuyo.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_1 = "El ejército de Raventhorne marcha hacia la ciudad élfica. \nLa guerra está llegando a su punto final, y las llamas de la destrucción iluminan el bosque ancestral. \nPero en el último momento, la reina Enieri se presenta ante ti. \nSu mirada es serena, pero su voz lleva el peso de la historia.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_2 = "Comandar el asalto (\"Escribe Batalla\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3 = "Buscar la paz (\"Escribe Paz\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_BATALLA = "\"¡Que caigan los muros de Eldraine!\" gritas, y los humanos avanzan con furia.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_PAZ = "Bajas tu arma y te acercas a Enieri. \"Esta guerra ha durado demasiado\", dices. \nAlgunos soldados a tus espaldas murmuran, pero otros también bajan sus espadas. \nSi has construido lazos con ambas partes, la tregua puede ser posible. \nSi no, ambos bandos te considerarán un traidor…";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_BATALLA_VICTORIA = "La resistencia élfica es feroz, pero uno a uno caen. \nLa magia del bosque se apaga y, con ella, las esperanzas de su pueblo. \nCuando finalmente tomas el trono en la ciudad caída, los gritos de los elfos resuenan en la distancia. \nHas sellado el destino de su gente… y el tuyo.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_PAZ_FALLADA = "Sumido en tu arrogancia has planteado una paz que nadie pedia. \nUnas tropas como las otras se tiran sobre ti y te cortan la cabeza. \nHas muerto.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_BATALLA_DERROTA = "Has subestimado a los elfos, caes fallecido al suelo. \nEn tu último respiro se te acerca Enieri y con la misma piedad que tuviste con su pueblo te clava su espada en el corazón. \nHas muerto.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_1 = "Los muros de la ciudad están a punto de caer. \nLa reina Enieri invoca el poder del Árbol del Mundo, pero la magia es demasiado fuerte. \nEl bosque entero tiembla y la energía comienza a devorarlo todo.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_2 = "Te sacrificas para detener la destrucción (Escribe \"Sacrificio\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_3 = "Intentas sellar la magia y negociar la paz (Escribe \"Paz\")";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_2_VICTORIA = "Caminas hacia el Árbol, sintiendo su esencia envolverte. \nSu poder te consume, y en un destello de luz, el caos cesa. \nHas salvado Eldraine, pero te has convertido en parte del Árbol para siempre.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_3_VICTORIA = "Con un último esfuerzo, controlas la energía del Árbol y detienes la destrucción. \nLa reina y el ejército humano quedan en silencio. \nAhora tienes la oportunidad de acabar con la guerra de una vez por todas.";
    private static final String LOS_PROTECTORES_DEL_BOSQUE_4_3_DERROTA = "Lamentablemente tu alma no es tan pura como para parar la magia. \nHas muerto, la magia del árbol del mundo se descontrola y convierte el mundo en una reserva floral.";

    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_1 = "Te encuentras con una civilización que no parece muy desarrollada arquitectónicamente pero de una majestuosidad apabullante.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_2 = "Ves casas en los árboles, con puentes entre ellas y enredaderas que van desde el suelo a lo más alto de esos enormes árboles.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_3 = "Y en medio de la ciudad un árbol que destaca de entre todos los otros, el árbol del mundo,\n del que se dice que es tan alto que conecta el cielo con el infierno.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_4 = "Mientras paseas por la ciudad una tienda te llama la atención en específico, una tienda de objetos antiguos regentada por la arqueóloga Carmen.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_5 = "Al entrar te encuentras con un montón de artículos de antigüedad extrema, casi parece como si fuesen a volverse polvo y desaparecer.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_6 = "En el mostrador hay una montaña de libros, de la que emanan unos ruidos extraños como si de una ratilla salieran, te acercas a ver.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_7 = "Al acercarte ves a Carmen la dueña de la tienda rebuscando entre los libros la respuesta a un enigma imposible.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_8 = "-Lo he encontrado, lo he encontrado es la puerta a…- dice Carmen mientras remueve libros buscando el que necesita sin éxito, con la mala suerte que tira uno antes de terminar la frase,\n el libro empuja tanto polvo al caer que casi pareciera que se empieza a formar un tornado.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_9 = "La ayudas y le recoges el libro, ella al verte exclama- !Un aventurero, si, eso necesitaba, un aventurero.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_10 = "Te coje del brazo y te lleva al almacén de la tienda, allí hay una mesa con un montón de papeles encima.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_11 = "Ella te enseña un mapa de lo que parece ser una cueva, -Es la cueva del árbol, me he adentrado lo suficiente como para desentrañar sus secretos,\n pero ya no puedo avanzar, necesito la ayuda de un aventurero y su fuerza para avanzar.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_12 = "¿Te pide ayuda para avanzar, la ayudaras? (Escribe 'ayudar' si quieres ayudarla)";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_12_LA_AYUDA = "-Te ayudaré- le dices, ella sonríe de oreja a oreja y te insta a volver dentro de un tiempo para adentrarte con ella en las ruinas.";
    private static final String LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_12_NO_LA_AYUDA = "-No puedo lo siento- le dices,ella enfadada te echa de la tienda, entristecido con tu mala experiencia en la ciudad abandonas Eldraine.";

    /**
     * Clase de los elfos que recoge las partes de la Historia Zelda
     */
    public abstract class Zelda extends Elfos {
        /**
         * Primera parte de la HistoriaDatos de los elfos; Zelda, La llamada de auxilio
         * .
         * <p>
         * En esta primera parte se encontrara con la llamada caracteristica de la
         * princesa zelda
         * al inicio de los miticos juegos de nintendo.
         * 
         * @see HistoriaDatos
         * @see Zelda
         * @see PersonajePrinc
         */
        public static void ZeldaParte1(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(ZELDA_1_1);
            TextoLento.printSlow(ZELDA_1_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_1_3);
            TextoLento.printSlow(ZELDA_1_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_1_5);
            personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
            personajePrincipal.setHistoria(PlayerData.HISTORIA_ZELDA.getValue(), PlayerData.HISTORIA.getValue());// Zelda
            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(),
                    PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
            LectorBuffRead.continuarHistoria();
        }

        /**
         * Segunda parte de la HistoriaDatos de los elfos; Zelda, El Umbral de la
         * Maldición.
         * <p>
         * En esta parte el jugador se encuentra con un caballero de la muerte al que
         * teien que vencer para avanzar en la historia
         * 
         * @param buffer
         * @throws IOException, InterruptedException
         * @see HistoriaDatos
         * @see Zelda
         * @see PersonajePrinc
         */
        public static void ZeldaParte2(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(ZELDA_2_1);
            TextoLento.printSlow(ZELDA_2_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_2_3);
            TextoLento.printSlow(ZELDA_2_4);
            LectorBuffRead.continuarHistoria();
            if (personajePrincipal.CombateEntero(Enemigos.CABALLERO_DE_LA_MUERTE.getVida(),
                    Enemigos.CABALLERO_DE_LA_MUERTE.getDaño())) {
                TextosAscii.setVerde();
                TextoLento.printSlow(ZELDA_2_4_VICTORIA);
                personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                personajePrincipal.setHistoria(PlayerData.HISTORIA_ZELDA.getValue(), PlayerData.HISTORIA.getValue());// Zelda
                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(),
                        PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
            } else {
                TextoLento.printSlow(ZELDA_2_4_DERROTA);
            }
        }

        /**
         * Tercera parte de la HistoriaDatos de los elfos; Zelda, El Castigo del hombre.
         * <p>
         * En esta parte, el jugador se encuentra con las malicias del villano en donde
         * podra salvar a una persona que fue absorvida por un tanto poderoso como vil
         * hechizo
         * 
         * @param primerDesenlaceBucleSalir
         * @param elecionIntrahistoria
         * @param buffer
         * @throws IOException, InterruptedException
         * @see HistoriaDatos
         * @see Zelda
         * @see PersonajePrinc
         */
        public static void ZeldaParte3(String elecionIntrahistoria, PersonajePrinc personajePrincipal)
                throws IOException, InterruptedException {

            TextoLento.printSlow(ZELDA_3_1);
            TextoLento.printSlow(ZELDA_3_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_3_3);
            TextoLento.printSlow(ZELDA_3_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_3_5);
            TextoLento.printSlow(ZELDA_3_6);

            elecionIntrahistoria = utilidades.LectorBuffRead.leer(ZELDA_3_7, "ATACAR", "DIALOGAR");

            switch (elecionIntrahistoria) {
                case "ATACAR":
                    if (personajePrincipal.CombateEntero(Enemigos.GANONDORF_PARCIAL.getVida(),
                            Enemigos.GANONDORF_PARCIAL.getDaño())) {
                        TextosAscii.setVerde();
                        TextoLento.printSlow(ZELDA_3_7_DESTRUCCION);
                        TextoLento.printSlow(ZELDA_3_8);
                        personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                        personajePrincipal.setHistoria(PlayerData.HISTORIA_ZELDA.getValue(),
                                PlayerData.HISTORIA.getValue());// Zelda
                        personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(),
                                PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
                    } else {
                        TextoLento.printSlow(ZELDA_3_7_DERROTA);
                    }
                    break;

                case "DIALOGAR":
                    if (personajePrincipal.CombateEntero(Enemigos.GANONDORF_PARCIAL.getVida(),
                            Enemigos.GANONDORF_PARCIAL.getDaño())) {
                        TextosAscii.setVerde();
                        TextoLento.printSlow(ZELDA_3_7_LIBERTAD);
                        TextoLento.printSlow(ZELDA_3_8);
                        personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                        personajePrincipal.setHistoria(PlayerData.HISTORIA_ZELDA.getValue(),
                                PlayerData.HISTORIA.getValue());// Zelda
                        personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(),
                                PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
                    } else {
                        TextoLento.printSlow(ZELDA_3_7_DERROTA);
                    }
                    break;
            }
        }

        /**
         * Cuarta y ultima parte de la HistoriaDatos de los elfos; Zelda, El Último
         * Ocaso.
         * <p>
         * En este final de historia el jugador finalmente se encuentra con el villano
         * principal Ganondorf.
         * 
         * @param buffer
         * @throws IOException, InterruptedException
         * @see HistoriaDatos
         * @see Zelda
         * @see PersonajePrinc
         */
        public static void ZeldaParte4(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            TextoLento.printSlow(ZELDA_4_1);
            TextoLento.printSlow(ZELDA_4_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_4_3);
            TextoLento.printSlow(ZELDA_4_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_4_5);
            TextoLento.printSlow(ZELDA_4_6);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(ZELDA_4_7);
            TextoLento.printSlow(ZELDA_4_8);
            LectorBuffRead.continuarHistoria();

            if (personajePrincipal.CombateEntero(Enemigos.GANONDORF_FINAL.getVida(),
                    Enemigos.GANONDORF_FINAL.getDaño())) {
                TextosAscii.setVerde();
                personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                personajePrincipal.setHistoria(PlayerData.HISTORIA_ZELDA.getValue(), PlayerData.HISTORIA.getValue());// Zelda
                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(),
                        PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
            } else {
                TextoLento.printSlow(ZELDA_4_8_DERROTA);
            }

        }
    }

    /**
     * Clase de los elfos que recoge las partes de la Historia Los Protectores del
     * Bosque
     */
    public class LosProtectoresDelBosque extends Elfos {
        private static int finalElegido;
        private static int bandoElegido;
        private static int probabilidadSalvacion;
        private static int probabilidadPaz;
        private static int finalHumanos;
        private static int finalElfos;

        public static int getFinalHumanos() {
            return finalHumanos;
        }

        public static void setFinalHumanos(int finalHumanos) {
            LosProtectoresDelBosque.finalHumanos = finalHumanos;
        }

        public static int getFinalElfos() {
            return finalElfos;
        }

        public static void setFinalElfos(int finalElfos) {
            LosProtectoresDelBosque.finalElfos = finalElfos;
        }

        public static int getProbabilidadSalvacion() {
            return probabilidadSalvacion;
        }

        public static void setProbabilidadSalvacion(int probabilidadSalvacion) {
            LosProtectoresDelBosque.probabilidadSalvacion = probabilidadSalvacion;
        }

        public static int getProbabilidadPaz() {
            return probabilidadPaz;
        }

        public static void setProbabilidadPaz(int probabilidadPaz) {
            LosProtectoresDelBosque.probabilidadPaz = probabilidadPaz;
        }

        public static int getBandoElegido() {
            return bandoElegido;
        }

        public static void setBandoElegido(int bandoElegido) {
            LosProtectoresDelBosque.bandoElegido = bandoElegido;
        }

        public static int getFinalElegido() {
            return finalElegido;
        }

        public static void setFinalElegido(int finalElegido) {
            LosProtectoresDelBosque.finalElegido = finalElegido;
        }

        /**
         * Primera parte de la HistoriaDatos de los elfos; los protectores del bosque.
         * <p>
         * En esta primera parte se presenta una guerra entre los humanos y los elfos,
         * en esta el jugador
         * se podra unir a segun que bando; sus aciones influiran en el futuro de la
         * partida.
         * 
         * @param primerDesenlaceBucleSalir
         * @param elecionIntrahistoria
         * @param buffer
         * @throws IOException, InterruptedException
         * @see HistoriaDatos
         * @see PersonajePrinc
         */
        public static void LosProtectoresDelBosqueParte1(
                String elecionIntrahistoria,
                PersonajePrinc personajePrincipal) throws IOException, InterruptedException {

            TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_1);

            TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_2);

            elecionIntrahistoria = LectorBuffRead.leer((LOS_PROTECTORES_DEL_BOSQUE_1_3 + "\n"
                    + LOS_PROTECTORES_DEL_BOSQUE_1_4 + "\n" + LOS_PROTECTORES_DEL_BOSQUE_1_5),
                    "humanos", "elfos","nada");

            switch (elecionIntrahistoria) {
                case "humanos":
                    if (personajePrincipal.CombateEntero(Enemigos.ELFO_BASE.getVida(), Enemigos.ELFO_BASE.getDaño())) {

                        TextosAscii.setVerde();
                        elecionIntrahistoria = LectorBuffRead.leer((LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA + "\n"
                                + LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_1 + "\n"
                                + LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_2 + "\n"
                                + LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_3 + "\n"),
                                "si", "batalla", "no");

                        switch (elecionIntrahistoria) {
                            case "si":
                                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_1_1);

                                LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_HUMANO.getValue());

                                personajePrincipal.setHistoria(Razas.Elfo.getValue(),
                                        PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(
                                        PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(),
                                        PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(),
                                        PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
                                break;
                            case "batalla":
                                if (personajePrincipal.CombateEntero(Enemigos.HUMANO_COMANDANTE.getVida(),
                                        Enemigos.HUMANO_COMANDANTE.getDaño())) {

                                    TextosAscii.setVerde();
                                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_2_VICTORIA);
                                    personajePrincipal.setHistoria(Razas.Elfo.getValue(),
                                            PlayerData.HISTORIA_RAZA.getValue());// Elfos

                                    personajePrincipal.setHistoria(
                                            PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(),
                                            PlayerData.HISTORIA.getValue());// Los protectores del bosque

                                    personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(),
                                            PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada

                                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_HUMANO.getValue());
                                } else {
                                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_2_DERROTA);
                                }
                                break;
                            case "no":
                                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_3_VICTORIA_3_1);
                                Zelda.ZeldaParte1(personajePrincipal);

                                break;

                            default:
                                TextoLento.printSlow("por favor elija una de las opciones");
                                break;
                        }

                    } else {
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_3_DERROTA);
                    }
                    break;
                case "elfos":

                    if (personajePrincipal.CombateEntero(Enemigos.HUMANO_BASE.getVida(),
                            Enemigos.HUMANO_BASE.getDaño())) {
                        TextosAscii.setVerde();
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_4_VICTORIA);
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_4_VICTORIA_1);
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_4_VICTORIA_2);
                        personajePrincipal.setDinero(personajePrincipal.getDinero() + 10);
                        LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_ELFO.getValue());
                        personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
                    } else {
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_1_4_DERROTA);
                    }
                    break;
                case "nada":
                    Zelda.ZeldaParte1(personajePrincipal);
                    break;

                default:
                    TextoLento.printSlow("Por favor elija una de las opciones aventurero");
                    break;
            }
        }

        public static void LosProtectoresDelBosqueParte2(String elecionIntrahistoria,
                PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            if (LosProtectoresDelBosque.getBandoElegido() == 1) {
                // Camino Humano
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_1);
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_2);
                LectorBuffRead.continuarHistoria();

                elecionIntrahistoria = LectorBuffRead.leer((LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_3 + "\n"
                        + LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_4 + "\n"), "Profanar", "Preservar");
                if (elecionIntrahistoria.equals("Profanar")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_4_PROFANAR);
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_5);
                    LectorBuffRead.continuarHistoria();
                    personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                    personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                    personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_ELFO.getValue());
                } else if (elecionIntrahistoria.equals("Preservar")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_4_PRESERVAR);
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_HUMANOS_5);
                    LectorBuffRead.continuarHistoria();
                    LosProtectoresDelBosque.setProbabilidadPaz(
                            LosProtectoresDelBosque.getProbabilidadPaz() + Aleatoriedad.devolverNumero(30));
                            personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_HUMANO.getValue());
                }
            } else {
                // Camino Elfo
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_1);
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_2);
                LectorBuffRead.continuarHistoria();
                if (Aleatoriedad.devolverNumero(100) >= 50) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_3_BIEN);
                    LosProtectoresDelBosque.setProbabilidadSalvacion(
                            LosProtectoresDelBosque.getProbabilidadSalvacion() + Aleatoriedad.devolverNumero(30));
                } else {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_3_MAL);
                }
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_2_4);
                LectorBuffRead.continuarHistoria();
                personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE2.getValue());// Parte 2 terminada
                LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_ELFO.getValue());
            }
        }

        public static void LosProtectoresDelBosqueParte3(String elecionIntrahistoria,
                PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            if (LosProtectoresDelBosque.getBandoElegido() == 1) {
                // Camino Humano
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_1);
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_2);
                LectorBuffRead.continuarHistoria();

                elecionIntrahistoria = LectorBuffRead.leer((LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_3 + "\n"
                        + LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_4 + "\n"),
                        "Si", "No");

                if (elecionIntrahistoria.equals("Si")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_4_SI);
                    LosProtectoresDelBosque.setProbabilidadPaz(LosProtectoresDelBosque.getProbabilidadPaz() - 20);
                    personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_HUMANO.getValue());
                } else if (elecionIntrahistoria.equals("No")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_HUMANOS_4_NO);
                    LosProtectoresDelBosque.setProbabilidadPaz(
                            LosProtectoresDelBosque.getProbabilidadPaz() + Aleatoriedad.devolverNumero(70));
                            personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_HUMANO.getValue());
                }

            } else {
                // Camino Elfo
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_1);
                LectorBuffRead.continuarHistoria();

                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_2);
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_3);
                if (elecionIntrahistoria.equals("Ejecutar")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_3_EJECUTAR);
                    LosProtectoresDelBosque
                            .setProbabilidadSalvacion(LosProtectoresDelBosque.getProbabilidadSalvacion() - 20);
                            personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                            personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_ELFO.getValue());
                } else if (elecionIntrahistoria.equals("Convencer")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_3_3_CONVENCER);
                    LosProtectoresDelBosque.setProbabilidadSalvacion(
                    LosProtectoresDelBosque.getProbabilidadSalvacion() + Aleatoriedad.devolverNumero(70));
                    personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                    personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                    personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE3.getValue());// Parte 3 terminada
                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_ELFO.getValue());
                } else {
                    TextoLento.printSlow("Por favor escriba una de las opciones.");
                }

            }
        }

        public static void LosProtectoresDelBosqueParte4(String elecionIntrahistoria,
                PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
            if (LosProtectoresDelBosque.getBandoElegido() == 1) {
                // Camino Humano
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_1);
                LectorBuffRead.continuarHistoria();

                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_2);
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3);
                elecionIntrahistoria = LectorBuffRead.leer((LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_2 + "\n"
                        + LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3 + "\n"),
                        "Batalla", "Paz");
                if (elecionIntrahistoria.equals("Batalla")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_BATALLA);
                    if (personajePrincipal.CombateEntero(Enemigos.ELFO_EJERCITO.getVida(),
                            Enemigos.ELFO_EJERCITO.getDaño())) {
                        TextosAscii.setVerde();
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_BATALLA_VICTORIA);
                        personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
                        LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_HUMANO.getValue());
                        LosProtectoresDelBosque.setFinalHumanos(1);
                    } else {
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_BATALLA_DERROTA);
                    }
                } else if (elecionIntrahistoria.equals("Paz")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_PAZ);
                    if ((Aleatoriedad.devolverNumero(LosProtectoresDelBosque.getProbabilidadPaz()) + 1) >= 80) {
                        personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
                        LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_HUMANO.getValue());
                        LosProtectoresDelBosque.setFinalHumanos(2);
                    } else {
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_HUMANOS_3_PAZ_FALLADA);
                    }
                }

            } else {
                // Camino Elfo
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_1);
                LectorBuffRead.continuarHistoria();

                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_2);
                TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_3);
                elecionIntrahistoria = LectorBuffRead.leer((LOS_PROTECTORES_DEL_BOSQUE_4_2 + "\n"
                        + LOS_PROTECTORES_DEL_BOSQUE_4_3 + "\n"),
                        "Sacrificio", "Paz");
                if (elecionIntrahistoria.equals("Sacrificio")) {
                    TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_2_VICTORIA);
                    personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
                    LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_ELFO.getValue());
                    LosProtectoresDelBosque.setFinalElfos(1);
                } else if (elecionIntrahistoria.equals("Paz")) {
                    if ((Aleatoriedad.devolverNumero(LosProtectoresDelBosque.getProbabilidadSalvacion()) + 1) >= 80) {
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_3_VICTORIA);
                        personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_LOS_PROTECTORES_DEL_BOSQUE.getValue(), PlayerData.HISTORIA.getValue());// Los protectores del bosque
                                personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE4.getValue());// Parte 4 terminada
                        LosProtectoresDelBosque.setBandoElegido(PlayerData.BANDO_ELFO.getValue());
                        LosProtectoresDelBosque.setFinalElfos(2);
                    } else {
                        TextoLento.printSlow(LOS_PROTECTORES_DEL_BOSQUE_4_3_DERROTA);
                    }
                }
            }
        }

    }

    /**
     * Clase de los elfos que recoge las partes de la Historia Las Ruinas Antiguas
     * de Jistav
     */
    public class LasRuinasAntiguasDeJistav extends Elfos {

        /**
         * Primera parte de la HistoriaDatos de los elfos; las antiguas ruinas de
         * Jistav.
         * <p>
         * En esta primera parte el jugador se encontrara con la alquimista,
         * un personaje que le acompañara en toda esta HistoriaDatos.
         * 
         * @param primerDesenlaceBucleSalir
         * @param elecionIntrahistoria
         * @param buffer
         * @throws IOException, InterruptedException
         * @see HistoriaDatos
         * @see PersonajePrinc
         */
        public static void LasRuinasAntiguasDeJistavParte1(
                String elecionIntrahistoria,
                PersonajePrinc personajePrincipal)
                throws IOException, InterruptedException {

            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_1);
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_2);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_3);
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_4);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_5);
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_6);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_7);
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_8);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_9);
            TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_10);

            elecionIntrahistoria = LectorBuffRead.leer((LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_11 + "\n"
                    + LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_12 + "\n"),
                    "ayudar");
            switch (elecionIntrahistoria) {
                case "ayudar":
                    TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_12_LA_AYUDA);
                    personajePrincipal.setHistoria(Razas.Elfo.getValue(), PlayerData.HISTORIA_RAZA.getValue());// Elfos
                    personajePrincipal.setHistoria(PlayerData.HISTORIA_LAS_RUINAS_ANTIGUAS_DE_JISTAV.getValue(), PlayerData.HISTORIA.getValue());// Las ruinas antiguas de jistav
                    personajePrincipal.setHistoria(PlayerData.HISTORIA_TERMINADA.getValue(), PlayerData.HISTORIA_PARTE1.getValue());// Parte 1 terminada
                    break;

                default:
                    TextoLento.printSlow(LAS_RUINAS_ANTIGUAS_DE_JISTAV_1_12_NO_LA_AYUDA);
                    Zelda.ZeldaParte1(personajePrincipal);
                    break;
            }
        }

    }
}
