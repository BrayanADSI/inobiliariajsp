/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author melissa
 */
public class Arriendo {

    private int id_Arriendo;
    private LocalDate Fecha_Arriendo;
    private int id_Cedula_Cliente_Arriendo;
    private int id_inmobiliario_Arriendo;
    private int id_Tipo_Arriendo;
    private int paginacion;

    public Arriendo() {
    }
    
     public int getId_Arriendo() {
        return id_Arriendo;
    }

    public void setId_Arriendo(int id_Arriendo) {
        this.id_Arriendo = id_Arriendo;
    }

    public LocalDate getFecha_Arriendo() {
        return Fecha_Arriendo;
    }

    public void setFecha_Arriendo(LocalDate Fecha_Arriendo) {
        this.Fecha_Arriendo = Fecha_Arriendo;
    }

    public int getId_Cedula_Cliente_Arriendo() {
        return id_Cedula_Cliente_Arriendo;
    }

    public void setId_Cedula_Cliente_Arriendo(int id_Cedula_Cliente_Arriendo) {
        this.id_Cedula_Cliente_Arriendo = id_Cedula_Cliente_Arriendo;
    }

    public int getId_inmobiliario_Arriendo() {
        return id_inmobiliario_Arriendo;
    }

    public void setId_inmobiliario_Arriendo(int id_inmobiliario_Arriendo) {
        this.id_inmobiliario_Arriendo = id_inmobiliario_Arriendo;
    }

    public int getId_Tipo_Arriendo() {
        return id_Tipo_Arriendo;
    }

    public void setId_Tipo_Arriendo(int id_Tipo_Arriendo) {
        this.id_Tipo_Arriendo = id_Tipo_Arriendo;
    }

    public int getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(int paginacion) {
        this.paginacion = paginacion;
    }
    
    public ArrayList listar(int pagina) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaArriendos = new ArrayList();
        Arriendo elArriendo;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY id_Arriendo";

        if (pagina > 0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY id_Arriendo LIMIT " + paginacionMin + "," + paginacionMax;
        }
        
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                elArriendo = new Arriendo();
                elArriendo.setId_Arriendo(rs.getInt("id_Arriendo"));
                elArriendo.setFecha_Arriendo(rs.getDate("Fecha_Arriendo").toLocalDate());
                elArriendo.setId_Cedula_Cliente_Arriendo(rs.getInt("id_Cedula_Cliente_Arriendo"));
                elArriendo.setId_inmobiliario_Arriendo(rs.getInt("id_inmobiliario_Arriendo"));
                elArriendo.setId_Tipo_Arriendo(rs.getInt("id_Tipo_Arriendo"));
                listaArriendos.add(elArriendo);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar arriendo:" + ex.getLocalizedMessage());
        }
        conexion.desconectar();
        return listaArriendos;
    }

    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("INSERT INTO arriendo(id_Arriendo, Fecha_Arriendo, id_Cedula_Cliente_Arriendo, id_inmobiliario_Arriendo, id_Tipo_Arriendo)" + " VALUES (" + getId_Arriendo() + ",'" + getFecha_Arriendo() + "','" + getId_Cedula_Cliente_Arriendo() + "','" + getId_inmobiliario_Arriendo() + "','" + getId_Tipo_Arriendo() + "')");

        } catch (SQLException ex) {
            System.err.println("Error al insertar arriendo:" + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE arriendo SET Fecha_Arriendo='" + getFecha_Arriendo() + "', id_Cedula_Cliente_Arriendo='" + getId_Cedula_Cliente_Arriendo() + "', id_inmobiliario_Arriendo='" + getId_inmobiliario_Arriendo() + "', id_Tipo_Arriendo='" + getId_Tipo_Arriendo() + "' WHERE id_Arriendo=" + getId_Arriendo());
        } catch (SQLException ex) {
            System.err.println("Error al modificar arriendo:" + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public void eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM arriendo WHERE id_Arriendo=" + getId_Arriendo());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar arriendo:" + ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }

    public int cantidadPaginas() throws SQLException {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(id_Arriendo)/" + this.paginacion + ") AS cantidad FROM " + this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas arriendo" + ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }

   

}
