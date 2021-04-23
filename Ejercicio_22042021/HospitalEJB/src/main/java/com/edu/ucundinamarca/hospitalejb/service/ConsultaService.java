// Paquetes
package com.edu.ucundinamarca.hospitalejb.service;

// Libreías
import javax.ejb.EJB;
import javax.ws.rs.NotFoundException;
import com.edu.ucundinamarca.hospitalejb.entity.Consulta;
import com.edu.ucundinamarca.hospitalejb.service.interfaz.IConsultaService;
import com.edu.ucundinamarca.hospitalejb.repository.interfaz.IConsultaRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.NoContentException;

/**
 * Servicio de consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Stateless
public class ConsultaService implements IConsultaService {

    // Variables
    
    /**
     * 
     */
    @EJB
    private IConsultaRepository consultaRepository;        
    
    // Métodos
    
    /**
     * Crear consulta
     * @param consulta - Objeto con los datos correspondientes
     */
    @Override
    public void crear(Consulta consulta) {
        consultaRepository.crear(consulta);        
    }

    /**
     * Actualizar consulta
     * @param consulta - Objeto con los datos correspondientes
     * @throws NotFoundException 
     */
    @Override
    public void actualizar(Consulta consulta) throws NotFoundException {
        consultaRepository.actualizar(consulta);
    }

    @Override
    public Consulta leer(Short s) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> leer() throws NoContentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Short s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
