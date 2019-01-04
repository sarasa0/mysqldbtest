package DBManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBMetaDataManager {

    private ArrayList<String> tablas;
    private ArrayList<ArrayList<String>> tabycol;
    private String rootNode;

    /**
     * uso esta clase para traer Datos de tablas y columnas
     * para popular el jtree
     */
    public DBMetaDataManager() {
        tablas = new ArrayList<>();
        tabycol = new ArrayList<>();
        Connection miconexion = Conexion.conectarmysql();
        ArrayList<String> columnas = new ArrayList<>();
        int i = 0;
        try {
            ResultSet dbtables = miconexion.getMetaData().getTables(miconexion.getCatalog(), null, "%", null);
            while (dbtables.next()) {
                tablas.add(dbtables.getString("TABLE_NAME"));
            }
            ResultSet dbcolumns = miconexion.getMetaData().getColumns(miconexion.getCatalog(), null, "%", "%");
            while (dbcolumns.next()) {
                if (dbcolumns.getString(3).equals(tablas.get(i))) {
                    columnas.add(dbcolumns.getString(4));
                } else {
                    i++;
                    tabycol.add(columnas);
                    columnas = new ArrayList<>();
                    columnas.add(dbcolumns.getString(4));
                }
            }
            tabycol.add(columnas);
            rootNode= miconexion.getCatalog();
        } catch (SQLException e) {
            System.out.println("Error Trayendo Metadata");
        } finally {
            try {
                miconexion.close();
            } catch (SQLException e) {
                System.out.println("DBMetaDataManager exploto");
            }
        }
    }

    public String getRootNode(){
        return rootNode;
    }

    public ArrayList<String> getTablas() {
        return tablas;
    }

    public ArrayList<ArrayList<String>> getTabycol() {
        return tabycol;
    }

}

