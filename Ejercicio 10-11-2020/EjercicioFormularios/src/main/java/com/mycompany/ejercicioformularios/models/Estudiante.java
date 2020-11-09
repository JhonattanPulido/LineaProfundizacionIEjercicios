// Paquetes
package com.mycompany.ejercicioformularios.models;

// Importaciones
import java.io.Serializable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Clase estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 09/11/2020
 * @version 1.0.0
 */
public class Estudiante implements Serializable {
    
    // Variables
    
    /**
     * Nombre del estudiante
     */
    private String nombre;
    
    /**
     * Apellido del estudiante
     */
    private String apellido;
    
    /**
     * Promedio del estudiante
     */
    private float promedio;
    
    /**
     * Código del estudiante
     */    
    @Pattern(regexp="[0-9]{9}", message = "ERROR (Código): Debe ingresar números entre el 0 y el 9, 9 dígitos")
    private String codigo;
    
    /**
     * Clave del estudiante
     */    
    @Size(min=8, max=20, message = "ERROR (Clave): La clave tiene mínimo 8 y máximo 20 dígitos")    
    private String clave;             

    /**
     * Constructor de la clase estudiante
     */
    public Estudiante() {
        
    }        
    
    // Métodos Set & Get

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

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }          

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }        
}
