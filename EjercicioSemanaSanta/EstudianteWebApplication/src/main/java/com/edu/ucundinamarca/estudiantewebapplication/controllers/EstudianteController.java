// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.controllers;

// Librerías
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.edu.ucundinamarca.estudianteejbmodule.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejbmodule.service.interfaz.IEstudianteService;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

/**
 * Controlador de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
@Stateless
@Path("/estudiantes")
public class EstudianteController {
    
    // Variables
    
    /**
     * Capa de servicios de estudiante
     */
    @EJB
    private IEstudianteService estudianteService;
    
    // Métodos
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response creer(@Valid Estudiante estudiante) throws  IntegridadException,
                                                                Exception {
        
        estudianteService.crear(estudiante);
        
        return Response.status(Response.Status.CREATED)
                        .build();
    }
    
    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response leer(@PathParam("id") short id) throws  NotFoundException,
                                                            Exception {
        
        return Response.status(Response.Status.OK)
                        .entity(estudianteService.leer(id))
                        .build();
    }
}
