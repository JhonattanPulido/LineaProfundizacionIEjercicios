// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.repository;

// Librerías
import javax.ejb.Stateless;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.repository.interfaz.IConsultaRepository;

/**
 *
 * @author Jhonattan Pulido
 */
@Stateless
public class ConsultaRepository extends GenericaRepository<Consulta> implements IConsultaRepository {
    
}
