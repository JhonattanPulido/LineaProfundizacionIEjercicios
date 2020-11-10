// Paquetes
package com.mycompany.ejercicioformularios.controller;
import com.mycompany.ejercicioformularios.logic.IniciarSesionService;
import com.mycompany.ejercicioformularios.models.Estudiante;
import java.io.Serializable;

// Librerías
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Controlador de la página estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 09/11/2020
 * @version 1.0.0
 */
@Named(value = "estudianteController")
@RequestScoped
public class EstudianteController implements Serializable {
    
    // Variables
    
    /**
     * Objeto con los atributos de estudiante
     */
    private Estudiante estudiante;

    /**
     * Constructor del controlador estudiante
     */
    public EstudianteController() {
     
        estudiante = new Estudiante();
    }
        
    // Métodos    
    public void iniciarSesion() {          
        
        estudiante = new IniciarSesionService().IniciarSesionEstudiante(estudiante);
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (estudiante != null)
            context.addMessage(null, new FacesMessage("Inicio de sesión correcto", (estudiante.getNombre() + " " + estudiante.getApellido() + ", su promedio es de: " + estudiante.getPromedio())));        
        else
            context.addMessage(null, new FacesMessage("Datos incorrectos", "Intentelo nuevamente"));            
    }
    
    // Métodos Set & Get

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }        
}
