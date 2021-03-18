// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;
import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;
import javax.ws.rs.core.MediaType;

// Librerías
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * Clase filtro de excepción
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
@Provider
public class ExceptionFilter implements ExceptionMapper<Exception> {

    /**
     * Responder 500 - INTERNAL SERVER ERROR
     * @param exception
     * @return Respuesta asociada a error 500
     */
    @Override
    public Response toResponse(Exception exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }       
}
