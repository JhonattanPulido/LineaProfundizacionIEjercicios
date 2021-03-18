// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;

// Librerías
import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de la excepción no content
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
@Provider
public class NoContentExceptionFilter implements ExceptionMapper<NoContentException> {

    /**
     * Responder 204 - NO CONTENT
     * @param exception
     * @return Respuesta asociada a la respuesta 204
     */
    @Override
    public Response toResponse(NoContentException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.NO_CONTENT)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }
    
    
}
