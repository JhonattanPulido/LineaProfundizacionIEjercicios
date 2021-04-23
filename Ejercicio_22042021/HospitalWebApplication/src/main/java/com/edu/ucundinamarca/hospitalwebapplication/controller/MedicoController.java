// Paquetes
package com.edu.ucundinamarca.hospitalwebapplication.controller;

// Librerías
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IMedicoService;

/**
 * Controlador de médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Stateless
@Path("/medicos")
public class MedicoController {
    
    // Variables
    
    /**
     * 
     */
    @EJB
    private IMedicoService medicoService;
    
    // Métodos
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)   
    @Produces(MediaType.APPLICATION_JSON)   
    public Response crear(Medico medico) {
        medicoService.crear(medico);
        return Response.status(Response.Status.CREATED)                        
                        .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)   
    public Response leer(@PathParam("id") Short id) throws  NotFoundException {
        return Response.status(Response.Status.OK)
                        .entity(medicoService.leer(id))
                        .build();
    }
    
    /**
     * Leer todos los médicos almacenados
     * @return Lista de médicos
     * @throws NoContentException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public Response leer() throws   NoContentException {
        return Response.status(Response.Status.OK)
                        .entity(medicoService.leer())
                        .build();                
    }
}
