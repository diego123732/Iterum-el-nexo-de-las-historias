package clases;

/**
 * Enum con datos auxiliares que ayudan para que se entienda mejor el codigo
 */
public enum PlayerData {
    // --- ESTADÍSTICAS ---
    DESTREZA(0),
    FUERZA(1),
    INTELIGENCIA(2),
    CARACTER(3),
    CONSTITUCION(4),
    SABIDURIA(5),
    
    // --- CASCOS ---
    SOMBRERO_DE_MAGO_VIDA(15),
    YELMO_BARBUTA_VIDA(15),
    BOINA_VIDA(20),
    CAPUCHA_VIDA(15),
    YELMO_CONICO_VIDA(15),
    
    // --- ARMADURAS ---
    TUNICA_ARMADURA_VIDA(35),
    COTA_MALLA_VIDA(35),
    CHALECO_CUERO_VIDA(35),
    
    // --- CALZADO ---
    ZAPATOS_CUERO_VIDA(15),
    
    // --- ARMAS DE DOS MANOS ---
    BACULO_DAMAGE(12),
    ESPADON_DAMAGE(12),
    
    // --- ARMAS DE UNA MANO ---
    DAGA_BASICA_DAMAGE(6),
    CRUCIFIJO_DAMAGE(6),
    MAZO_DAMAGE(6),
    ESCUDO_DAMAGE(6);
    
    private final int value;
    
    private PlayerData(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
