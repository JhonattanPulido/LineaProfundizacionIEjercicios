// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.repository;

// Librerías
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import com.edu.ucundinamarca.estudianteejbmodule.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejbmodule.repository.interfaz.IEstudianteRepository;

/**
 * Capa de datos de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
@Stateless
public class EstudianteRepository implements IEstudianteRepository {

    // Variables
    
    /**
     * Variable que permite realizar transacciones con la base de datos
     */
    @PersistenceContext(unitName = "com.edu.ucundinamarca_EstudianteEJBModule_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    /**
     * Variable auxiliar de Estudiante
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
        
        this.estudiante = leer(estudiante.getNumeroDocumento());
        
        if (this.estudiante == null) {
            em.persist(estudiante);
            return true;
        }
        
        throw new IntegridadException("El número de documento ya está en uso.");
    }
    
    @Override
    public Estudiante leer(int id) {
                
        try {
            return em.createQuery("SELECT e FROM Estudiante e WHERE e.id = :id", Estudiante.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }                
    }

    @Override
    public Estudiante leer(String numeroDocumento) {        
        try {
            return em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroDocumento = :numero_documento", Estudiante.class).setParameter("numero_documento", numeroDocumento).getSingleResult();                           
        } catch (NoResultException e) {
            return null;
        }           
    }     
    
    @Override
    public List<Estudiante> leer() {
        
        return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();                
    }

    @Override
    public boolean actualizar(Estudiante estudiante) throws NotFoundException,
                                                            IntegridadException, 
                                                            Exception {
        
        this.estudiante = leer(estudiante.getId());
        
        if (this.estudiante != null) {
            
            this.estudiante = leer(estudiante.getNumeroDocumento());
            
            if (this.estudiante == null || (this.estudiante != null && this.estudiante.getId().compareTo(estudiante.getId()) == 0)) {
                
                em.merge(estudiante);
                return true;
                
            } else
                throw new IntegridadException("El número de documento ya está en uso");
        }
        
        throw new NotFoundException("No se encontró el estudiante");
    }

    @Override
    public boolean eliminar(int id) throws  NotFoundException,
                                            Exception {
        
        estudiante = leer(id);
        
        if (estudiante != null) {        
            em.remove(estudiante);
            return true;
        }
        
        throw new NotFoundException("No se encontró el estudiante");
    }    
}
