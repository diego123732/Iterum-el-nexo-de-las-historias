package utilidades;

import java.util.Random;
/**
 * Aquello que depende de la suerte o del azar; esta clase 
 * tiene los metodos que se desarrollan con la clase  de java 'Random' 
 * @see Random
 */
public class Aleatoriedad {
    private static final Random RANDOM = new Random();

    /**
     * metodo que devuelve un numero del 1 al 20
     * @return double (1-20)
     */
    public static double dadoVeinte () {
        double dadoVeinte = 0;
        dadoVeinte = RANDOM.nextInt(20)+1;
        return dadoVeinte;
    }
    /**
     * Numero que devuelve un numero entre un rango de numeros 
     * delimitados por un numero minimo y uno maximo
     * @param numMin
     * @param numMax
     * @return Numero entre numMax y numMin incluidos
     */
    public static int devolverNumero (int numMin, int numMax) {
        return RANDOM.nextInt((numMax - numMin) + 1) + numMin;
        /*1º numero del numMin al numMax y 2º hace que el minimo sea el numero minimo (numMin)
        Por lo que el numero esta dentro de los rangos*/
    }
    /**
     * Metodo que devuelve un numero aleatorio de cero al numero que se le pasa como parametro
     * @param numMax
     * @return Numero aleatorio entre 0 y numMax
     */
    
    public static int devolverNumero (int numMax) {
        return RANDOM.nextInt(numMax);
    }
}
