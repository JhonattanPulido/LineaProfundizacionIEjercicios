// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.repository.interfaz;

// Librerías
import java.util.List;

/**
 * Interfaz de repositorio de genérica
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 * @param <T>
 */
public interface IGenericaRepository<T> {
    
    // Métodos
    
    /**
     * Crear registro
     * @param t - Objeto con los datos del registro     
     */
    public void crear(T t);
    
    /**
     * Leer un registro filtrado por el ID
     * @param queryName
     * @param id - ID del registro
     * @return Objeto con los datos específicos    
     */
    public T leer(String queryName, Short id);
    
    /**
     * Leer todos los registros de una tabla
     * @return Lista con los registros
     */
    public List<T> leer();
    
    /**
     * Actualizar registro
     * @param t - Objeto con los datos del registro
     */
    public void actualizar(T t);
    
    /**
     * Eliminar registro
     * @param t - Objeto con los datos del registro
     */
    public void eliminar(T t);
    
    /**
     * Cantidad de registros filtrados por ID
     * @param queryName - Nombre del query
     * @param id - ID del registro
     * @return Cantidad de registros encontrados
     */
    public long cantidadRegistros(String queryName, short id);
}
