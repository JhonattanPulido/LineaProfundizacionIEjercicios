// Paquetes
package com.edu.ucundinamarca.estudianteejbmodule.entity;

// Librerías
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

/**
 * Entidad Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 30/03/2021
 * @version 1.0.0
 */
@Entity
@Table(name = "estudiante", schema = "public")
public class Estudiante implements Serializable {
    
    // Variables
    
    @Id
    @NotNull(message = "El ID es requerido")
    @Min(value = 0, message = "El ID debe ser un número igual o mayor a 0")
    private Short id;
    
    @Column(name = "nombre")
    @NotNull(message = "El nombre es requerido")
    @Size(min = 2, max = 26, message = "El nombre debe tener mínimo 2 y máximo 26 letras")
    private String nombre;
    
    @Column(name = "apellido")
    @NotNull(message = "El apellido es requerido")
    @Size(min = 2, max = 26, message = "El apellido debe tener mínimo 2 y máximo 26 letras")
    private String apellido;
    
    @Column(name = "edad")
    @NotNull(message = "La edad es requerida")
    @Min(value = 14, message = "La edad debe ser mínimo 14 años")
    @Max(value = 28, message = "La edad debe ser máximo 28 años")
    private Short edad;
    
    @Column(name = "numero_documento")
    @NotNull(message = "El número de documento es requerido")
    @Size(min = 6, max = 10, message = "El número de documento debe tener mínimo 6 y máximo 10 números")
    private String numeroDocumento;

    /**
     * Constructor
     */
    public Estudiante() {
        
    }   
    
    // Métodos Set & Get

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }        
}
