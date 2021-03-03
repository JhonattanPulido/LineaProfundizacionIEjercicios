// Paquetes
package com.edu.ucundinamarca.webapiestudiante.data;
import com.edu.ucundinamarca.webapiestudiante.pojos.Estudiante;

// Importaciones
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        prepararConexion();
    }  

    // Métodos
    
    /**
     * Método para crear estudiante
     * @param estudiante - Objeto con los datos del estudiante
     * @return - True : si el estudiante se almaceno correctamente
     */
    public boolean crearEstudiante(Estudiante estudiante) throws SQLException {
        
        try {
        
            CallableStatement funcion = dbContext.prepareCall("{ call f_crear_estudiante(?,?,?) }");
            funcion.setString(1, estudiante.getNombre());
            funcion.setString(2, estudiante.getApellido());                          
            funcion.setString(3, estudiante.getNumeroDocumento());            
            
            ResultSet respuesta = funcion.executeQuery();       
            System.out.println("La respuesta es: " + respuesta.getBoolean(0));
            
            return respuesta.getBoolean(0);
            
        } catch (SQLException ex) { throw ex; }
    }
    
    /**
     * Método para leer los estudiantes registrados
     * @return lista de estudiantes
     */
    public ArrayList<Estudiante> leerEstudiantes() throws SQLException {
    
        try {
        
            CallableStatement funcion = dbContext.prepareCall("{ call f_leer_estudiante() }");            
            
            ResultSet respuesta = funcion.executeQuery();                   
            
            ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
            
            while (respuesta.next()) {
                listaEstudiantes.add(new Estudiante(
                    respuesta.getShort("id"),
                    respuesta.getString("nombre"),
                    respuesta.getString("apellido"),
                    respuesta.getString("numero_documento")
                ));
            }
            
            return listaEstudiantes;
            
        } catch (SQLException ex) { throw ex; }
    }
    
    /**
     * Método para leer un estudiante filtrado por id
     * @param id - Identificación del usuario
     * @return los datos del estudiante
     */
    public Estudiante leerEstudiante(short id) throws SQLException {
    
        try {
        
            CallableStatement funcion = dbContext.prepareCall("{ call f_leer_estudiante(?) }");
            funcion.setShort(1, id);            
            
            ResultSet respuesta = funcion.executeQuery();                   
            
            return new Estudiante(
                respuesta.getShort("id"),
                respuesta.getString("nombre"),
                respuesta.getString("apellido"),
                respuesta.getString("numero_documento")
            );
            
        } catch (SQLException ex) { throw ex; }
    }
    
    /**
     * Método para actualizar un estudiante
     * @param estudiante
     * @return índice de respuesta obtenido de la base de datos
     */
    public short actualizarEstudiante(Estudiante estudiante) throws SQLException {
    
        try {
        
            CallableStatement funcion = dbContext.prepareCall("{ call f_actualizar_estudiante(?,?,?,?) }");
            funcion.setShort(1, estudiante.getId());
            funcion.setString(2, estudiante.getNombre());
            funcion.setString(3, estudiante.getApellido());                          
            funcion.setString(4, estudiante.getNumeroDocumento());
            
            ResultSet respuesta = funcion.executeQuery();       
            System.out.println("La respuesta es: " + respuesta.getShort(0));
            
            return respuesta.getShort(0);
            
        } catch (SQLException ex) { throw ex; }
    }
    
    /**
     * Método para eliminar un estudiante
     * @param id - Identificación del estudiante
     * @return true: si el estudiante es eliminado correctamente
     */
    public boolean eliminarEstudiante(short id) throws SQLException {
    
        try {
        
            CallableStatement funcion = dbContext.prepareCall("{ call f_eliminar_estudiante(?) }");
            funcion.setShort(1, id);            
            
            ResultSet respuesta = funcion.executeQuery();                   
            
            return respuesta.getBoolean(0);
            
        } catch (SQLException ex) { throw ex; }
    }
    
    /**
     * Método para preparar la conexión con la base de datos
     */
    private boolean prepararConexion() throws Exception {
    
        try {
        
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
            
            dbContext = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ejercicio_estudiante_db", 
                "postgres",
                "sami2010"    
            );
            
            return true;
            
        } catch(SQLException ex) { throw ex; }
    }
}
