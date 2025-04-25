package historias;

import java.io.IOException;

import clases.PersonajePrinc;
import clases.Razas;
import utilidades.LectorBuffRead;
import utilidades.TextoLento;
import utilidades.TextosAscii;

public abstract class Orcos{
    private static final String MORDOR_1_1 = "Mientras caminas por el bosque empiezas a oler algo moribundo, putrefacto, sumido en tu curiosidad te intentas acercar al origen.";
private static final String MORDOR_1_2 = "De repente empiezas a escuchar muchos caballos corriendo rápidamente hacia ti, te asustas y te escondes detrás de unos árboles.";
private static final String MORDOR_1_3 = "Ante ti aparecen nueve figuras oscuras, espectros que llevan un aura tenebrosa.\nMiran a su alrededor y no consiguen encontrar lo que buscaban por lo que reanudan el trote hacia fuera del bosque.";
private static final String MORDOR_1_4 = "Te giras y lo ves, un humanoide muy pequeño, con los pies muy grandes, y muerto, te acercas y sientes que algo te atrae.\nY cuando te quieres dar cuenta tienes un anillo en tu mano sin poner, rebuscas en el cadáver y encuentras una carta.";
private static final String MORDOR_1_5 = "-Hola soy Oblib, si has encontrado esta carta hemos fallado nuestra misión, esto no habría pasado si hubiéramos tenido la ayuda de los humanos.";
private static final String MORDOR_1_6 = "-Si todavía sigo teniendo el anillo podría haber una esperanza, la supervivencia de las razas está en tu poder, debes destruir el anillo, debes ir al monte...";
private static final String MORDOR_1_7 = "Ahí acaba la carta con un manchurrón de sangre que no deja ver el final.";
private static final String MORDOR_1_8 = "Sumido en tu heroísmo y el miedo de que eliminen a tu raza este villano desconocido avanzas en busca de una forma de destruir el anillo.";

private static final String MORDOR_2_1 = "Tu camino te lleva a través de senderos peligrosos y aldeas donde escuchas rumores sobre extrañas criaturas buscando algo. \nSabes que no puedes confiar en nadie. \nAl llegar a un pueblo, una banda de jinetes oscuros aparece de la nada, sembrando el pánico.";
private static final String MORDOR_2_2 = "Corres entre las calles, intentando evitar ser visto, pero entonces, una criatura horrenda se interpone en tu camino. Un espectro deforme, con garras afiladas y una voz gélida que susurra en un idioma olvidado. No es un simple sirviente de la oscuridad, es un guardián enviado para detenerte.";
private static final String MORDOR_2_2_VICTORIA = "La batalla es feroz, pero logras derrotarlo, aunque apenas logras escapar con vida.";
private static final String MORDOR_2_2_DERROTA = "Caes al suelo malherido, el espectro te roba el anillo de las manos y te remata. \nHas muerto.";
private static final String MORDOR_2_3 = "Después del combate, decides que antes de continuar tu viaje, necesitas ayuda. Debes encontrar aliados y fortalecerte antes de enfrentarte al verdadero peligro.";

private static final String MORDOR_3_1 = "Siguiendo las pistas en la carta, llegas a una antigua ciudad en ruinas. \nAllí descubres la presencia de un culto oscuro, devotos de un dios desconocido. \nLos llaman \"Los Hijos de Malakar\" y murmuran sobre el poder que desean desatar sobre el mundo.";
private static final String MORDOR_3_2 = "Mientras exploras la ciudad, eres descubierto. Los cultistas te rodean y un sumo sacerdote se acerca.";
private static final String MORDOR_3_3 = "\"El anillo no debe ser destruido. Su destino es la voluntad de Malakar.\"";
private static final String MORDOR_3_4 = "Antes de que puedan atraparte, logras romper su formación y escapar, pero ahora sabes que no solo los Espectros te buscan: \nhay fuerzas aún más antiguas y aterradoras en juego.";

private static final String MORDOR_4_1 = "Tras semanas de viaje, alcanzas las tierras volcánicas. \nLa caldera del Monte del Destino se alza ante ti, su calor sofocante es una advertencia del final que se acerca. \nPero antes de llegar a la cima, una última prueba te espera.";
private static final String MORDOR_4_2 = "Desde las sombras surge una figura aterradora. No es un simple sirviente, es un antiguo ser caído en desgracia, un señor de la guerra maldito por el poder del anillo. \nSu armadura ennegrecida y su espada envuelta en llamas lo hacen ver como un titán de pesadilla.";
private static final String MORDOR_4_3 = "\"No permitiré que destruyas lo que nos pertenece. El anillo es nuestro destino.\"";
private static final String MORDOR_4_4 = "Un combate mortal se desata en el corazón de la montaña.";
private static final String MORDOR_4_4_VICTORIA = "Cada golpe hace temblar la tierra, pero finalmente, con un último esfuerzo, logras derrotarlo. \nExhausto y herido, avanzas hasta el borde del abismo y, con una última mirada, arrojas el anillo al fuego eterno.";
private static final String MORDOR_4_4_DERROTA = "El espectro te derrota y caes al volcán en erupción. \nEl espectro entonces toma el anillo y se lo pone. \nMientras el volcán empieza a volverse loco, empieza a formarse una gran niebla; el presagio de una gran desgracia. \nHas muerto.";
    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_1 = "Después de caminar durante días llegas al territorio orco, pero llevas demasiados días sin comer y la temperatura del territorio orco no te favorece.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_2 = "Te empiezas a marear por falta de fluidos y te desmayas.\n"
            +
            "Al levantarte, contrario al destino que pensabas que tenías, sigues vivo. Te incorporas y notas que te encuentras en una tienda de campaña.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_3 = "Después de incorporarte, ves cómo se abre la lona. De entre ella aparece un orco con una piel de lobo a sus espaldas y un collar de dientes humanos.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_4 = "Tú te asustas, nunca habías visto un orco y menos uno tan grande y con tantas cicatrices. Rápidamente sacas tu arma y la apuntas hacia él.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_5 = "Él se ríe y te dice en lenguaje humano casi incomprensible: -Jajajajaja, tranquilo humano, yo no ser malo. Necesitarías un cuchillo más grande para hacerme daño.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_6 = "Te acerca un cuenco, dentro hay tripas y sesos de jabalí y una sopa que huele a excremento de algún animal.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_7 = "No crees en él y decides combatirlo (Escribe batalla)";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_7_DESENLACE = "Antes de que puedas utilizar tu arma, te encuentras muerto sobre la lona en la que dormías. "
            +
            "Sin ti, el pueblo orco se sumirá en la magia oscura y ninguna raza los podrá parar.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8 = "¿Quién eres? ¿Dónde estoy? (Escribe hablar)";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_1 = "-Yo ser Piel Blanca, un comandante orco, y tú estar en problemas. Eres muy fuerte como para llegar hasta aquí tú solo.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_2 = "-¡¿Dónde estoy?!- le dices sin dejar de apuntarle con tu arma.\n"
            +
            "-Esto es un campamento orco, el campamento de los pieles blancas.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_3 = "Sumido en tu inferioridad de número y fuerza, te rindes y bajas tu arma.\n"
            +
            "-Pequeño humano, estabas en mitad del campo de batalla. Es extraño que sigas en pie.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_4 = "Cansado de tener una charla con un orco que no conoces, le dices:\n"
            +
            "-¿Necesitas algo de mí o me puedo ir?\n" +
            "Él te responde:\n" +
            "-La verdad, humano, es que necesitamos tu ayuda.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_5 = "-Hace unos días encontré el ultraje del chamán de nuestra tribu. Lo encontré sacrificando a compañeros para hacer rituales de magia oscura.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_6 = "-En cuanto volví, se lo conté a la tribu, lo que empezó la guerra contra el chamán en la que estamos ahora.\n"
            +
            "-En medio de todo esto apareces tú, humano, sin agua ni comida.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_7 = "-Necesitamos tu ayuda para reponer recursos dada la necesidad de nuestra tribu.\n"
            +
            "-El problema es que siempre que vamos a las aldeas humanas a por alimento, nos echan.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_8 = "-Necesito que vayas a una de estas aldeas humanas a por cualquier cosa.\n"
            +
            "Le respondes inmediatamente:\n" +
            "-Por supuesto, Piel Blanca. De alguna forma tendré que devolveros el favor por salvarme la vida.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_9 = "Piel Blanca te da una bolsa con dinero y te encaminas a la aldea humana.\n"
            +
            "Mientras caminas por el campamento de los pieles blancas, ves cómo además de una mirada de desprecio, ven en ti la única esperanza que les queda para encaminar su guerra.";

    private static final String LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_10 = "Recibes 100 monedas.";

    private static final String LA_REBELION_GOBLIN_1_1 = "Mientras tu te estas llendo, lejos de tu mirada, una gran y espesa niebla empieza a engullir al goblin que habias dejado moribundo en el suelo.";
    private static final String LA_REBELION_GOBLIN_1_2 = "Al esfumarse esa niebla aparece una pequeña sombra; -Así que hay un aventurero abusando de mis peones...";
    private static final String LA_REBELION_GOBLIN_1_3 = "Sigues tu camino sin darte cuenta de los problemas que te podrias haber buscado, o los que podrias haber esquivado.";

    private static final String LA_REBELION_GOBLIN_2_1 = "Han pasado varios días desde tu encuentro con la sombra misteriosa, y te has adentrado más en el bosque, decidido a cumplir tu misión. \nDurante estos días, has realizado algunas misiones secundarias.";
    private static final String LA_REBELION_GOBLIN_2_2 = "En tu camino, has rescatado a varios aldeanos de criaturas peligrosas y has enfrentado bandidos que se aprovechaban de los más débiles. \nTambién has conseguido información de un antiguo líder goblin que podría ser clave para tu causa.";
    private static final String LA_REBELION_GOBLIN_2_3 = "Tu llegada a un campamento escondido en el bosque marca el comienzo de una nueva etapa en tu viaje. \nEn la distancia, puedes ver una pequeña fogata, rodeada por varios goblins que parecen distraídos. \nCuando te acercas, uno de ellos, un goblin más grande y con cicatrices que recorren su rostro, te observa con desconfianza.";
    private static final String LA_REBELION_GOBLIN_2_4 = "\"¿Qué quieres, humano?\" gruñe el goblin, con tono desafiante, pero una chispa de curiosidad en sus ojos.";
    private static final String LA_REBELION_GOBLIN_2_5 = "\"Quiero liberar a todos ustedes\" respondes con firmeza. \nEl mago les tiene bajo su control. Juntos podemos derrocarlo.";
    private static final String LA_REBELION_GOBLIN_2_6 = "Al principio, algunos goblins se muestran escépticos. \nLos murmullos entre ellos no dejan de aumentar, pero el goblin cicatrizado, con una expresión seria, se acerca un paso más.";
    private static final String LA_REBELION_GOBLIN_2_7 = "\"¿Y qué ganamos con eso?\" pregunta.";
    private static final String LA_REBELION_GOBLIN_2_8 = "\"Libertad\" respondes. El mago no es invencible. Juntos podemos derrotarlo y finalmente ser libres.";
    private static final String LA_REBELION_GOBLIN_2_9 = "Tras un tenso silencio, el goblin cicatrizado asiente y da una señal. \nPoco a poco, los demás goblins comienzan a mostrar interés en unirse a tu causa.";
    private static final String LA_REBELION_GOBLIN_2_10 = "\"Bien, pero no será fácil\" responde el goblin. \"El mago tiene más poder del que crees.\"";
    private static final String LA_REBELION_GOBLIN_2_11 = "Con su ayuda, el campamento de goblins se convierte en un lugar seguro para que tu grupo crezca.";

    private static final String LA_REBELION_GOBLIN_3_1 = "El tiempo ha pasado y tu pequeño ejército de goblins sigue creciendo. \nSin embargo, sabes que no será suficiente para enfrentarte al mago. \nA lo largo de los días, has seguido completando misiones secundarias para mejorar tu posición: \nrescataste a más goblins atrapados, recuperaste antiguos artefactos mágicos, y te enfrentaste a varias criaturas oscuras que aún patrullan el bosque.";
    private static final String LA_REBELION_GOBLIN_3_2 = "La información que obtuviste de un anciano goblin sobre el mago resulta ser crucial. \nTe enteras de que su poder está vinculado al propio castillo donde reside, y que las tierras que lo rodean están impregnadas de magia oscura. \nPara enfrentarlo de verdad, tendrás que debilitar esa conexión mágica, y eso solo se puede hacer durante la luna llena, cuando los poderes del mago alcanzan su punto más vulnerable.";
    private static final String LA_REBELION_GOBLIN_3_3 = "Mientras tanto, el campamento se ha convertido en un refugio donde los goblins entrenan, luchan y preparan sus armas. \nTu presencia, junto a tu liderazgo, les ha dado una nueva esperanza. \nPero a medida que el tiempo avanza, también lo hace la amenaza del mago.";
    private static final String LA_REBELION_GOBLIN_3_4 = "Una noche, después de un día agotador de entrenamiento y planificación, te encuentras con algo inesperado: \nuna horda de criaturas oscuras se acerca al campamento. \nPero entre ellas, hay una figura imponente que destaca: \nun enviado del mago. \nAlto, cubierto con una armadura negra, con un aura de maldad y poder palpable. \nSu presencia es abrumadora, como si la oscuridad misma lo hubiera engullido.";
    private static final String LA_REBELION_GOBLIN_3_5 = "Sin previo aviso, la figura alza una mano y lanza un hechizo contra tu campamento. \nLos goblins cercanos caen al suelo, paralizados por la magia oscura. \nLa batalla comienza, y sabes que esta será una prueba crucial de tus habilidades y la fuerza de tu ejército.";
    private static final String LA_REBELION_GOBLIN_3_6 = "\"¡Es hora de que pagues por desafiar al mago!\" ruge el enviado, avanzando hacia ti con una velocidad impresionante.";
    private static final String LA_REBELION_GOBLIN_3_6_VICTORIA = "\"¡Esto no ha terminado, maldito!\" grita, pero en sus ojos se refleja la derrota.";
    private static final String LA_REBELION_GOBLIN_3_6_DERROTA = "Yaces en el suelo, contigo y con todos los goblins que te seguían se forma un río de sangre que llegará hasta los reinos más lejanos del continente.";
    private static final String LA_REBELION_GOBLIN_3_7 = "Sin embargo, antes de que puedas dar el golpe final, el enviado desaparece en una nube de oscuridad, dejando un último suspiro lleno de ira y frustración. \nSu magia se desvanece, pero sabes que el mago sigue estando cerca, y este enviado solo fue una pequeña muestra del poder que aún te espera.";
    private static final String LA_REBELION_GOBLIN_3_8 = "Aunque tu victoria contra el enviado es clara, la batalla no ha terminado. \nLos goblins, que antes estaban paralizados, se levantan y siguen luchando con más determinación. \nLa moral de tu ejército crece, y la sensación de que ahora, juntos, pueden enfrentar cualquier adversidad es más fuerte que nunca.";
    private static final String LA_REBELION_GOBLIN_3_9 = "Después de la pelea, te tomas un tiempo para recuperar energías. \nDurante los siguientes días, sigues entrenando a tus tropas y organizando las estrategias que te llevarán a enfrentarte directamente al mago. \nLas misiones secundarias también continúan: consigues nuevos recursos, investigas más sobre los artefactos mágicos que podrían debilitar al mago y encuentras antiguos aliados que podrían ser clave en la batalla final.";
    
    private static final String LA_REBELION_GOBLIN_4_1 = "Tu ejército está listo para el asalto final, pero el tiempo apremia. \nEl hechizo que has encontrado debe realizarse antes de la luna llena, y todo debe ser perfecto. \nHas utilizado los días previos para realizar misiones secundarias importantes: has recuperado componentes mágicos para un ritual, has derrotado a centinelas enviados por el mago, y has asegurado rutas de escape en caso de que las cosas no salgan como esperabas.";
    private static final String LA_REBELION_GOBLIN_4_2 = "El asalto al castillo comienza, y tu ejército de goblins avanza con determinación. Los combates son intensos. \nLos goblins luchan con astucia y ferocidad, utilizando sus conocimientos del terreno y sus habilidades para emboscar a las criaturas oscuras que protegen el castillo.";
    private static final String LA_REBELION_GOBLIN_4_3 = "Cuando finalmente llegas a la sala del trono, el mago está esperando. \nSu poder, aunque debilitado, sigue siendo formidable. La batalla que sigue es épica. \nMagia y acero chocan, mientras tu ejército sostiene el castillo contra las fuerzas que aún le quedan al mago.";
    private static final String LA_REBELION_GOBLIN_4_3_VICTORIA = "Finalmente, después de una lucha interminable, el vínculo mágico del mago se rompe.";
    private static final String LA_REBELION_GOBLIN_4_3_DERROTA = "Eres superado por la magia del mago y caes totalmente indefenso. \nEl mago reúne todas sus fuerzas y te destruye junto con todo tu ejército. \nHas muerto.";
    private static final String LA_REBELION_GOBLIN_4_4 = "En su último intento por salvarse, el mago lanza un hechizo devastador, pero ya es demasiado tarde. \nEl castillo comienza a colapsar, y con él, la magia del mago se desvanece. \nLa victoria es tuya.";


    /**
     * Primera parte de la historia de los enanos; Mordor, El anillo de poder.
     * <p>
     * En esta parte el jugador se encuentra con la tarea de destruir el anillo de
     * poder unico para que no caiga en malas manos.
     * 
     * @param buffer
     * @see HistoriaDatos
     * @see Mordor
     * @see PersonajePrinc
     */
    public static void MordorParte1(PersonajePrinc personajePrincipal) throws IOException, InterruptedException, InterruptedException {

        TextoLento.printSlow(MORDOR_1_1);
        TextoLento.printSlow(MORDOR_1_2);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(MORDOR_1_3);
        TextoLento.printSlow(MORDOR_1_4);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(MORDOR_1_5);
        TextoLento.printSlow(MORDOR_1_6);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(MORDOR_1_7);
        TextoLento.printSlow(MORDOR_1_8);
        LectorBuffRead.continuarHistoria();
        personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_MORDOR.getValue(), DatosHistoria.HISTORIA.getValue());// Mordor
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE1.getValue());// Parte 1 terminada
    }

    /**
     * Segunda parte de la historia de los enanos; Mordor, La Huida y la
     * Persecución.
     * <p>
     * En esta parte el jugador se encuentra perseguido por un espectro que quiere
     * conseguir el anillo.
     * 
     * @param buffer
     * @see HistoriaDatos
     * @see Batalla
     * @see clases
     * @see Mordor
     * @see PersonajePrinc
     */
    public static void MordorParte2(PersonajePrinc personajePrincipal) throws IOException, InterruptedException, InterruptedException {
        TextoLento.printSlow(MORDOR_2_1);
        TextoLento.printSlow(MORDOR_2_2);
        LectorBuffRead.continuarHistoria();
        if (personajePrincipal.CombateEntero(Enemigos.ESPECTRO.getVida(), Enemigos.ESPECTRO.getDaño())) {
            TextosAscii.setRojo();
            TextoLento.printSlow(MORDOR_2_2_VICTORIA);
            TextoLento.printSlow(MORDOR_2_3);
            LectorBuffRead.continuarHistoria();
            personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_MORDOR.getValue(), DatosHistoria.HISTORIA.getValue());// Mordor
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE2.getValue());// Parte 2 terminada
        } else {
            TextoLento.printSlow(MORDOR_2_2_DERROTA);
        }
    }

    /**
     * Tercera parte de la historia de los enanos; Mordor, Los Cultistas del Olvido.
     * <p>
     * En esta parte el jugador se encuentra con el verdadero problema del anillo,
     * los cultistas que quiern utilizar su poder para su propio beneficio.
     * 
     * @param buffer
     * @see HistoriaDatos
     * @see Mordor
     * @see PersonajePrinc
     */
    public static void MordorParte3(PersonajePrinc personajePrincipal) throws IOException, InterruptedException, InterruptedException {
        TextoLento.printSlow(MORDOR_3_1);
        TextoLento.printSlow(MORDOR_3_2);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(MORDOR_3_3);
        TextoLento.printSlow(MORDOR_3_4);
        LectorBuffRead.continuarHistoria();
        personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_MORDOR.getValue(), DatosHistoria.HISTORIA.getValue());// Mordor
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE3.getValue());// Parte 3 terminada
    }

    /**
     * Cuarta parte de la historia de los enanos; Mordor, El Último Sendero.
     * <p>
     * En esta parte el jugador se encuentra con el espectro rey y pelea contra el
     * para destruir el anillo.
     * 
     * @param buffer
     * @see HistoriaDatos
     * @see Batalla
     * @see clases
     * @see Mordor
     * @see PersonajePrinc
     */
    public static void MordorParte4(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
        TextoLento.printSlow(MORDOR_4_1);
        TextoLento.printSlow(MORDOR_4_2);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(MORDOR_4_3);
        TextoLento.printSlow(MORDOR_4_4);
        LectorBuffRead.continuarHistoria();
        if (personajePrincipal.CombateEntero(Enemigos.ESPECTRO_REY.getVida(), Enemigos.ESPECTRO_REY.getDaño())) {
            TextosAscii.setRojo();
            TextoLento.printSlow(MORDOR_4_4_VICTORIA);
            personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_MORDOR.getValue(), DatosHistoria.HISTORIA.getValue());// Mordor
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE4.getValue());// Parte 4 terminada
        } else {
            TextoLento.printSlow(MORDOR_4_4_DERROTA);
        }
    }

    /**
     * Primera parte de la historia de los orcos; La Rebelion Goblin, La muerte del
     * Goblin.
     * <p>
     * En esta primera parte solo se deja caer que existe una amenaza que hace
     * peligrar al jugador
     * @see LaRebelionGoblin
     * @see PersonajePrinc
     */
    public static void LaRebelionGoblinParte1(PersonajePrinc personajePrincipal) throws InterruptedException{
        TextoLento.printSlow(LA_REBELION_GOBLIN_1_1);
        TextoLento.printSlow(LA_REBELION_GOBLIN_1_2);
        TextoLento.printSlow(LA_REBELION_GOBLIN_1_3);
        personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_LA_REBELION_GOBLIN.getValue(), DatosHistoria.HISTORIA.getValue());// La rebelion goblin
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE1.getValue());// Parte 1 terminada
    }

    /**
     * Segunda parte de la historia de los orcos; La Rebelion Goblin, La Rebelión
     * Comienza.
     * <p>
     * En esta segunda parte el jugador se decide a combatir a El Mago y quiere
     * conseguir la ayuda de un pueblo de goblins.
     * 
     * @param buffer
     * @see HistoriaDatos
     * @see Batalla
     * @see clases
     * @see LaRebelionGoblin
     * @see PersonajePrinc
     */
    public static void LaRebelionGoblinParte2(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_1);
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_2);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_3);
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_4);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_5);
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_6);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_7);
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_8);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_9);
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_10);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_2_11);
        LectorBuffRead.continuarHistoria();
        personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_LA_REBELION_GOBLIN.getValue(), DatosHistoria.HISTORIA.getValue());// La rebelion goblin
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE2.getValue());// Parte 2 terminada
    }

    /**
     * Tercera parte de la historia de los orcos; La Rebelion Goblin, El Ejército de
     * la Libertad.
     * <p>
     * En esta tercera parte el jugador se encuentra con los siervos de El Mago, que
     * amenazan la vida del jugador y la de los goblins que le siguen.
     * 
     * @param buffer
     * @see HistoriaDatos
     * @see clases
     * @see Batalla
     * @see LaRebelionGoblin
     * @see PersonajePrinc
     */
    public static void LaRebelionGoblinParte3(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
        TextoLento.printSlow(LA_REBELION_GOBLIN_3_1);
        TextoLento.printSlow(LA_REBELION_GOBLIN_3_2);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_3_3);
        TextoLento.printSlow(LA_REBELION_GOBLIN_3_4);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_3_5);
        TextoLento.printSlow(LA_REBELION_GOBLIN_3_6);
        LectorBuffRead.continuarHistoria();
        if (personajePrincipal.CombateEntero(Enemigos.GOBLIN_GENERAL.getVida(),
                Enemigos.GOBLIN_GENERAL.getDaño())) {
            TextosAscii.setRojo();
            TextoLento.printSlow(LA_REBELION_GOBLIN_3_6_VICTORIA);
            TextoLento.printSlow(LA_REBELION_GOBLIN_3_7);
            LectorBuffRead.continuarHistoria();
            TextoLento.printSlow(LA_REBELION_GOBLIN_3_8);
            TextoLento.printSlow(LA_REBELION_GOBLIN_3_9);
            LectorBuffRead.continuarHistoria();
            personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_LA_REBELION_GOBLIN.getValue(), DatosHistoria.HISTORIA.getValue());// La rebelion goblin
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE3.getValue());// Parte 3 terminada
        } else {
            TextoLento.printSlow(LA_REBELION_GOBLIN_3_6_DERROTA);
        }
    }

    /**
     * Cuarta parte de la historia de los orcos; La Rebelion Goblin, La Batalla
     * Final.
     * <p>
     * En esta cuarta parte el jugador se enfrenta a El Mago, un abusador de
     * goblins.
     * 
     * @param buffer
     * @see HistoriaDatos
     * @see clases
     * @see Batalla
     * @see LaRebelionGoblin
     * @see PersonajePrinc
     */
    public static void LaRebelionGoblinParte4(PersonajePrinc personajePrincipal) throws IOException, InterruptedException {
        TextoLento.printSlow(LA_REBELION_GOBLIN_4_1);
        TextoLento.printSlow(LA_REBELION_GOBLIN_4_2);
        LectorBuffRead.continuarHistoria();
        TextoLento.printSlow(LA_REBELION_GOBLIN_4_3);
        LectorBuffRead.continuarHistoria();

        if (personajePrincipal.CombateEntero(Enemigos.HUMANO_EL_MAGO.getVida(),
                Enemigos.HUMANO_EL_MAGO.getDaño())) {
            TextosAscii.setRojo();
            TextoLento.printSlow(LA_REBELION_GOBLIN_4_3_VICTORIA);
            TextoLento.printSlow(LA_REBELION_GOBLIN_4_4);
            LectorBuffRead.continuarHistoria();
            personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_LA_REBELION_GOBLIN.getValue(), DatosHistoria.HISTORIA.getValue());// La rebelion goblin
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE4.getValue());// Parte 4 terminada
        } else {
            TextoLento.printSlow(LA_REBELION_GOBLIN_4_3_DERROTA);
        }
    }

    /**
     * Primera parte de la historia de los orcos; La guerra del clan piel blanca
     * <p>
     * En esta primera parte el jugador se encuentra en medio de la guerra que tiene
     * el clan piel blanca y les promete que les ayudara en su pelea.
     * 
     * @param primerDesenlaceBucleSalir
     * @param elecionIntrahistoria
     * @param buffer
     * @see HistoriaDatos
     * @see PersonajePrinc
     */
    public static void LaGuerraDelClanPielBlancaParte1(
            String elecionIntrahistoria,
            PersonajePrinc personajePrincipal)
            throws IOException, InterruptedException {

        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_1);
        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_2);
        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_3);
        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_4);
        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_5);
        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_6);

        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_7);// a partir de aqui
        TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8);
        elecionIntrahistoria = LectorBuffRead.leer((LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_7 + "\n"
                + LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8 + "\n"),
                "batalla", "hablar");

        if (elecionIntrahistoria.equals("batalla")) {
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_7_DESENLACE);
        } else if (elecionIntrahistoria.equals("hablar")) {
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_1);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_2);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_3);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_4);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_5);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_6);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_7);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_8);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_9);
            TextoLento.printSlow(LA_GUERRA_DEL_CLAN_PIEL_BLANCA_1_8_10);
            personajePrincipal.setHistoria(Razas.Orco.getValue(), DatosHistoria.HISTORIA_RAZA.getValue());// Orcos
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_LA_GUERRA_DEL_CLAN_PIEL_BLANCA.getValue(), DatosHistoria.HISTORIA.getValue());// La guerra del clan piel blanca
            personajePrincipal.setHistoria(DatosHistoria.HISTORIA_TERMINADA.getValue(), DatosHistoria.HISTORIA_PARTE1.getValue());// Parte 1 terminada
        } else {
            TextoLento.printSlow("Por favor elije una de las opciones sabiamente");
        }
    }
}
