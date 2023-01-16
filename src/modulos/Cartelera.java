package modulos;

import Estilos.Colorinchis;
import java.sql.Time;
import java.time.LocalDate;

public class Cartelera {

    private String nombre;
    private String id_cine;
    private int id_sala;
    private LocalDate fecha_hora;
    private Time hora;
    private int duracion;
    private String tipo;

    public Cartelera(String nombre, String id_cine, int id_sala, LocalDate fecha_hora, Time hora, int duracion, String tipo) {
        this.nombre = nombre;
        this.id_cine = id_cine;
        this.id_sala = id_sala;
        this.fecha_hora = fecha_hora;
        this.hora = hora;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public Cartelera(String nombre, String id_cine, int id_sala, LocalDate fecha_hora, int duracion, String tipo) {
        this.nombre = nombre;
        this.id_cine = id_cine;
        this.id_sala = id_sala;
        this.fecha_hora = fecha_hora;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public LocalDate getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDate fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_cine() {
        return id_cine;
    }

    public void setId_cine(String id_cine) {
        this.id_cine = id_cine;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String toString() {
        return Colorinchis.purple("NOMBRE: ") + nombre + Colorinchis.purple("      ID_CINE: ") + id_cine + Colorinchis.purple("        SALA: ") + id_sala + Colorinchis.purple("       SESIÓN: ") + fecha_hora + "-" + hora + Colorinchis.purple("      DURACION: ") + duracion + Colorinchis.purple("      VERSIÓN: ") + tipo + "\n";
    }

}
