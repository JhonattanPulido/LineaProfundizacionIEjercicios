// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.service;

// Librerías
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.edu.ucundinamarca.estudianteejbmodule.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejbmodule.service.interfaz.IEstudianteService;
import com.edu.ucundinamarca.estudianteejbmodule.repository.interfaz.IEstudianteRepository;

/**
 * Capa de servicios de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
@Stateless
public class EstudianteService implements IEstudianteService {

    // Variables
    
    /**
     * Variable que permite usar los métodos de IEstudianteRepository
     */
    @EJB
    private IEstudianteRepository estudianteRepository;
    
    /**
     * Variable auxiliar de estudiante
     */
    private Estudiante estudiante;
    
    // Métodos
    
    @Override
    public boolean crear(Estudiante estudiante) throws  IntegridadException,
                                                        Exception {
        
        return estudianteRepository.crear(estudiante);
    }         

    @Override
    public Estudiante leer(int id) throws   NotFoundException,
                                            Exception {
        
        estudiante = estudianteRepository.leer(id);
        
        if (estudiante != null)
            return estudiante;
        else
            throw new NotFoundException("No se encontró el estudiante");        
    }
}
