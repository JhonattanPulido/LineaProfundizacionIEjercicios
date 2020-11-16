// Paquetes
package com.disquera.proyectodisquera.models;

// Librerías
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase disco
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 16/11/2020
 */

@Entity
@Table(name = "disco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disco.findAll", query = "SELECT d FROM Disco d"),
    @NamedQuery(name = "Disco.findById", query = "SELECT d FROM Disco d WHERE d.id = :id"),
    @NamedQuery(name = "Disco.findByNombre", query = "SELECT d FROM Disco d WHERE d.nombre = :nombre")})

public class Disco implements Serializable {

    // Variables
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Id del disco
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    
    /**
     * Nombre del disco
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    
    /**
     * Precio del disco
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    
    /**
     * Id del artista al que pertenece el disco
     */
    @JoinColumn(name = "artista_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Artista artistaId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discoId")
    private List<Cancion> cancionList;

    /**
     * Constructor de la clase
     */
    public Disco() {
        
    }

    /**
     * Constructor de la clase
     * @param id - Id del disco
     */
    public Disco(Short id) {
        this.id = id;
    }

    /**
     * Constructor de la clase
     * @param id - Id del disco
     * @param nombre - Nombre del disco
     * @param precio - Precio del disco
     */
    public Disco(Short id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }    

    // Métodos
    
    
    
    // Métodos predeterminados
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disco)) {
            return false;
        }
        Disco other = (Disco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.disquera.proyectodisquera.models.Disco[ id=" + id + " ]";
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Artista getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Artista artistaId) {
        this.artistaId = artistaId;
    }

    @XmlTransient
    public List<Cancion> getCancionList() {
        return cancionList;
    }

    public void setCancionList(List<Cancion> cancionList) {
        this.cancionList = cancionList;
    }
}
