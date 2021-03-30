// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.service.interfaz;

// Librerías
import javax.ejb.Local;
import com.edu.ucundinamarca.estudianteejbmodule.entity.Estudiante;
import com.edu.ucundinamarca.estudianteejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.estudianteejbmodule.exception.IntegridadException;

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
}
