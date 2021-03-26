// Paquetes
package com.edu.ucundinamarca.estudianteejb.entity;

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
 * Entidad de Estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 25/03/2021
 * @version 1.0.0
 */
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {
    
    /**
     * ID del estudiante
     */
    @Id
    @NotNull(message = "El ID es requerido")
    @Min(value = 0, message = "El ID debe ser un número igual o mayor a 0")
    private Integer id;
    
    /**
     * Nombre del estudiante
     */
    @Column(columnDefinition = "nombre")
    @NotNull(message = "El nombre es requerido")
    @Size(min = 2, max = 26, message = "El nombre debe tener mínimo 2 y máximo 26 letras")
    private String nombre;
    
    /**
     * Apellido del estudiante
     */
    @Column(columnDefinition = "apellido")
    @NotNull(message = "El apellido es requerido")
    @Size(min = 2, max = 26, message = "El apellido debe tener mínimo 2 y máximo 26 letras")
    private String apellido;       
    
    /**
     * Edad del estudiante
     */
    @Column(columnDefinition = "edad")
    @NotNull(message = "La edad es requerida")
    @Min(value = 14, message = "La edad debe ser mínimo 14 años")
    @Max(value = 28, message = "La edad debe ser máximo 28 años")
    private Short edad;
    
    /**
     * Número de documento del estudiante
     */
    @Column(columnDefinition = "numero_documento")
    @NotNull(message = "El número de documento es requerido")
    @Size(min = 6, max = 10, message = "El número de documento debe tener mínimo 6 y máximo 10 números")
    private String numeroDocumento;

    /**
     * Constructor
     */
    public Estudiante() {
        
    }        

    // Métodos Set & Get
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
