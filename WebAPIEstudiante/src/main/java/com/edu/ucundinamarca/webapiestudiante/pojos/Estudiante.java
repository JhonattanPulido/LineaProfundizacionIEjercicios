// Paquetes
package com.edu.ucundinamarca.webapiestudiante.pojos;

// Librerías
import java.io.Serializable;

/**
 * Clase estudiante
 * @author Sandra Milena - Jhonattan Pulido
 * @version 1.0.0
 * @since 03/03/2021
 */
public class Estudiante implements Serializable {
    
    // Variables
    private short id;
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    
    // Constructor
    public Estudiante() {
        
    }

    // Constructor con parámetros
    public Estudiante(short id, String nombre, String apellido, String numeroDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
    }       
    
    // Métodos set & get
    
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }    
}
