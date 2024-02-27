package edu.badpals.bicipalma.domain.estacion;
import edu.badpals.bicipalma.domain.bici.Movil;

public class Anclajes {

    private Anclaje[] anclajes;

    Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    private void crearAnclajes() {
        for (int i = 0; i < anclajes.length; i++) {
            this.anclajes[i] = new Anclaje(i);
        }
    }

    Anclaje[] anclajes() {
        return this.anclajes;
    }

    int numAnclajes() {
        return this.anclajes.length;
    }

    void ocuparAnclaje(int anclaje, Movil bici) {
        anclajes[anclaje].anclarBici(bici);
    }

    boolean isAnclajeOcupado(int anclaje) {
        return anclajes[anclaje].isOcupado();
    }

    void liberarAnclaje(int anclaje) {
        anclajes[anclaje].liberarBici();
    }

    Movil getBiciAt(int anclaje) {
        return anclajes[anclaje].getBici();
    }

    @Override
    public String toString() {
        return "Anclajes: " + Integer.toString(numAnclajes());
    }
}
