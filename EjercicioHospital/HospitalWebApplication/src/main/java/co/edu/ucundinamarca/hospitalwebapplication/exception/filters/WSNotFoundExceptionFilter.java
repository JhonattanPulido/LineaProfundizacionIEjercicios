// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.exception.filters;

// Librerías
import co.edu.ucundinamarca.hospitalwebapplication.pojos.ErrorDto;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Filtro de NotFoundException
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Provider
public class WSNotFoundExceptionFilter implements ExceptionMapper<NotFoundException> {

    /**
     * Se ejecuta cuando solicitan un método que no existe
     * @param exception
     * @return 404 - NOT FOUND
     */
    @Override
    public Response toResponse(NotFoundException exception) {
        
        ErrorDto error = new ErrorDto("El método solicitado no existe", exception.getStackTrace()[0].toString());

        return Response.status(Response.Status.NOT_FOUND)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }    
}
