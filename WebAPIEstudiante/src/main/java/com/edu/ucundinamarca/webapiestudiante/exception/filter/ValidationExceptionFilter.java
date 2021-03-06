// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;

// Librerías

import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de la excepción validation
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
@Provider
public class ValidationExceptionFilter implements ExceptionMapper<ValidationException> {

    /**
     * Responder 400 - BAD REQUEST
     * @param exception
     * @return Respuesta asociada a error 400
     */
    @Override
    public Response toResponse(ValidationException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(error)
                        .build();
    }       
}
