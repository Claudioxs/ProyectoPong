package modelo;

import modelo.Personaje;
import vista.Ventana;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Raqueta extends Personaje implements KeyListener {


    private String direccion = ""; //Puede ser w o s.
    private final int velocidad = 2; //Cuntos pixeles sube o baja cada pulsacion.


    public Raqueta(int posicionX, int posicionY) {
        super(posicionX, posicionY, 80,8);//Agregando medidas de la raqueta.
    }



    @Override
    public void mover() {//Cambia el lugar de la paleta.

        if (this.direccion.equals("w")){//Hacia arriba.
            this.setPosicionY(this.getPosicionY()-this.velocidad);
        }

        else if (this.direccion.equals("s")){//Hacia abajo.
            this.setPosicionY(this.getPosicionY()+this.velocidad);
        }

    }

    @Override
    public void dibujar(Graphics g) {

        this.mover();
        try {
            this.limitarAlFondo();
        } catch (Exception e) {
            e.printStackTrace();
            this.repulsion();
        }
        g.setColor(this.getColor());
        g.fillRect(this.getPosicionX(), this.getPosicionY(), this.getAncho(), this.getAlto());

    }

    @Override
    public void limitarAlFondo() throws Exception {
        super.limitarAlFondo();

        int margen = 50;

        //Corresponde a los limites para la raqueta.
        if (this.getPosicionY()+this.getAlto() <= Ventana.ALTO - margen && this.getPosicionY() > 0) {
            System.out.println("Raqueta: dentro de los limites");
        }

        else {//Si se sale del tablero
           throw new Exception  ("Raqueta: fuera de los limites");
        }
    }

    public void repulsion(){ //Se ejecuta cada vez que la paleta se sale de los limites.

        int borde = 40;

        if (this.getPosicionY()+this.getAlto() > Ventana.ALTO - borde){//Pared de abajo
            this.setPosicionY(this.getPosicionY()-this.velocidad);
        }

        else if (this.getPosicionY() <= 0){//Pared de arriba
            this.setPosicionY(this.getPosicionY()+this.velocidad);
        }

    }

    @Override//Cambia el sentido del movimiento
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == 'w'){
            this.direccion = "w";
        }

        else if (e.getKeyChar() == 's'){
            this.direccion = "s";
        }

    }

    @Override//Al soltar las teclas.
    public void keyReleased(KeyEvent e) {
        this.direccion = "";
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
