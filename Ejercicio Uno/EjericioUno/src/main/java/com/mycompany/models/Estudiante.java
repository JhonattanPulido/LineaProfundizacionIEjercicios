// Paquetes
package com.mycompany.models;

// Librerías
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * Clase estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 29/10/2020
 * @version 1.0.0
 */
@Dependent
@Named
public class Estudiante {   
    
    public String getMessage() {    
        return "Hola Mensaje!";
    }
    
}
