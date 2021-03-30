// Paquetes
package com.edu.ucundinamarca.estudianteejb.service;

// Librerías
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejb.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejb.repository.interfaz.IEstudianteRepository;
import com.edu.ucundinamarca.estudianteejb.service.interfaz.IEstudianteService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.NoContentException;

/**
 * Capa de servicio de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 28/03/2021
 * @version 1.0.0
 */
@Stateless
public class EstudianteService implements IEstudianteService {

    @EJB
    private IEstudianteRepository repository;
    
    private Estudiante estudiante;
    
    @Override
    public boolean crear(Estudiante estudiante) {        
        
        return repository.crear(estudiante);
    }

    /*@Override
    public Estudiante leer(short id) throws NotFoundException,
                                            Exception {        
        
        return repository.leer(id);
    }*/
    
    @Override
    public Estudiante leer(short id) {        
        
        estudiante = repository.leer(id);
        
        if (estudiante != null)
            return estudiante;
        else
            throw new NotFoundException("No se econtró el estudiante");
    }

    @Override
    public Estudiante leer(String numeroDocumento) throws   NotFoundException,
                                                            Exception {
        
        return repository.leer(numeroDocumento);
    }

    @Override
    public List<Estudiante> leer() throws   NoContentException,
                                            Exception {
        
        return repository.leer();
    }

    @Override
    public boolean actualizar(Estudiante estudiante) throws NotFoundException,
                                                            IntegridadException,
                                                            Exception {
        
        return repository.actualizar(estudiante);
    }

    @Override
    public boolean eliminar(short id) throws    NotFoundException,
                                                Exception{
        
        return repository.eliminar(id);
    }            
}
