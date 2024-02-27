package edu.badpals.bicipalma.domain.estacion;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "id: " + getId() + " \ndireccion: " + getDireccion() + " \nanclajes: " + anclajesLibres();
    }

    public int anclajesLibres() {
        List<Anclaje> anclajesStream = Arrays.asList(anclajes());
        return (int) anclajesStream.stream()
                .filter(a -> !a.isOcupado())
                .count();
    }

    public void anclarBicicleta(Bicicleta bici) {
        Optional<Anclaje> libre = Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).findAny();
        if (libre.isPresent()) {
            libre.get().anclarBici(bici);
        }

    }

    public void retirarBicicleta(TarjetaUsuario tarjeta) {
        if (leerTarjetaUsuario(tarjeta)) {
            Optional<Anclaje> anclajeOcupado = Arrays.stream(anclajes()).filter(Anclaje::isOcupado).findAny();
            if (anclajeOcupado.isPresent()) {
                anclajeOcupado.get().liberarBici();
            }
        }
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjeta) {
        return tarjeta.isActivada();
    }

    public void consultarAnclajes() {
        Arrays.stream(anclajes())
                .forEach(System.out::println);
    }
}
