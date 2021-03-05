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
import javax.ws.rs.core.Response;

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
    public Response crearEstudiante(Estudiante estudiante){
        try {
            return new DEstudiante().crearEstudiante(estudiante) ? Response.status(Response.Status.ACCEPTED)
                    .entity(estudiante)
                    .build() : Response.status(Response.Status.CONFLICT)
                                        .entity(estudiante)
                                        .build();            
        } catch (Exception ex) {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                           .entity("Fallo en el servidor")
                           .build();
        } 
    }
    
    /**
     * Método para obtener todos los estudiantes registrados
     * @return lista de estudiantes
     */
    @GET
    @Path("/leer")
    public  ArrayList<Estudiante> leerEstudiantes() throws Exception {
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
    public Response leerEstudiante(@PathParam("id") short id) {
        try {
            new DEstudiante().leerEstudiante(id);
            return Response.status(Response.Status.OK)
                       .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .build();
        }  
    }           
    
    /**
     * Método para actualizar los datos de un estudiante
     * @param estudiante
     * @return 
     */
    @PUT
    @Path("/actualizar") 
    public Response actualizarEstudiante(Estudiante estudiante){
        try {
            switch (new DEstudiante().actualizarEstudiante(estudiante)) {
                
                // Estudiante se actualizó correctamente
                case 0:
                     return Response.status(Response.Status.OK)
                          .build();                   
                   
                // No se encontró al estudiante    
                case 1:
                    return Response.status(Response.Status.CONFLICT)
                          .entity("No se encontro el estudiante")
                          .build(); 
                
                // El número de documento ya está en uso
                case 2:
                    return Response.status(Response.Status.CONFLICT)
                          .entity("El numero de documento ya esta en uso")
                          .build();                                 
            }
            
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                          .build();                     
            
        } catch (Exception ex) {
             return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                          .build();                     
        }           
    }
    
    /**
     * Método para eliminar un estudiante filtrado por id
     * @param id - Identificación del estudiante
     * @return 
     */
    @DELETE
    @Path("/eliminar/{ id }") 
    public Response eliminarEstudiante(@PathParam("id") short id) {
        try {
            return new DEstudiante().eliminarEstudiante(id) ? Response.status(Response.Status.OK)
                    .build() : Response.status(Response.Status.CONFLICT)
                            .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                    .build();
        }
    }
}
