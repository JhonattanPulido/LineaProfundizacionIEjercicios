// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service.interfaz;

// Librerías

import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import java.util.List;
import javax.ws.rs.core.NoContentException;

/**
 * Interfaz del servicio de consulta
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 * @param <T>
 */
public interface IGenericaService<T> {
    
    /**
     * Crear registro
     * @param t - Objeto con los datos del registro
     */
    public void crear(T t);
    
    /**
     * Leer un registro filtrado por ID
     * @param id - ID del registro
     * @return Objeto con los datos específicos
     * @throws NotFoundException
     */
    public T leer(Short id) throws    NotFoundException;
    
    /**
     * Leer todos los registros almacenados
     * @return Lista de registros específicos
     * @throws NoContentException
     */
    public List<T> leer() throws    NoContentException;
    
    /**
     * Actualizar un registro
     * @param t - Objeto con los datos del registro
     * @throws NotFoundException
     */
    public void actualizar(T t) throws    NotFoundException;
    
    /**
     * Eliminar un registro
     * @param id
     * @throws NotFoundException
     */
    public void eliminar(Short id) throws  NotFoundException;
}
