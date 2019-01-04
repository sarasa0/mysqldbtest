package GUI;

import Service.JTreeBuilder;

import javax.swing.*;
import java.awt.*;

public class PanelTree extends JPanel {
    private JTreeBuilder DBStruct;

    public JTreeBuilder getDBStruct() {
        return DBStruct;
    }


    public PanelTree() {
        setLayout(new BorderLayout());
        DBStruct = new JTreeBuilder();
        JComboBoxBuilder test = new JComboBoxBuilder();
        //TODO hacer items para cada conexion
        JScrollPane treescroll = new JScrollPane(DBStruct);
        treescroll.setWheelScrollingEnabled(true);
        treescroll.setPreferredSize(new Dimension(180, 350));
        add(treescroll, BorderLayout.CENTER);
        add(new RefreshUIButton("Refresh"), BorderLayout.SOUTH);
        add(test,BorderLayout.NORTH);
    }

}
