package DBManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConectionsList {
    //TODO
    private static ArrayList<String> Conecciones;

    public static ArrayList<String> getConecciones() {

        return Conecciones;
    }
    public ConectionsList(){
        Conecciones = new ArrayList<String>();
        try {
            Connection test = Conexion.conectarmysql();
            ResultSet a = test.getMetaData().getCatalogs();
            while (a.next()){
                Conecciones.add(a.getString("TABLE_CAT"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
