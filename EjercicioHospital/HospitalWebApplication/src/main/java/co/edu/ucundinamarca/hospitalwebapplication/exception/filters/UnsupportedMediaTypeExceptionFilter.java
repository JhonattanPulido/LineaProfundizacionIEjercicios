// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.exception.filters;

// Librerías
import co.edu.ucundinamarca.hospitalwebapplication.pojos.ErrorDto;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de UnsupportedMediaTypeException
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Provider
public class UnsupportedMediaTypeExceptionFilter implements ExceptionMapper<NotSupportedException> {

    /**
     * Se ejecuta cuando no se envia el tipo de dato correcto
     * @param exception
     * @return 415 - UNSUPPORTED MEDIA TYPE
     */
    @Override
    public Response toResponse(NotSupportedException exception) {
        
        ErrorDto error = new ErrorDto("Tipo de dato no soportado", exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }    
}
