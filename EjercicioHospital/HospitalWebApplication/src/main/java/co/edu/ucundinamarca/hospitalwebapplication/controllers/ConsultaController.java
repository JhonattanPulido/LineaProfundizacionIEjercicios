//Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.controllers;

//Librerias
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IConsultaService;
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
 * Controlador de consulta
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Stateless
@Path("/consulta")
public class ConsultaController implements Serializable{
    
    @EJB
    private IConsultaService consultaService;
    
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response leer() throws NoContentException{
            return Response.status(Response.Status.OK)
                        .entity(consultaService.leer())
                        .build();
    }       
    
    
    @Path("{idConsulta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response leer(@PathParam("consultaId") Short consultaId) throws NotFoundException{
            Consulta consulta = consultaService.leer(consultaId);
            return Response.status(Response.Status.OK)
                        .entity(consulta)
                        .build();
    }       
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(@Valid Consulta consulta) {
            consultaService.crear(consulta);
            return Response.status(Response.Status.CREATED)
                        .build();
    }
        
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@Valid Consulta consulta) throws NotFoundException {
            consultaService.actualizar(consulta);
            return Response.status(Response.Status.NO_CONTENT)
                        .build();
    } 
    
    @Path("{idConsulta}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("consultaId") short consultaId) throws NotFoundException {
            consultaService.eliminar(consultaId);
            return Response.status(Response.Status.NO_CONTENT)
                        .build();
    }    
}
