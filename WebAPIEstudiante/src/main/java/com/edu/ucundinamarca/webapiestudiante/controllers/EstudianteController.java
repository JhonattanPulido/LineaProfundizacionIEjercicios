// Paquetes
package com.edu.ucundinamarca.webapiestudiante.controllers;
import com.edu.ucundinamarca.webapiestudiante.data.DEstudiante;
import com.edu.ucundinamarca.webapiestudiante.exceptions.IntegridadException;
import com.edu.ucundinamarca.webapiestudiante.pojos.Estudiante;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;

// Importaciones
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
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
    
    /*
        BAD REQUEST
    */
    
    /**
     * Método para crear un estudiante 
     * @param estudiante - Objeto con los datos del estudiante   
     * @return (201 - CREATED) - Si el estudiante es almacenado correctamente     
     * @throws IntegridadException - (409 - CONFLICT) -  Ocurre cuando al registrar un nuevo estudiante, se encuentra que el número de documento ya existe
     * @throws SQLException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando se encuentra un error al procesar alguna función en la base de datos
     * @throws ClassNotFoundException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando no se encuentra el driver de PostgreSQL     
     */
    @POST
    @Path("/crear")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearEstudiante(@Valid Estudiante estudiante) throws    IntegridadException,
                                                                            SQLException,
                                                                            ClassNotFoundException,
                                                                            Exception {
        
        new DEstudiante().crearEstudiante(estudiante);              
        return Response.status(Response.Status.CREATED)
                        .entity("Estudiante creado correctamente")
                        .build();
                    
    }
    
    /**
     * Método para obtener todos los estudiantes registrados
     * @return (200 - OK) lista de estudiantes
     * @throws NoContentException (204 - NO CONTENT) - Ocurre cuando no hay estudiantes en la base de datos
     * @throws SQLException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando se encuentra un error al procesar alguna función en la base de datos
     * @throws ClassNotFoundException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando no se encuentra el driver de PostgreSQL     
     */
    @GET
    @Path("/leer")
    @Produces(MediaType.APPLICATION_JSON)    
    public Response leerEstudiantes() throws    NoContentException,
                                                SQLException,
                                                ClassNotFoundException, 
                                                Exception {
        
        Gson gson = new Gson();
        List<Estudiante> listaEstudiantes = new DEstudiante().leerEstudiantes();
        return Response.status(Response.Status.OK)
                        .entity(gson.toJson(listaEstudiantes))
                        .build();             
    }
    
    /**
     * Método para obtener un estudiante filtrado por id
     * @param id - Identificación del estudiante
     * @return estudiante
     */
    @GET
    @Path("/leer/{ id }")
    @Produces(MediaType.APPLICATION_JSON)
    public Response leerEstudiante(@PathParam("id") short id) {
        try {
            Estudiante estudiante = new DEstudiante().leerEstudiante(id);
            
            if (estudiante != null)
                return Response.status(Response.Status.OK)
                                .entity(estudiante)
                                .build();
            else
                return Response.status(Response.Status.NOT_FOUND)
                                .entity("No se encontró el estudiante")
                                .build();
                
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(ex)
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarEstudiante(@Valid Estudiante estudiante){
        try {
            switch (new DEstudiante().actualizarEstudiante(estudiante)) {
                
                // Estudiante se actualizó correctamente
                case 0:
                    return Response.status(Response.Status.OK)
                                    .entity("Estudiante actualizado correctamente")
                                    .build();
                   
                // No se encontró al estudiante    
                case 1:
                    return Response.status(Response.Status.NOT_FOUND)
                                    .entity("No se encontró el estudiante")
                                    .build();
                
                // El número de documento ya está en uso
                case 2:
                    return Response.status(Response.Status.BAD_REQUEST)
                                    .entity("El número de documento ya está en uso")
                                    .build();
            }
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)                            
                            .entity("Ha ocurrido un error inesperado")
                            .build();                    
            
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(ex)
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarEstudiante(@PathParam("id") short id){
        try {
            if (new DEstudiante().eliminarEstudiante(id)) 
                return Response.status(Response.Status.OK)
                            .entity("Estudiante eliminado correctamente")
                            .build();
            else
                return Response.status(Response.Status.BAD_REQUEST)
                            .entity("No se encontró el estudiante")
                            .build();                
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(ex)
                            .build();
        }  
    }
}
