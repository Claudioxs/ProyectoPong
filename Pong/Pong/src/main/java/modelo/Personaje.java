package modelo;

import modelo.Entidad;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Personaje implements Entidad {

    private int posicionX;
    private int posicionY;
    private int alto;
    private int ancho;
    private final Color color = Color.white;

    public Personaje(int posicionX, int posicionY, int alto, int ancho) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.alto = alto;
        this.ancho = ancho;
    }

    public Color getColor() {
        return color;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public abstract void mover();


    @Override
    public Rectangle2D colision() { //Representa los limites de cada personaje
        return new Rectangle(this.posicionX, this.posicionY, this.ancho, this.alto);
    }

    @Override
    public void limitarAlFondo() throws Exception {
    }
}
