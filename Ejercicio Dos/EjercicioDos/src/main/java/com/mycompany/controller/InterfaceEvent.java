/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.inject.Named;

/**
 *
 * @author SANDRA
 */
@Named(value = "interfaceEvent")
public class InterfaceEvent implements ActionListener {

    /**
     * Creates a new instance of InterfaceEvent
     */
    public InterfaceEvent() {
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Interface Evento");
    }
    
}
