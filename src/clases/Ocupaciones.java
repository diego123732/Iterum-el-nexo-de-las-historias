package clases;

public enum Ocupaciones {
    Tanque(new int[]{7,11,7,8,12,10}, 
    new String[]{"Mazo","Escudo","Yelmo cónico","Cota de malla","Zapatos de cuero"}),

    Guerrero(new int[]{10, 12, 7, 8, 11, 7}, 
    new String[]{"Espadón", "", "Yelmo barbuta", "Cota de malla", "Zapatos de cuero" }),

    Mago(new int[]{8, 7, 12, 11, 7, 10}, 
    new String[]{"Baculo", "", "Sombrero de mago", "Túnica", "Zapatos de cuero"}),

    Asesino(new int[]{12, 7, 8, 10, 7, 11}, 
    new String[]{"Daga basica", "Daga basica", "Capucha", "Chaleco de cuero", "Zapatos de cuero"}),

    Curandero(new int[]{10, 7, 8, 12, 7, 11}, 
    new String[]{"Baculo", "", "Boina", "Cota de malla", "Zapatos de cuero"}),

    Paladin(new int[]{7, 10, 8, 7, 11, 12}, 
    new String[]{"Crucifijo", "Escudo", "Yelmo cónico", "Cota de malla", "Zapatos de cuero"});

    private final int[] estadisticas;
    private final String[] equipamiento;

    // Constructor
    Ocupaciones(int[] estadisticas, String[] equipamiento) {
        this.estadisticas = estadisticas;
        this.equipamiento = equipamiento;
    }

    // Getters
    public int[] getEstadisticas() {
        return estadisticas;
    }

    public String[] getEquipamiento() {
        return equipamiento;
    }

    public static void mostrarEstadisticasPersonajes() {
        System.out.println("Estadísticas de los personajes:");
        System.out.printf("%-10s | %s%n", "Personaje", "Dest | Fue | Int | Def | Con | Srt |");
        System.out.println("-----------|------------------------------------|");

        for (Ocupaciones ocupacion : Ocupaciones.values()) {
            int[] stats = ocupacion.getEstadisticas();
            System.out.printf("%-10s |  %2d  | %2d  | %2d  | %2d  | %2d  | %2d  |%n",
                    ocupacion, stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
        }
        System.out.println();
    }

    public static void mostrarEquipamientoPersonajes() {
        System.out.println("Equipamiento de los personajes:");
        System.out.printf("%-10s | %13s | %12s | %18s | %17s | %17s |%n", "Personaje", "Mano 1", "Mano 2" , "Cabeza" , "Cuerpo" , "Pies");
        System.out.println("-----------|---------------|--------------|--------------------|-------------------|-------------------|");

        for (Ocupaciones ocupacion : Ocupaciones.values()) {
            String[] stats = ocupacion.getEquipamiento();
            System.out.printf("%-10s |  %11s  | %11s  | %17s  | %16s  | %11s  |%n",
                    ocupacion, stats[0], stats[1], stats[2], stats[3], stats[4]);
        }
        System.out.println();
    }
}
