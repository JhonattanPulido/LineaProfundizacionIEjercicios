// Paquetes
package com.edu.ucundinamarca.estudianteejb.service;

// Librerías
import javax.ejb.EJB;
import java.util.List;
import javax.ejb.Stateless;
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejb.interfaz.IEstudiante;
import com.edu.ucundinamarca.estudianteejb.repository.interfaz.IEstudianteRepository;

/**
 * Servicio de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 25/03/2021
 * @version 1.0.0
 */
@Stateless
public class EstudianteService implements IEstudiante {

    // Variables
    @EJB
    private IEstudianteRepository repository;
    
    // Métodos
    
    @Override
    public void crear(Estudiante estudiante) throws Exception {
        repository.crear(estudiante);
    }

    @Override
    public Estudiante leer(int id) {
        return repository.leer(id);
    }

    @Override
    public Estudiante leer(String numeroDocumento) {
        return repository.leer(numeroDocumento);
    }
    
    @Override
    public List<Estudiante> leer() {
        return repository.leer();
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        repository.actualizar(estudiante);
    }

    @Override
    public void eliminar(int id) {
        repository.eliminar(id);
    }    
    
}
