package clases;

/**
 * Enum con todas las razas que puede jugar el personaje principal y sus valores en la historia
 */
public enum Razas {
    Elfo(1),
    Humano(2),
    Enano(3),
    Orco(4);
    

    private final int value;
    
    private Razas(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}