// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.exception.filter;

// Librerías
import com.edu.ucundinamarca.estudianteejb.exception.IntegridadException;
import com.edu.ucundinamarca.estudiantewebapplication.pojo.ErrorDto;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Filtro de Exception
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 28/03/2021
 * @version 1.0.0
 */
@Provider
public class ExceptionFilter implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        
        ErrorDto error = new ErrorDto(e.getMessage(), e.getStackTrace()[0].toString());        
        
        /*if (e instanceof NotFoundException)
            error.setResponseCode(Response.Status.NOT_FOUND);            
        else if (e instanceof IntegridadException)
            error.setResponseCode(Response.Status.CONFLICT);            
        else if(e instanceof NoContentException)
            error.setResponseCode(Response.Status.NO_CONTENT);
        else {
            error.setResponseCode(Response.Status.INTERNAL_SERVER_ERROR);
            error.setMensaje("Ha ocurrido un error en el servidor");
        }*/
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON)
                        .build();
    }    
}
