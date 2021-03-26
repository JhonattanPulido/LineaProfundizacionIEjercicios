// Paquetes
package com.edu.ucundinamarca.webapiestudiante.pojo;

// Librerías
import java.io.Serializable;
import java.util.Date;

/**
 * Clase de Error Dto
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 25/03/2021
 * @version 1.0.0
 */
public class ErrorDto implements Serializable {
    
    /**
     * Mensaje de la excepción
     */
    private String mensaje;
    
    /**
     * Fecha en la que se generó la excepción
     */
    private final String fecha;
    
    /**
     * Ruta en la que se generó la exepción
     */
    private String path;

    /**
     * Constructor
     * @param mensaje
     * @param path 
     */
    public ErrorDto(String mensaje, String path) {
        this.mensaje = mensaje;
        this.path = path;
        fecha = new Date().toString();
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }    
}
