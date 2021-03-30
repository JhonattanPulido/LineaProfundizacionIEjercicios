// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.exception;

/**
 * Exception de Integridad
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
public class IntegridadException extends Exception {

    /**
     * Constructor
     * @param message - Mensaje de error
     */
    public IntegridadException(String message) {
        super(message);
    }        
}
