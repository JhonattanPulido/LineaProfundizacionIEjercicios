// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.exception.filters;

// Librerías
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NoContentException;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de NoContentException
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 01/04/2021
 * @version 1.0.0
 */
@Provider
public class NoContentExceptionFilter implements ExceptionMapper<NoContentException> {

    @Override
    public Response toResponse(NoContentException exception) {               
        
        return Response.status(Response.Status.NO_CONTENT)                        
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }
}
