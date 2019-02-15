package DBManagement;

import ErrorHandlers.DAOException;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

//ALTER TABLE table ADD nombreAtributo tipoAtributo / DROP COLUMN nombreAtributo / MODIFY COLUMN nombreAtributo tipoAtributo
//CREATE TABLE tabla (atributo1 tipoAtributo1, atributo2 tipoAtributo2);
//DROP TABLE tabla
//DELETE FROM table WHERE condicion
//INSERT INTO table (column1,columnN) VALUES ("value1","valueN")

/**
 * Esta Clase Maneja todos los querys del usuario
 * y devuelve datos para mostrar en la tabla
 */
public class OperacionesDAOMysqlImpl implements OperacionesDAO {

    private ArrayList<String> ColumnNames;

    @Override
    public ArrayList<ArrayList<Object>> SQLQUERY(String sql) throws DAOException {
        Connection conexion = null;
        try {
            conexion = Conexion.conectarmysql();
            PreparedStatement p = conexion.prepareStatement(sql);
            System.out.println("Connection Successful");
            if (sql.toLowerCase().contains("select")) {
                ResultSet queryresult = p.executeQuery();
                SetColumnNames(queryresult);
                return generateData(queryresult);
            } else {
                p.executeUpdate();
                JOptionPane.showMessageDialog(null, "OPERATION SUCESSFULL");
                conexion.close();
            }
            return null;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            try {
                conexion.close();
            } catch (SQLException e1) {
                System.out.println(e.getMessage());
            }
            throw new DAOException("Ocurrio un error Con la operacion de la base de datos:\n"+ e.getMessage());
        } finally {
            System.out.println("closing connection to database");
        }
    }

    private ArrayList<ArrayList<Object>> generateData(ResultSet datos) throws SQLException {

        ArrayList<ArrayList<Object>> rows = new ArrayList<>();
        while (datos.next()) {
            ArrayList<Object> columns = new ArrayList<>();
            for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
                columns.add(datos.getString(i));
            }
            rows.add(columns);
        }
        datos.close();
        return rows;
    }

    private void SetColumnNames(ResultSet data) throws SQLException {
        ColumnNames = new ArrayList<>();
        ResultSetMetaData nombres = data.getMetaData();
        for (int i = 0; i < nombres.getColumnCount(); i++) {
            ColumnNames.add(nombres.getColumnLabel(i + 1));
        //    ColumnNames.add(nombres.getColumnName(i + 1));        original
        }
    }

    public ArrayList<String> getColumnNames() {
        return ColumnNames;
    }
}