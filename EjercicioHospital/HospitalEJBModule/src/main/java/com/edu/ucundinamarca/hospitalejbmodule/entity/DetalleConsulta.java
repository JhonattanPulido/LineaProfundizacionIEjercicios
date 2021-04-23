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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Entidad detalle consulta
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Entity
@Table(name = "detalles_consultas", schema = "public")
public class DetalleConsulta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Null
    private Short id;
    
    @Column(name = "tratamiento")
    @NotNull(message = "El tratamiento es obligatorio")
    @Size(min = 2, max = 50, message = "El tratamiento debe tener mínimo 2 y máximo 50 caracteres")
    private String tratamiento;
    
    @Column(name = "diagnostico")
    @NotNull(message = "El diagnóstico es obligatorio")
    @Size(min = 2, max = 50, message = "El diagnóstico debe tener mínimo 2 y máximo 50 caracteres")
    private String diagnostico;        
    
    @ManyToOne
    @JsonbTransient
    @JoinColumn(name = "consulta_id")
    @NotNull(message = "La consulta es obligatoria")
    private Consulta consulta;

    /**
     * Constructor
     */
    public DetalleConsulta() {
        
    }   
    
    // Métodos Set & Get

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
}
