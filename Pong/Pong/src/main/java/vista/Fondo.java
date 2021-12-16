package vista;

import modelo.PaletaPC;
import modelo.Pelota;
import modelo.Raqueta;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Fondo extends JPanel{


    //Personajes del fondo.
    private Raqueta jugadorUno;
    private PaletaPC jugadorDos;
    Pelota pelota;

    //se agregan los puntajes
    private int puntajeJugador1= 0;
    private int puntajeJugador2= 0;



    public Fondo(int ANCHO, int ALTO){

        //Creando los personajes y posicionandolos en su lugar inicial.
        jugadorUno = new Raqueta(32,200);
        jugadorDos = new PaletaPC(920,200);
        pelota = new Pelota(500,230, jugadorUno, jugadorDos);

        jugadorDos.setPelota(pelota);

        //Configuraciones para eventos de teclado.
        this.setFocusable(true);
        this.addKeyListener(this.jugadorUno);

        //Algunas configuraciones del vista.Fondo.
        this.setSize(ANCHO, ALTO);
        this.setBackground(Color.BLACK);



    }

    public Pelota getPelota() {
        return pelota;
    }

    @Override
    public void paint(Graphics g) { //Encargado de dibujar a los personajes.
        super.paint(g);

        //Se dibujan las paletas y la pelota.
        jugadorUno.dibujar(g);
        jugadorDos.dibujar(g);
        pelota.dibujar(g);

        //Se dibuja el puntaje , se le pone color, se llama al  metodo
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.WHITE);
        dibujarPuntaje(g2);

        // metodo de la linea
        dibujarJuego(g2);



    }
    //metodo para dibujar los puntajes
    private void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g, g3 = g;
        //formato letra, tamaño
        Font puntaje = new Font("Arial", Font.BOLD, 38);
        Font reiniciar = new Font("Arial", Font.BOLD, 38);
        //se instancia
        g.setFont(puntaje);
        g3.setFont(reiniciar);
        g1.drawString(Integer.toString(puntajeJugador1), (float) getBounds().getCenterX() - 70, 40);
        g2.drawString(Integer.toString(puntajeJugador2), (float) getBounds().getCenterX() + 45, 40);
    }



    //este metodo es para crear la linea del medio
    private void dibujarJuego(Graphics2D g) {
        // se crea la linea , se centra en la ventana, se le da (x , y)
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());
        g.draw(linea);

    }
    //se crean set y get para los puntajes de jugador 1 y 2
    public int getPuntajeJugador2() {
        return puntajeJugador2;
    }

    public int getPuntajeJugador1() {
        return puntajeJugador1;
    }

    public void setPuntajeJugador2(int puntajeJugador2) {
        this.puntajeJugador2 = puntajeJugador2;
    }

    public void setPuntajeJugador1(int puntajeJugador1) {
        this.puntajeJugador1 = puntajeJugador1;
    }


    public void actualizarFondo(){ //Metodo que se llama en el hilo.

        this.repaint();//Vuelve a llamar al metodo paint.

        this.pelota.marcarPunto(this);
    }
}
