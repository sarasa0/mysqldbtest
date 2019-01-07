package GUI;

import Service.JTreeBuilder;

import javax.swing.*;
import java.awt.*;

public class PanelTree extends JPanel {
    private JTreeBuilder DBStruct;
    private RefreshUIButton Refresh;

    public JTreeBuilder getDBStruct() {
        return DBStruct;
    }

    public RefreshUIButton getRefresh(){
        return Refresh;
    }

    public PanelTree() {
        setLayout(new BorderLayout());
        DBStruct = new JTreeBuilder();
        JComboBoxBuilder test = new JComboBoxBuilder();
        //TODO hacer items para cada conexion
        JScrollPane treescroll = new JScrollPane(DBStruct);
        treescroll.setWheelScrollingEnabled(true);
        treescroll.setPreferredSize(new Dimension(180, 350));
        Refresh=new RefreshUIButton("Refresh");
        add(treescroll, BorderLayout.CENTER);
        add(Refresh, BorderLayout.SOUTH);
        add(test,BorderLayout.NORTH);
    }

}
