/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.awt.event.ActionEvent;
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

   public void actionEvento(ActionEvent event){
       System.out.println("Metodo del evento");
   }

}
