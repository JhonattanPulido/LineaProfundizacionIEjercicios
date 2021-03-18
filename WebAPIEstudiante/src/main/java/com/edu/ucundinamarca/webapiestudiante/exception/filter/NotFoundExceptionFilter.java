// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ext.ExceptionMapper;
import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;
import javax.ws.rs.core.MediaType;

/**
 * Filtro para la excepción not found
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
@Provider
public class NotFoundExceptionFilter implements ExceptionMapper<NotFoundException> {

    /**
     * Responder 404 - NOT FOUND
     * @param exception
     * @return Respuesta asociada a error 404
     */
    @Override
    public Response toResponse(NotFoundException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.NOT_FOUND)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }
}
