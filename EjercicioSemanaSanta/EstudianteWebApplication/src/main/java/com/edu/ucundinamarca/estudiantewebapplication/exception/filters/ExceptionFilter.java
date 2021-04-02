// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.exception.filters;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import com.edu.ucundinamarca.estudiantewebapplication.pojos.ErrorDto;

/**
 * Filtro de Exception
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
@Provider
public class ExceptionFilter implements ExceptionMapper<Exception> {

    /**
     * Se ejecuta cuando no hay excepciones controladas
     * @param exception
     * @return 500 - INTERNAL SERVER ERROR
     */
    @Override
    public Response toResponse(Exception exception) {
        
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }    
}
