// Paquetes
package com.edu.ucundinamarca.estudianteejb.interfaz;

// Librerías
import java.util.List;
import javax.ejb.Local;
import com.edu.ucundinamarca.estudianteejb.entity.Estudiante;

/**
 * Interfáz de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 25/03/2021
 * @version 1.0.0
 */
@Local
public interface IEstudiante {
    
    /**
     * Crear estudiante
     * @param estudiante - Objeto con los datos de estudiante 
     * @throws Exception
     */
    public void crear(Estudiante estudiante) throws Exception;
   
    /**
     * Leer estudiante filtrado por ID
     * @param id - ID del estudiante
     * @return Objeto con los datos del estudiante
     */
    public Estudiante leer(int id);
   
    /**
     * Leer estudiante filtrado por número de documento
     * @param numeroDocumento - Número de documento del estudiante
     * @return Objeto con los datos del estudiante
     */
    public Estudiante leer(String numeroDocumento);
    
    /**
     * Leer todos los estudiantes registrados
     * @return Lista con los estudiantes registrados
     */
    public List<Estudiante> leer();
   
    /**
     * Actualizar datos de un estudiante
     * @param estudiante - Objeto con los datos del estudiante
     */
    public void actualizar(Estudiante estudiante);
   
    /**
     * Eliminar estudiante
     * @param id - ID del estudiante
     */
    public void eliminar(int id);      
}
