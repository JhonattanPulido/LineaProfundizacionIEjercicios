// Paquetes
package com.edu.ucundinamarca.hospitalejb.service;

// Librerías
import javax.ejb.EJB;
import javax.ws.rs.NotFoundException;
import com.edu.ucundinamarca.hospitalejb.entity.Medico;
import com.edu.ucundinamarca.hospitalejb.repository.interfaz.IMedicoRepository;
import com.edu.ucundinamarca.hospitalejb.service.interfaz.IMedicoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.NoContentException;

/**
 * Servicio del médico
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
    
    // Métodos
    
    /**
     * Crear médico
     * @param medico - Objeto con los datos del médico
     */
    @Override
    public void crear(Medico medico) {
        medicoRepository.crear(medico);
    }

    /**
     * Actualizar médico
     * @param medico - Objeto con los datos del médico
     * @throws NotFoundException 
     */
    @Override
    public void actualizar(Medico medico) throws NotFoundException {
        medicoRepository.actualizar(medico);
    }

    @Override
    public Medico leer(Short s) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medico> leer() throws NoContentException {
        return medicoRepository.leer();
    }

    @Override
    public void eliminar(Short s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
