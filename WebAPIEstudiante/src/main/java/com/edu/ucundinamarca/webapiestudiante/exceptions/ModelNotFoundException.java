// Paquetes
package com.edu.ucundinamarca.webapiestudiante.exceptions;

/**
 * Clase excepción de modelo
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 17/03/2021
 * @version 1.0.0
 */
public class ModelNotFoundException extends Exception {

    /**
     * Constructor
     * @param message 
     */
    public ModelNotFoundException(String message) {
        super(message);
    }       
}
