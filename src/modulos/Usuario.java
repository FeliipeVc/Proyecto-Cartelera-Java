package modulos;

import Estilos.Colorinchis;
import java.time.LocalDate;

public class Usuario {
    
    private String nombre;
    private String apellidos;
    private String nick;
    private LocalDate fecha_nac;
    private String correo;
    private String contraseña;
    private boolean premium;

    public Usuario(String nombre, String apellidos, String nick, LocalDate fecha_nac, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.fecha_nac = fecha_nac;
        this.correo = correo;
        this.contraseña = contraseña;
        this.premium = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String toString() {
        return "¿Son los datos correctos?" +"\n"+ Colorinchis.purple("\nNombre:    ") + nombre + Colorinchis.purple("\nApellidos:  ") + apellidos + Colorinchis.purple("\nNick:    ") + nick + Colorinchis.purple("\nFecha de nacimiento:  ") + fecha_nac + 
                Colorinchis.purple("\nCorreo:  ") + correo + "\n";
    }
    
    
}
