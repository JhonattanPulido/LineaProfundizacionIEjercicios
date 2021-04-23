// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service;

// Librerías
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IConsultaRepository;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IConsultaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.NoContentException;

/**
 * Servicio de consulta
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
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
    
    @Override
    public void crear(Consulta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consulta leer(String queryName, Short id) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> leer() throws NoContentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Actualizar consulta
     * @param queryName
     * @param consulta
     * @throws NotFoundException 
     */
    @Override
    public void actualizar(String queryName, Consulta consulta) throws NotFoundException {
        
        if (consultaRepository.cantidadRegistrosId("QConsultas", consulta.getId()) == 1)
            consultaRepository.actualizar(consulta);  
        
        throw new NotFoundException("No se encontró la consulta");
    }

    /**
     * Eliminar consulta
     * @param queryName
     * @param consulta
     * @throws NotFoundException 
     */
    @Override
    public void eliminar(String queryName, Consulta consulta) throws NotFoundException {
        
        if (consultaRepository.cantidadRegistrosId("QConsultas", consulta.getId()) == 1)
            consultaRepository.eliminar(consulta);  
        
        throw new NotFoundException("No se encontró la consulta");
    }
    
}
