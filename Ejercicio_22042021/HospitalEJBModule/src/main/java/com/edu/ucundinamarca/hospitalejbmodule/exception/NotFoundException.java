// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.exception;

// Librerías

/**
 * NotFoundException
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
 */
public class NotFoundException extends Exception {

    /**
     * Constructor
     * @param message - Mensaje de error
     */
    public NotFoundException(String message) {
        super(message);
    }        
}
