// Paquetes
package com.edu.ucundinamarca.webapiestudiante.data;

// Importaciones
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.NoContentException;
import com.edu.ucundinamarca.webapiestudiante.pojos.Estudiante;
import com.edu.ucundinamarca.webapiestudiante.exceptions.IntegridadException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

/**
 * Clase datos estudiante
 * @author Sandra Moreno - Jhonattan Pulido
 * @since 03/03/2021
 * @version 1.0.0
 */
public class DEstudiante implements Serializable {
    
    // Variables
    private Connection dbContext;

    // Constructor
    public DEstudiante() throws Exception {
        
    }  

    // Métodos
    
    /**
     * Método para crear estudiante
     * @param estudiante - Objeto con los datos del estudiante   
     * @throws BadRequestException - Ocurre cuando la información no ha sido enviada correctamente
     * @throws IntegridadException - Ocurre cuando al registrar un nuevo estudiante, se encuentra que el número de documento ya existe
     * @throws SQLException - Ocurre cuando se encuentra un error al procesar alguna función el la base de datos
     * @throws ClassNotFoundException - Ocurre cuando no se encuentra el driver de PostgreSQL     
     */
    public void crearEstudiante(Estudiante estudiante) throws   BadRequestException,
                                                                IntegridadException,
                                                                SQLException,
                                                                ClassNotFoundException,
                                                                Exception {                       

        if (estudiante == null) throw new BadRequestException("La información no ha sido enviada correctamente");
        
        Class.forName("org.postgresql.Driver");            

        dbContext = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ejercicio_estudiante_db", 
            "postgres",
            "2220"    
        );

        CallableStatement funcion = dbContext.prepareCall("{ call f_crear_estudiante(?,?,?) }");
        funcion.setString(1, estudiante.getNombre());
        funcion.setString(2, estudiante.getApellido());                          
        funcion.setString(3, estudiante.getNumeroDocumento());            

        ResultSet respuesta = funcion.executeQuery();       

        boolean res = false;
        
        while (respuesta.next()) {                
            res = respuesta.getBoolean(1);
        }            

        if (!res) throw new IntegridadException("El número de documento ya está en uso.");
    }
    
    /**
     * Método para leer los estudiantes registrados
     * @return lista de estudiantes
     * @throws NoContentException - Ocurre cuando no hay estudiantes en la base de datos
     * @throws SQLException - Ocurre cuando se encuentra un error al procesar alguna función el la base de datos
     * @throws ClassNotFoundException - Ocurre cuando no se encuentra el driver de PostgreSQL          
     */
    public List<Estudiante> leerEstudiantes() throws    NoContentException,
                                                        SQLException,
                                                        ClassNotFoundException, 
                                                        Exception {
           
        Class.forName("org.postgresql.Driver");            
            
        dbContext = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ejercicio_estudiante_db", 
            "postgres",
            "2220"    
        );

        CallableStatement funcion = dbContext.prepareCall("{ call f_leer_estudiante() }");            

        ResultSet respuesta = funcion.executeQuery();                   

        List<Estudiante> listaEstudiantes = new ArrayList<>();

        while (respuesta.next()) {
            listaEstudiantes.add(new Estudiante(
                (short) respuesta.getShort("id"),
                respuesta.getString("nombre"),
                respuesta.getString("apellido"),
                respuesta.getString("numero_documento")
            ));
        }

        if (listaEstudiantes.size() > 0) return listaEstudiantes;

        throw new NoContentException("No hay estudiantes registrados.");
    }
    
    /**
     * Método para leer un estudiante filtrado por id
     * @param id - Identificación del usuario
     * @return los datos del estudiante
     * @throws NotFoundException - Ocurre cuando no se encuentra el usuario asociado al ID
     * @throws SQLException - Ocurre cuando se encuentra un error al procesar alguna función el la base de datos
     * @throws ClassNotFoundException - Ocurre cuando no se encuentra el driver de PostgreSQL          
     */
    public Estudiante leerEstudiante(short id) throws   NotFoundException,
                                                        SQLException,
                                                        ClassNotFoundException, 
                                                        Exception {
            
        Class.forName("org.postgresql.Driver");
                        
        dbContext = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ejercicio_estudiante_db", 
            "postgres",
            "2220"    
        );

        CallableStatement funcion = dbContext.prepareCall("{ call f_leer_estudiante_id(?) }");
        funcion.setShort(1, id);            

        ResultSet respuesta = funcion.executeQuery();                   

        while (respuesta.next()) {
            return new Estudiante(
                (short) respuesta.getShort("id"),
                respuesta.getString("nombre"),
                respuesta.getString("apellido"),
                respuesta.getString("numero_documento")
            );
        }                        

        throw new NotFoundException("No se encontró el estudiante");            
    }
    
    /**
     * Método para actualizar un estudiante
     * @param estudiante     
     * @throws BadRequestException - Ocurre cuando la información no ha sido enviada correctamente
     * @throws NotFoundException - Ocurre cuando no se encuentra el usuario asociado al ID
     * @throws IntegridadException - Ocurre cuando al registrar un nuevo estudiante, se encuentra que el número de documento ya existe
     * @throws SQLException - Ocurre cuando se encuentra un error al procesar alguna función el la base de datos
     * @throws ClassNotFoundException - Ocurre cuando no se encuentra el driver de PostgreSQL          
     */
    public void actualizarEstudiante(Estudiante estudiante) throws  BadRequestException,
                                                                    NotFoundException,
                                                                    IntegridadException,
                                                                    SQLException,
                                                                    ClassNotFoundException, 
                                                                    Exception {
        
        if (estudiante == null) throw new BadRequestException("La información no ha sido enviada correctamente");
            
        Class.forName("org.postgresql.Driver");            

        dbContext = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ejercicio_estudiante_db", 
            "postgres",
            "2220"    
        );

        CallableStatement funcion = dbContext.prepareCall("{ call f_actualizar_estudiante(?,?,?,?) }");
        funcion.setShort(1, estudiante.getId());
        funcion.setString(2, estudiante.getNombre());
        funcion.setString(3, estudiante.getApellido());                          
        funcion.setString(4, estudiante.getNumeroDocumento());

        ResultSet respuesta = funcion.executeQuery();                   

        short res = 3;
        
        while (respuesta.next()) {                
            res = respuesta.getShort(1);
        }   

        switch (res) {                    
            
            // No se encontró al estudiante    
            case 1:
                throw new NotFoundException("No se encontró al estudiante");
                
            // El número de documento ya está en uso
            case 2:
                throw new IntegridadException("El número de documento ya está en uso");                
        }                
    }
    
    /**
     * Método para eliminar un estudiante
     * @param id - Identificación del estudiante     
     * @throws NotFoundException - Ocurre cuando no se encuentra el usuario asociado al ID
     * @throws SQLException - Ocurre cuando se encuentra un error al procesar alguna función el la base de datos
     * @throws ClassNotFoundException - Ocurre cuando no se encuentra el driver de PostgreSQL          
     */
    public void eliminarEstudiante(short id) throws NotFoundException,
                                                    SQLException,
                                                    ClassNotFoundException,
                                                    Exception {
            
        Class.forName("org.postgresql.Driver");


        dbContext = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ejercicio_estudiante_db", 
            "postgres",
            "2220"    
        );

        CallableStatement funcion = dbContext.prepareCall("{ call f_eliminar_estudiante(?) }");
        funcion.setShort(1, id);            

        ResultSet respuesta = funcion.executeQuery();                   

        boolean res = false;
        
        while(respuesta.next()) {
            res = respuesta.getBoolean(1);
        }        
        
        if (!res) throw new NotFoundException("No se encontró al estudiante");                   
    }        
}
