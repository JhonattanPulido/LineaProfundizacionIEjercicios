// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.exception.filters;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.BadRequestException;
import com.edu.ucundinamarca.estudiantewebapplication.pojos.ErrorDto;

/**
 * Filtro de BadRequest
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 03/04/2021
 * @version 1.0.0
 */
@Provider
public class BadRequestExceptionFilter implements ExceptionMapper<BadRequestException> {

    /**
     * Se ejecuta cuando una consulta no se envia correctamente
     * @param exception
     * @return 400 - BAD REQUEST
     */
    @Override
    public Response toResponse(BadRequestException exception) {
        
        ErrorDto error = new ErrorDto("La información no se ha enviado correctamente", exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }        
}
