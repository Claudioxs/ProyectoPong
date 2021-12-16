package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaletaPCTest {

    PaletaPC paletaPC;
    Pelota pelota;


    @BeforeEach
    void setUp() {

        paletaPC = new PaletaPC(200,200);
        pelota = new Pelota(200,198,10,10);
        paletaPC.setPelota(pelota);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mover() {

        assertNotEquals(paletaPC.getPosicionY(), pelota.getPosicionY());
        paletaPC.mover();
        paletaPC.mover();
        assertEquals(paletaPC.getPosicionY(), pelota.getPosicionY());

        pelota.setPosicionY(pelota.getPosicionY()-4);
        assertNotEquals(paletaPC.getPosicionY(), pelota.getPosicionY());
        paletaPC.mover();
        paletaPC.mover();
        paletaPC.mover();
        paletaPC.mover();
        assertEquals(paletaPC.getPosicionY(), pelota.getPosicionY());

    }
}