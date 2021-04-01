// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.repository.interfaz;

// Librerías
import java.util.List;
import javax.ejb.Local;
import com.edu.ucundinamarca.estudianteejbmodule.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NoContentException;

/**
 * Interfaz de la capa de datos de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
@Local
public interface IEstudianteRepository {
    
    /**
     * Crear estudiante
     * @param estudiante - Objeto con los datos del estudiante
     * @return true - Si el estudiante es agregado correctamente
     * @throws IntegridadException
     */
    public boolean crear(Estudiante estudiante) throws  IntegridadException,
                                                        Exception;
    
    /**
     * Leer estudiante filtrado por el id
     * @param id - ID del estudiante
     * @return Objeto con los datos del estudiante     
     */
    public Estudiante leer(int id);
    
    /**
     * Leer estudiante filtrado por numero de documento
     * @param numeroDocumento - Número de documento
     * @return Objeto con los datos del estudiante
     */
    public Estudiante leer(String numeroDocumento);
    
    /**
     * Leer todos los estudiantes registrados en la base de datos
     * @return - Lista de estudiantes     
     */
    public List<Estudiante> leer();
    
    /**
     * Actualizar estudiante
     * @param estudiante - Objeto con los datos del estudiante
     * @return - True si el estudiante es actualizado correctamente
     * @throws NotFoundException
     * @throws IntegridadException
     * @throws Exception 
     */
    public boolean actualizar(Estudiante estudiante) throws NotFoundException,
                                                            IntegridadException,
                                                            Exception;
    
    /**
     * Eliminar estudiante
     * @param id - ID del estudiante
     * @return - True si el estudiante es eliminado correctamente
     * @throws NotFoundException
     * @throws Exception 
     */
    public boolean eliminar(int id) throws  NotFoundException,
                                            Exception;
}
