package modelo;

import modelo.PaletaPC;
import vista.Fondo;
import vista.Ventana;

import java.awt.*;

public class Pelota extends Personaje {

    //Valores encargados de la direccion de la pelota.
    private int velocidadX = 1;
    private int velocidadY = 1;

    //Jugadores.
    Raqueta jugadorUno;
    PaletaPC jugadorDos;

    public Pelota(int posicionX, int posicionY, Raqueta jugadorUno, PaletaPC jugadorDos) {
        super(posicionX, posicionY, 16, 16);//Medidas de la pelota.
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
    }

    public Pelota(int posicionX, int posicionY, int alto, int ancho) {
        super(posicionX, posicionY, alto, ancho);
    }

    @Override
    public void dibujar(Graphics g) {

        try {
            this.mover();
            this.rebotarConRaqueta();
            this.limitarAlFondo(); //Por si con estos metodos escapa de los limites
        } catch (Exception e) {    //se ejecuta rebotar.
            e.printStackTrace();
            this.rebotar();
        }

        //Esto es la pelota en si, se dibuja en el objeto del argumento.

        g.fillRect(this.getPosicionX(), this.getPosicionY(), this.getAncho(), this.getAlto());

    }

    @Override
    public void mover() {//Cambia la posicion de la pelota en el eje x o y.
        this.setPosicionX(this.getPosicionX() + this.velocidadX);
        this.setPosicionY(this.getPosicionY() + this.velocidadY);
    }


    public void rebotar() {//Se cambia el sentido que tiene la pelota.

        int ventanaY = Ventana.ALTO - 100; //La ventana tiene un margen y se le debe restar.

        if (this.getPosicionY() > ventanaY) {
            this.velocidadY = -this.velocidadY;
        }

        if (this.getPosicionY() < 0) {
            this.velocidadY = -this.velocidadY;
        }

        if (this.getPosicionX() > Ventana.ANCHO) {
            this.velocidadX = -this.velocidadX;
        }

        if (this.getPosicionX() < 0) {
            this.velocidadX = -this.velocidadX;
        }
    }

    @Override
    public void limitarAlFondo() throws Exception {
        super.limitarAlFondo();

        int margen = 50;

        //Corresponde a los limites para la pelota.
        if (this.getPosicionY() < Ventana.ALTO - margen && this.getPosicionY() > 0) {

            System.out.println("Pelota: dentro de los limites ");
        } else {
            throw new Exception("Pelota: fuera de los limites ");
        }
    }

    public int getVelocidadX() {
        return velocidadX;
    }

    void rebotarConRaqueta() {//Cambia el sentido de la velocidad en X si es que colisionan.

        if (jugadorUno.colision().intersects(this.colision())) {
            this.velocidadX = -this.velocidadX;
        }

        if (jugadorDos.colision().intersects(this.colision())) {
            this.velocidadX = -this.velocidadX;
        }
    }

    public void marcarPunto(Fondo fondo) {
    //se llama a la clase Fondo por parametros

            //Corresponden a los limites de X.
            if (this.getPosicionX() < 0 || this.getPosicionX() > Ventana.ANCHO) {
                //Si es que se llega a los limites de X, la pelota se reposiciona.
                fondo.setPuntajeJugador2(fondo.getPuntajeJugador2()+1);//marcar punto para jugador 2

                this.setPosicionX(Ventana.ANCHO / 2);

                this.setPosicionY(Ventana.ALTO / 2);

            }if(this.getPosicionX()>  1000 || this.getPosicionX() > Ventana.ANCHO){
                fondo.setPuntajeJugador1(fondo.getPuntajeJugador1()+1);//marcar punto para jugador 1
                this.setPosicionX(Ventana.ANCHO / 2);

                this.setPosicionY(Ventana.ALTO / 2);
            }
        }


    }



