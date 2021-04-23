// Paquetes
package com.edu.ucundinamarca.hospitalejb.repository.interfaz;

// Librerías
import com.edu.ucundinamarca.hospitalejb.entity.Consulta;
import javax.ejb.Local;

/**
 * Interfaz del repositorio de estudiante
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Local
public interface IConsultaRepository extends IGenericRepository<Consulta> {
    
}
