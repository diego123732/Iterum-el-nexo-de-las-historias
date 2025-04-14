package historias;

public enum Enemigos {
    // Razas principales

    // Orcos
    ORCO_BASE(55, 30),
    ORCO_PIELBLANCA(180, 100),
    // Elfos
    ELFO_BASE(57.5, 27.5),
    ELFO_EJERCITO(160, 50),
    // Enanos
    ENANO_BASE(60, 25),
    // Humanos
    HUMANO_BASE(55, 25),
    HUMANO_COMANDANTE(80, 35),
    HUMANO_CULTISTA(100, 50),
    HUMANO_EL_MAGO(120, 50),

    // Razas secundarias
    GOBLIN(45, 15),
    GOBLIN_GENERAL(80, 30),
    GOBLIN_GRUPO(55, 25),
    TROLL(80, 35),
    MINOTAURO(80, 40),
    CABALLERO_DE_LA_MUERTE(85, 35),
    GANONDORF_PARCIAL(130, 50),
    GANONDORF_FINAL(165, 70),
    DIOS_ZHAELOR(200, 90),
    MONARCA_DE_LA_PLAGA(150, 100),
    ESPECTRO(70, 30),
    ESPECTRO_REY(140, 50),
    LA_FORJA(160, 60),
    LICH(80, 30),
    TITAN_DEL_RAGNAROK(180, 60);

    private final double vida;
    private final double daño;

    Enemigos(double vida, double daño) {
        this.vida = vida;
        this.daño = daño;
    }

    public double getVida() {
        return vida;
    }

    public double getDaño() {
        return daño;
    }

    public static void listarEnemigos() {
        for (Enemigos enemigo : Enemigos.values()) {
            System.out.println(enemigo.name() + " -> Vida: " + enemigo.getVida() + ", Daño: " + enemigo.getDaño());
        }
    }
}
