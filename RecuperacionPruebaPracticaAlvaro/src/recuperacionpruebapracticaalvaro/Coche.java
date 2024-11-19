package recuperacionpruebapracticaalvaro;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Coche implements Runnable{
    private final GestorAparcamiento gestorAparcamiento;
    private final String matricula;
    private final int tiempoCircular;
    private final Random random = new Random();

    public Coche(GestorAparcamiento gestorAparcamiento, String matricula, int tiempoCircular) {
        this.gestorAparcamiento = gestorAparcamiento;
        this.matricula = matricula;
        this.tiempoCircular = tiempoCircular;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getTiempoCircular() {
        return tiempoCircular;
    }

    
    
    
    
    
    @Override
    public void run() {
        
        final int plaza = gestorAparcamiento.aparcar(matricula);
        
        // Aparcar
        gestorAparcamiento.aparcar(matricula);

        
        // Devolverlos.
        gestorAparcamiento.liberar(plaza, matricula);
    
          
        
    }
}
