// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.exception.filters;

// Librerías
import com.edu.ucundinamarca.estudiantewebapplication.pojos.ErrorDto;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de UnsupportedMediaTypeException
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 01/04/2021
 * @version 1.0.0
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
