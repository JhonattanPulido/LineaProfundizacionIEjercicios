// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;

// Liberías
import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;
import javax.el.MethodNotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Filtro para la excepción method not allowerd
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
public class MethodNotAllowedFilter implements ExceptionMapper<MethodNotFoundException> {

    /**
     * Responder 405 - METHOD NOT ALLOWED
     * @param exception
     * @return Respuesta asociada al error 405
     */
    @Override
    public Response toResponse(MethodNotFoundException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.METHOD_NOT_ALLOWED)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }             
}
