package clases;

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