// Paquetes
package com.edu.ucundinamarca.webapiestudiante.controllers;
import com.edu.ucundinamarca.webapiestudiante.data.DEstudiante;
import com.edu.ucundinamarca.webapiestudiante.pojos.Estudiante;
import java.util.ArrayList;

// Importaciones
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Controlador estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @version 1.0.0
 * @since 03/03/2021
 */
@Stateless
@Path("/estudiante")
public class EstudianteController {
    
    /**
     * Método para obtener todos los estudiantes registrados
     * @return lista de estudiantes
     */
    @GET
    @Path("/leer")
    public ArrayList<Estudiante> leerEstudiantes() throws Exception {
        try {
            return new DEstudiante().leerEstudiantes();
        } catch (Exception ex) {
            return null;
        }        
    }
    
    /**
     * Método para obtener un estudiante filtrado por id
     * @param id - Identificación del estudiante
     * @return estudiante
     */
    @GET
    @Path("/leer/{ id }")
    public Estudiante leerEstudiante(@PathParam("id") short id) {
        try {
            return new DEstudiante().leerEstudiante(id);
        } catch (Exception ex) {
            return null;
        }  
    }
}
