// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity;

// Librerías
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Null;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Entidad consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 21/04/2021
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "QConsultas", query = "SELECT COUNT(c.id) FROM Consulta c WHERE c.id = :id"),
    @NamedQuery(name = "LeerConsulta", query = "SELECT c FROM Consulta c WHERE c.id = :id")
})
@Table(name = "consultas", schema = "public")
public class Consulta implements Serializable {
    
    // Variables
    
    /**
     * ID de la consulta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Null
    private Short id;
    
    /**
     * Fecha de la consulta
     */
    /*@Column(name = "fecha")
    @NotNull
    private LocalDateTime fecha;*/
    
    /**
     * Médico de la consulta
     */
    @OneToOne
    @JoinColumn(name = "medico_id")
    @NotNull
    private Medico medico;   
    
    /**
     * Lista de detalles de consulta
     */
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleConsulta> listaDetallesConsultas;

    /**
     * Constructor
     */
    public Consulta() {
        
    }           
    
    /**
     * Constructor con parámetros
     * @param id     
     * @param medico 
     */
    public Consulta(Short id, Medico medico) {
        this.id = id;        
        this.medico = medico;
    }
    
    // Métodos Set & Get
    
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }    

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }   

    public List<DetalleConsulta> getListaDetallesConsultas() {
        return listaDetallesConsultas;
    }

    public void setListaDetallesConsultas(List<DetalleConsulta> listaDetallesConsultas) {
        this.listaDetallesConsultas = listaDetallesConsultas;
    }
    
}
