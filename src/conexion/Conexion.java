package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase encargada de establecer la conexión entre la aplicación Java
// y la base de datos MySQL del sistema Soporte Técnico Estudiantil.
 
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/soporte_estudiantil";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    
    // Método que retorna una conexión activa con la base de datos.
    public static Connection getConexion() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL.");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            System.out.println(e.getMessage());
        }
        //return objeto Connection si la conexión es exitosa, o null si ocurre un error.
        return conexion;
    }
}