// Paquetes
package com.edu.ucundinamarca.estudianteejb.repository;

// Librerías
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejb.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejb.repository.interfaz.IEstudianteRepository;
import javax.ws.rs.core.NoContentException;

/**
 * Capa de datos de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 27/03/2021
 * @version 1.0.0
 */
@Stateless
public class EstudianteRepository implements IEstudianteRepository {

    // Variables
    
    /**
     * Variable que permite realizar transacciones con la base de datos
     */
    @PersistenceContext(unitName = "com.edu.ucundinamarca_EstudianteEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    /**
     * Variable auxiliar de estudiante
     */
    private Estudiante estudiante;
    
    /**
     * Lista auxiliar de estudiantes
     */
    private List<Estudiante> listaEstudiantes;
    
    /**
     * Constructor
     */
    public EstudianteRepository() {               
        
    }

    // Métodos
    
    @Override
    public boolean crear(Estudiante estudiante) {
        
        /*if (leer(estudiante.getNumeroDocumento()) == null) {
            em.persist(estudiante);
            return true;
        }            
        
        throw new IntegridadException("El número de documento ya existe");*/
        
        return true;
    }

    /*@Override
    public Estudiante leer(short id) throws NotFoundException,
                                            Exception {
        
        estudiante = em.find(Estudiante.class, id);
        
        if (estudiante != null)
            return estudiante;
        else
            throw new NotFoundException("No se econtró el estudiante");
    }*/        
    
    @Override
    public Estudiante leer(short id) {
        return em.find(Estudiante.class, id);
    }

    @Override
    public Estudiante leer(String numeroDocumento) throws   NotFoundException,
                                                            Exception {
        
        estudiante = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroDocumento = :numero_documento", Estudiante.class).setParameter("numero_documento", numeroDocumento).getSingleResult();
        
        if (estudiante != null)
            return estudiante;
        else
            throw new NotFoundException("No se encontró el estudiante");
    }
    
    @Override
    public List<Estudiante> leer() throws   NoContentException,
                                            Exception {        
        
        listaEstudiantes = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
        
        if (listaEstudiantes != null)
            return listaEstudiantes;
        else
            throw new NoContentException("");
    }

    @Override
    public boolean actualizar(Estudiante estudiante) throws NotFoundException,
                                                            IntegridadException, 
                                                            Exception {
        
        if (leer(estudiante.getId()) != null) {
            
            this.estudiante = em.createQuery("SELECT e FROM Estudiante e WHERE e.id != :id AND e.numeroDocumento = :numero_documento", Estudiante.class)
                        .setParameter("id", estudiante.getId())
                        .setParameter("numero_documento", estudiante.getNumeroDocumento())
                        .getSingleResult();

            if (this.estudiante == null) {
                em.merge(estudiante);
                return true;
            }                    
            
            throw new IntegridadException("El número de documento ya existe");
        }
        
        throw new NotFoundException("No se encontró el estudiante");
    }

    @Override
    public boolean eliminar(short id) throws    NotFoundException,
                                                Exception {
        
        if (leer(id) != null) {
            em.remove(id);
            return true;
        }
        
        throw new NotFoundException("No se encontró el estudiante");                
    }    
}
