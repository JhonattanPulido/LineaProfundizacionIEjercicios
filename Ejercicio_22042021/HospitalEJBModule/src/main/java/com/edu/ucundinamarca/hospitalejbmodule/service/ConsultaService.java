// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service;

// Librerías
import javax.ejb.EJB;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IConsultaService;
import com.edu.ucundinamarca.hospitalejbmodule.repository.interfaz.IConsultaRepository;

/**
 * Servicio de consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
 */
@Stateless
public class ConsultaService implements IConsultaService {
    
    // Variables
    
    /**
     * 
     */
    @EJB
    private IConsultaRepository consultaRepository;
    
    /**
     * Variable consulta auxiliar     
     */
    private Consulta consulta;
    
    /**
     * Lista auxiliar de consultas
     */
    private List<Consulta> listaConsultas;
    
    // Métodos

    /**
     * Crear consulta
     * @param consulta 
     */
    @Override
    public void crear(Consulta consulta) {
        consultaRepository.crear(consulta);
    }   

    /**
     * Leer consulta
     * @param id - ID de la consulta
     * @return Objeto con los datos de la consulta
     */
    @Override
    public Consulta leer(Short id) throws   NotFoundException {   
        
        consulta = consultaRepository.leer("LeerConsulta", id);   
        
        if (consulta != null)
            return consulta;
        
        throw new NotFoundException("No se encontró la consulta");
    }

    /**
     * Leert todas las consultas almacenadas
     * @return Lista de consultas
     * @throws NoContentException 
     */
    @Override
    public List<Consulta> leer() throws NoContentException {
        
        listaConsultas = consultaRepository.leer();
        
        if (listaConsultas != null && listaConsultas.size() > 0)           
            return listaConsultas;
        
        throw new NoContentException("");
    }
    
    /**
     * Actualizar consulta
     * @param consulta - Objeto con los datos de la consulta
     * @throws NotFoundException 
     */
    @Override
    public void actualizar(Consulta consulta) throws    NotFoundException {
        
        if (consultaRepository.cantidadRegistros("QConsultas", consulta.getId()) == 1)
            consultaRepository.actualizar(consulta);
        
        throw new NotFoundException("No se encontró la consulta");
    }

    /**
     * Eliminar consulta
     * @param id - ID de la consulta
     * @throws NotFoundException 
     */
    @Override
    public void eliminar(Short id) throws   NotFoundException {
        
        if (consultaRepository.cantidadRegistros("QConsultas", id) == 1)            
            consultaRepository.eliminar(consultaRepository.leer("LeerConsulta", id));        
        
        throw new NotFoundException("No se encontró la consulta");                   
    }
    
}
