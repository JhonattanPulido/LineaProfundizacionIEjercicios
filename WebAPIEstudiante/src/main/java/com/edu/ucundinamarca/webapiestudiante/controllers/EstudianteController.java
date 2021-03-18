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
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
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
     * @throws BadRequestException - (400 - BAD REQUEST) - Ocurre cuando la información no ha sido enviada correctamente
     * @throws IntegridadException - (409 - CONFLICT) -  Ocurre cuando al registrar un nuevo estudiante, se encuentra que el número de documento ya existe
     * @throws SQLException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando se encuentra un error al procesar alguna función en la base de datos
     * @throws ClassNotFoundException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando no se encuentra el driver de PostgreSQL     
     */
    @POST
    @Path("/crear")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearEstudiante(@Valid Estudiante estudiante) throws    BadRequestException,
                                                                            IntegridadException,
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
     * @return (200 - OK) - Lista de estudiantes
     * @throws NoContentException (204 - NO CONTENT) - Ocurre cuando no hay estudiantes en la base de datos
     * @throws SQLException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando se encuentra un error al procesar alguna función en la base de datos
     * @throws ClassNotFoundException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando no se encuentra el driver de PostgreSQL     
     */
    @GET
    @Path("/leer")
    @Produces(MediaType.APPLICATION_JSON)    
    @Consumes(MediaType.APPLICATION_JSON)
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
     * @return (200 - OK) - Objeto con los datos del estudiante
     * @throws NotFoundException - (404 - NOT FOUND) - Ocurre cuando no se encuentra el usuario asociado al ID
     * @throws SQLException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando se encuentra un error al procesar alguna función en la base de datos
     * @throws ClassNotFoundException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando no se encuentra el driver de PostgreSQL     
     */
    @GET
    @Path("/leer/{ id }")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response leerEstudiante(@PathParam("id") short id) throws    NotFoundException,
                                                                        SQLException,
                                                                        ClassNotFoundException, 
                                                                        Exception  {
        
        Estudiante estudiante = new DEstudiante().leerEstudiante(id);

        return Response.status(Response.Status.OK)
                        .entity(estudiante)
                        .build();            

    }           
    
    /**
     * Método para actualizar los datos de un estudiante
     * @param estudiante
     * @return (200 - OK) - Estudiante actualizado correctamente
     * @throws BadRequestException - (400 - BAD REQUEST) - Ocurre cuando la información no ha sido enviada correctamente
     * @throws NotFoundException - (404 - NOT FOUND) - Ocurre cuando no se encuentra el usuario asociado al ID
     * @throws IntegridadException - (409 - CONFLICT) - Ocurre cuando al registrar un nuevo estudiante, se encuentra que el número de documento ya existe
     * @throws SQLException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando se encuentra un error al procesar alguna función el la base de datos
     * @throws ClassNotFoundException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando no se encuentra el driver de PostgreSQL          
     */
    @PUT
    @Path("/actualizar")   
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarEstudiante(@Valid Estudiante estudiante) throws   BadRequestException,
                                                                                NotFoundException,
                                                                                IntegridadException,
                                                                                SQLException,
                                                                                ClassNotFoundException, 
                                                                                Exception {
        
        new DEstudiante().actualizarEstudiante(estudiante);
                        
        return Response.status(Response.Status.OK)
                        .entity("Estudiante actualizado correctamente")
                        .build();
                                  
    }
    
    /**
     * Método para eliminar un estudiante filtrado por id
     * @param id - Identificación del estudiante
     * @return (200 - OK) - Estudiante eliminado correctamente
     * @throws NotFoundException - (404 - NOT FOUND) - Ocurre cuando no se encuentra el usuario asociado al ID     
     * @throws SQLException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando se encuentra un error al procesar alguna función el la base de datos
     * @throws ClassNotFoundException - (500 - INTERNAL SERVER ERROR) - Ocurre cuando no se encuentra el driver de PostgreSQL          
     */
    @DELETE
    @Path("/eliminar/{ id }")   
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminarEstudiante(@PathParam("id") short id) throws    NotFoundException,
                                                                            SQLException,
                                                                            ClassNotFoundException,
                                                                            Exception {        
        
        new DEstudiante().eliminarEstudiante(id);
        return Response.status(Response.Status.OK)
                    .entity("Estudiante eliminado correctamente")
                    .build();            
    }
}
