// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz;

// Librerías
import javax.ejb.Local;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;

/**
 * Interfaz del repositorio de médico
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Local
public interface IMedicoRepository extends IGenericaRepository<Medico> {
    
}
