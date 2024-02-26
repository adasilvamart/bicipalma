package edu.badpals.bicipalma.domain.estacion;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnclajesTest {

    @Test
    public void toStringTest() {
        Anclajes anclajes = new Anclajes(6);
        assertEquals("Anclajes: 6", anclajes.toString());
    } 
}