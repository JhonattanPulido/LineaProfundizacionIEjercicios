// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.repository;

// Librerías
import com.edu.ucundinamarca.hospitalejbmodule.repository.interfaz.IGenericaRepository;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Repositorio de genérica
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 * @param <T>
 */
public class GenericaRepository<T> implements IGenericaRepository<T> {

    /**
     * Variable de persistencia
     */
    @PersistenceContext(unitName = "com.edu.ucundinamarca_HospitalEJBModule_ejb_1.0-SNAPSHOTPU")
    protected EntityManager em;
    
    /**
     * Almacena el tipo de clase que se desea usar
     */
    private final Class<T> classType;
    
    /**
     * Constructor de la clase
     */
    public GenericaRepository() {
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
    @JsonbTransient
    public T leer(String queryName, Short id) {
        try {
            return (T) em.createNamedQuery(queryName, classType).setParameter("id", id).getSingleResult();                                      
        } catch (NoResultException ex) {
            return null;
        }
    }   
    
    /**
     * Leer todos los registros de una tabla
     * @return Lista de los objetos de una tabla 
     */    
    @Override
    @JsonbTransient
    public List<T> leer() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(classType);
        Root<T> root = criteriaQuery.from(classType);
        criteriaQuery.select(root);
        TypedQuery<T> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    /**
     * Actualizar un registro
     * @param t - Objeto con los datos del registro
     */
    @Override
    public void actualizar(T t) {
        em.merge(t);        
    }
    
    /**
     * Eliminar un registro
     * @param t - Objeto con los datos del registro
     */
    @Override
    public void eliminar(T t) {
        em.remove(t);
    }
    
    /**
     * Cantidad de registros filtrados por ID
     * @param queryName - Nombre del query
     * @param id - ID del registro
     * @return Cantidad de registros encontrados
     */
    @Override
    public long cantidadRegistros(String queryName, short id) {
        return (long) em.createNamedQuery(queryName, classType).setParameter("id", id).getSingleResult();
    }
    
    // Métodos Get

    public EntityManager getEm() {
        return em;
    }   
    
}
