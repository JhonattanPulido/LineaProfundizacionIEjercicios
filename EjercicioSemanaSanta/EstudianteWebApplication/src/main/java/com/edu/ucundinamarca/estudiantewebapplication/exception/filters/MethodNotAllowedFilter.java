// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.exception.filters;

// Librerías
import com.edu.ucundinamarca.estudiantewebapplication.pojos.ErrorDto;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de MethodNotAllowed
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 01/04/2021
 * @version 1.0.0
 */
@Provider
public class MethodNotAllowedFilter implements ExceptionMapper<NotAllowedException> {

    /**
     * Se ejecuta cuando se reconoce el método pero la información no esta correctamente enviada
     * @param exception
     * @return 405 - METHOD NOT ALLOWED
     */
    @Override
    public Response toResponse(NotAllowedException exception) {
        
        ErrorDto error = new ErrorDto("Método no permitido", exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.METHOD_NOT_ALLOWED)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }    
}
