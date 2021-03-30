// Paquetes
package com.edu.ucundinamarca.estudianteejb.repository.interfaz;

// Librerías
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejb.exception.IntegridadException;

/**
 * Interfaz de la capa de datos de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 27/03/2021
 * @version 1.0.0
 */
@Local
public interface IEstudianteRepository {
    
    /**
     * Crear estudiante
     * @param estudiante 
     * @return  
     * @throws IntegridadException
     * @throws Exception
     */
    public boolean crear(Estudiante estudiante);
    
    /**
     * Leer estudiante filtrado por id
     * @param id
     * @return 
     * @throws NotFoundException
     * @throws Exception
     */
    public Estudiante leer(short id);
    
    /**
     * Leer estudiante filtrado por numero de documento     
     * @param numeroDocumento
     * @return 
     * @throws NotFoundException
     * @throws Exception
     */
    public Estudiante leer(String numeroDocumento) throws   NotFoundException,
                                                            Exception;
    
    /**
     * Leer todos los estudiantes registrados
     * @return 
     * @throws NoContentException
     * @throws Exception
     */
    public List<Estudiante> leer() throws   NoContentException,
                                            Exception;
    
    /**
     * Actualizar estudiante
     * @param estudiante 
     * @return  
     * @throws NotFoundException
     * @throws IntegridadException
     * @throws Exception
     */
    public boolean actualizar(Estudiante estudiante) throws NotFoundException,
                                                            IntegridadException,
                                                            Exception;
    
    /**
     * Eliminar estudiante
     * @param id 
     * @return  
     * @throws NotFoundException,
     * @throws Exception
     */
    public boolean eliminar(short id) throws    NotFoundException,
                                                Exception;
}
