// Paquetes
package com.mycompany.ejercicioformularios.controller;
        
// Librerías
import com.mycompany.ejercicioformularios.logic.IniciarSesionService;
import com.mycompany.ejercicioformularios.models.Vehiculo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador de vehículo
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 10/11/2020
 * @version 1.0.0
 */
@WebServlet(name = "VehiculosController", urlPatterns = {"/VehiculosController"})
public class VehiculosController extends HttpServlet {

    // Variables
    
    /**
     * Objeto con los datos del vehículo
     */
    private Vehiculo vehiculo;   
    
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
                
        vehiculo = new Vehiculo();
        vehiculo.setPlaca(request.getParameter("IPlaca"));
        vehiculo.setClave(request.getParameter("IClave"));
        
        vehiculo = new IniciarSesionService().IniciarSesionVehiculo(vehiculo);
        
        if (vehiculo != null) {
            request.getSession().setAttribute("vehiculo", vehiculo);
            request.getRequestDispatcher("vehiculo.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("vehiculo-error.jsp").forward(request, response);
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
        processRequest(request, response);
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
