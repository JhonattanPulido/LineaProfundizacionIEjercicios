// Paquetes
package com.edu.ucundinamarca.hospitalejb.entity;

// Librerías
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

/**
 * Entidad médico
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Entity
@Table(name = "medicos", schema = "public")
public class Medico implements Serializable {
    
    // Variables
    
    /**
     * ID del médico
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Null
    private Short id;
    
    /**
     * Nombre del médico
     */
    @Column(name = "nombre")
    @NotNull(message = "El nombre es necesario")
    @Size(min = 2, max = 24, message = "El nombre debe tener mínimo 2 y máximo 24 letras")
    private String nombre;
}
