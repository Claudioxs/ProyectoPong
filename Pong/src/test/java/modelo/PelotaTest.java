package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PelotaTest {

    Pelota pelota;

    @BeforeEach
    void setUp() {
        pelota = new Pelota(100,100,10,10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rebotar() {

        assertEquals(1, pelota.getVelocidadX()); //sentido actual.

        pelota.setPosicionX(-100); //mas alla de los limites.
        pelota.rebotar(); //deberia cambiar su sentido.
        assertEquals(-1,pelota.getVelocidadX());


    }
}