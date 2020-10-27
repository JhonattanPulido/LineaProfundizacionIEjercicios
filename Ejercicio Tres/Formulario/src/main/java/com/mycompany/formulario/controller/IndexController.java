// Librerías
package com.mycompany.formulario.controller;
import com.mycompany.formulario.classess.Trabajador;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * Controlador de la vista Index
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 26/10/2020
 * @version 1.0.0
 */
@Named(value = "indexController")
@RequestScoped
public class IndexController {

    // Variables
    
    /**
     * Variable que contiene los datos del trabajador
     */
    private Trabajador trabajador;
    
    /**
     * Lista con los idiomas que puede registrar el trabajador
     */
    private List<String> listaIdiomas;
    
    /**
     * Lista con los niveles de estudio que el trabajador puede seleccionar
     */
    private List<String> listaNivelesEstudio;               
    
    /**
     * Salario total del trabajador
     */
    private int salarioTotal;
    
    /**
     * Constructor de la clase IndexController
     */
    public IndexController() {
        
        trabajador = new Trabajador();        
        
        // Añadiendo los idiomas disponibles para el trabajador
        listaIdiomas = new ArrayList<>();
        listaIdiomas.add("Inglés");
        listaIdiomas.add("Francés");
        listaIdiomas.add("Chino");
        
        // Añadiendo los niveles de estudio disponibles para el trabajador
        listaNivelesEstudio = new ArrayList<>();
        listaNivelesEstudio.add("Primaria");
        listaNivelesEstudio.add("Secundaria");
        listaNivelesEstudio.add("Técnico");
        listaNivelesEstudio.add("Tecnologo");
        listaNivelesEstudio.add("Profesional");
        listaNivelesEstudio.add("Magister");
    }
    
    // Métodos
    
    /**     
     * Cambia el valor del salario total del trabajador
     */
    public void calcularSalario() {
        salarioTotal = trabajador.calcularSalarioTotal();
    }
    
    // Métodos Set & Get  

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }        

    public int getSalarioTotal() {
        return salarioTotal;
    }          
    
    public List<String> getListaIdiomas() {
        return listaIdiomas;
    }

    public List<String> getListaNivelesEstudio() {
        return listaNivelesEstudio;
    }        
}
