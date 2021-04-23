//Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service;

//Librerias
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IMedicoRepository;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IMedicoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.NoContentException;

/**
 * Servicio de Medico
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Stateless
public class MedicoService implements IMedicoService {
       // Variables
    
    /**
    * Variable auxiliar del objeto medico
    */
    private Medico medico;
    
    /**
    * Lista auxiliar de lista de Medicos
    */
    private List<Medico> listaMedicos;
    
    /**
     * EJB de medico
     */
    @EJB
    private IMedicoRepository medicoRepository;
    
    // Métodos
    
    /**
    * Crear medico
    * @param medico - Objeto medico
    */
    @Override
    public void crear(Medico medico) {
        medicoRepository.crear(medico);
    }
    
    /**
    * Leer medico por id
    * @param id - id del medico
    * @return Objeto con los datos del medico
    * @throws NotFoundException
    */
    @Override
    public Medico leer(Short id) throws NotFoundException {
        medico = medicoRepository.leer("LeerMedico", id);
        
        if(medico != null)
            return medico;
        throw new NotFoundException("No se encontra el medico solicitado");
    }
    
    /**
    * Leer todos los medicos
    * @return lista de consultas
    * @throws NoContentException
    */
    @Override
    public List<Medico> leer() throws NoContentException {
        
        listaMedicos = medicoRepository.leer("LeerTodosMedico");
        
        if (listaMedicos != null && listaMedicos.size() > 0)           
            return listaMedicos;
        
        throw new NoContentException("La lista no tiene ningun contenido");
    }
    
    /**
    * Actualizar Medico
    * @param medico
    * @throws NotFoundException 
    */
    @Override
    public void actualizar(Medico medico) throws NotFoundException {
               
        if (medicoRepository.cantidadRegistrosId("QMedicos", medico.getId()) == 1)
            medicoRepository.actualizar(medico);  
        
        throw new NotFoundException("No se encontró el medico");
    }
    
    /**
    * Eliminar Medico
    * @param id
    * @throws NotFoundException 
    */
    @Override
    public void eliminar(Short id) throws NotFoundException {
                
        if (medicoRepository.cantidadRegistrosId("QMedicos", medico.getId()) == 1)
            medicoRepository.eliminar(medico);  
        
        throw new NotFoundException("No se encontró el medico");
    }
    
}
