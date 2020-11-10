/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicioformularios.controller;

import com.mycompany.ejercicioformularios.logic.IniciarSesionService;
import com.mycompany.ejercicioformularios.models.Animales;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author SANDRA
 */
@Named(value = "animalesController")
@SessionScoped
public class AnimalesController implements Serializable {

    
    // Variables
    
    /**
     * Objeto con los atributos de estudiante
     */
    private Animales animales;
    
    public AnimalesController() {
        animales = new Animales();
    }

    // Métodos    
    public void iniciarSesion() {          
        
        animales = new IniciarSesionService().IniciarSesionAnimales(animales);
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (animales != null)
            context.addMessage(null, new FacesMessage("Inicio de sesión correcto", (animales.getNombre())));        
        else
            context.addMessage(null, new FacesMessage("Datos incorrectos", "Intentelo nuevamente"));            
    }
    
    // Métodos Set & Get

    public Animales getAnimales() {
        return animales;
    }

    public void setAnimales(Animales animales) {
        this.animales = animales;
    }

    
    
}
