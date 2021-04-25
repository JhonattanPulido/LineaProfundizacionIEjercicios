// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository;

// Librerías
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IGenericaRepository;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Repositorio de genérica
 *
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 * @param <T> - Tipo de entidad
 */
public class GenericaRepository<T> implements IGenericaRepository<T> {

    // Variables
    /**
     * Variable de persistencia contra la BD
     */
    @PersistenceContext(unitName = "com.edu.ucundinamarca_HospitalEJBModule_ejb_1.0-SNAPSHOTPU")
    protected EntityManager em;

    /**
     * Almacena el tipo de clase que se desea usar
     */
    private final Class<T> classType;

    public GenericaRepository() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        classType = (Class) pt.getActualTypeArguments()[0];
    }

    // Métodos
    /**
     * Crear un registro
     *
     * @param t - Objeto con los datos específicos
     */
    @Override
    public void crear(T t) {
        em.persist(t);
    }

    /**
     * Leer un registro filtrado por ID
     *
     * @param id - ID del registro
     * @return Objeto con los datos específicos
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public T leer(String queryName, Short id) throws NotFoundException {
        try {
            return (T) em.createNamedQuery(queryName, classType).setParameter("id", id).getSingleResult();
        } catch (NoResultException ex) {
            throw new NotFoundException("No se encontró el registro");
        }
    }

    /**
     * Leer todos los registros almacenados
     *
     * @return Lista de registros
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<T> leer(String queryName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(classType);
        Root<T> root = criteriaQuery.from(classType);
        criteriaQuery.select(root);
        TypedQuery<T> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Actualizar un registro
     *
     * @param t - Objeto con los datos específicos
     */
    @Override
    public void actualizar(T t) {
        em.merge(t);
    }

    /**
     * Eliminar un registro
     *
     * @param t - Objeto con los datos específicos
     */
    @Override
    public void eliminar(T t) {
        em.remove(t);
    }

    /**
     * Obtener cantidad de registros a partir de un ID
     *
     * @param queryName - Nombre del Query
     * @param id - ID del registro
     * @return Cantidad de registros con el ID
     */
    @Override
    public long cantidadRegistrosId(String queryName, Short id) {
        return (long) em.createNamedQuery(queryName, long.class).setParameter("id", id).getSingleResult();
    }

}
