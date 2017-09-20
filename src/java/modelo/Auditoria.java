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
public class Auditoria {

    private int idauditoria;
    private LocalDate fechaauditoria;
    private String descripcionauditoria;
    private int idusuariosauditorias;
    private int paginacion;

    public Auditoria() {
    }

    public int getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(int idauditoria) {
        this.idauditoria = idauditoria;
    }

    public LocalDate getFechaauditoria() {
        return fechaauditoria;
    }

    public void setFechaauditoria(LocalDate fechaauditoria) {
        this.fechaauditoria = fechaauditoria;
    }

    public String getDescripcionauditoria() {
        return descripcionauditoria;
    }

    public void setDescripcionauditoria(String descripcionauditoria) {
        this.descripcionauditoria = descripcionauditoria;
    }

    public int getIdusuariosauditorias() {
        return idusuariosauditorias;
    }

    public void setIdusuariosauditorias(int idusuariosauditorias) {
        this.idusuariosauditorias = idusuariosauditorias;
    }

    public ArrayList listar(int pagina) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaAuditoria = new ArrayList();
        Auditoria unaAuditoria;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idauditoria";

        if (pagina > 0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idauditoria LIMIT " + paginacionMin + "," + paginacionMax;
        }
                try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                unaAuditoria = new Auditoria();
                unaAuditoria.setIdauditoria(rs.getInt("idauditoria"));
                unaAuditoria.setFechaauditoria(rs.getDate("fechaauditoria").toLocalDate());
                unaAuditoria.setDescripcionauditoria(rs.getString("descripcionauditoria"));
                unaAuditoria.setIdusuariosauditorias(rs.getInt("idusuariosauditorias"));
                listaAuditoria.add(unaAuditoria);
            }
        } catch (SQLException ex) {
            System.err.print("Error al listar auditoria:" + ex.getLocalizedMessage());
        }
        conexion.desconectar();
        return listaAuditoria;

    }
    
    
     public int cantidadPaginas(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idauditoria)/"+this.paginacion+") AS cantidad FROM "+this.getClass().getSimpleName());
        if (rs.next()){
                cantidadDeBloques = rs.getInt("cantidad");
        }
        } catch (SQLException ex) {
            System.err.println("Error al obtener la cantidad de paginas auditoria"+ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
}
