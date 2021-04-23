// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.repository.interfaz;

// Librerías
import javax.ejb.Local;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;

/**
 * Interfaz de repositorio de médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Local
public interface IMedicoRepository extends IGenericaRepository<Medico> {
    
}