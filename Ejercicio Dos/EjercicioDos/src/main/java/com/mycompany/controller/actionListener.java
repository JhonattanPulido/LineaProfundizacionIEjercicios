/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author SANDRA
 */
@Named(value = "actionListener")
@Dependent
public class actionListener {

      private String texto;
    /**
     * Creates a new instance of action
     */
    public actionListener() {
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @PostConstruct
    public void inicial(){
        texto = "";
    }

}
