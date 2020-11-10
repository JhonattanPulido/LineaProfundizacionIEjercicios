/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicioformularios.models;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 *
 * @author SANDRA
 */

public class Animales implements Serializable {
   // Variables
    
    /**
     * Nombre de animales
     */
    private String nombre;
    
    /**
     * Identificacion de animales
     */    
    @Pattern(regexp="[0-9]{6,10}", message = "ERROR (Identificacion): Debe ingresar números entre el 1 y el 9, 10 dígitos")
    private String identificacion;
    
    /**
     * Clave de animales
     */    
    @Size(min=8, max=20, message = "ERROR (Clave): La clave tiene mínimo 8 y máximo 20 dígitos")    
    private String clave;             

    /**
     * Constructor de la clase estudiante
     */
    public Animales() {
        
    }        
    
    // Métodos Set & Get

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }        
    
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
