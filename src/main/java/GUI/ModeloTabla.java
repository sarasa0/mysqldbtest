package GUI;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;

public class ModeloTabla extends AbstractTableModel {
    private ArrayList<ArrayList<Object>> data;

    public ModeloTabla(ArrayList<ArrayList<Object>> data) {
        super();
        if (data.size()!=0){
            this.data = data;
        }
        else {
            this.data=new ArrayList<>();
            this.data.add(new ArrayList<Object>(Arrays.asList("No Hay Resultados")));
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return data.get(0).size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

}
