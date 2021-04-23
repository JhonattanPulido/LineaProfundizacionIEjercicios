// Paquetes
package com.edu.ucundinamarca.hospitalwebapplication.exception.filter;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import com.edu.ucundinamarca.hospitalwebapplication.pojo.ErrorDto;
import javax.ws.rs.core.MediaType;

/**
 * Filtro de excepción
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
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
