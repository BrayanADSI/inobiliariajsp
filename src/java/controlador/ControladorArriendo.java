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
import modelo.Arriendo;

/**
 *
 * @author melissa
 */
@WebServlet(name = "ControladorArriendo", urlPatterns = {"/ControladorArriendo"})
public class ControladorArriendo extends HttpServlet {

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
            out.println("<title>Servlet ControladorArriendo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorArriendo at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("fid_Arriendo");
        String fecha = request.getParameter("fFecha_Arriendo");
        String cedula = request.getParameter("fid_Cedula_Cliente_Arriendo");
        String idd = request.getParameter("fid_inmobiliario_Arriendo");
        String tipo = request.getParameter("fid_Tipo_Arriendo");
        String accion = request.getParameter("fAccion");
        
        int id_Arriendo = 0;
        try {
         id_Arriendo = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
        }

        
        LocalDate Fecha_Arriendo = LocalDate.now();
        try {
            Fecha_Arriendo = LocalDate.parse(fecha);
        } catch (DateTimeParseException dtpe) {
        }

        
        int id_Cedula_Cliente_Arriendo = 0;
        try {
            id_Cedula_Cliente_Arriendo = Integer.parseInt(cedula);
        } catch (NumberFormatException nfe) {
        }

        
        int id_inmobiliario_Arriendo = 0;
        try {
            id_inmobiliario_Arriendo = Integer.parseInt(idd);
        } catch (NumberFormatException nfe) {
        }
        
        
        
        int id_Tipo_Arriendo= 0;
        try {
            id_Tipo_Arriendo = Integer.parseInt(tipo);
        } catch (NumberFormatException nfe) {
        }
        
        
        Arriendo elArriendo = new Arriendo();
        elArriendo.setId_Arriendo(id_Arriendo);
        elArriendo.setFecha_Arriendo(Fecha_Arriendo);
        elArriendo.setId_Cedula_Cliente_Arriendo(id_Cedula_Cliente_Arriendo);
        elArriendo.setId_inmobiliario_Arriendo(id_inmobiliario_Arriendo);
        elArriendo.setId_Tipo_Arriendo(id_Tipo_Arriendo);
        
        String mensaje = "";
        switch (accion.toLowerCase()) {
            
            case "insertar":
                elArriendo.insertar();
                mensaje = "Inserto Arriendo";
                break;

            case "modificar":
                elArriendo.modificar();
                mensaje = "Modifico Arriendo";
                break;

            case "eliminar":
                elArriendo.eliminar();
                mensaje = "Elimino Arriendo";
                break;
        }
        request.getRequestDispatcher("/WEB-INF/formularioArriendo.jsp?msj=" + mensaje).forward(request, response);

        
    
    
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
