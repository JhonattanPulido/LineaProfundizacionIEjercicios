// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz;

// Librerías
import javax.ejb.Local;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;

/**
 * Interfaz del repositorio de consulta
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Local
public interface IConsultaRepository extends IGenericaRepository<Consulta> {
    
}
