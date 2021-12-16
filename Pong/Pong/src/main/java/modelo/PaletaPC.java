package modelo;

public class PaletaPC extends Raqueta {

    Pelota pelota; //modelo.Pelota del juego.

    public PaletaPC(int posicionX, int posicionY) {
        super(posicionX, posicionY);

    }

    public void setPelota(Pelota pelota) {
        this.pelota = pelota;
    }

    @Override
    public void mover() {
       //le baje la velocidad
        int velocidad = 1; //Tiene esa velocidad para que el movimiento se vea mas natural.

        //Si la pelota esta mas arriba que la paleta en el eje y.
        if (pelota.getPosicionY() > this.getPosicionY()){
            this.setPosicionY(this.getPosicionY()+velocidad);
        }
        //Si la pelota esta mas abajo que la pelota en el eje y.
        else if (pelota.getPosicionY() < this.getPosicionY()){
            this.setPosicionY(this.getPosicionY()-velocidad);
        }
    }
}
