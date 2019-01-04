package GUI;

import DBManagement.ConectionsList;

import javax.swing.*;

public class JComboBoxBuilder extends JComboBox {
    public JComboBoxBuilder(){
        ConectionsList a = new ConectionsList();
        for (int i=0;i<a.getConecciones().size();i++){
            addItem(a.getConecciones().get(i));
        }
    }
}
