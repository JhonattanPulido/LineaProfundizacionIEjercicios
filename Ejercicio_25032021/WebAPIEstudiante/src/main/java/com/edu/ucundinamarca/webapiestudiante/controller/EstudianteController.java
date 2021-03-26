// Paquetes
package com.edu.ucundinamarca.webapiestudiante.controller;

// Librerías
import javax.ejb.EJB;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejb.interfaz.IEstudiante;

/**
 * Controlador de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 26/03/2021
 * @version 1.0.0
 */
@Stateless
@Path("/estudiantes")
public class EstudianteController {
    
    // Variables
    @EJB
    private IEstudiante service;
    
    // Métodos
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response crear(@Valid Estudiante estudiante) throws Exception {
        service.crear(estudiante);
        return Response.status(Response.Status.CREATED)
                        .build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response leer() {
        
        List<Estudiante> listaEstudiantes = service.leer();
        
        return Response.status(Response.Status.OK)
                        .entity(listaEstudiantes)
                        .build();
    }
}
