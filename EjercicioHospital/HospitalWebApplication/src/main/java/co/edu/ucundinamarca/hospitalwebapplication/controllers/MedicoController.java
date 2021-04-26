//Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.controllers;

//Librerias
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IMedicoService;
import java.io.Serializable;
import javax.ejb.EJB;
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
 * Controlador de Medico
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Stateless
@Path("/medico")
public class MedicoController implements Serializable {
    
    @EJB
    private IMedicoService medicoService;
    
          
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response leer() throws NoContentException{
            return Response.status(Response.Status.OK)
                        .entity(medicoService.leer())
                        .build();
    }       
    
    
    @Path("leer/{idMedico}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response leer(@PathParam("idMedico") Short medicoId) throws NotFoundException{
            Medico medico = medicoService.leer(medicoId);
            return Response.status(Response.Status.OK)
                        .entity(medico)
                        .build();
    }       
    
    @Path("/crear")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Medico medico) {
            medicoService.crear(medico);
            return Response.status(Response.Status.CREATED)
                        .build();
    }
        
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@Valid Medico medico) throws NotFoundException {
            medicoService.actualizar(medico);
            return Response.status(Response.Status.NO_CONTENT)
                        .build();
    } 
    
    @Path("eliminar/{medicoId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("medicoId") short medicoId) throws NotFoundException {
            medicoService.eliminar(medicoId);
            return Response.status(Response.Status.NO_CONTENT)
                        .build();
    }    
}
