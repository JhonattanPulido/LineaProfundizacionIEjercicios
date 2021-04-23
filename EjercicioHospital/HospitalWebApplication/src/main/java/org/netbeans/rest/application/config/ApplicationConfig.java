/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Sandra Moreno
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.controllers.ConsultaController.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.controllers.MedicoController.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.BadRequestExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.IntegridadExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.JsonParsingExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.MethodNotAllowedFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.NoContentExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.NotFoundExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.NullPointerExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.UnsupportedMediaTypeExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.hospitalwebapplication.exception.filters.WSNotFoundExceptionFilter.class);
    }
    
}
