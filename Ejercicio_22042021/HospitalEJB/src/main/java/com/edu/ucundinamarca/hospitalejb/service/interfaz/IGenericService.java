// Paquetes
package com.edu.ucundinamarca.hospitalejb.service.interfaz;

// Librerías
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.NoContentException;

/**
 * Interfaz del servicio genérico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @param <T>
 * @since 20/04/2021
 */
public interface IGenericService<T> {        
    
    /**
     * Leer un registro filtrado por ID
     * @param id - ID del registro
     * @return Objeto con los datos correspondientes
     * @throws NotFoundException
     */
    public T leer(Short id) throws  NotFoundException;
    
    /**
     * Leer todos los registros almacenados
     * @return Lista con los datos correspondientes
     * @throws NoContentException
     */
    public List<T> leer() throws    NoContentException;        
    
    /**
     * Eliminar un registro
     * @param id - ID del registro
     */
    public void eliminar(Short id);
}
