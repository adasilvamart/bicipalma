package edu.badpals.bicipalma.domain;

public class Bicicleta {

    private final int id;

    public Bicicleta(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return Integer.toString(getId());
    }
}
