// Paquetes
package com.edu.ucundinamarca.estudianteejb.repository;

// Librerías
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejb.repository.interfaz.IEstudianteRepository;
import java.util.List;
import javax.persistence.PersistenceContext;

/**
 * Repositorio de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 25/03/2021
 * @version 1.0.0
 */
@Stateless
public class EstudianteRepository implements IEstudianteRepository {    
    
    @PersistenceContext(unitName = "com.edu.ucundinamarca_EstudianteEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Override
    public void crear(Estudiante estudiante) throws Exception {
        em.persist(estudiante);
    }

    @Override
    public Estudiante leer(int id) {
        return em.find(Estudiante.class, id);
    }

    @Override
    public Estudiante leer(String numeroDocumento) {
        return em.createQuery("SELECT * FROM estudiante WHERE numero_documento = :numero_documento", Estudiante.class).setParameter("numero_documento", numeroDocumento).getSingleResult();
    }

    @Override
    public List<Estudiante> leer() {
        return em.createQuery("SELECT e FROM public.estudiante e", Estudiante.class).getResultList();
    }
    
    @Override
    public void actualizar(Estudiante estudiante) {
        em.merge(estudiante);
    }

    @Override
    public void eliminar(int id) {
        em.remove(id);
    }        
}
