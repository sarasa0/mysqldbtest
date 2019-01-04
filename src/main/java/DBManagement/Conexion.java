package DBManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected static String DB_URL = "jdbc:mysql://localhost:3306/bdd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
    protected static String USER = "test";
    protected static String PASS = "test";

    /**
     * esta clase solo genera una conexion a la base de datos
     */
    public Conexion() {
    }

    public static Connection conectarmysql() {
        Connection c = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error Generando Conexion a la Base de Datos");
            System.exit(-1);
        }
        return c;
    }

}