
public class Pruebas {

    

    public static void main(String[] args) {
        double falloV = 1;
        double V = 50;
        double Q = (1.08 * Math.pow(10, -8));
        double falloQ = (5.82 * Math.pow(10, -10));
        double C = Q/V;
        double total = C * (Math.sqrt(Math.pow((falloV/V), 2) + Math.pow((falloQ/Q), 2)));
        System.out.println("C = " + C + "\nFallo de C = " + total);


    }
}
