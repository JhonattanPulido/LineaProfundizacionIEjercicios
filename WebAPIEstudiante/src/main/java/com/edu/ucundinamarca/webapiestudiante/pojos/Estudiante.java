// Paquetes
package com.edu.ucundinamarca.webapiestudiante.pojos;

// Librerías
import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase estudiante
 * @author Sandra Milena - Jhonattan Pulido
 * @version 1.0.0
 * @since 03/03/2021
 */
public class Estudiante implements Serializable {
    
    // Variables
    
    /**
     * Id del estudiante
     */    
    @Min(value = 0, message = "El id debe ser mayor a 0")
    private short id;
    
    /**
     * Nombre del estudiante
     */
    @NotNull(message = "El nombre es requerido")
    @Size(min = 2, max = 50, message = "El nombre debe tener mínimo 2 y máximo 50 caracteres")
    private String nombre;
    
    /**
     * Apellido del estudiante
     */
    @NotNull(message = "El apellido es requerido")
    @Size(min = 2, max = 50, message = "El apellido debe tener mínimo 2 y máximo 50 caracteres")
    private String apellido;
    
    /**
     * Número de documento del estudiante
     */
    @NotNull(message = "El número de documento es requerido")
    @Size(min = 6, max = 10, message = "El número de documento debe tener mínimo 6 y máximo 10 caracteres")
    private String numeroDocumento;
    
    /**
     * Constructor vacio de la clase estudiante
     */
    public Estudiante() {
        
    }

    /**
     * Constructor con parámetros de la clase estudiante
     * @param id - Identificación del estudiante
     * @param nombre - Nombre del estudiante
     * @param apellido - Apellido del estudiante
     * @param numeroDocumento - Número de documento del estudiante
     */
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
