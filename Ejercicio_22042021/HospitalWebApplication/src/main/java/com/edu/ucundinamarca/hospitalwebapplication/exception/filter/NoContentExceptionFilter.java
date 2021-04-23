// Paquetes
package com.edu.ucundinamarca.hospitalwebapplication.exception.filter;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.hospitalwebapplication.pojo.ErrorDto;

/**
 * Filtro de NoContentException
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
 */
@Provider
public class NoContentExceptionFilter implements ExceptionMapper<NoContentException> {

    /**
     * Se ejecuta cuando no hay contenido
     * @param exception
     * @return 204 - NO CONTENT
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
