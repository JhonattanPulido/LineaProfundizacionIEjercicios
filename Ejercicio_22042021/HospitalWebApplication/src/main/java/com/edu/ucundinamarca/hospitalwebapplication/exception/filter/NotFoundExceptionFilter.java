// Paquetes
package com.edu.ucundinamarca.hospitalwebapplication.exception.filter;

// Librerías
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import com.edu.ucundinamarca.hospitalwebapplication.pojo.ErrorDto;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;

/**
 * Filtro de NotFoundException
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
 */
@Provider
public class NotFoundExceptionFilter implements ExceptionMapper<NotFoundException> {

    /**
     * Se ejecuta cuando no se encuentra un registro, método etc.
     * @param exception
     * @return 404 - NOT FOUND
     */
    @Override
    public Response toResponse(NotFoundException exception) {
        
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.NOT_FOUND)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }
    
}
