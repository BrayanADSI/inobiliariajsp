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
public class Abonos {

    private int idabonos;
    private int valorabono;
    private LocalDate fechaabono;
    private int iddeudasabonos;
    private int paginacion;

    public Abonos() {
    }

    public int getIdabonos() {
        return idabonos;
    }

    public void setIdabonos(int idabonos) {
        this.idabonos = idabonos;
    }

    public int getValorabono() {
        return valorabono;
    }

    public void setValorabono(int valorabono) {
        this.valorabono = valorabono;
    }

    public LocalDate getFechaabono() {
        return fechaabono;
    }

    public void setFechaabono(LocalDate fechaabono) {
        this.fechaabono = fechaabono;
    }

    public int getIddeudasabonos() {
        return iddeudasabonos;
    }

    public void setIddeudasabonos(int iddeudasabonos) {
        this.iddeudasabonos = iddeudasabonos;
    }

    public ArrayList listar(int pagina) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaAbonos = new ArrayList();
        Abonos unAbono;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idabonos";

        if (pagina > 0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idabonos LIMIT " + paginacionMin + "," + paginacionMax;
        }

        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                unAbono = new Abonos();
                unAbono.setIdabonos(rs.getInt("idabonos"));
                unAbono.setValorabono(rs.getInt("valorabono"));
                unAbono.setFechaabono(rs.getDate("fechaabono").toLocalDate());
                unAbono.setIddeudasabonos(rs.getInt("iddeudasabonos"));
                listaAbonos.add(unAbono);
            }
        } catch (SQLException ex) {
            System.err.print("Error al listar abonos:" + ex.getLocalizedMessage());
        }
        conexion.desconectar();
        return listaAbonos;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("INSERT INTO abonos (idabonos, valorabono, fechaabono, iddeudasabonos)"+ " VALUES(NULL,'"+getValorabono()+"','"+getFechaabono()+"','"+getIddeudasabonos()+"')");
        } catch (SQLException ex) {
          
            System.err.println("Error al insertar abonos:"+ex.getLocalizedMessage());
        }
         System.out.println("fvalorabono"+getValorabono());
        conexion.desconectar();
    }
    
    
    public void modificar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE abonos SET valorabono='"+getValorabono()+"', fechaabono='"+getFechaabono()+"', iddeudasabonos='"+getIddeudasabonos()+"' WHERE idabonos="+getIdabonos());
        } catch (SQLException ex) {
            System.err.println("Error al modificar abonos:"+ex.getLocalizedMessage());  
        }
        conexion.desconectar();
    }
    
    
    public void eliminar(){
       Conexion conexion = new Conexion();
       Statement st = conexion.conectar(); 
        try {
            st.executeUpdate("DELETE FROM Abonos WHERE idabonos="+getIdabonos());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar abonos:"+ex.getLocalizedMessage());  
        }
        conexion.desconectar();
    }
    
    
    public int cantidadPaginas() throws SQLException{
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idabonos)/"+this.paginacion+") AS cantidad FROM "+this.getClass().getSimpleName());
        if (rs.next()){
                cantidadDeBloques = rs.getInt("cantidad");
        }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas abonos"+ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }

}
