package Service;

import GUI.ModeloTabla;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;

public class JTableBuilder {

    public void buildTable(String Query, JTable Table) {
        TableDataGenerator tabledatagenerator = new TableDataGenerator(Query);
        ArrayList<ArrayList<Object>> TableData = tabledatagenerator.getData();
        ModeloTabla tableModel = new ModeloTabla(TableData);
        int TableColumns = tableModel.getColumnCount();
        int TableRows = tableModel.getRowCount();
        Table.setModel(tableModel);
        for (int i = 0; i < TableRows; i++) {
            for (int j = 0; j < TableColumns; j++) {
                Table.setValueAt(TableData.get(i).get(j), i, j);
                JTableHeader th = Table.getTableHeader();
                TableColumnModel tcm = th.getColumnModel();
                TableColumn tc = tcm.getColumn(j);
                tc.setHeaderValue(tabledatagenerator.getColumnsName(j));
            }
        }
    }
}
