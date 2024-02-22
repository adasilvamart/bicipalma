package edu.badpals.bicipalma;

import edu.badpals.bicipalma.domain.Bicicleta;

public class App {
    public static void main(String[] args) {
        Bicicleta bici = new Bicicleta(1);

        System.out.println(bici.toString());
    }
}
