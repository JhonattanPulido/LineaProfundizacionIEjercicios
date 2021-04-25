// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity;

// Librerías
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Entidad consulta
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "QConsultas", query = "SELECT COUNT(c.id) FROM Consulta c WHERE c.id = :id"),
    @NamedQuery(name = "LeerConsulta", query = "SELECT c FROM Consulta c WHERE c.id = :id"),
    @NamedQuery(name = "LeerTodasConsulta", query = "SELECT c FROM Consulta c")
})
@Table(name = "consultas", schema = "public")
public class Consulta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    private Short id;        
    
    @OneToOne
    @JoinColumn(name = "medico_id")    
    private Medico medico;
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleConsulta> listaDetallesConsultas;

    /**
     * Constructor
     */
    public Consulta() {
        
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
