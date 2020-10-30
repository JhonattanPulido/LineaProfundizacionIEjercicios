// Librerías
package com.mycompany.controller;

// Paquetes
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * Controlador de la vista dependent
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 29/10/2020
 * @version 1.0.0
 */
@Named(value = "dependentController")
@Dependent
public class DependentController {

    public String getMessage() {
        return "Hola Mundo!";
    }
}
