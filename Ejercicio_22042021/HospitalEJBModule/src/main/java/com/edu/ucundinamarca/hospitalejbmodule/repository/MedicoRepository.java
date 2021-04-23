// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.repository;

// Librerías
import javax.ejb.Stateless;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;
import com.edu.ucundinamarca.hospitalejbmodule.repository.interfaz.IMedicoRepository;

/**
 * Repositorio de médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Stateless
public class MedicoRepository extends GenericaRepository<Medico> implements IMedicoRepository {
    
}
