// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service;

// Librerías
import javax.ejb.EJB;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.hospitalejbmodule.entity.Medico;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IMedicoService;
import com.edu.ucundinamarca.hospitalejbmodule.repository.interfaz.IMedicoRepository;

/**
 * Servicio de médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Stateless
public class MedicoService implements IMedicoService {

    // Variables     
    
    /**
     * 
     */
    @EJB
    private IMedicoRepository medicoRepository;     
    
    /**
     * Médico
     */
    private Medico medico;
    
    /**
     * Lista de médicos
     */
    private List<Medico> listaMedicos;
    
    // Métodos   
    
    /**
     * Crear médico
     * @param medico - Objeto con los datos del médico
     */
    @Override
    public void crear(Medico medico) {        
        //medicoRepository.crear(medico);        
        System.out.println("Cantidad de médicos con id 1: " + medicoRepository.cantidadRegistros("QMedicos", (short) 1));
    }

    /**
     * Leer médico filtrado por id
     * @param id - ID del médico
     * @return Objeto con los datos del médico
     */
    @Override
    public Medico leer(Short id) throws NotFoundException {
        
        medico = medicoRepository.leer("LeerMedico", id);
        
        if (medico != null)
            return medico;
        
        throw new NotFoundException("No se encontró el médico");
    }
    
    /**
     * Leer todos los médicos registrados
     * @return Lista de los médicos registrados
     */
    @Override
    public List<Medico> leer() throws   NoContentException {
        listaMedicos = medicoRepository.leer();
        if (listaMedicos != null && listaMedicos.size() > 0)            
            return listaMedicos;
        
        throw new NoContentException("");
    }
    
    /**
     * Actualizar médico
     * @param medico 
     */
    @Override
    public void actualizar(Medico medico) throws    NotFoundException {  
        
        this.medico = leer(medico.getId()); // Cambiar
        
        if (this.medico != null)
            medicoRepository.actualizar(medico);
        
        throw new NotFoundException("No se encontró el médico");
    }          

    /**
     * Eliminar médico
     * @param id - ID del médico
     */
    @Override
    public void eliminar(Short id) throws   NotFoundException {
        
        medico = leer(id); // Cambiar
        
        if (medico != null)
            medicoRepository.eliminar(medico);
        
        throw new NotFoundException("No se encontró el médico");
    }
        
}
