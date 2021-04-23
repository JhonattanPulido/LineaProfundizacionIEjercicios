// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service.interfaz;

// Librerías
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;
import javax.ejb.Local;

/**
 * Interfaz del servicio de consulta
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Local
public interface IMedicoService extends IGenericaService<Medico> {
    
}
