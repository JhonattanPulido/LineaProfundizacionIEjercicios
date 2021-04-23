// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity;

// Librerías
import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Entidad dirección
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Entity
@Table(name = "direccion", schema = "public")
public class Direccion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Null
    private Short id;
    
    @Column(name = "codigo_postal")
    @NotNull(message = "El código postal es obligatorio")
    @Size(min = 6, max = 6, message = "El código postal debe tener 6 números")
    private String codigoPostal;
    
    @Column(name = "direccion_detallada")
    @NotNull(message = "La dirección detallada es obligatoria")
    @Size(min = 2, max = 80, message = "La dirección debe tener mínimo 2 y máximo 80 caracteres")
    private String direccionDetallada;    
    
    @OneToOne
    @JsonbTransient
    @JoinColumn(name = "medico_id")
    @NotNull(message = "El médico asociado es necesario")
    private Medico medico;

    /**
     * Constructor
     */
    public Direccion() {
        
    }

    // Métodos Set & Get
    
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccionDetallada() {
        return direccionDetallada;
    }

    public void setDireccionDetallada(String direccionDetallada) {
        this.direccionDetallada = direccionDetallada;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
}
