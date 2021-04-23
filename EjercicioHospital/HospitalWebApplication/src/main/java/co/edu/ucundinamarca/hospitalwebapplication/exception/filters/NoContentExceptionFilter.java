// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.exception.filters;

// Librerías
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de NoContentException
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
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
