/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author melissa
 */
public class Conexion {
   
 Connection conexion = null;

    public Statement conectar(){
        Statement st = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/BDinmobiliaria_jn1");
            conexion = ds.getConnection("brayan","1234"); //usuario y clave
            st = conexion.createStatement();
        } catch (NamingException ex) {
            System.err.println("Error al iniciar contexto:" + ex.getLocalizedMessage());
        } catch (SQLException ex) {
            System.err.println("Error al conectarse a la BD:" + ex.getLocalizedMessage());
        }
        return st;
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Error al conectar a la BD:" + ex.getLocalizedMessage());
    }
}
    
}
