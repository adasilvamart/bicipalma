package edu.badpals.bicipalma.domain.estacion;

import edu.badpals.bicipalma.domain.bici.Bicicleta;

public class Anclaje {
    private boolean ocupado = false;
    private Bicicleta bici = null;

    // Modificar constructor a privado, preguntar porqué vacío
    Anclaje() {}

    boolean isOcupado() {
        return this.ocupado;
    }

    Bicicleta getBici() {
        return this.bici;
    }

    void anclarBici(Bicicleta bici){
        this.ocupado = true;
        this.bici = bici;
    }

    void liberarBici() {
        this.ocupado = false;
        this.bici = null;
    }

    @Override
    public String toString() {
        return isOcupado() ? "Ocupado" : "Libre";
    }

}
