package edu.badpals.bicipalma.domain.estacion;

import edu.badpals.bicipalma.domain.bici.Movil;

public class Anclaje {
    
    private final int id;
    private boolean ocupado = false;
    private Movil bici = null;

    Anclaje(int id) {
        this.id = id + 1;
    }

    public int getId() {
        return this.id;
    }

    boolean isOcupado() {
        return this.ocupado;
    }

    Movil getBici() {
        return this.bici;
    }

    void anclarBici(Movil bici) {
        this.ocupado = true;
        this.bici = bici;
    }

    void liberarBici() {
        this.ocupado = false;
        this.bici = null;
    }

    @Override
    public String toString() {
        return isOcupado() ? "Anclaje " + getId() + ": " + getBici() : "Anclaje " + getId() + ": libre";
    }
}
