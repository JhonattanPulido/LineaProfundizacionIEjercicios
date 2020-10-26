/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author SANDRA
 */
@Named(value = "conversationController")
@ConversationScoped
public class ConversationController implements Serializable {

    /**
     * Creates a new instance of ConversationController
     */
    public ConversationController() {
    }
    
    private int numero = 0;
    
    @Inject
    private Conversation conversation;
        

    public void contar(){
        numero++;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
     }
}
