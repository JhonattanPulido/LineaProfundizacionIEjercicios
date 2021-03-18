// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;
import com.edu.ucundinamarca.webapiestudiante.exceptions.IntegridadException;
import javax.ws.rs.core.MediaType;

/**
 * Filtro de la excepción de integridad
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
@Provider
public class IntegridadExceptionFilter implements ExceptionMapper<IntegridadException> {

    /**
     * Responder 409 - CONFLICT
     * @param exception
     * @return Respuesta asociada a error 409
     */
    @Override
    public Response toResponse(IntegridadException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.CONFLICT)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }        
}
