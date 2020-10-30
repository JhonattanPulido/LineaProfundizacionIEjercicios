/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author SANDRA
 */
@Named(value = "actionListener")
//@Dependent
public class actionListener implements ActionListener {

   public void actionEvento(ActionEvent event){
       System.out.println("Metodo del evento");
   }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Hola mijo!");
    }

}
