/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Abonos;

/**
 *
 * @author melissa
 */
@WebServlet(name = "ControladorAbonos", urlPatterns = {"/ControladorAbonos"})
public class ControladorAbonos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("fidabonos");
        String Valorabono = request.getParameter("fvalorabono");
        String fecha = request.getParameter("ffechaabono");
        String idd = request.getParameter("fiddeudasabonos");
        String accion = request.getParameter("fAccion");
        int idabonos = 0;
        try {
            idabonos = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
        }

        LocalDate fechaabono = LocalDate.now();
        try {
            fechaabono = LocalDate.parse(fecha);
        } catch (DateTimeParseException dtpe) {
        }

        int valorabono = Integer.parseInt(Valorabono);
               

        try {
            valorabono = Integer.parseInt(Valorabono);
        } catch (NumberFormatException nfe) {
        }

        int iddeudasabonos = 0;
        try {
            iddeudasabonos = Integer.parseInt(idd);
        } catch (NumberFormatException nfe) {
        }

        Abonos unAbono = new Abonos();
        unAbono.setIdabonos(idabonos);
        unAbono.setValorabono(valorabono);
        unAbono.setFechaabono(fechaabono);
        unAbono.setIddeudasabonos(iddeudasabonos);

        String mensaje = "";
        switch (accion.toLowerCase()) {
            case "insertar":
                
                unAbono.insertar();
                mensaje = "Inserto Abono";
                break;

            case "modificar":
                unAbono.modificar();
                mensaje = "Modifico Abono";
                break;

            case "eliminar":
                unAbono.eliminar();
                mensaje = "Elimino Abono";
                break;
        }
        request.getRequestDispatcher("/WEB-INF/formularioAbonos.jsp?msj=" + mensaje).forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
