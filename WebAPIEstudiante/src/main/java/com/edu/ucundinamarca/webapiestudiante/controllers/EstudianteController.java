// Paquetes
package com.edu.ucundinamarca.webapiestudiante.controllers;
import com.edu.ucundinamarca.webapiestudiante.data.DEstudiante;
import com.edu.ucundinamarca.webapiestudiante.pojos.Estudiante;
import java.util.ArrayList;

// Importaciones
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Controlador estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 03/03/2021
 */
@Stateless
@Path("/estudiante")
public class EstudianteController {
    
    /**
     * Método para crear un estudiante 
     * @param estudiante objeto con los datos del estudiante
     * @return true si el estudiante fué agregado correctametne
     */
    @POST
    @Path("/crear")
    public String crearEstudiante(Estudiante estudiante){
        try {
            return new DEstudiante().crearEstudiante(estudiante) ? "201 Created: Estudiante creado correctamente" : "409 Conflict: El número de documento ya está en uso.";            
        } catch (Exception ex) {
            return "500 Internal server error: Hubó un problema en el servidor";
        } 
    }
    
    /**
     * Método para obtener todos los estudiantes registrados
     * @return lista de estudiantes
     */
    @GET
    @Path("/leer")
    public ArrayList<Estudiante> leerEstudiantes() throws Exception {
        try {
            return new DEstudiante().leerEstudiantes();
        } catch (Exception ex) {
            return null;
        }        
    }
    
    /**
     * Método para obtener un estudiante filtrado por id
     * @param id - Identificación del estudiante
     * @return estudiante
     */
    @GET
    @Path("/leer/{ id }")
    public Estudiante leerEstudiante(@PathParam("id") short id) {
        try {
            return new DEstudiante().leerEstudiante(id);
        } catch (Exception ex) {
            return null;
        }  
    }           
    
    /**
     * Método para actualizar los datos de un estudiante
     * @param estudiante
     * @return 
     */
    @PUT
    @Path("/actualizar")    
    public String actualizarEstudiante(Estudiante estudiante){
        try {
            switch (new DEstudiante().actualizarEstudiante(estudiante)) {
                
                // Estudiante se actualizó correctamente
                case 0:
                    return "200 Ok: Estudiante actualizado correctamente";                    
                   
                // No se encontró al estudiante    
                case 1:
                    return "409 Confict: No se encontró el estudiante";
                
                // El número de documento ya está en uso
                case 2:
                    return "409 Confict: El número de documento ya está en uso";                                
            }
            
            return "500 Internal server error: Hubó un problema en el servidor";                    
            
        } catch (Exception ex) {
            return "500 Internal server error: Hubó un problema en el servidor";                    
        }           
    }
    
    /**
     * Método para eliminar un estudiante filtrado por id
     * @param id - Identificación del estudiante
     * @return 
     */
    @DELETE
    @Path("/eliminar/{ id }")    
    public String eliminarEstudiante(@PathParam("id") short id){
        try {
            return new DEstudiante().eliminarEstudiante(id) ? "200 Ok: Estudiante eliminado correctamente" : "409 Conflict: No se encontró el estudiante";
        } catch (Exception ex) {
            return "500 Internal server error: Hubó un problema en el servidor";
        }  
    }
}
