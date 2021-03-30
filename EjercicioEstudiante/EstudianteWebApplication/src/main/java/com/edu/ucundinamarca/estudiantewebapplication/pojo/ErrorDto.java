// Paquetes
package com.edu.ucundinamarca.estudiantewebapplication.pojo;

// Librerías
import java.io.Serializable;
import java.util.Date;
import javax.ws.rs.core.Response;

/**
 * Clase de error
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 28/03/2021
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
}
