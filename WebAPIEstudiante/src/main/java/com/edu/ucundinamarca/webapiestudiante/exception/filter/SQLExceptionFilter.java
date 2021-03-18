// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exception.filter;
import com.edu.ucundinamarca.webapiestudiante.pojos.ErrorDto;

// Librerías
import java.sql.SQLException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * Filtro de la excepción SQL
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
@Provider
public class SQLExceptionFilter implements ExceptionMapper<SQLException> {

    /**
     * Responder 500 - INTERNAL SERVER ERROR
     * @param exception
     * @return Respuesta asociada a error 500
     */
    @Override
    public Response toResponse(SQLException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), exception.getStackTrace()[0].toString());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }
    
}
