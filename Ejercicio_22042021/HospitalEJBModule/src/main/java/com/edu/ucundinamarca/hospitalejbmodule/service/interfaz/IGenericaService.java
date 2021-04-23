// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service.interfaz;

// Librerías
import java.util.List;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;

/**
 * Interfaz de serviciso de genérica
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 * @param <T>
 */
public interface IGenericaService<T> {
    
    /**
     * Crear registro
     * @param t - Objeto con los datos específicos
     */
    public void crear(T t);
    
    /**
     * Leer registro filtrado por ID
     * @param id - ID del registro
     * @return Objeto con los datos específicos
     * @throws NotFoundException
     */
    public T leer(Short id) throws  NotFoundException;
    
    /**
     * Leer todos los registros almacenados
     * @return Lista con los registros
     * @throws NoContentException
     */
    public List<T> leer() throws    NoContentException;
    
    /**
     * Actualizar un registro
     * @param t - Objeto con los datos específicos
     * @throws NotFoundException
     */
    public void actualizar(T t) throws  NotFoundException;
    
    /**
     * Eliminar un registro
     * @param id - ID del registro
     * @throws NotFoundException
     */
    public void eliminar(Short id) throws   NotFoundException;
}
