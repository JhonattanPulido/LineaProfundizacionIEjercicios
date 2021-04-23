// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz;

// Librerías
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import java.util.List;

/**
 * Interfaz del repositorio de genérica
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0 
 * @since 23/04/2021
 * @param <T> - Tipo de entidad
 */
public interface IGenericaRepository<T> {
    
    /**
     * Crear registro
     * @param t - Objeto con los datos del registro
     */
    public void crear(T t);
    
    /**
     * Leer un registro filtrado por ID
     * @param id - ID del registro
     * @param queryName 
     * @return Objeto con los datos específicos
     * @throws NotFoundException
     */
    public T leer(String queryName, Short id) throws    NotFoundException;
    
    /**
     * Leer todos los registros almacenados
     * @return Lista de registros específicos
     */
    public List<T> leer();
    
    /**
     * Actualizar un registro
     * @param t - Objeto con los datos del registro     
     */
    public void actualizar(T t);
    
    /**
     * Eliminar un registro
     * @param t - Objeto con los datos del registro     
     */
    public void eliminar(T t);
    
    /**
     * Obtener cantidad de registros a partir de un ID
     * @param queryName - Nombre del Query
     * @param id - ID del registro
     * @return Cantidad de registros con el ID
     */
    public long cantidadRegistrosId(String queryName, Short id);
}
