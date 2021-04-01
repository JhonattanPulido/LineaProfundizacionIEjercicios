// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.service.interfaz;

// Librerías
import java.util.List;
import javax.ejb.Local;
import com.edu.ucundinamarca.estudianteejbmodule.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.IntegridadException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NoContentException;

/**
 * Interfaz de la capa de servicios de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/02/2021
 * @version 1.0.0
 */
@Local
public interface IEstudianteService {
    
    /**
     * Crear estudiante
     * @param estudiante - Objeto con los datos del estudiante
     * @return true - Si el estudiante es agregado correctamente
     * @throws IntegridadException - El número de documento ya existe
     * @throws Exception - Error del servidor
     */
    public boolean crear(Estudiante estudiante) throws  IntegridadException,
                                                        Exception;
    
    /**
     * Leer estudiante filtrado por el id
     * @param id - ID del estudiante
     * @return Objeto con los datos del estudiante
     * @throws NotFoundException - No se econtró el estudiante
     * @throws Exception - Error del servidor
     */
    public Estudiante leer(int id) throws   NotFoundException,
                                            Exception;       
    
    /**
     * Leer todos los estudiantes registrados en la base de datos
     * @return - Lista de estudiantes
     * @throws NoContentException
     * @throws Exception 
     */
    public List<Estudiante> leer() throws   NoContentException,
                                            Exception;
    
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
