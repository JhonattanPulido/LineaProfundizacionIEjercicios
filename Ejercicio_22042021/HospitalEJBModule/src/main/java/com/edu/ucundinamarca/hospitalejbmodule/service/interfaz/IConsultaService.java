// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service.interfaz;

// Librerías
import javax.ejb.Local;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;

/**
 * Interfaz del servicio de consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
 */
@Local
public interface IConsultaService extends IGenericaService<Consulta> {
    
}
