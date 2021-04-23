// Paquetes
package com.edu.ucundinamarca.hospitalejb.repository;

// Librerías
import com.edu.ucundinamarca.hospitalejb.entity.Consulta;
import com.edu.ucundinamarca.hospitalejb.repository.interfaz.IConsultaRepository;
import javax.ejb.Stateless;

/**
 * Repositorio de consultas
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/02/2021
 */
@Stateless
public class ConsultaRepository extends GenericRepository<Consulta> implements IConsultaRepository {
    
}
