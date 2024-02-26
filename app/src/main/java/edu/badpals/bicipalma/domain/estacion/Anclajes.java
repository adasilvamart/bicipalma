package edu.badpals.bicipalma.domain.estacion;

import edu.badpals.bicipalma.domain.bici.Bicicleta;

public class Anclajes {

    Anclaje[] anclajes;

    Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    private void crearAnclajes() {
        for (int i = 0; i < anclajes.length; i++) {
            this.anclajes[i] = new Anclaje();
        }
    }

    Anclaje[] anclajes() {
        return this.anclajes;
    }

    int numAnclajes() {
        return this.anclajes.length;
    }

    void ocuparAnclaje(int anclaje, Bicicleta bici) {
        anclajes[anclaje].anclarBici(bici);
    }

    boolean isAnclajeOcupado(int anclaje) {
        return anclajes[anclaje].isOcupado();
    }

    void liberarAnclaje(int anclaje) {
        anclajes[anclaje].liberarBici();
    }

    Bicicleta getBiciAt(int anclaje) {
        return anclajes[anclaje].getBici();
    }

    @Override
    public String toString() {
        return "Anclajes: " + Integer.toString(numAnclajes());
    }
}
