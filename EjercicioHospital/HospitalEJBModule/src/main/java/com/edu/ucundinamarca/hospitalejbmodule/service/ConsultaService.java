// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.service;

// Librerías
import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.entity.DetalleConsulta;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IConsultaRepository;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IDetalleConsultaRepository;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import com.edu.ucundinamarca.hospitalejbmodule.service.interfaz.IConsultaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.NoContentException;

/**
 * Servicio de consulta
 *
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Stateless
public class ConsultaService implements IConsultaService {

    // Variables
    /**
     * Variable auxiliar del objeto consulta
     */
    private Consulta consulta;

    /**
     * Lista auxiliar de lista de consultas
     */
    private List<Consulta> listaConsultas;

    /**
     * EJB de consulta
     */
    @EJB
    private IConsultaRepository consultaRepository;

    @EJB
    private IDetalleConsultaRepository detalleRepository;

    // Métodos
    /**
     * Crear consulta
     *
     * @param consulta - Objeto consulta
     */
    @Override
    public void crear(Consulta consulta) {
        if (consulta.getListaDetallesConsultas() != null) {
            for (DetalleConsulta dc : consulta.getListaDetallesConsultas()) {
                dc.setConsulta(consulta);
            }
        }
        consultaRepository.crear(consulta);
    }

    /**
     * Leer consulta por id
     *
     * @param id - id de la consulta
     * @return Objeto con los datos de la consulta
     * @throws NotFoundException
     */
    @Override
    public Consulta leer(Short id) throws NotFoundException {
        consulta = consultaRepository.leer("LeerConsulta", id);

        if (consulta != null) {

            List<DetalleConsulta> detalles = consulta.getListaDetallesConsultas();
            for (DetalleConsulta detalle : detalles) {
                detalle.setConsulta(null);

            }

            consulta.getMedico().setListaConsultas(null);

            return consulta;
        } else {
            throw new NotFoundException("No se encontra la consulta solicitada");
        }

    }

    /**
     * Leer todas las consultas
     *
     * @return lista de consultas
     * @throws NoContentException
     */
    @Override
    public List<Consulta> leer() throws NoContentException {

        listaConsultas = consultaRepository.leer("LeerTodasConsulta");

        if (listaConsultas != null && listaConsultas.size() > 0) {
            for (Consulta doc : listaConsultas) {
                List<DetalleConsulta> detalles = doc.getListaDetallesConsultas();
                for (DetalleConsulta detalle : detalles) {
                    detalle.setConsulta(null);

                }

                doc.getMedico().setListaConsultas(null);
            }
            return listaConsultas;
        } else {
            throw new NoContentException("La lista no tiene ningun contenido");
        }

    }

    /**
     * Actualizar consulta
     *
     * @param consulta
     * @throws NotFoundException
     */
    @Override
    public void actualizar(Consulta consulta) throws NotFoundException {

        if (consultaRepository.cantidadRegistrosId("QConsultas", consulta.getId()) == 1) {
            consultaRepository.actualizar(consulta);
        }

        throw new NotFoundException("No se encontró la consulta");
    }

    /**
     * Eliminar consulta
     *
     *
     * @throws NotFoundException
     */
    @Override
    public void eliminar(Short id) throws NotFoundException {
        consulta = this.leer(id);
        List<DetalleConsulta> detalles = consulta.getListaDetallesConsultas();
        for (DetalleConsulta detalle : detalles) {
            detalleRepository.eliminarDetalle(detalle.getId());
        }

        consultaRepository.eliminarConsulta(id);

    }

}
