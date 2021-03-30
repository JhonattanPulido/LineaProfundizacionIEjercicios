/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.ucundinamarca.estudiantewebapplication.exception.filter;

import com.edu.ucundinamarca.estudianteejb.exception.IntegridadException;
import com.edu.ucundinamarca.estudiantewebapplication.pojo.ErrorDto;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author jhona
 */
@Provider
public class IntegridadExceptionFilter implements ExceptionMapper<IntegridadException> {

    @Override
    public Response toResponse(IntegridadException e) {
        ErrorDto error = new ErrorDto(e.getMessage(), e.getStackTrace()[0].toString());        
        return Response.status(Response.Status.CONFLICT)
                        .entity(error)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build();
    }            
}
