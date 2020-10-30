package com.mycompany.dependent.controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 * Controlador de la vista principal
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 29/10/2020
 * @version 1.0.0
 */
@Named(value = "messageServerBean")
@Dependent
public class MessageServerBean {

    // Método para obtener un mensaje
    public String getMessage() {
        return "Hola Mundo!";
    }
    
}
