// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository;

// Librerías
import javax.ejb.Stateless;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IConsultaRepository;

/**
 * Repositorio de médico
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Stateless
public class ConsultaRepository extends GenericaRepository<Consulta> implements IConsultaRepository {
    
     @Override
    public void eliminarConsulta(int id) {
        em.createNativeQuery("DELETE FROM consultas WHERE id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    
}
