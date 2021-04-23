// Paquetes
package com.edu.ucundinamarca.hospitalejb.exception;

// Librerías

/**
 * Excepción de integridad
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
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
