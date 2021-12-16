package modelo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public interface Entidad {


    public void dibujar(Graphics g);
    public Rectangle2D colision();
    public void limitarAlFondo() throws Exception;

}
