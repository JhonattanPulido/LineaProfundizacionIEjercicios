// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity;

// Librerías
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = "QMedicos", query = "SELECT COUNT(m.id) FROM Medico m WHERE m.id = :id"),
    @NamedQuery(name = "LeerMedico", query = "SELECT m FROM Medico m WHERE m.id = :id")
})
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
    
    /**
     * Lista de consultas del médico
     */
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consulta> listaConsultas;
    
    /**
     * Constructor
     */
    public Medico() {    
        
    }

    /**
     * Constructor con parámetros
     * @param id
     * @param nombre 
     */
    public Medico(Short id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public List<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
    
}