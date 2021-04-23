// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.exception.filters;

// Librerías
import co.edu.ucundinamarca.hospitalwebapplication.pojos.ErrorDto;
import javax.ws.rs.ext.ExceptionMapper;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Filtro de JsonParsingException
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Provider
public class JsonParsingExceptionFilter implements ExceptionMapper<JsonParsingException> {

    /**
     * Se ejecuta cuando el JSON no esta sintacticamente bien armado
     * @param exception
     * @return 400 - BAD REQUEST
     */
    @Override
    public Response toResponse(JsonParsingException exception) {
        
        ErrorDto error = new ErrorDto("La información no se ha enviado correctamente", exception.getStackTrace()[0].toString());
        
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }        
}
