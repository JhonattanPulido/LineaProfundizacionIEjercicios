// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.service;

// Librerías
import javax.ejb.EJB;
import java.util.List;
import javax.ejb.Stateless;
import com.edu.ucundinamarca.estudianteejbmodule.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NoContentException;
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
    
    /**
     * Lista auxiliar de estudiantes
     */
    private List<Estudiante> listaEstudiantes;
    
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

    @Override
    public List<Estudiante> leer() throws   NoContentException,
                                            Exception {
        
        listaEstudiantes = estudianteRepository.leer();
        
        if (listaEstudiantes.size() > 0)
            return listaEstudiantes;
        else
            throw new NoContentException("");
    }

    @Override
    public boolean actualizar(Estudiante estudiante) throws NotFoundException,
                                                            IntegridadException,
                                                            Exception {
        
        return estudianteRepository.actualizar(estudiante);
    }

    @Override
    public boolean eliminar(int id) throws  NotFoundException,
                                            Exception {
        
        return estudianteRepository.eliminar(id);
    }
}
