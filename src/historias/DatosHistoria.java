package historias;

public enum DatosHistoria {
    // --- HISTORIA DATOS --- //
    HISTORIA_RAZA(0),
    HISTORIA(1),
    HISTORIA_PARTE1(2),
    HISTORIA_PARTE2(3),
    HISTORIA_PARTE3(4),
    HISTORIA_PARTE4(5),
    HISTORIA_TERMINADA(1),
    // --- HISTORIAS ORCOS --- //
    HISTORIA_MORDOR(1),
    HISTORIA_LA_REBELION_GOBLIN(2),
    HISTORIA_LA_GUERRA_DEL_CLAN_PIEL_BLANCA(3),
    // --- HISTORIAS HUMANOS --- //
    HISTORIA_LA_MUJER_DE_MORADO(1),
    HISTORIA_GUERRA_DE_REYES_HERMANOS(2),
    HISTORIA_EL_GOBLIN_DEL_TUTORIAL(3),
    // --- HISTORIAS ENANOS --- //
    HISTORIA_EL_PUEBLO_ENANO_OWARF(1),
    HISTORIA_LA_CREACION_DEL_ARTEFACTO_MITICO(2),
    HISTORIA_EL_CODICE_MALDITO(3),
    // --- HISTORIAS ELFOS --- //
    HISTORIA_ZELDA(1),
    HISTORIA_LOS_PROTECTORES_DEL_BOSQUE(2),
    BANDO_HUMANO(1),
    BANDO_ELFO(2),
    HISTORIA_LAS_RUINAS_ANTIGUAS_DE_JISTAV(3);

    private final int value;
    
    private DatosHistoria(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
