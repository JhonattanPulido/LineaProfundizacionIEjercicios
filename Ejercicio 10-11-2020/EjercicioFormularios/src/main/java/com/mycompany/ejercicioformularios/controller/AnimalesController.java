// Paquetes
package com.mycompany.ejercicioformularios.controller;

// Librerías
import com.mycompany.ejercicioformularios.logic.IniciarSesionService;
import com.mycompany.ejercicioformularios.models.Animales;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Controlador de animales
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 09/11/2020
 * @version 1.0.0
 */
@Named(value = "animalesController")
@RequestScoped
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
