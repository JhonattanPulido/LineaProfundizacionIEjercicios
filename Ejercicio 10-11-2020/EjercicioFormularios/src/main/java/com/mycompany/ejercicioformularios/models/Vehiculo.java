// Paquetes
package com.mycompany.ejercicioformularios.models;

// Librerías
import java.io.Serializable;

/**
 * Clase vehículo
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 09/11/2020
 * @version 1.0.0
 */
public class Vehiculo implements Serializable {
    
    // Variables
    
    /**
     * Placa del vehículo
     */
    private String placa;
    
    /**
     * Marca del vehículo
     */
    private String marca;
    
    /**
     * Nombre del propietario
     */
    private String nombrePropietario;
    
    /**
     * Clave para ingresar a la plataforma
     */
    private String clave;

    /**
     * Constructor vacio de la clase vehículo
     */
    public Vehiculo() {
        
    }        
    
    // Métodos Set & Get

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }        
}
