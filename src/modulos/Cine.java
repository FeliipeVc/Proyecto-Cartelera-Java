package modulos;

import java.util.Vector;

public class Cine {
    
    private String nombre;
    private String direccion;
    private String id;
    private Vector<Entrada> entradas;
    private Vector<Sala> salas;
    private Cartelera cartelera;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vector<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(Vector<Entrada> entradas) {
        this.entradas = entradas;
    }

    public Vector<Sala> getSalas() {
        return salas;
    }

    public void setSalas(Vector<Sala> salas) {
        this.salas = salas;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }
    
    
}
