package utilidades;


public class TextoLento {
    /**
     * Metodo que muestra el texto que se le mete por parametro de 
     * forma que parezca que se muestra de poco en poco
     * @param text
     * @throws InterruptedException
     */
    public static void printSlow(String texto) throws InterruptedException {
        char[] placeholderChars = {'*', '#', '~', '%', '@'};
        int milisegundosRetraso = 11;
        
        for (int i = 0; i < texto.length(); i++) {
            char currentChar = texto.charAt(i);
            
            // Si es un salto de línea o espacio, imprímelo directamente sin efecto
            if (currentChar == '\n' || currentChar == ' ') {
                System.out.print(currentChar);
                continue;
            }
            
            // Efecto de disolución (3 caracteres aleatorios antes del real)
            for (int j = 0; j < 3; j++) {
                System.out.print(placeholderChars[utilidades.Aleatoriedad.devolverNumero(placeholderChars.length)]);
                Thread.sleep(milisegundosRetraso/4);
                System.out.print("\b"); // Borra el carácter aleatorio
            }
            System.out.print(currentChar); // Imprime el carácter real
            Thread.sleep(milisegundosRetraso);
        }
        System.out.println();
    }
}
