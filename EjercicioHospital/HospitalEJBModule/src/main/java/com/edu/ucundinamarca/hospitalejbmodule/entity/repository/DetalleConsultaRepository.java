/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository;

import com.edu.ucundinamarca.hospitalejbmodule.entity.Consulta;
import com.edu.ucundinamarca.hospitalejbmodule.entity.DetalleConsulta;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IConsultaRepository;
import com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz.IDetalleConsultaRepository;
import com.edu.ucundinamarca.hospitalejbmodule.exception.NotFoundException;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sandra Moreno
 */
@Stateless
public class DetalleConsultaRepository extends GenericaRepository<DetalleConsulta> implements IDetalleConsultaRepository {

    @Override
    public void eliminarDetalle(int id) {
         em.createNativeQuery("DELETE FROM detalles_consultas WHERE id = ?1")
                .setParameter(1, id)
                .executeUpdate();
        }

  
    
}
