package recuperacionpruebapracticaalvaro;

import java.util.Arrays;
import java.util.Random;



public class GestorAparcamiento {
    private final String[] plazas;
    private int tiempoAparcado;
    private final Random random = new Random();

    
    public GestorAparcamiento(int numeroPlazas) {
        this.plazas = new String[numeroPlazas];
        this.tiempoAparcado = 1000 + random.nextInt(2000);
    }
      
    // Método sincronizado para intentar aparcar un coche
    public synchronized int aparcar(String matricula) {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = matricula;
                System.out.printf(">>> El coche con matrícula %s entra al aparcamiento, ocupa la plaza %d y permanecera durante %d s. %s. \n", matricula, i, tiempoAparcado, Arrays.toString(plazas));
                return i;
            }
        }
        System.out.printf("--- El coche con matrícula %s debe esperar a que haya plazas de aparcamiento disponibles.\n", matricula);
        return -1;   
    }
    
    

    // Método sincronizado para liberar una plaza
    public synchronized void liberar(int plaza, String matricula) {
        if (plaza >= 0 && plaza < plazas.length && plazas[plaza] != null) {
            plazas[plaza] = null;
            System.out.printf("<<< El coche con matrícula %s sale del aparcamiento, deja libre la plaza %d.\n", matricula, plaza);
            notifyAll(); // Notificar a otros coches que una plaza está libre
        }
    }
}


