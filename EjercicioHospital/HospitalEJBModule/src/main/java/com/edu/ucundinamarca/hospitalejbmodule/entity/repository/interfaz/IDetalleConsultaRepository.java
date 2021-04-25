/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.ucundinamarca.hospitalejbmodule.entity.repository.interfaz;

import com.edu.ucundinamarca.hospitalejbmodule.entity.DetalleConsulta;
import javax.ejb.Local;

/**
 *
 * @author Sandra Moreno
 */
@Local
public interface IDetalleConsultaRepository extends IGenericaRepository<DetalleConsulta> {
    
    public void eliminarDetalle(int id);
}
