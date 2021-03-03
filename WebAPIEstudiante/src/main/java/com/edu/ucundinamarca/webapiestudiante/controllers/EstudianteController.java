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
        return new Estudiante((short) 1, "Jhonattan", "Pulido", "1000689384");
    }
    
    
    @POST
    @Path("/crear")
    public boolean crearEstudiante(Estudiante estudiante){
        try {
            new DEstudiante().crearEstudiante(estudiante);
            return true;
        } catch (Exception ex) {
            return false;
        } 
    }
    
    @Path("/editar")
    @PUT
    public short editar(Estudiante estudiante){
        try {
            new DEstudiante().actualizarEstudiante(estudiante);
        } catch (Exception ex) {
            return 0;
        }   
        return 0;
    }
    
    /**
     * Método para eliminar un estudiante filtrado por id
     * @param id - Identificación del estudiante
     */
    @Path("/eliminar")
    @DELETE
    public void eliminar(@PathParam("id") int id){
        try {
            new DEstudiante().eliminarEstudiante((short) 1);
        } catch (Exception ex) {
            
        }  
    }
}
