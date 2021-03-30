// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.exception;

// Librerías

/**
 * Not Found Exception
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
public class NotFoundException extends Exception {

    /**
     * Constructor
     * @param message 
     */
    public NotFoundException(String message) {
        super(message);
    }        
}
