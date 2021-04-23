// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity;

// Librerías
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.NotNull;

/**
 * Entidad detalle consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
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
    @NotNull
    private String diagnositco;
    
    /**
     * Tratamiento de la consulta
     */
    @Column(name = "tratamiento")
    private String tratamiento;
    
    /**
     * Consulta asociada
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "consulta_id")
    @NotNull
    private Consulta consulta;

    /**
     * Constructor
     */
    public DetalleConsulta() {
        
    }

    /**
     * Constructor con parámetros
     * @param id
     * @param diagnositco
     * @param tratamiento
     * @param consulta 
     */
    public DetalleConsulta(Short id, String diagnositco, String tratamiento, Consulta consulta) {
        this.id = id;
        this.diagnositco = diagnositco;
        this.tratamiento = tratamiento;
        this.consulta = consulta;
    }

    // Métodos Set & Get
    
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDiagnositco() {
        return diagnositco;
    }

    public void setDiagnositco(String diagnositco) {
        this.diagnositco = diagnositco;
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
