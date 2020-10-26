/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 * Controlador de Conversation
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 26/10/2020
 */
@Named(value = "conversationController")
@ConversationScoped
public class ConversationController implements Serializable {

    /**
     * Creates a new instance of ConversationController
     */
    //Constructor
    public ConversationController() {
    }
    
    //Numero contador
    private int numero = 0;
    
    //Bean que controla el ciclo de vida de la conversación
    //Se obtiene por medio de inyección
    @Inject
    private Conversation conversation;
        
    //Funcion de contar
    public void contar(){
        numero++;
    }
    
    public void iniciarConversacion(){
        if(conversation.isTransient())
            conversation.begin();
    }
    
    public void finConversacion(){
        if(!conversation.isTransient())
            conversation.end();
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
     }
}
