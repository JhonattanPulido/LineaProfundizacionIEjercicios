// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.controller;

// Librerías
import javax.ejb.EJB;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejb.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejb.service.interfaz.IEstudianteService;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.NoContentException;

/**
 * Controlador de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 28/03/2021
 * @version 1.0.0
 */
@Stateless
@Path("/estudiantes")
public class EstudianteController {
    
    @EJB
    private IEstudianteService estudianteService;
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response crear(@Valid Estudiante estudiante) throws  IntegridadException,
                                                                Exception {
        
        estudianteService.crear(estudiante);
        return Response.status(Response.Status.CREATED)
                        .build();
    }
    
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response leer(@PathParam("id") short id) throws  NotFoundException,                                                            
                                                            Exception {
        
        return Response.status(Response.Status.OK)
                        .entity(estudianteService.leer(id))
                        .build();
    }        
    
    @GET    
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response leer() throws   NoContentException,
                                    Exception {
        
        List<Estudiante> listaEstudiantes = estudianteService.leer();        
        return Response.status(Response.Status.OK)
                        .entity(listaEstudiantes)
                        .build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response actualizar(@Valid Estudiante estudiante) throws NotFoundException,
                                                                    IntegridadException,
                                                                    Exception {
        
        estudianteService.actualizar(estudiante);
        return Response.status(Response.Status.OK)                        
                        .build();
    }
    
    @DELETE    
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response eliminar(@PathParam("id") short id) throws  NotFoundException,
                                                                Exception {
        
        return Response.status(Response.Status.NO_CONTENT)                        
                        .build();
    }
}
