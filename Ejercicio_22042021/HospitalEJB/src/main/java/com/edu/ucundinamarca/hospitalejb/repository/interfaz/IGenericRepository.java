// Paquetes
package com.edu.ucundinamarca.hospitalejb.repository.interfaz;

// Librerías
import java.util.List;
import javax.ejb.Local;

/**
 * Repositorio general
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @param <T>
 * @since 20/04/2021
 */
public interface IGenericRepository<T> {
   
    /**
     * Crear
     * @param t - Objeto con los datos correspondientes
     */
    public void crear(T t);
    
    /**
     * Leer un registro filtrado por ID
     * @param id - ID del registro
     * @return Objeto con los datos correspondientes
     */
    public T leer(Short id);
    
    /**
     * Leer todos los objetos de una tabla
     * @return Lista con los objetos de una tabla específica
     */
    public List<T> leer();
    
    /**
     * Actualizar un registro
     * @param t - Objeto con los datos correspondientes
     */
    public void actualizar(T t);
    
    /**
     * Eliminar un registro
     * @param t - Objeto con los datos correspondientes
     */
    public void eliminar(T t);
}
