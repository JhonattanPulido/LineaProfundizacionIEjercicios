// Paquetes
package com.edu.ucundinamarca.webapiestudiante.pojos;

// Librerías
import java.io.Serializable;
import java.util.Date;

/**
 * Clase error
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
public class ErrorDto implements Serializable {
    
    // Variables
    
    /**
     * Mensaje de error
     */
    private String mensaje;
    
    /**
     * Fecha en la que se ejecuta el error
     */
    private String fecha;
    
    /**
     * Path del error que se genera
     */
    private String path;

    /**
     * Constructor de la clase
     * @param mensaje     
     * @param path     
     */
    public ErrorDto(String mensaje, String path) {
        this.mensaje = mensaje;
        this.fecha = new Date().toString(); 
        this.path = path;
    }        
    
    // Métodos Set & Get

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }        
}
