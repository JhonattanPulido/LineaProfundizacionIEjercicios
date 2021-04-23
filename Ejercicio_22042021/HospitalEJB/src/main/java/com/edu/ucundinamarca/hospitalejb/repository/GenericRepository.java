// Paquetes
package com.edu.ucundinamarca.hospitalejb.repository;

// Librerías
import java.util.List;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import javax.persistence.PersistenceContext;
import com.edu.ucundinamarca.hospitalejb.repository.interfaz.IGenericRepository;

/**
 * Repositorio general
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @param <T>
 * @since 20/04/2021
 */
public class GenericRepository<T> implements IGenericRepository<T> {
    
    // Variables
    
    /**
     * Variable de persistencia
     */
    @PersistenceContext(unitName = "com.edu.ucundinamarca_HospitalEJB_ejb_1.0-SNAPSHOTPU")
    protected EntityManager em;
    
    /**
     * Almacena el tipo de clase que se desea usar
     */
    private Class<T> classType;
    
    /**
     * Constructor de la clase
     */
    public GenericRepository() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        classType = (Class) pt.getActualTypeArguments()[0];
    }    
    
    // Métodos
    
    /**
     * Crear
     * @param t - Objeto con datos de la clase
     */
    @Override
    public void crear(T t) {
        em.persist(t);
    }

    /**
     * Leer objeto
     * @param id - ID del objeto
     * @return Objeto con los datos correspondientes
     */
    @Override
    public T leer(Short id) {
        return (T) em.find(classType, id);
    }

    /**
     * Leer todos los registros de una tabla
     * @return Lista de los objetos de una tabla 
     */
    @Override
    public List<T> leer() {
        return em.createQuery("SELECT t FROM classType t", classType).getResultList();
    }

    @Override
    public void actualizar(T t) {
        em.merge(t);
    }

    @Override
    public void eliminar(T t) {
        em.remove(t);
    }
    
    // Métodos Get

    public EntityManager getEm() {
        return em;
    }       
}
