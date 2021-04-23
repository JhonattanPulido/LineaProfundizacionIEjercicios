// Paquetes
package com.edu.ucundinamarca.hospitalejb.service.interfaz;

// Librerías
import javax.ws.rs.NotFoundException;
import com.edu.ucundinamarca.hospitalejb.entity.Consulta;
import javax.ejb.Local;

/**
 * Interfaz del Servicio de consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Local
public interface IConsultaService extends IGenericService<Consulta> {
    
    /**
     * Crear consulta
     * @param consulta     
     */
    public void crear(Consulta consulta);
    
    /**
     * Actualizar consulta
     * @param consulta 
     * @throws NotFoundException
     */
    public void actualizar(Consulta consulta) throws    NotFoundException;                                                       
}
