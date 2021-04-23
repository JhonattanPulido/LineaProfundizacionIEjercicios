// Paquetes
package com.edu.ucundinamarca.hospitalejb.entity;

// Librerías
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

/**
 * Entidad detalle consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 20/04/2021
 */
@Entity
@Table(name = "detalles_consultas", schema = "public")
public class DetalleConsulta implements Serializable {
    
    // Variables
    
    /**
     * ID del detalle de la consulta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Null
    private Short id;
    
    /**
     * Diagnóstico de la consulta
     */
    @Column(name = "diagnostico")
    @NotNull(message = "El diagnóstico es obligatorio")
    @Size(min = 2, max = 24, message = "El diagnóstico debe tener mínimo 2 y máximo 24 caracteres")
    private String diagnostico;
    
    /**
     * Tratamiento de la consulta
     */
    @Column(name = "tratamiento")
    @NotNull(message = "El tratamiento es obligatorio")
    @Size(min = 2, max = 50, message = "El tratamiento debe tener mínimo 2 y máximo 50 caracteres")
    private String tratamiento;
    
    /**
     * Consulta asociada a detalle consulta
     */    
    @ManyToOne
    @JoinColumn(name = "consulta_id")
    @NotNull
    private Consulta consulta;    
    
    /**
     * Constructor de la clase
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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }        
}
