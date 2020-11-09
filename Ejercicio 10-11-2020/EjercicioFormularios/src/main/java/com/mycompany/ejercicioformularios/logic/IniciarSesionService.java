// Paquetes
package com.mycompany.ejercicioformularios.logic;
import com.mycompany.ejercicioformularios.models.Estudiante;

/**
 * Clase servicio de iniciar sesión
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 09/11/2020
 * @version 1.0.0
 */
public class IniciarSesionService {

    /**
     * Constructor de la clase servicio de iniciar sesión
     */
    public IniciarSesionService() {
        
    }        
    
    /**
     * Validar el inicio de sesión de un estudiante
     * @param estudiante
     * @return La información de un estudiante
     */
    public Estudiante IniciarSesionEstudiante(Estudiante estudiante) {
        if (estudiante.getCodigo().equals("461217257") && estudiante.getClave().equals("12345678")) {
        
            estudiante.setNombre("Jhonattan");
            estudiante.setApellido("Pulido");
            estudiante.setPromedio(4);
            return estudiante;
            
        } else
            return null;
    }   
}
