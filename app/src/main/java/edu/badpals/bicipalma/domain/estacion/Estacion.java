package edu.badpals.bicipalma.domain.estacion;

import edu.badpals.bicipalma.domain.bici.Bicicleta;
import edu.badpals.bicipalma.domain.tarjetausuario.TarjetaUsuario;

public class Estacion {

    private final int id;
    private final String direccion;
    private final Anclajes anclajes;
    
    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    private int getId() {
        return this.id;
    }

    private String getDireccion() {
        return this.direccion;
    }

    private Anclaje[] anclajes() {
        return this.anclajes.anclajes();
    }

    public void consultarEstacion() {
        this.toString();
    }

    @Override
    public String toString() {
        return "id: " + getId() + " \ndireccion: " + getDireccion() + " \nanclajes: " + anclajesLibres();
    }

    public int anclajesLibres() {
        int libres = 0;
        for (Anclaje anclaje : anclajes()) {
            if (!anclaje.isOcupado()) {
                libres += 1;
            }
        }
        return libres;
    }

    public void anclarBicicleta(Bicicleta bici) {
        int posicion = 0;
        int numeroAnclaje = posicion + 1;

        for (Anclaje anclaje : anclajes()) {
            if (!anclaje.isOcupado()) {
                anclajes.ocuparAnclaje(posicion, bici);
                mostrarAnclaje(bici, numeroAnclaje);
                break;
            } else {
                posicion++;
            }
            numeroAnclaje++;
        }
    }

    public void retirarBicicleta(TarjetaUsuario tarjeta) {
        int posicion = 0;
        int numeroAnclaje = posicion + 1;
        if (tarjeta.isActivada()) {
            for (Anclaje anclaje : anclajes()) {
                if (anclaje.isOcupado()) {
                    anclajes.liberarAnclaje(posicion);
                    System.out.println("Bicicleta " + anclaje.getBici() + "retirada del anclaje " + numeroAnclaje);
                    break;
                } else {
                    posicion++;
                }
                numeroAnclaje++;
            }
        } else {
            ;
        }

    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjeta) {
        return tarjeta.isActivada();
    }

    private void mostrarAnclaje(Bicicleta bici, int anclaje) {
        System.out.println("Bicicleta " + bici.getId() + " anclada en anclaje: " + anclaje);
    }

    public void consultarAnclajes() {

        int posicion = 0;
        int numeroAnclaje = posicion + 1;

        for (Anclaje anclaje : anclajes()) {
            System.out.println("Anclaje " + numeroAnclaje + ": " + (anclaje.isOcupado() ? anclaje.getBici() : "libre"));
            numeroAnclaje++;
        }
    }

}
