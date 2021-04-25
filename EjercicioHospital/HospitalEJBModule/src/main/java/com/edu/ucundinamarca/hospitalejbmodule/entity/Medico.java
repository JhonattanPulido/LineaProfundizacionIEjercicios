// Paquetes
package com.edu.ucundinamarca.hospitalejbmodule.entity;

// Librerías
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Entidad médico
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 23/04/2021
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "QMedicos", query = "SELECT COUNT(m.id) FROM Medico m WHERE m.id = :id"),
    @NamedQuery(name = "LeerMedico", query = "SELECT m FROM Medico m WHERE m.id = :id"),
    @NamedQuery(name = "LeerTodosMedico", query = "SELECT m FROM Medico m")
})
@Table(name = "medicos", schema = "public")
public class Medico implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Null
    private Short id;
    
    @Column(name = "nombre")
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 2, max = 24, message = "El nombre debe tener mínimo 2 y máximo 24 letras")
    private String nombre;
    
    @Column(name = "apellido")
    @NotNull(message = "El apellido es obligatorio")
    @Size(min = 2, max = 24, message = "El apellido debe tener mínimo 2 y máximo 24 letras")
    private String apellido;
    
    @Column(name = "correo_electronico")
    @NotNull(message = "El correo electrónico es obligatorio")
    private String correoElectronico;
    
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Consulta> listaConsultas;
    
    @OneToOne(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)    
    @NotNull(message = "La dirección es obligatoria")
    private Direccion direccion;

    /**
     * Constructor
     */
    public Medico() {
        
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @JsonIgnore
    public List<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }        

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
}
