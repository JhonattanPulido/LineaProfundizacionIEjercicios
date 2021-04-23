// Paquetes
package co.edu.ucundinamarca.hospitalwebapplication.pojos;

// Librerías
import java.util.Date;
import java.io.Serializable;

/**
 * Error Dto
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
public class ErrorDto implements Serializable {
    
    // Variables
    
    /**
     * Mensaje de error
     */
    private final String mensaje;
    
    /**
     * Fecha en la que se ejecuta el error
     */
    private final String fecha;
    
    /**
     * Path del error que se genera
     */
    private final String path;        

    /**
     * Constructor     
     * @param mensaje
     * @param path      
     */    
    public ErrorDto(String mensaje, String path) {        
        this.path = path;        
        this.mensaje = mensaje;
        fecha = new Date().toString();
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPath() {
        return path;
    }        
}
