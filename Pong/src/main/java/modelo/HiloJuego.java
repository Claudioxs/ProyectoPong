package modelo;

import vista.Fondo;
import vista.Ventana;


public class HiloJuego extends Thread{

    private Fondo fondo; //El fondo del juego.

    public HiloJuego(Fondo fondo){
        this.fondo = fondo;
    }

    @Override
    public void run() { //Comienza a ejecutarse en vista.Ventana.
        super.run();

        while (true){//Se activa entodo momento.


            try {
                sleep(5); //Tiempo de respuesta entre la ejecucion del metodo actualizarFondo.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.fondo.actualizarFondo(); // Se ejecuta.


        }

    }
}
