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
@Named(value = "action")
@Dependent
public class action {
    public void click(){
        System.out.println("click...");
    }

    
}
