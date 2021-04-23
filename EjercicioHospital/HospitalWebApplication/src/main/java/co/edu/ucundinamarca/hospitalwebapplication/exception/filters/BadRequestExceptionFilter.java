// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.exception.filters;

// Librerías
import co.edu.ucundinamarca.hospitalwebapplication.pojos.ErrorDto;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.BadRequestException;

/**
 * Filtro de BadRequest
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
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
