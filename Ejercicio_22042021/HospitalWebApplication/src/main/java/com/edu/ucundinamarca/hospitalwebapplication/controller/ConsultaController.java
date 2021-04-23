// Paquetes
package com.edu.ucundinamarca.hospitalwebapplication.controller;

// Librerías
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IConsultaService;
import java.time.LocalDateTime;

/**
 * Controlador de consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
 */
@Stateless
@Path("/consultas")
public class ConsultaController {
    
    // Variables
    
    /**
     * 
     */
    @EJB
    private IConsultaService consultaService;
    
    // Métodos
    
    /**
     * Crear consulta
     * @param consulta - Objeto con los datos de consulta
     * @return 201 CREATED
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)   
    @Produces(MediaType.APPLICATION_JSON)   
    public Response crear(@Valid Consulta consulta) {
        
        consultaService.crear(consulta);
        
        return Response.status(Response.Status.CREATED)
                        .build();
    }
    
    /**
     * Leer una consulta filtrada por ID
     * @param id - ID de la consulta
     * @return Objeto con los datos de la consulta
     * @throws NotFoundException
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)   
    public Response leer(@PathParam("id") Short id) throws  NotFoundException {
        System.out.println("LA HORA ES: " + LocalDateTime.now());
        return Response.status(Response.Status.OK)
                        .entity(consultaService.leer(id))
                        .build();
    }
        
    /**
     * Leer todos las consultas almacenadas
     * @return Lista de consultas almacenadas
     * @throws NoContentException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public Response leer() throws   NoContentException {
        return Response.status(Response.Status.OK)
                        .entity(consultaService.leer())
                        .build();
    }
}
