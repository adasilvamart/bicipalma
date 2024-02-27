package edu.badpals.bicipalma.domain.estacion;

import edu.badpals.bicipalma.domain.bici.Bicicleta;

public class Anclaje {
    
    private final int id;
    private boolean ocupado = false;
    private Bicicleta bici = null;

    Anclaje(int id) {
        this.id = id + 1;
    }

    public int getId() {
        return this.id;
    }

    boolean isOcupado() {
        return this.ocupado;
    }

    Bicicleta getBici() {
        return this.bici;
    }

    void anclarBici(Bicicleta bici) {
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
