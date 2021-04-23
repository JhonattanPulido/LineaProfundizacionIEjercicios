// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.exception.filters;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import co.edu.ucundinamarca.hospitalwebapplication.pojos.ErrorDto;
import com.edu.ucundinamarca.hospitalejbmodule.exception.IntegridadException;

/**
 * Filtro de IntegridadException
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Provider
public class IntegridadExceptionFilter implements ExceptionMapper<IntegridadException> {

    @Override
    public Response toResponse(IntegridadException exception) {
        
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.CONFLICT)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }    
}
