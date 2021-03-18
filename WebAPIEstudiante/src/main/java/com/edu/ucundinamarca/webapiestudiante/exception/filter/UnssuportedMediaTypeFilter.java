// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;

// Librerías
import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.NotSupportedException;

/**
 * Filtro para la excepción unssuported media type
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
public class UnssuportedMediaTypeFilter implements ExceptionMapper<NotSupportedException> {

    @Override
    public Response toResponse(NotSupportedException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE)
                        .entity(error)
                        .build();
    }
    
}
