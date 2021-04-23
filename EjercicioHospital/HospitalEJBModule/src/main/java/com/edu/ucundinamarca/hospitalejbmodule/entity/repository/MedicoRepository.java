// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository;

// Librerías
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;
import javax.ejb.Stateless;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IMedicoRepository;

/**
 * Repositorio de médico
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Stateless
public class MedicoRepository extends GenericaRepository<Medico> implements IMedicoRepository {
    
}
