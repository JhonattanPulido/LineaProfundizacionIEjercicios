// Paquetes
package com.edu.ucundinamarca.hospitalejb.repository.interfaz;

// Librerías
import com.edu.ucundinamarca.hospitalejb.entity.Medico;
import javax.ejb.Local;

/**
 * Interfaz del repositorio de médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Local
public interface IMedicoRepository extends IGenericRepository<Medico> {
    
}
