// Paquetes
package com.mycompany.ejercicioformularios.controller;

// Librerías
import com.mycompany.ejercicioformularios.models.Vehiculo;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Controlador de vehículo
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 09/11/2020
 * @version 1.0.0
 */
@Named(value = "vehiculoController")
@RequestScoped
public class VehiculoController implements Serializable {

    // Variables
    
    /**
     * Objeto con los datos del vehículo
     */
    private Vehiculo vehiculo;
    
    /**
     * Constructor del controlador de vehículo
     */
    public VehiculoController() {
        
        vehiculo = new Vehiculo();
    }
    
    // Métodos
        
    public void iniciarSesion() {
        
        FacesContext context = FacesContext.getCurrentInstance();        
        context.addMessage(null, new FacesMessage("Inicio de sesión correcto", "Hola"));        
    }
    
    public void submit() {
        
        FacesContext context = FacesContext.getCurrentInstance();        
        context.addMessage(null, new FacesMessage("Submit", "Submit"));        
    }
    
    // Métodos Set & Get

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }        
}
