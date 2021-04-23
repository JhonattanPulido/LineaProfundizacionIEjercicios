// Paquete
package com.edu.ucundinamarca.hospitalejb.service.interfaz;

// Librerías
import com.edu.ucundinamarca.hospitalejb.entity.Medico;
import javax.ejb.Local;
import javax.ws.rs.NotFoundException;

/**
 * Interfaz del servicio de médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Local
public interface IMedicoService extends IGenericService<Medico> {
    
    /**
     * Crear médico
     * @param medico - Objeto con los datos del médico
     */
    public void crear(Medico medico);
    
    /**
     * Actualizar médico
     * @param medico - Objeto con los datos del médico
     * @throws NotFoundException
     */
    public void actualizar(Medico medico) throws    NotFoundException;
}
