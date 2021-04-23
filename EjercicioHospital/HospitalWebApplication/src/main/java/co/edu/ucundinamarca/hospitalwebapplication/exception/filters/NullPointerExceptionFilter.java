// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.exception.filters;

// Librerías
import co.edu.ucundinamarca.hospitalwebapplication.pojos.ErrorDto;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de NullPointerException
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Provider
public class NullPointerExceptionFilter implements ExceptionMapper<NullPointerException> {

    @Override
    public Response toResponse(NullPointerException exception) {
     
        ErrorDto error = new ErrorDto("La información ha llegado nula.", exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }    
}
