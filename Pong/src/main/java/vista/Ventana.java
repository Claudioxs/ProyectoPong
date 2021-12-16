package vista;

import modelo.HiloJuego;
import vista.Fondo;

import javax.swing.*;

public final class Ventana extends JFrame {

    //Medidas de la ventana.
    public static final int ALTO = 560;
    public static final int ANCHO = 1000;

    //Componentes principales.
    private Fondo fondo;
    private HiloJuego hiloJuego;

    public Ventana(){

        //Instanciando y agregando el fondo en la vista.Ventana.
        fondo = new Fondo(ANCHO, ALTO);
        this.add(fondo);

        //Instanciando y arrancando el hilo.
        hiloJuego = new HiloJuego(fondo);
        hiloJuego.start();

        //Modificaciones varias a la ventana.
        setTitle("Juego Pong");// titulo de la ventana
        this.setResizable(false);
        this.setSize(ANCHO, ALTO);
        this.setVisible(true);
        setLocationRelativeTo(null);// la ventana se vea en el centro
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}

