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
import modelo.Auditoria;

/**
 *
 * @author melissa
 */
@WebServlet(name = "ControladorAuditoria", urlPatterns = {"/ControladorAuditoria"})
public class ControladorAuditoria extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAuditoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAuditoria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String id = request.getParameter("fiidauditoria");
        String fecha = request.getParameter("ffechaauditoria");
        String des = request.getParameter("fdescripcionauditoria");
        String idd = request.getParameter("fidusuariosauditorias");
        

        int idauditoria = 0;
        try {
            idauditoria = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
        }

        LocalDate fechaauditoria = LocalDate.now();
        try {
            fechaauditoria = LocalDate.parse(fecha);
        } catch (DateTimeParseException dtpe) {
        }

        int idusuariosauditorias = 0;
        try {
            idusuariosauditorias = Integer.parseInt(idd);
        } catch (NumberFormatException nfe) {
        }
        
        

        Auditoria unaAuditoria = new Auditoria();
        unaAuditoria.setIdauditoria(idauditoria);
        unaAuditoria.setFechaauditoria(fechaauditoria);
        unaAuditoria.setDescripcionauditoria (des);
        unaAuditoria.setIdusuariosauditorias(idusuariosauditorias);
        
        

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
