package com.codoacodo.modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codoacodo.connection.AdministradorDeConexiones;
import com.codoacodo.modelo.Orador;
import java.sql.PreparedStatement;

public class OradorDAO {

    private static final String SQL_SLTID = "select * from oradores where id=";
    private static final String SQL_SLTALL = "select * from oradores order by nombre, apellido";
    private static final String SQL_DELETE = "delete from oradores where id = ?";
    private Orador oradorFromDb = null;

    /*metodos del crud*/
    public Orador obtenerPorId(int id) {

        String sql = SQL_SLTID + id;

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!
            if (rs.next()) {
                oradorFromDb = new Orador();

                oradorFromDb.setId(rs.getLong(1));
                oradorFromDb.setNombre(rs.getString(2));
                oradorFromDb.setApellido(rs.getString(3));
                oradorFromDb.setEmail(rs.getString(4));
                oradorFromDb.setTema(rs.getString(5));
                oradorFromDb.setFechaCreacion(rs.getDate(6));
                oradorFromDb.setImagen(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return oradorFromDb;
    }

    public List<Orador> listarOradores() {

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();
        List<Orador> list = new ArrayList<>();
        String sql = SQL_SLTALL;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Orador oradorFromDb = new Orador();
                oradorFromDb.setId(rs.getLong(1));
                oradorFromDb.setNombre(rs.getString(2));
                oradorFromDb.setApellido(rs.getString(3));
                oradorFromDb.setEmail(rs.getString(4));
                oradorFromDb.setTema(rs.getString(5));
                oradorFromDb.setFechaCreacion(rs.getDate(6));
                oradorFromDb.setImagen(rs.getString(7));

                //agrego a la lista 
                list.add(oradorFromDb);
            }

            //cierro la conexion
            con.close();
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace(System.err);
        }
        return list;
    }

    public void crearOrador(Orador orador) {

        Connection con = AdministradorDeConexiones.getConnection();

        if (con != null) {
            // insert en la db > SQL: INSERT INTO....
            String sql = "INSERT INTO oradores (nombre, apellido,email,tema,fechaCreacion,imagen) ";
            sql += "VALUES('" + orador.getNombre() + "','" + orador.getApellido() + "',";
            sql += "'" + orador.getEmail() + "','" + orador.getTema() + "',CURRENT_DATE,'" + orador.getImagen() + "')";

            //control de errores
            try {
                Statement st = con.createStatement();
                st.execute(sql);

                //cierre de conexion
                con.close();

            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public void actualizarOrador(Long id, String nombre, String apellido, String email, String tema, String imagen) {
        Connection con = AdministradorDeConexiones.getConnection();
        if (con != null) {
            String sql = "UPDATE oradores "
                    + " set nombre='" + nombre + "',"
                    + " apellido='" + apellido + "',"
                    + " email='" + email + "',"
                    + " tema='" + tema + "',"
                    + " imagen='" + imagen + "'"
                    + " WHERE id = " + id;

            try {
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public void updateOrador(Orador orador) {
        Connection con = AdministradorDeConexiones.getConnection();
        if (con != null) {
            String sql = "UPDATE oradores "
                    + " set nombre='" + orador.getNombre() + "',"
                    + " apellido='" + orador.getApellido() + "',"
                    + " email='" + orador.getEmail() + "',"
                    + " tema='" + orador.getTema() + "',"
                    + " imagen='" + orador.getImagen() + "'"
                    + " WHERE id = " + orador.getId();

            try {
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public List<Orador> buscar(String value) {
        //Connection
        Connection con = AdministradorDeConexiones.getConnection();
        List<Orador> listado = new ArrayList<Orador>();

        String sql = "select * from oradores where concat_WS(nombre,apellido,email,tema) like '%" + value + "%' ";

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Orador oradorFromDb = new Orador();
                oradorFromDb.setId(rs.getLong(1));
                oradorFromDb.setNombre(rs.getString(2));
                oradorFromDb.setApellido(rs.getString(3));
                oradorFromDb.setEmail(rs.getString(4));
                oradorFromDb.setTema(rs.getString(5));
                oradorFromDb.setFechaCreacion(rs.getDate(6));
                oradorFromDb.setImagen(rs.getString(7));

                listado.add(oradorFromDb);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return listado;
    }

    public int eliminarOrador(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = AdministradorDeConexiones.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }
}
