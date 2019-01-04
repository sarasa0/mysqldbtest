package Service;

import DBManagement.OperacionesDAOMysqlImpl;
import ErrorHandlers.DAOException;
import ErrorHandlers.ServiceException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TableDataGenerator {

    private OperacionesDAOMysqlImpl queryresults;
    private ArrayList<ArrayList<Object>> data;
    private ArrayList<String> ColumnNames;
    private String Query;

    public TableDataGenerator(String query) {
        queryresults = new OperacionesDAOMysqlImpl();
        this.Query = query;
        this.SetData(query);
        this.setColumnNames();
    }

    private void SetData(String query) {
        try {
            this.data = queryresults.SQLQUERY(query);
            if (data.size()==0){
                this.data=new ArrayList<>();
                this.data.add(new ArrayList<Object>(Arrays.asList("No Hay Resultados")));
            }

        } catch (DAOException e) {
            new ServiceException("Falla de Servicio por Error de DAO:\n"+e.getMessage());
        }
    }

    public ArrayList<ArrayList<Object>> getData() {
        return this.data;
    }

    private void setColumnNames() {
        ColumnNames = queryresults.getColumnNames();
    }

    public String getColumnsName(int columnindex) {
        return ColumnNames.get(columnindex);
    }
}
