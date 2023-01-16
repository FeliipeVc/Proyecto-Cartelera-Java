package bbdd;

import Estilos.Colorinchis;
import modulos.Cartelera;
import modulos.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;
import modulos.Entrada;


public class BD_LDF extends BD_Conector {

    private static Statement s;
    private static PreparedStatement ps;
    private static ResultSet reg;

    /**
     * Método constructor de la clase BD_LDF
     *
     * @param file Nombre de la BBDD
     */
    public BD_LDF(String file) {
        super(file);
    }

    public Vector<Cartelera> listarCartelera() {

        String cadenaSQL = "SELECT * FROM CARTELERA";
        Vector<Cartelera> v = new Vector<Cartelera>();

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                Time f = reg.getTime("fecha_hora");

                Date fecha = reg.getDate("fecha_hora");
                LocalDate fBuena = fecha.toLocalDate();

                v.add(new Cartelera(reg.getString("nombre"), reg.getString("id_cine"), reg.getInt("id_sala"), fBuena, f, reg.getInt("duracion"), reg.getString("tipo")));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;

    }

    public Cartelera listarPeliculaCartelera(String nombre, String id_cine, int id_sala, String hora) {

        String cadenaSQL = "SELECT * FROM CARTELERA WHERE NOMBRE LIKE '%" + nombre + "%' AND ID_CINE LIKE '%" + id_cine + "%' AND ID_SALA = " + id_sala + " AND FECHA_HORA LIKE '%" + hora + "%'";
        Cartelera ca = null;
        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                Time f = reg.getTime("fecha_hora");

                Date fecha = reg.getDate("fecha_hora");
                LocalDate fBuena = fecha.toLocalDate();

                ca = new Cartelera(reg.getString("nombre"), reg.getString("id_cine"), reg.getInt("id_sala"), fBuena, f, reg.getInt("duracion"), reg.getString("tipo"));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return ca;

    }

    public boolean sitioOcupado(Entrada en) {

        String cadenaSQL = "SELECT * FROM ENTRADAS WHERE NOMBRE LIKE '%" + en.getNombre()
                + "%' AND ID_CINE LIKE '%" + en.getId_cine() + "%' AND ID_SALA = "
                + en.getId_sala() + " AND FECHA_HORA LIKE '%" + en.getFecha_hora() + "%' AND NUM_FILA = " + en.getFila() + " AND NUM_BUTACA = " + en.getButaca();

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                return true;
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;

    }

    public Vector<Cartelera> listarCarteleraFiltrada(String dato, String campo) {

        String data = "%" + dato + "%";
        String cadenaSQL = "SELECT * FROM CARTELERA WHERE " + campo + " LIKE  ?";
        Vector<Cartelera> v = new Vector<Cartelera>();

        try {

            this.abrir();
            ps = c.prepareStatement(cadenaSQL);

            ps.setString(1, data);

            reg = ps.executeQuery();

            while (reg.next()) {

                Time f = reg.getTime("fecha_hora");
                Date fecha = reg.getDate("fecha_hora");
                LocalDate fBuena = fecha.toLocalDate();

                v.add(new Cartelera(reg.getString("nombre"), reg.getString("id_cine"), reg.getInt("id_sala"), fBuena, f, reg.getInt("duracion"), reg.getString("tipo")));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;

    }

    public Vector<String> listarCampoTablaString(String tabla, String campo) {

        String cadenaSQL = "SELECT " + campo + " FROM " + tabla;
        Vector<String> v = new Vector<String>();

        try {

            this.abrir();
            ps = c.prepareStatement(cadenaSQL);

            reg = ps.executeQuery();

            while (reg.next()) {
                v.add(reg.getString(1));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;

    }

    public Vector<Integer> listarFilaButaca(int sala, String cine) {

        String cadenaSQL = "SELECT NUM_FILA, NUM_BUTACA FROM SALAS WHERE ID_SALA = " + sala + " AND ID_CINE LIKE '" + cine + "'";
        Vector<Integer> v = new Vector<Integer>();

        try {

            this.abrir();
            ps = c.prepareStatement(cadenaSQL);

            reg = ps.executeQuery();

            while (reg.next()) {
                v.add(reg.getInt("NUM_FILA"));
                v.add(reg.getInt(("NUM_BUTACA")) / reg.getInt("NUM_FILA"));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;

    }

    public Vector<Date> listarCampoTablaFecha(String tabla, String campo) {

        String cadenaSQL = "SELECT ? FROM ?";
        Vector<Date> v = new Vector<Date>();

        try {

            this.abrir();
            ps = c.prepareStatement(cadenaSQL);

            ps.setString(1, campo);
            ps.setString(2, tabla);

            reg = ps.executeQuery();

            while (reg.next()) {
                v.add(reg.getDate(1));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;

    }

    public Vector<Integer> listarCampoTablaInt(String tabla, String campo) {

        String cadenaSQL = "SELECT ? FROM ?";
        Vector<Integer> v = new Vector<Integer>();

        try {

            this.abrir();
            ps = c.prepareStatement(cadenaSQL);

            ps.setString(1, campo);
            ps.setString(2, tabla);

            reg = ps.executeQuery();

            while (reg.next()) {
                v.add(reg.getInt(1));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;

    }

    public String listarPassword(String nick) {

        String dato = "'%" + nick + "%'";
        String cadenaSQL = "SELECT contrasena FROM USUARIOS WHERE nick like " + dato;
        String v = "";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                v = reg.getString(1);
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;

    }

    public void listarUser(String nick) {

        String dato = "'%" + nick + "%'";
        String cadenaSQL = "SELECT * FROM USUARIOS WHERE nick like " + dato;

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                java.sql.Date f = reg.getDate("fecha_nacimiento");
                LocalDate fBuena = f.toLocalDate();

                System.out.println(Colorinchis.purple("NICK: ") + reg.getString("nick") + Colorinchis.purple("       NOMBRE: ") + reg.getString("nombre")
                        + Colorinchis.purple("       APELLIDOS: ") + reg.getString("apellidos") + Colorinchis.purple("       CORREO: ") + reg.getString("correo")
                        + Colorinchis.purple("       FECHA DE NACIMIENTO: ") + fBuena + Colorinchis.purple("        PREMIUM: ") + reg.getBoolean("premium") + "\n");
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    
    public void listarCines() {

        String cadenaSQL = "SELECT id_cine, nombre, direccion FROM CINES";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {

                System.out.println(Colorinchis.purple("ID_CINE: ") + reg.getString("id_cine") + Colorinchis.purple("       NOMBRE: ") + reg.getString("nombre")
                        + Colorinchis.purple("       DIRECCION: ") + reg.getString("direccion") + "\n");

            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    
    public void listarEntradasUsuario(String nick) {

        String cadenaSQL = "SELECT * FROM ENTRADAS where NICK = '" + nick + "'";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {

                java.sql.Date f = reg.getDate("FECHA_HORA");
                LocalDate fBuena = f.toLocalDate();

                System.out.println(Colorinchis.purple("NICK: ") + reg.getString("NICK") + Colorinchis.purple("       ID_CINE: ") + reg.getString("ID_CINE")
                        + Colorinchis.purple("       ID_SALA: ") + reg.getInt("ID_SALA") + Colorinchis.purple("       NOMBRE: ") + reg.getString("NOMBRE")
                        + Colorinchis.purple("       NUM_FILA: ") + reg.getInt("NUM_FILA") + Colorinchis.purple("       NUM_BUTACA: ") + reg.getInt("NUM_BUTACA")
                        + Colorinchis.purple("       SESION: ") + fBuena + Colorinchis.purple("       PRECIO: ") + reg.getDouble("PRECIO") + "\n");

            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    
    public boolean esPremium(String nick) {

        String cadenaSQL = "SELECT PREMIUM FROM USUARIOS where NICK = '" + nick + "'";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {

                return reg.getBoolean("premium");

            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;

    }

    public int añadirUsuario(Usuario u) {

        String cadenaSQL = "INSERT INTO USUARIOS VALUES('" + u.getNick() + "','"
                + u.getNombre() + "','" + u.getApellidos() + "','" + u.getCorreo()
                + "','" + u.getContraseña() + "','" + u.getFecha_nac() + "', '0')";

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return -1;
    }

    public int añadirEntrada(String nick, Entrada e, Double precio) {

        String cadenaSQL = "INSERT INTO ENTRADAS VALUES('" + nick + "','"
                + e.getId_cine() + "','" + e.getId_sala() + "','" + e.getNombre()
                + "','" + e.getFila() + "','" + e.getFecha_hora() + "','" + e.getButaca() + "','"
                + precio + "')";

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException es) {

            es.printStackTrace();
        }

        return -1;
    }

    public int cambiarNick(String newNick, String oldNick) {

        String cadenaSQL = "UPDATE USUARIOS SET NICK = '" + newNick + "' WHERE NICK = '" + oldNick + "'";

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return -1;

    }

    public int cambiarContrasena(String newPass, String Nick) {

        String cadenaSQL = "UPDATE USUARIOS SET CONTRASENA = '" + newPass + "' WHERE NICK = '" + Nick + "'";

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return -1;

    }

    public void Admin_listarUsuarios() {

        String cadenaSQL = "SELECT * FROM USUARIOS";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {

                if (!reg.getString(1).equalsIgnoreCase("admin")) {
                    java.sql.Date f = reg.getDate("fecha_nacimiento");
                    LocalDate fBuena = f.toLocalDate();

                    System.out.println(Colorinchis.purple("NICK: ") + reg.getString("nick") + Colorinchis.purple("       NOMBRE: ") + reg.getString("nombre")
                            + Colorinchis.purple("       APELLIDOS: ") + reg.getString("apellidos") + Colorinchis.purple("       CORREO: ") + reg.getString("correo")
                            + Colorinchis.purple("       FECHA DE NACIMIENTO: ") + fBuena + Colorinchis.purple("        PREMIUM: ") + reg.getBoolean("premium"));
                }
            }

            reg.close();
            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public boolean Admin_existeUsuario(String nick) {
        String cadenaSQL = "SELECT COUNT(*) FROM USUARIOS WHERE nick LIKE '" + nick + "'";
        int contador = 0;
        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                contador = reg.getInt(1);
            }
            reg.close();
            this.cerrar();
            if (contador == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Admin_existeUsuarioPass(String nick, String password) {
        String cadenaSQL = "SELECT COUNT(*) FROM USUARIOS WHERE nick LIKE '" + nick + "' AND contrasena LIKE '" + "'";
        int contador = 0;
        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                contador = reg.getInt(1);
            }
            reg.close();
            this.cerrar();
            if (contador == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int Admin_borrarUsuario(String nick) {
        String cadenaSQL = "DELETE FROM USUARIOS WHERE nick LIKE '" + nick + "'";

        Admin_borrarMovAsociados(nick);

        try {

            this.abrir();
            s = c.createStatement();
            int filasAfectadas = s.executeUpdate(cadenaSQL);
            reg.close();
            this.cerrar();

            return filasAfectadas;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void Admin_borrarMovAsociados(String nick) {
        String cadenaSQL = "DELETE FROM ENTRADAS WHERE nick LIKE '" + nick + "'";

        try {

            this.abrir();
            s = c.createStatement();
            s.executeUpdate(cadenaSQL);
            reg.close();
            this.cerrar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int Admin_updateUser(String campo, String valor, String nick) {
        String cadenaSQL = "UPDATE USUARIOS SET " + campo + " = '" + valor + "' WHERE nick LIKE '%" + nick + "%'";

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);

            reg.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean Admin_existeIdCine(String idCine) {
        String cadenaSQL = "SELECT id_cine FROM CINES";
        boolean existe = false;
        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                if (reg.getString(1).equalsIgnoreCase(idCine)) {
                    existe = true;
                }
            }
            reg.close();
            this.cerrar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public boolean Admin_insertCartelera(Cartelera c1) {
        String cadenaSQL = "INSERT INTO CARTELERA VALUES (?, ?, ?, ?, ?, ?)";
        int exito = -1;
        try {

            this.abrir();
            PreparedStatement pSt = c.prepareStatement(cadenaSQL);

            pSt.setString(1, c1.getNombre());
            pSt.setString(2, c1.getId_cine());
            pSt.setInt(3, c1.getId_sala());
            pSt.setDate(4, Date.valueOf(c1.getFecha_hora()));
            pSt.setInt(5, c1.getDuracion());
            pSt.setString(6, c1.getTipo());

            exito = pSt.executeUpdate();
            reg.close();
            this.cerrar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito == 1;
    }

    public int Admin_updateCine(String campo, String valor, String id_cine) {
        String cadenaSQL = "UPDATE CINES SET " + campo + " = '" + valor + "' WHERE id_cine LIKE '" + id_cine + "'";
        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);

            reg.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int Admin_updateCine(String campo, int valor, String id_cine) {
        String cadenaSQL = "UPDATE CINES SET " + campo + " = " + valor + " WHERE id_cine LIKE '" + id_cine + "'";
        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);

            reg.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int Admin_delete_entrada(String id_cine, int id_sala, int num_fila, int num_butaca) {
        String cadenaSQL = "DELETE FROM ENTRADAS WHERE id_cine LIKE '" + id_cine + "'" + " AND id_sala = " + id_sala + " AND num_fila = " + num_fila + " AND num_butaca = " + num_butaca;
        int filas;
        try {

            this.abrir();
            s = c.createStatement();
            filas = s.executeUpdate(cadenaSQL);
            reg.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int Admin_contarEntradas(String nick) {
        String cadenaSQL = "SELECT COUNT(*) FROM ENTRADAS WHERE nick LIKE '" + nick + "'";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            if (reg.next()) {
                return reg.getInt(1);
            }
            reg.close();
            this.cerrar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Vector<Cartelera> Admin_mostrar_cartelera(String id_cine) {
        String cadenaSQL = "SELECT * FROM CARTELERA WHERE id_cine LIKE '" + id_cine + "'";
        Vector<Cartelera> v = new Vector<Cartelera>();

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                Time f = reg.getTime("fecha_hora");

                Date fecha = reg.getDate("fecha_hora");
                LocalDate fBuena = fecha.toLocalDate();

                v.add(new Cartelera(reg.getString("nombre"), reg.getString("id_cine"), reg.getInt("id_sala"), fBuena, f, reg.getInt("duracion"), reg.getString("tipo")));
            }

            this.cerrar();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return v;
    }

    public void Admin_mostrarIdCine() {
        String cadenaSQL = "SELECT id_cine FROM CINES";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            while (reg.next()) {
                System.out.println(Colorinchis.purple(reg.getString(1)));
            }
            reg.close();
            this.cerrar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int Admin_contarPeliculas(String nombre, String id_cine) {
        String cadenaSQL = "SELECT COUNT(*) FROM CARTELERA WHERE id_cine LIKE '" + id_cine + "' AND NOMBRE LIKE '" + nombre + "'";

        try {

            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);

            if (reg.next()) {
                return reg.getInt(1);
            }
            reg.close();
            this.cerrar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int Admin_borrarCartelera(String nombre, String id_cine, int num_sala) {
        String cadenaSQL = "DELETE FROM CARTELERA WHERE nombre LIKE '" + nombre + "'" + " AND id_cine LIKE '" + id_cine + "' AND id_sala = " + num_sala;
        int filas;
        try {

            this.abrir();
            s = c.createStatement();
            filas = s.executeUpdate(cadenaSQL);
            reg.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int mejorarPremium(String Nick) {

        String cadenaSQL = "UPDATE USUARIOS SET PREMIUM = '1' WHERE NICK = '" + Nick + "'";

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return -1;

    }

}
