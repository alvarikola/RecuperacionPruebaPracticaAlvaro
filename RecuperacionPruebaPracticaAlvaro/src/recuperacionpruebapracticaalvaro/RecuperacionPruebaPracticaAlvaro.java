package recuperacionpruebapracticaalvaro;

import java.util.Random;

/*Se tiene un aparcamiento con 5 plazas, numeradas de 0 a 4, al que intentan acceder
coches continuamente. La entrada de coches se puede simular con el programa principal
que, cada cierto tiempo (aleatorio, por ejemplo entre 500 y 3000 ms), crea un hilo que
simula un coche. Cada coche se crea con una matrícula distinta. Cada coche intenta
conseguir acceso al aparcamiento, indicando su matrícula para ello, que queda registrada
para la plaza de aparcamiento libre, si la hay, que se le asigna. Pasado un tiempo
aleatorio (por ejemplo, de 10 a 20 s), el coche abandona el aparcamiento. Desarrolla un
programa que simule el aparcamiento.*/


public class RecuperacionPruebaPracticaAlvaro {

    
    public static void main(String[] args) {
        
        // CONSTANTES
        final int TIEMPO_MINIMO = 5;
        final int TIEMPO_MAXIMO = 30;
        final int NUMERO_PLAZAS = 5;       
        
        GestorAparcamiento gestorAparcamientos = new GestorAparcamiento(NUMERO_PLAZAS);
        
        String matricula = "";
        int tiempoCircular = 0;
        
        //Bucle infinito creando coches
        int numeroCoche = 0;
        while (true) {
            
            numeroCoche++;
            matricula = "LZ " + numeroCoche; 
            tiempoCircular = numeroAleatorio(TIEMPO_MINIMO, TIEMPO_MAXIMO);
            System.out.printf("*** El coche con matricula %s solicita aparcamiento despues de haber circulado %d ms. \n",
                        matricula, tiempoCircular);
            Thread hiloCoche = new Thread(new Coche(gestorAparcamientos, matricula, tiempoCircular));
            
            try {
                Thread.sleep(tiempoCircular * 100);
            } catch (InterruptedException e) {
            }
            hiloCoche.start();
        }

    }
    public static int numeroAleatorio(int valorMinimo, int valorMaximo) {
        Random r = new Random();
        return valorMinimo + r.nextInt(valorMaximo - valorMinimo + 1);
    }
    
}
