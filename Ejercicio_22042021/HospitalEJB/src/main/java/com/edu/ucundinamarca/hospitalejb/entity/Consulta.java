// Paquetes
package com.edu.ucundinamarca.hospitalejb.entity;

// Librerías
import java.io.Serializable;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import javax.validation.constraints.NotNull;

/**
 * Entidad consulta
 * @author Jhonattan Pulido
 * @version 1.0.0
 * @since 22/04/2021
 */
@Entity
@Table(name = "consultas", schema = "public")
public class Consulta implements Serializable {
    
    /**
     * ID de la consulta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Null
    @Min(value = 1, message = "El ID debe ser igual o mayor a 1")
    private Short id;
    
    /**
     * Fecha de la consulta
     */
    @Column(name = "fecha")
    @NotNull(message = "Fecha es obligatoria")
    private LocalDateTime fecha;
    
    /**
     * Médico asociado a la consulta
     */
    private Medico medico;
    
    /**
     * Lista de detalles de las consultas
     */
    @OneToMany( mappedBy = "consulta", // Colocar el nombre de la variable de DetalleConsulta
                cascade = CascadeType.ALL, // Especificar con que métodos quiere que se hagan operaciones en cascada
                orphanRemoval = true, // Siempre en true
                fetch = FetchType.LAZY // Por lo general en lazy
                ) 
    private List<DetalleConsulta> listaDetallesConsulta;

    /**
     * Constructor de la clase
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }        

    public List<DetalleConsulta> getListaDetallesConsulta() {
        return listaDetallesConsulta;
    }

    public void setListaDetallesConsulta(List<DetalleConsulta> listaDetallesConsulta) {
        this.listaDetallesConsulta = listaDetallesConsulta;
    }        
}
