// Librerías
package com.mycompany.formulario.classess;

import java.util.Date;
import java.util.List;

/**
 * Clase trabajador
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 26/10/2020
 * @version 1.0.0
 */
public class Trabajador {
    
    // Variables
    
    /**
     * Número de cédula del trabajador
     */
    private String numeroCedula;
    
    /**
     * Nombre del trabajador
     */
    private String nombre;
    
    /**
     * Apellido del trabajador
     */
    private String apellido;
    
    /**
     * Fecha de naciemiento del trabajador
     */
    private Date fechaNacimiento;
    
    /**
     * Nivel de estudio del trabajador
     */
    private String nivelEstudio;
    
    /**
     * Lista de idiomas hablados por el trabajador
     */
    private String[] listaIdiomas;
    
    /**
     * Número de días trabajados en el mes
     */
    private short numeroDiasTrabajados;
    
    /**
     * Sueldo base del trabajador
     */
    private int sueldoBase;

    /**
     * Constructor de la clase Trabajador
     */
    public Trabajador() {
        
    }         
    
    // Métodos
    
    /**
     * Calcula el salario del trabajador
     * @return el valor del salario total calculado
     */
    public int calcularSalarioTotal() {
        
        int sueldoTotal;
        
        sueldoTotal = sueldoBase * numeroDiasTrabajados;
        
        switch (nivelEstudio) {
        
            case "Técnico":
                sueldoTotal += 5000;
                break;
                
            case "Tecnologo":
                sueldoTotal += 15000;
                break;
                
            case "Profesional":
                sueldoTotal += 30000;
                break;
                
            case "Magister":
                sueldoTotal += 40000;
                break;
        }
        
        sueldoTotal += 10000 * listaIdiomas.length;
        
        return sueldoTotal;
    }
    
    // Métodos Set & Get

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }   

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String[] getListaIdiomas() {
        return listaIdiomas;
    }

    public void setListaIdiomas(String[] listaIdiomas) {
        this.listaIdiomas = listaIdiomas;
    }   

    public short getNumeroDiasTrabajados() {
        return numeroDiasTrabajados;
    }

    public void setNumeroDiasTrabajados(short numeroDiasTrabajados) {
        this.numeroDiasTrabajados = numeroDiasTrabajados;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }       
}