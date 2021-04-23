// Paquetes
package com.edu.ucundinamarca.hospitalejb.repository;

// Librerías
import com.edu.ucundinamarca.hospitalejb.entity.Medico;
import com.edu.ucundinamarca.hospitalejb.repository.interfaz.IMedicoRepository;
import javax.ejb.Stateless;

/**
 * Repositorio de médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Stateless
public class MedicoRepository extends GenericRepository<Medico> implements IMedicoRepository {
    
}
